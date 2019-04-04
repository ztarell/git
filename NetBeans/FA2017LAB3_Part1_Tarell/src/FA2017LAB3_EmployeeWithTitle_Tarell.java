/**
 *Employee With Tile Class
 * By Zachary Tarell
 * 9/14/2017
 */
public class FA2017LAB3_EmployeeWithTitle_Tarell extends FA2017LAB3_Employee_Tarell {
    //protected title data type
    private String eTitle;
    
    //Constructor for EmployeeWithTitle class - passes variables w/ title
    public FA2017LAB3_EmployeeWithTitle_Tarell(String name, String id, String address, double salary, String eTitle) {
        super(name, id, address, salary);
        this.eTitle = eTitle;
    }
    //deepCopy - must make sure you deepCopy to add title to array when user adds it
    public FA2017LAB3_EmployeeWithTitle_Tarell deepCopy() {
        FA2017LAB3_EmployeeWithTitle_Tarell clone = new FA2017LAB3_EmployeeWithTitle_Tarell(name, id, address, salary, eTitle);
                return clone;
    }
    //toString method for EmployeeWithTitle class - adds title to toString()
    public String toString() {
        String s = super.toString() + "\nEmployee TITLE:\t\t" + this.eTitle;
        return s;
    }
}
