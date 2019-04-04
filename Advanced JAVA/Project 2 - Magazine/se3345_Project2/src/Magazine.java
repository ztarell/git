/*
 * Magazine Class
 * By Zachary Tarell
 * Class: SE-3345
 * Section: 003
 * Semester: Spring 2019
 * 2/14/19
 */
public class Magazine implements IDedObject {

    private int magazineID;
    private String magazineName;
    private String publisherName;

    //private Array<SinglyLinkedList> list;
    public Magazine(int id, String m, String p) {
        this.magazineID = id;
        this.magazineName = m;
        this.publisherName = p;
    }

    @Override
    public void printID() {
        String s = "\n\t" + magazineID
                + "\n\t" + magazineName + "\n\t"
                + publisherName;
        System.out.println(s);
    }

    @Override
    public int getID() {

        return this.magazineID;
    }

    public void setID(int id) {
        magazineID = id;
    }

    @Override
    public int compareTo(int targetKey) {

        return (this.magazineID - targetKey);
    }

}//End of Magazine Class
