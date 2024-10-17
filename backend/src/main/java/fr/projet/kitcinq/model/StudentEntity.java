package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String lastName;
    private String firstName;

    @OneToOne
    private UserEntity user;

    @ManyToOne
    @JoinTable(
            name = "student_formation",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private FormationEntity formation;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourseEntity> courses=new HashSet<>();

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity users) {
        this.user = users;
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
               ", users=" + user +
               ", formation=" + formation +
               ", courses=" + courses +
               '}';
    }
}
