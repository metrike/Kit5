package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class StudentEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String lastName;
    private String firstName;

    @OneToOne
    @JoinTable(
            name = "user_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private UserEntity users;

    @ManyToOne
    @JoinTable(
            name = "student_formation",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private FormationEntity formation;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourseEntity> courses;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String nom) {
        this.lastName = nom;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String prenom) {
        this.firstName = prenom;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public FormationEntity getFormation() {
        return formation;
    }

    public void setFormation(FormationEntity formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", nom='" + lastName + '\'' +
               ", prenom='" + firstName + '\'' +
               ", users=" + users +
               ", formation=" + formation +
               ", courses=" + courses +
               '}';
    }
}
