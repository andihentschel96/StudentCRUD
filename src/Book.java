import java.io.Serializable;


public class Book implements Serializable {
    private static int count = 0;
    private int bookID;
    private String bookTitle;
    private String author;
    private boolean membershipNeeded;

    public Book() {}
    public Book(Book book) {
        setBookID(count++);
        this.bookTitle = book.bookTitle;
        this.author = book.author;
        this.membershipNeeded = book.membershipNeeded;
    }

    public Book(String title, String author, boolean membershipNeeded) {
        setBookID(count++);
        this.bookTitle = title;
        this.author = author;
        this.membershipNeeded = membershipNeeded;
    }
    public int getBookID(Book b) {
        return b.bookID;
    }
    public void setBookID(int id) {
        this.bookID = id;
    }
    public String getBookTitle(Book b) {
        return b.bookTitle;
    }
    public void setBookTitle(String bt) {
        this.bookTitle = bt;
    }
    public String getAuthor(Book b) {
        return b.author;
    }
    public void setAuthor(String a) {
        this.author = a;
    }
    public boolean getMembershipNeeded(Book b) {
        return b.membershipNeeded;
    }
    public void setMembershipNeeded(boolean b) {
        this.membershipNeeded = b;
    }

    @Override
    public String toString() {
        return "Book {" + "ID = " + this.bookID + ", Booktitle = " + this.bookTitle + ", Author = " + this.author + ", Membership needed = " + this.membershipNeeded +"}\n";
    }
}
