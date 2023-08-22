import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {

    private static final String FILE_NAME = "login.txt";

    public static boolean verification() {
        try {
            String username = "";
            String password = "";
            Scanner input = new Scanner(System.in);
            Scanner scan;
            File file = new File(FILE_NAME);
            scan = new Scanner(file);
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
        } catch (FileNotFoundException e) {
            System.out.print("File could not be found.");
            return false;
        } catch (Exception e) {
            System.out.print("Error occurred while doing credential verification, error message: " + e.getLocalizedMessage());
            return false;
        }
    }

    public static void changeLogin() {
        try {
            File file = new File(FILE_NAME);
            if (file.delete()) {
                ChangeLoginRequest changeLoginRequest = setInputsFromKeyboard();
                updateCredentialsFile(file, changeLoginRequest.getNewUsername(), changeLoginRequest.getNewPassword());
            } else {
                System.out.println("Something went wrong while deleting the old credentials file.");
            }
        } catch (IOException e) {
            System.out.println("IO Exception occurred while changing login credentials. Error message: " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Unknown Exception occurred while changing login credentials. Error message: " + e.getLocalizedMessage());
        }
    }

    private static void updateCredentialsFile(File file, String username, String password) throws IOException {
        if (file.createNewFile()) {
            FileWriter output = new FileWriter(file);
            output.write(username);
            output.write(" ");
            output.write(password);
            output.close();
        } else {
            System.out.println("Something went wrong.");
        }
    }

    private static ChangeLoginRequest setInputsFromKeyboard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Change Username and Password.");
        System.out.print("Username: ");
        String username = input.next();
        System.out.print("Password: ");
        String password = input.next();
        return new ChangeLoginRequest(username, password);
    }
}
