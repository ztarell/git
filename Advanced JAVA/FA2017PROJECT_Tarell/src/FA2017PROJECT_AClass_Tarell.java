/*
 * FA2017 PROJECT
   Zachary Tarell
   11/26/2017
 */

public class FA2017PROJECT_AClass_Tarell {

    private String className;
    private String grade;

    public FA2017PROJECT_AClass_Tarell(String cName, String g) {

        this.className = cName;
        this.grade = g;
    }

    public void setClass(String className, String grade) {

        this.className = className;
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        if (grade == null && className == null) {
            grade = "Not Registered for class";
        } else if (grade.equalsIgnoreCase("X")) {
            grade = "Not Complete";
        }
        String s = className + " - " + grade;
        return s;
    }

    //gradefile for writing to file
    public String gradeFile() {
        if (grade.equalsIgnoreCase("Not Complete")) {
            grade = "X";
        }
        return className + "," + grade;
    }
}
