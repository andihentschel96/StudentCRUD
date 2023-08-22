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

    public void start(StudentManagement m) {
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
        System.out.print("BookTitle: ");
        String title = input.next();
        System.out.print("Author: ");
        String author = input.next();
        System.out.print("Membership needed (true/false): ");
        boolean membershipNeeded = input.nextBoolean();
        allBooks.add(new Book(title, author, membershipNeeded));
    }

    public void readAll() {
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    public void updateBook() {
        Scanner input = new Scanner(System.in);
        Book book = new Book();
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
                book.setBookID(choice);
                book.setBookTitle(title);
                book.setAuthor(author);
                book.setMembershipNeeded(memNeeded);

                allBooks.set(choice, book);
            }
        }
    }

    public void listStudentsWithAccess(StudentManagement m) {
        LinkedList<Student> allStudents = m.getList();

        Scanner input = new Scanner(System.in);
        System.out.print("Type in Book ID: ");
        int choice = input.nextInt();
        for (Book book : allBooks) {
            if (choice == book.getBookID(book)) {
                for (Student student : allStudents) {
                    if (student.getHasAccess(student) && book.getMembershipNeeded(book)) {
                        System.out.println(student);
                    } else if (!student.getHasAccess(student) && book.getMembershipNeeded(book)) {
                        System.out.println("Student is no Library Member");
                    } else if (student.getHasAccess(student) && !book.getMembershipNeeded(book)) {
                        System.out.println(student);
                    } else if (!student.getHasAccess(student) && !book.getMembershipNeeded(book)) {
                        System.out.println(student);
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
                Book book = (Book) objIn.readObject();
                allBooks.add(new Book(book));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}
