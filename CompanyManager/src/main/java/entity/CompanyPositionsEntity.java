package entity;

import javax.persistence.*;

@Entity
@Table(name = "company_positions", schema = "company")
public class CompanyPositionsEntity {
    @Basic
    @Column(name = "position_name")
    private String positionName;
    @Basic
    @JoinColumn(name = "ID_worker")
    private int idWorker;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_worker", referencedColumnName = "ID_worker", nullable = false)
    private WorkersEntity workersByIdWorker;
    @Id
    private Long id_company;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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

        CompanyPositionsEntity that = (CompanyPositionsEntity) o;

        if (idWorker != that.idWorker) return false;
        if (positionName != null ? !positionName.equals(that.positionName) : that.positionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionName != null ? positionName.hashCode() : 0;
        result = 31 * result + idWorker;
        return result;
    }

    public WorkersEntity getWorkersByIdWorker() {
        return workersByIdWorker;
    }

    public void setWorkersByIdWorker(WorkersEntity workersByIdWorker) {
        this.workersByIdWorker = workersByIdWorker;
    }

    public Long getId_company() {
        return id_company;
    }

    public void setId_company(Long id_company) {
        this.id_company = id_company;
    }

    @Override
    public String toString() {
        return "CompanyPositionsEntity{" +
                "positionName='" + positionName + '\'' +
                ", idWorker=" + idWorker +
                ", workersByIdWorker=" + workersByIdWorker +
                ", id_company=" + id_company +
                '}';
    }
}
