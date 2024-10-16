package fr.projet.kitcinq.model;
import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    
    @OneToOne
    private UserEntity user;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity users) {
        this.user = users;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
               "adminId=" + adminId +
               ", users=" + user +
               '}';
    }
}