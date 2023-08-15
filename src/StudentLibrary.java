import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentLibrary {
    LinkedList<Book> allBooks;
    LinkedList<Student> access;

    public StudentLibrary() {
        allBooks = new LinkedList<>();
        access = new LinkedList<>();
    }

    public void start() {
        File file = new File("books.txt");
        Scanner input = new Scanner(System.in);
        boolean runMenu = true;

        do {
            bookMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> readAll();
                case 9 -> runMenu = false;


                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while(runMenu);
    }

    public static void bookMenu() {

        System.out.println("Welcome to our Library Management System!");
        System.out.println("Which action do you want to operate?\n");
        System.out.println("1: Add a new Book");
        System.out.println("2: List of all Books");
        System.out.println("3: Change Book info");
        System.out.println("4: Check if already taken");
        System.out.println("5: Library Membership");
        System.out.println("9: Exit to main menu");
    }

    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add a new Book.");
        System.out.print("Booktitle: ");
        String title = input.next();
        System.out.print("Author: ");
        String author = input.next();
        allBooks.add(new Book(title, author));
    }

    public void readAll() {
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    public void writeBookObjects(LinkedList<Book> ls) {
        File file = new File("books.txt");
        try(FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(output)) {
            for (Book book : ls) {
                objOut.writeObject(new Book(book));
            }
            objOut.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void readBookObjects(File file) {
        try {
            FileInputStream input = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(input);
            for (;;) {
                Book b = (Book) objIn.readObject();
                allBooks.add(new Book(b));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}
