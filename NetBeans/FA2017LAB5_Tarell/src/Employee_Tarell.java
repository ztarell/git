/**
 *Employee Class
 * By Zachary Tarell
 * 10/24/2017
 */

public class Employee_Tarell {
    //data types for Employee class 
    protected String name;
    protected String id;
    protected String address;
    protected double salary;
    //Parameter-Constructor for Employee class
    public Employee_Tarell(String n, String i, String a, double s) {
        name = n;
        id = i; 
        address = a;
        salary = s;
    }
    //Gets a key uses name
    public String getKey() {
        return name;
    }
    //Gets id uses id
    public String getID() {
        return id;
    }
    //Sets id passes id
    public void setID(String i) {
        id = i;
    }
    //Used to verify encapsulation option
    public String getAddress() {
        return address;
    }
    //Used to verify encapsulation option
    public void setAddress (String address2) {
        this.address = address2;
    }
    //Used to verify encapsulation option
    public void setSalary (double salary2) {
        this.salary = salary2;
    }
    //toString for Employee class
    public String toString () {
        String s = "\nEmployee NAME:\t\t" + name
                + "\nEmployee ID:\t\t" + id
                + "\nEmployee ADDRESS:\t" + address
                + "\nEmployee SALARY:\t" + salary;
        return s;
    }
    
    //deepCopy method for Employee class - returns a clone
    public Employee_Tarell deepCopy() {
        Employee_Tarell clone = new Employee_Tarell(name, id, address, salary);
                return clone;
    }
    //compareTo for Employee class - compares ID to targetKey
    public int compareTo(String targetKey) {
        return(id.compareTo(targetKey));
    }
    //setName method for Employee class - passes String
    public void setName(String n) {
        name = n;
    }
    //verify method for Employee class - passes variables
    public void verify(String n, String i, String a, double s) {
        name = n;
        id = i; 
        address = a;
        salary = s;
    }
    
}
