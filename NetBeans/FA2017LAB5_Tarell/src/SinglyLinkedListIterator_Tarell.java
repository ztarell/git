/*
 * Singly Linked List with Iterator Class
By Zachary Tarell
10/24/2017
 */


public class SinglyLinkedListIterator_Tarell {
    //Data Members
    private Node h; //List header
    public Iterator i;
    //no-argument constructor
    public SinglyLinkedListIterator_Tarell() {
        h = new Node();//dummy node
        i = new Iterator();
        h.l = null;
        h.next = null;
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
        public Node() {//no-argument constructor of Node class
            
        }
    }
    //Iterator Class creates the Iterator with data members
    public class Iterator {
        private Node ip;
        public Iterator() {//no-argument constructor of Iterator Class
            ip = h;
        }
        //reset() moves node to beginning
        public void reset() {
            ip = h;
        }
        //hasNext() check if a node is null or present
        public boolean hasNext() {
            if (ip.next != null)
                return true;
            else 
                return false;
        }
        //next() moves node forward one
        public Employee_Tarell next() {
            ip = ip.next;
            return ip.l.deepCopy();
        }
        //set() passes a deepCopy back using the parameters of Node Class and a new Node
        public void set(Employee_Tarell newEmployee_Tarell) {
            ip.l = newEmployee_Tarell.deepCopy();
        }
    }
}
