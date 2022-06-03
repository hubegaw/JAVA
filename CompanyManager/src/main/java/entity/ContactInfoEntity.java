package entity;

import javax.persistence.*;

@Entity
@Table(name = "contact_info", schema = "company")
public class ContactInfoEntity {
    @Basic
    @JoinColumn(name = "ID_worker")
    private int idWorker;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "alternate_email")
    private String alternateEmail;
    @Basic
    @Column(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_worker", referencedColumnName = "ID_worker", nullable = false)
    private WorkersEntity workersByIdWorker;
    @Id
    private Long id_contact;

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInfoEntity that = (ContactInfoEntity) o;

        if (idWorker != that.idWorker) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (alternateEmail != null ? !alternateEmail.equals(that.alternateEmail) : that.alternateEmail != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorker;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (alternateEmail != null ? alternateEmail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public WorkersEntity getWorkersByIdWorker() {
        return workersByIdWorker;
    }

    public void setWorkersByIdWorker(WorkersEntity workersByIdWorker) {
        this.workersByIdWorker = workersByIdWorker;
    }

    public Long getId_contact() {
        return id_contact;
    }

    public void setId_contact(Long id_contact) {
        this.id_contact = id_contact;
    }

    @Override
    public String toString() {
        return "ContactInfoEntity{" +
                "idWorker=" + idWorker +
                ", email='" + email + '\'' +
                ", alternateEmail='" + alternateEmail + '\'' +
                ", password='" + password + '\'' +
                ", workersByIdWorker=" + workersByIdWorker +
                ", id_contact=" + id_contact +
                '}';
    }
}
