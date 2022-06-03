package Workers;

import java.sql.Timestamp;
import java.time.Instant;

public class Worker implements IWorker{
    private String name;
    private String surname;
    private int age;
    private final Timestamp companyJoinDate;

    private String email;

    public Worker(Timestamp companyJoinDate) {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.companyJoinDate = companyJoinDate;
    }

    public Worker(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.companyJoinDate = Timestamp.from(Instant.now());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getCompanyJoinDate() {
        return companyJoinDate.toString();
    }

    @Override
    public String getEmail() {
        return email;
    }
}