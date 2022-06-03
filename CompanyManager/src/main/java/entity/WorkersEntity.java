package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
@NamedQuery(name="WorkersEntity.ByName", query = "select w from WorkersEntity w left join CompanyPositionsEntity cpe on w.idWorker = cpe.idWorker where cpe.positionName = ?1")
@Entity
@Table(name = "workers", schema = "company")
public class WorkersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_worker")
    private int idWorker;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "age")
    private int age;
    @Basic
    @Column(name = "companyJoinDate")
    private Timestamp companyJoinDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workersByIdWorker", fetch = FetchType.LAZY)
    private Collection<CompanyPositionsEntity> companyPositionsByIdWorker;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workersByIdWorker", fetch = FetchType.LAZY)
    private Collection<ContactInfoEntity> contactInfosByIdWorker;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workersByIdWorker", fetch = FetchType.LAZY)
    private Collection<DepartmentsEntity> departmentsByIdWorker;

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getCompanyJoinDate() {
        return companyJoinDate;
    }

    public void setCompanyJoinDate(Timestamp companyJoinDate) {
        this.companyJoinDate = companyJoinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkersEntity that = (WorkersEntity) o;

        if (idWorker != that.idWorker) return false;
        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (companyJoinDate != null ? !companyJoinDate.equals(that.companyJoinDate) : that.companyJoinDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorker;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (companyJoinDate != null ? companyJoinDate.hashCode() : 0);
        return result;
    }

    public Collection<CompanyPositionsEntity> getCompanyPositionsByIdWorker() {
        return companyPositionsByIdWorker;
    }

    public void setCompanyPositionsByIdWorker(Collection<CompanyPositionsEntity> companyPositionsByIdWorker) {
        this.companyPositionsByIdWorker = companyPositionsByIdWorker;
    }

    public Collection<ContactInfoEntity> getContactInfosByIdWorker() {
        return contactInfosByIdWorker;
    }

    public void setContactInfosByIdWorker(Collection<ContactInfoEntity> contactInfosByIdWorker) {
        this.contactInfosByIdWorker = contactInfosByIdWorker;
    }

    public Collection<DepartmentsEntity> getDepartmentsByIdWorker() {
        return departmentsByIdWorker;
    }

    public void setDepartmentsByIdWorker(Collection<DepartmentsEntity> departmentsByIdWorker) {
        this.departmentsByIdWorker = departmentsByIdWorker;
    }

    @Override
    public String toString() {
        return "WorkersEntity{" +
                "idWorker=" + idWorker +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", companyJoinDate=" + companyJoinDate +
                '}';
    }
}
