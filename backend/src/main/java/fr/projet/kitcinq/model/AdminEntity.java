package fr.projet.kitcinq.model;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    
    @OneToOne
//    @JoinColumn(name = "users")
    @JoinTable(
            name = "users_admin",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private UserEntity users;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
               "adminId=" + adminId +
               ", users=" + users +
               '}';
    }
}