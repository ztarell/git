/**
 *Employee With Title Class
 * By Zachary Tarell
 * 11/6/2017
 */
public class FA2017LAB6_TitleEmployee_Tarell extends FA2017LAB6_Employee_Tarell {
    //private title data type
    private String eTitle;
    
    //Constructor for EmployeeWithTitle class - passes variables w/ title
    public FA2017LAB6_TitleEmployee_Tarell(String firstname, String lastname, String id, String department, double salary, String eTitle) {
        super(firstname, lastname, id, department, salary);
        this.eTitle = eTitle;
    }
    //deepCopy - must make sure you deepCopy to add title to array when user adds it
    public FA2017LAB6_TitleEmployee_Tarell deepCopy() {
        FA2017LAB6_TitleEmployee_Tarell clone = new FA2017LAB6_TitleEmployee_Tarell(firstname, lastname, id, department, salary, eTitle);
                return clone;
    }
    //toString method for EmployeeWithTitle class - adds title to toString()
    public String toString() {
        String s = super.toString() + "Employee TITLE:\t\t" + this.eTitle  + "\n";
        return s;
    }
    public String toFile() {
        return super.toFile() + " - " + this.eTitle;
    }
}

