import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    public static boolean verification() {
        String username = "";
        String password = "";

        Scanner input = new Scanner(System.in);
        Scanner scan = null;
        File file = new File("login.txt");
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        while (Objects.requireNonNull(scan).hasNext()) {
            username = scan.next();
            password = scan.next();
        }
        scan.close();
        System.out.println("Please log in:");
        System.out.print("Username: ");
        String inputUsername = input.next();
        System.out.print("Password: ");
        String inputPassword = input.next();

        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public static void changeLogin() {
        Scanner input = new Scanner(System.in);
        File file = new File("login.txt");
        if (file.delete()) {
            System.out.println("Change Username and Password.");
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();
            try {
                if (file.createNewFile()) {
                    FileWriter output = new FileWriter(file);
                    output.write(username);
                    output.write(" ");
                    output.write(password);

                    output.close();
                } else {
                    System.out.println("Something went wrong.");
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        } else {
            System.out.println("Something went wrong.");
        }
    }
}
