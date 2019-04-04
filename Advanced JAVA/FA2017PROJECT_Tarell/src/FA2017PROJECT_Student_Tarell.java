/*
 * FA2017 Project
   Zachary Tarell
   11/26/2017
 */
import java.util.*;
import java.text.*;
import java.io.*;

public class FA2017PROJECT_Student_Tarell {

    private String id;
    private String lastname;
    private String firstname;
    private String ssn;
    private String dob;
    private String phone;
    private String address;
    private String className;
    private String grade;
    private ArrayList<FA2017PROJECT_AClass_Tarell> classList;

    public FA2017PROJECT_Student_Tarell(String i, String l, String f, String s, String d, String p, String a) {
        this.id = i;
        this.lastname = l;
        this.firstname = f;
        this.ssn = s;
        this.dob = d;
        this.phone = p;
        this.address = a;
        this.classList = new ArrayList<>();
    }

    public FA2017PROJECT_Student_Tarell deepCopy() {
        FA2017PROJECT_Student_Tarell clone = new FA2017PROJECT_Student_Tarell(id, lastname, firstname, ssn, dob, phone, address);
        clone.classList = classList;
        return clone;
    }

    public String getKey() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public int compareTo(String targetKey) {
        return (id.compareTo(targetKey));
    }

    public void dropClass(String className) {
        for (int i = 0; i < classList.size(); i++) {
            FA2017PROJECT_AClass_Tarell oneClass = classList.get(i);
            if (className.compareTo(oneClass.getClassName()) == 0) {
                if (oneClass.getGrade().compareTo("Not Complete") == 0) {
                    classList.remove(i);
                    System.out.println("\nSuccessfully dropped class\n");
                    break;
                } else {
                    System.out.println("\nThis class is completed, cannot be dropped\n");

                }
            }
        }
    }

    public String classToString(String className) {
        String str = "";
        if (classList != null) {
            for (int i = 0; i < classList.size(); i++) {
                str = str + classList.get(i) + "\n";
            }
        }
        String s = id + "\t\t" + firstname + " " + lastname;

        return s;
    }

    public String toString() {
        String str = "";
        if (classList != null) {
            for (int i = 0; i < classList.size(); i++) {
                str = str + classList.get(i) + "\n";
            }
        }
        String s = "\nStudent:\t" + firstname + " " + lastname
                + "\nStudent ID:\t" + id
                + "\nSS Number:\t" + ssn
                + "\nBirthday:\t" + dob
                + "\nPhone:\t\t" + phone
                + "\nAddress:\t" + address
                + "\nClasses:\n" + str;

        return s;
    }

    public ArrayList getClassList() {
        return classList;
    }

    public String getGrade() {
        return grade;
    }

    public void setClassList(ArrayList classList) {
        this.classList = classList;
    }
    // Date for printing out Transcript
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();

    //method to print out transcript
    public String printTranscript() {
        String str = "";
        for (int i = 0; i < classList.size(); i++) {
            str = str + classList.get(i) + "\n";
        }
        String s = "\nSCHOOL ABC - TRANSCRIPT"
                + "\n---------------------------------"
                + "\nStudent:\t" + firstname + " " + lastname
                + "\nStudent ID:\t" + id
                + "\nDate:\t\t" + dateFormat.format(date)
                + "\n---------------------------------"
                + "\n" + str;
        return s;
    }

    public String toFile() {
        return this.id + "," + this.lastname + "," + this.firstname + "," + this.ssn + "," + this.dob + "," + this.phone + "," + this.address;
    }

    public String gradeFile() {
        String str = this.id + ",";
        for (int i = 0; i < classList.size(); i++) {
            str = str + classList.get(i).gradeFile() + ",";// without gradeFile() is will auto call toString()
        }
        return str;
    }

}
