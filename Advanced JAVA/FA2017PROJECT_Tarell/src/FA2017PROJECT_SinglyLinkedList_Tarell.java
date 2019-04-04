
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

/*
 * Singly Linked List Class
By Zachary Tarell
10/26/2017
 */
public class FA2017PROJECT_SinglyLinkedList_Tarell {

    //Data Member
    private Node h; //List header

    //no-argument constructor
    public FA2017PROJECT_SinglyLinkedList_Tarell() {
        h = new Node();//dummy node
        h.l = null;
        h.next = null;
    }

    //I created a getStudents() method to check if Array is empty
    public Node getStudents() {
        return h.next;
    }

    //Insert returns a boolean and inserts a deepCopy passing a Node Class and a new Node
    public boolean insert(FA2017PROJECT_Student_Tarell newStudent) {
        Node n = new Node();
        if (n == null) // out of memory
        {
            return false;
        } else {
            n.next = h.next;
            h.next = n;
            n.l = newStudent.deepCopy();
            return true;
        }
    }

    //Fetch returns a deepCopy and uses a target key to compare
    public FA2017PROJECT_Student_Tarell fetch(String targetKey) {
        Node p = h.next;
        while (p != null && (p.l.compareTo(targetKey) != 0)) {
            p = p.next;
        }
        if (p != null) {
            return p.l.deepCopy();
        } else {
            return null;
        }
    }

    //Delete returns boolean and also uses a target key to compare
    public boolean delete(String targetKey) {
        Node q = h;
        Node p = h.next;
        while (p != null && (p.l.compareTo(targetKey) != 0)) {
            q = p;
            p = p.next;
        }
        if (p != null) {
            q.next = p.next;
            return true;
        } else {
            return false;
        }
    }

    //Update returns a boolean and passes a target key and Node as parameter
    public boolean update(String targetKey, FA2017PROJECT_Student_Tarell newFA2017PROJECT_Student_Tarell) {
        if (delete(targetKey) == false) {
            return false;
        } else if (insert(newFA2017PROJECT_Student_Tarell) == false) {
            return false;
        }
        return true;
    }

    //Show All uses calls the toString method
    public void showAll() {
        Node p = h.next;
        while (p != null) {//continue to traverse the list
            System.out.println(p.l.toString());
            p = p.next;
        }

    }
    //Prints one class passes classname
    public void printOneClass(String className) {
        Node p = h.next;
        while (p != null) {//continue to traverse the list
            ArrayList aClass = p.l.getClassList();

            for (int i = 0; i < aClass.size(); i++) {
                FA2017PROJECT_AClass_Tarell temp;
                temp = (FA2017PROJECT_AClass_Tarell) aClass.get(i);
                String cName = temp.getClassName();
                if (cName.compareTo(className) == 0) {
                    System.out.println(p.l.classToString(cName));
                }
            }
            p = p.next;
        }
    }

    //Node Class with data mambers
    public class Node {

        private FA2017PROJECT_Student_Tarell l;
        private Node next;

        public Node() {//no-argument constructor 

        }
    }
    //Write to file method passes FileWriter's
    public void writeToFile(FileWriter fwriter, FileWriter gfile) {
        Node p = h.next;
        try {
            while (p != null) {
                fwriter.write(p.l.toFile() + "\n");
                gfile.write(p.l.gradeFile() + "\n");
                p = p.next;
            }
        } catch (IOException ioe) {
            System.err.println(" IOException: " + ioe.getMessage());
        }
    }

}//end of class
