/**
 * Lab 4 - Part 1 
 * Book Class
 * By Zachary Tarell
 * 09/28/2017
 */


public class Book_Tarell {
    //Data members
    protected String bookID;
    protected String ISBN;
    protected String title;
    protected String writer;
    protected String publisher;
    //Constructor no-argument
    public Book_Tarell () {
        bookID = "";
        ISBN = "";
        title = "";
        writer = "";
        publisher = "";
    }
    //Parameter Constructor
    public Book_Tarell (String b, String i, String t, String w, String p) {
        bookID = b;
        ISBN = i;
        title = t;
        writer = w;
        publisher = p;
    }
    //toString()
    public String toString() {
        String s = "\n Book ID:\t" + bookID
                + "\n Book ISBN:\t" + ISBN
                + "\n Book title:\t" + title
                + "\n Writer:\t" + writer
                + "\n Publisher:\t" + publisher;
        return s;
    }
    
    //deepCopy method for Book class - returns a clone
    public Book_Tarell deepCopy() {
        Book_Tarell clone = new Book_Tarell(bookID, ISBN, title, writer, publisher);
                return clone;
    }
    //compareTo for Book class - compares bookID to targetKey
    public int compareTo(String targetKey) {
        return(bookID.compareTo(targetKey));
    } 
}
