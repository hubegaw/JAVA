package entity;

import javax.persistence.*;

@Entity
@Table(name = "departments", schema = "company")
public class DepartmentsEntity {
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Basic
    @JoinColumn(name = "ID_worker")
    private int idWorker;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_worker", referencedColumnName = "ID_worker", nullable = false)
    private WorkersEntity workersByIdWorker;
    @Id
    private Long id_depart;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentsEntity that = (DepartmentsEntity) o;

        if (idWorker != that.idWorker) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentName != null ? departmentName.hashCode() : 0;
        result = 31 * result + idWorker;
        return result;
    }

    public WorkersEntity getWorkersByIdWorker() {
        return workersByIdWorker;
    }

    public void setWorkersByIdWorker(WorkersEntity workersByIdWorker) {
        this.workersByIdWorker = workersByIdWorker;
    }

    public Long getId_depart() {
        return id_depart;
    }

    public void setId_depart(Long id_depart) {
        this.id_depart = id_depart;
    }

    @Override
    public String toString() {
        return "DepartmentsEntity{" +
                "departmentName='" + departmentName + '\'' +
                ", idWorker=" + idWorker +
                ", workersByIdWorker=" + workersByIdWorker +
                ", id_depart=" + id_depart +
                '}';
    }
}
