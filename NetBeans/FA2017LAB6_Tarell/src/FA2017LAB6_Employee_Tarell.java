
/**
 *Employee Class
 * By Zachary Tarell
 * 11/6/2017
 */
public class FA2017LAB6_Employee_Tarell {

    //data types for Employee class 
    protected String firstname;
    protected String lastname;
    protected String id;
    protected String department;
    protected double salary;

    //Parameter-Constructor for Employee class
    public FA2017LAB6_Employee_Tarell(String fn, String ln, String i, String d, double s) {
        firstname = fn;
        lastname = ln;
        id = i;
        department = d;
        salary = s;
    }

    //Gets a key uses id
    public String getKey() {
        return id;
    }

    //Used to verify encapsulation option
    public double getSalary() {
        return salary;
    }

    //Used to verify encapsulation option
    public void setSalary(double salary2) {
        this.salary = salary2;
    }

    //toString for Employee class
    public String toString() {
        String s = "\nEmployee NAME:\t\t" + firstname + " " + lastname
                + "\nEmployee ID:\t\t" + id
                + "\nEmployee DEPARTMENT:\t" + department
                + "\nEmployee SALARY:\t" + salary + "\n";
        return s;
    }

    //deepCopy method for Employee class - returns a clone
    public FA2017LAB6_Employee_Tarell deepCopy() {
        FA2017LAB6_Employee_Tarell clone = new FA2017LAB6_Employee_Tarell(firstname, lastname, id, department, salary);
        return clone;
    }

    //compareTo for Employee class - compares ID to targetKey
    public int compareTo(String targetKey) {
        return (id.compareTo(targetKey));
    }
    
    public String toFile() {
        return firstname + " - " + lastname + " - " + id + " - " + department + " - " + salary;
    }

}
