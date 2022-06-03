package CreateEmail;

public interface IEmail {
    void setMailboxCapacity(int capacity);
    void setAlternateEmail(String altEmail);
    void changePassword(String password);
    int getMailboxCapacity();
    String getEmail();
    String getAlternateEmail();
    String getPassword();

}
