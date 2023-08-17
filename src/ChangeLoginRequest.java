
public class ChangeLoginRequest {

    private String newUsername;
    private String newPassword;

    public ChangeLoginRequest(String newUsername, String newPassword) {
        this.newPassword = newPassword;
        this.newUsername = newUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
