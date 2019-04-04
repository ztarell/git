
import java.util.*;

public class FA2017LAB1_MyStore_Tarell {

    public static void main(String[] args) {

        Scanner rec = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String pro_Name = rec.nextLine();
        System.out.print("Enter Product ID: ");
        String pro_ID = rec.nextLine();
        System.out.print("Enter Transaction ID: ");
        int tran_ID = rec.nextInt();
        System.out.print("Enter Product Price: ");
        double pro_Price = rec.nextDouble();
        System.out.print("Enter how many units purchased: ");
        int howmany_Purch = rec.nextInt();
        System.out.print("Enter amount of money paid: ");
        double amt_Paid = rec.nextDouble();

        FA2017LAB1_Receipt_Tarell receipt = new FA2017LAB1_Receipt_Tarell(pro_Name, pro_ID, tran_ID, pro_Price, howmany_Purch, amt_Paid);

        System.out.print(receipt.toString());
    }

}
