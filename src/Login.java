import java.io.File;
import java.io.FileNotFoundException;
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
        while (scan.hasNext()) {
            username = scan.next();
            password = scan.next();
        }
        System.out.println("Please log in:");
        System.out.print("Username: ");
        String inputUsername = input.next();
        System.out.print("Password: ");
        String inputPassword = input.next();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}