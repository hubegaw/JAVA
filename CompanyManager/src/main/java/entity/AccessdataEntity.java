package entity;

import javax.persistence.*;

@Entity
@Table(name = "accessdata", schema = "company")
public class AccessdataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_login")
    private int idLogin;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "ID_worker_position")
    private int idWorkerPosition;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdWorkerPosition() {
        return idWorkerPosition;
    }

    public void setIdWorkerPosition(int idWorkerPosition) {
        this.idWorkerPosition = idWorkerPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessdataEntity that = (AccessdataEntity) o;

        if (idLogin != that.idLogin) return false;
        if (idWorkerPosition != that.idWorkerPosition) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLogin;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + idWorkerPosition;
        return result;
    }
}
