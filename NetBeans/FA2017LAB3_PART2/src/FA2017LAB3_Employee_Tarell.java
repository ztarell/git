/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ztare
 */
public class FA2017LAB3_Employee_Tarell {
    //data types for Employee class 
    protected String name;
    protected String id;
    protected String address;
    protected double salary;
    //Constructor for Employee class
    public FA2017LAB3_Employee_Tarell(String n, String i, String a, double s) {
        name = n;
        id = i; 
        address = a;
        salary = s;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress (String address2) {
        this.address = address2;
    }
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
    public FA2017LAB3_Employee_Tarell deepCopy() {
        FA2017LAB3_Employee_Tarell clone = new FA2017LAB3_Employee_Tarell(name, id, address, salary);
                return clone;
    }
    //compareTo for Employee class - compares ID to targetKey
    public int compareTo(String targetKey) {
        String tKey = (String) targetKey;
        return(address.compareTo(tKey));
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
