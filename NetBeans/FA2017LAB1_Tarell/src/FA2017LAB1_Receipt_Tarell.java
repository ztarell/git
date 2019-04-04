
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FA2017LAB1_Receipt_Tarell {

    // data members
    public String proName;
    public String proID;
    public int tranID;
    public double proPrice;
    public int howmanyPurch;
    public double amtPaid;

    // no-argument constructor
    public FA2017LAB1_Receipt_Tarell() {
        proName = "";
        proID = "";
        tranID = 0;
        proPrice = 0;
        howmanyPurch = 0;
        amtPaid = 0;
    }

    // parameter costructor
    public FA2017LAB1_Receipt_Tarell(String proName, String proID, int tranID, double proPrice, int howmanyPurch, double amtPaid) {
        this.proName = proName;
        this.proID = proID;
        this.tranID = tranID;
        this.proPrice = proPrice;
        this.howmanyPurch = howmanyPurch;
        this.amtPaid = amtPaid;
    }
    // Date
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();

    // methods
    public double subTotal() {
        return proPrice * howmanyPurch;
    }

    public double salesTax() {
        return subTotal() * .0825;
    }

    public double Total() {
        return subTotal() + salesTax();
    }

    public double Balance() {
        return amtPaid - Total();
    }

    // To String
    public String toString() {
        String line = "\n-------------------------------------";
        String store = line + "\n              MY STORE\n"
                + "    123 ABRAMS RD DALLAS TX 75243\n"
                + "           STORE #: 55555\n"
                + "       THANK YOU FOR SHOPPING\n";
        String e = "       TRANSACTION #: ";
        String f = "          Date: ";

        return String.format("%1s %2s" + tranID + "\n%3s" + dateFormat.format(date) + "%4s", store, e, f, line)
                + String.format("\n%1$15s %2$15d", proName, howmanyPurch)
                + String.format("\n%1$15s %2$15.2f", "Unit price:", proPrice)
                + String.format("\n%1$15s %2$15.2f", "Sub total:", subTotal())
                + String.format("\n%1$15s %2$15.2f", "Tax (8.25%):", salesTax())
                + String.format("\n%1$15s %2$15.2f", "Total:", Total()) + line
                + String.format("\n%1$15s %2$15.2f", "Cash:", amtPaid)
                + String.format("\n%1$15s %2$15.2f\n", "Change:", Balance());

    }

}
