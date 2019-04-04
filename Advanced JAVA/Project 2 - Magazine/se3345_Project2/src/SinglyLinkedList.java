/*
 * SinglyLinkedList Class
 * By Zachary Tarell
 * Class: SE-3345
 * Section: 003
 * Semester: Spring 2019
 * 2/14/19
 */
public class SinglyLinkedList<AnyType extends IDedObject> {

    //Data Member
    private Node h; //List header
    private AnyType l;

    //Node Class with data mambers
    public class Node {

        AnyType l;
        Node next;

        //no-argument constructor
        public Node() {
        }
    }

    //no-argument constructor
    public SinglyLinkedList() {
        h = null;//dummy node
        l = null;
    }

    public void makeEmpty() {
        h = null;
    }

    //InsertAtFront returns a boolean and inserts a node at front of list
    public boolean insertAtFront(AnyType x) {
        Node n = new Node();
        n.l = x;
        if (h != null) {
            n.next = h;
        }
        h = n;
        return true;
    }

    //findID returns generic AnyType and uses a target key to compare id's
    public AnyType findID(int ID) {
        Node p = h;
        while (p != null && (p.l.compareTo(ID) != 0)) {
            p = p.next;
        }
        if (p != null) {
            return p.l;
        } else {
            return null;
        }
    }

    //DeleteFromFront returns node if there, or null if empty - and also uses a target key to compare
    public AnyType deleteFromFront() {
        if (h != null) {
            h = h.next;
            return l;
        } else {
            return null;
        }
    }

    //Delete returns record if there, or null if empty - and also uses a target key to compare id's
    public AnyType delete(int ID) {
        Node p = h.next;
        while (p != null && (p.l.compareTo(ID) != 0)) {
            h = p;
            p = p.next;
        }
        if (p != null) {
            h.next = p.next;
            return l;
        } else {
            return null;
        }
    }

    //Show All uses calls the toString method
    public void printAllRecords() {

        Node p = h;
        while (p != null) {//continue to traverse the list
            p.l.printID();
            p = p.next;
        }

    }

}//end of sLL class
