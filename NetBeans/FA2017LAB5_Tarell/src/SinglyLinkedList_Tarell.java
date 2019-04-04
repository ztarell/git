/*
 * Singly Linked List Class
By Zachary Tarell
10/24/2017
 */

public class SinglyLinkedList_Tarell {
    //Data Member
    private Node h; //List header
    
    //no-argument constructor
    public SinglyLinkedList_Tarell() {
        h = new Node();//dummy node
        h.l = null;
        h.next = null;
    }
    //I created a getEmployees() method to check if Array is empty
    public Node getEmployees() {
        return h.next;
    }
    //Insert returns a boolean and inserts a deepCopy passing a Node Class and a new Node
    public boolean insert(Employee_Tarell newEmployee_Tarell) {
        Node n = new Node();
        if (n == null) // out of memory
            return false;
        else {
            n.next = h.next;
            h.next = n;
            n.l = newEmployee_Tarell.deepCopy();
            return true;
        }
    }
    //Fetch returns a deepCopy and uses a target key to compare
    public Employee_Tarell fetch(String targetKey) {
        Node p = h.next;
        while (p != null && (p.l.compareTo(targetKey) != 0)) {
            p = p.next;
        }
        if (p != null)
            return p.l.deepCopy();
        else
            return null;
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
        }
        else
            return false;
    }
    //Update returns a boolean and passes a target key and Node as parameter
    public boolean update(String targetKey, Employee_Tarell newEmployee_Tarell) {
        if (delete(targetKey) == false)
            return false;
        else if (insert(newEmployee_Tarell) == false)
            return false;
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
    //Node Class with data mambers
    public class Node {
        private Employee_Tarell l;
        private Node next;
        public Node() {//no-argument constructor 
            
        }
    }
}
