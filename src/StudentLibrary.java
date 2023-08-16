import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import static java.util.Collections.*;

public class StudentLibrary {
    LinkedList<Book> allBooks;
    LinkedList<Student> access;

    public StudentLibrary() {
        allBooks = new LinkedList<>();
        access = new LinkedList<>();
    }

    public void start(StudentManagement m) {
        File file = new File("books.txt");
        Scanner input = new Scanner(System.in);
        boolean runMenu = true;

        do {
            bookMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> readAll();
                case 3 -> updateBook();
                case 4 -> listStudentsWithAccess(m);
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
        System.out.println("4: List of Students that have access to the searched Book");
        System.out.println("9: Exit to main menu");
    }

    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add a new Book.");
        System.out.print("Booktitle: ");
        String title = input.next();
        System.out.print("Author: ");
        String author = input.next();
        System.out.print("Membership needed (true/false): ");
        boolean memNeeded = input.nextBoolean();
        allBooks.add(new Book(title, author, memNeeded));
    }

    public void readAll() {
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    public void updateBook() {
        Scanner input = new Scanner(System.in);
        Book b = new Book();
        System.out.print("Type in Book ID: ");
        int choice = input.nextInt();
        for (int i = 0; i < allBooks.size(); i++) {
            if (i == choice) {
                System.out.println("Update Book information.");
                System.out.print("Firstname: ");
                String title = input.next();
                System.out.print("Lastname: ");
                String author = input.next();
                System.out.print("Membership needed (true/false): ");
                boolean memNeeded = input.nextBoolean();
                b.setBookID(choice);
                b.setBookTitle(title);
                b.setAuthor(author);
                b.setMembershipNeeded(memNeeded);

                allBooks.set(choice, b);
            }
        }
    }

    public void listStudentsWithAccess(StudentManagement m) {
        LinkedList<Student> allStudents = m.getList();

        Scanner input = new Scanner(System.in);
        System.out.print("Type in Book ID: ");
        int choice = input.nextInt();
        for (Book b : allBooks) {
            if (choice == b.getBookID(b)) {
                for (Student s : allStudents) {
                    if (s.getHasAccess(s) && b.getMembershipNeeded(b)) {
                        System.out.println(s);
                    } else if (!s.getHasAccess(s) && b.getMembershipNeeded(b)) {
                        System.out.println("Student is no Library Member");
                    } else if (s.getHasAccess(s) && !b.getMembershipNeeded(b)) {
                        System.out.println(s);
                    } else if (!s.getHasAccess(s) && !b.getMembershipNeeded(b)) {
                        System.out.println(s);
                    }
                }
            }
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
            while (true) {
                Book b = (Book) objIn.readObject();
                allBooks.add(new Book(b));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}
