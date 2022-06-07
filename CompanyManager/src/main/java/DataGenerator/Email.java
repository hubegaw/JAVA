package CreateEmail;

public class Email implements IEmail {
    private String email;
    private final String name;
    private final String surname;
    private String password;
    private final int defaultPasswordLength = 8;
    private String department;
    private String alternateEmail;
    private final String companySuffix = "company.com";

    public Email(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.department = setDepartment();
        this.password = generatePassword(defaultPasswordLength);
        this.email = generateEmail();
    }

    private String setDepartment() {
        String depName = "";
        System.out.println("Choose department:");
        //wyświetl listę działów z bazy danych
        return depName;
    }

    private String generatePassword(int length) {
        String characters = "abcdefghijklmnoprstuwzvyABCDEFGHIJKLMNOPRSTUWZVY0123456789!@#$%^&*()<>?{}[]/.,";
        StringBuilder password = new StringBuilder();

        for(int i = 0; i < length; i++) {
            int randomSign = (int) (Math.random() * characters.toCharArray().length);
            password.append(characters.toCharArray()[randomSign]);
        }

        return password.toString();
    }


    private String generateEmail() {
        return this.name + "." + this.surname + "@" + this.department + "." + this.companySuffix;
    }


    @Override
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    @Override
    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAlternateEmail() {
        return alternateEmail;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "email: " + email + "\npassword: " + password;
    }
}
