import java.util.LinkedList;

public class BookLibrary {
    private static int count = 0;
    private int bookID;
    private String bookTitle;
    private String author;
    LinkedList<Student> hasAccess;

    public BookLibrary() {}

    public BookLibrary(String title, String author) {
        setBookID(count++);
        this.bookTitle = title;
        this.author = author;
    }
    public void setBookID(int id) {
        this.bookID = id;
    }
}
