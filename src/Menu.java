import java.io.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        StudentManagement m = new StudentManagement();
        int choice;
        do {
            if (Login.verification()) {
                do {
                    Menu.menu();
                    choice = input.nextInt();

                    switch (choice) {
                        case 1 -> m.addStudent();
                        case 2 -> m.delStudent();
                        case 3 -> m.updateStudent();
                        case 4 -> m.searchStudent();
                        case 5 -> m.readAll();
                        case 9 -> {
                            m.writeFile(m.list);
                            System.out.println("\nThank you and see you later.\n");
                            System.exit(0);
                        }
                        default -> System.out.println("\nInvalid input.\n");
                    }
                }while (true);

            } else {
                System.out.println("Login failed.");
            }
        }while (true);
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Delete Student");
        System.out.println("3: Update Student");
        System.out.println("4: Search Student");
        System.out.println("5: List all Students");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
    }
}
