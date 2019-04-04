/**
 * Lab 4 - Part 1 
 * Borrowed Book Class
 * By Zachary Tarell
 * 09/28/2017
 */


public class BorrowedBook_Tarell extends Book_Tarell {
    //dtat members
    private String checkoutDate;
    private String dueDate;
    
    //Constructor
    public BorrowedBook_Tarell () {
        super();
        this.checkoutDate = "";
        this.dueDate = "";
    }
    
    //Parameter Constructor for BorrowedBook class - passes variables w/ checkout and due dates
    public BorrowedBook_Tarell(String bookID, String ISBN, String title, String writer, String publisher, String checkoutDate, String dueDate) {
        super(bookID, ISBN, title, writer, publisher);
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }
    //deepCopy - must make sure you deepCopy to add checkout and due dates to array when user adds it
    public BorrowedBook_Tarell deepCopy() {
        BorrowedBook_Tarell clone = new BorrowedBook_Tarell(bookID, ISBN, title, writer, publisher, checkoutDate, dueDate);
                return clone;
    }
    //toString method for BorrowBook class - adds checkout and due dates to toString()
    public String toString() {
        String s = super.toString() + "\n Checkout date:\t" + this.checkoutDate
                + "\n Due date:\t" + this.dueDate;
        return s;
    }
    
}
