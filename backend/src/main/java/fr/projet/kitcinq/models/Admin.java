package fr.projet.kitcinq.models;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String role;

    @OneToOne
//    @JoinColumn(name = "users")
    @JoinTable(
            name = "users_admin",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private User users;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Admin{" +
               "adminId=" + adminId +
               ", role='" + role + '\'' +
               ", users=" + users +
               '}';
    }
}