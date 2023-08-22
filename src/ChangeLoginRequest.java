
public class ChangeLoginRequest {

    private final String newUsername;
    private final String newPassword;

    public ChangeLoginRequest(String newUsername, String newPassword) {
        this.newPassword = newPassword;
        this.newUsername = newUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }


}
