import java.io.*;
import java.util.Scanner;

public class Menu {

    private static final String STUDENT_FILE = "output.txt";
    private static final String BOOKS_FILE = "books.txt";

    public static void main(String[] args) {
        File students = new File(STUDENT_FILE);
        File books = new File(BOOKS_FILE);
        Scanner input = new Scanner(System.in);
        StudentManagement m = new StudentManagement();
        StudentLibrary sl = new StudentLibrary();
        m.readObjects(students);
        sl.readBookObjects(books);
        while(true) {
            if (Login.verification()) {
                do {
                    sl.writeBookObjects(sl.allBooks);
                    menu();
                    performMenuOperations(input, m, sl);
                } while (true);
            } else {
                System.out.println("Login failed.");
            }
        }
    }

    private static void performMenuOperations(Scanner input, StudentManagement m, StudentLibrary sl) {
        int choice;
        choice = input.nextInt();
        switch (choice) {
            case 1 -> m.addStudent();
            case 2 -> m.addStudentViaID();
            case 3 -> m.delStudent();
            case 4 -> m.updateStudent();
            case 5 -> m.searchStudent();
            case 6 -> m.readAll();
            case 7 -> sl.start(m);
            case 8 -> m.addMembership();
            case 9 -> {
                m.writeObjects(m.getList());
                System.out.println("\nThank you and see you later.\n");
                System.exit(0);
            }
            case 0 -> Login.changeLogin();
            default -> System.out.println("\nInvalid input.\n");
        }
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Add a Student via ID");
        System.out.println("3: Delete Student");
        System.out.println("4: Update Student");
        System.out.println("5: Search Student");
        System.out.println("6: List all Students");
        System.out.println("7: Library Management");
        System.out.println("8: Add/Delete Library Membership");
        System.out.println("9: Save & exit program");
        System.out.println("0: Change Login");
        System.out.print("Enter your selection : ");
    }

}
