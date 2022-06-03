package Workers;

public interface IWorker {
    void setName(String name);
    void setSurname(String surname);
    void setAge(int age);
    void setEmail(String email);
    String getName();
    String getSurname();
    int getAge();
    String getCompanyJoinDate();
    String getEmail();
}
