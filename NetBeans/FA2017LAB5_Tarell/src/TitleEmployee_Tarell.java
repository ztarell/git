/**
 *Employee With Title Class
 * By Zachary Tarell
 * 10/24/2017
 */
public class TitleEmployee_Tarell extends Employee_Tarell {
    //protected title data type
    private String eTitle;
    
    //Constructor for EmployeeWithTitle class - passes variables w/ title
    public TitleEmployee_Tarell(String name, String id, String address, double salary, String eTitle) {
        super(name, id, address, salary);
        this.eTitle = eTitle;
    }
    //deepCopy - must make sure you deepCopy to add title to array when user adds it
    public TitleEmployee_Tarell deepCopy() {
        TitleEmployee_Tarell clone = new TitleEmployee_Tarell(name, id, address, salary, eTitle);
                return clone;
    }
    //toString method for EmployeeWithTitle class - adds title to toString()
    public String toString() {
        String s = super.toString() + "\nEmployee TITLE:\t\t" + this.eTitle;
        return s;
    }
}
