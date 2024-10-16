package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professors")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String lastName;
    private String firstName;

    @OneToOne
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    @JoinTable(
            name = "professor_formation",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private FormationEntity formation;

    @ManyToMany
//    @JoinTable(
//            name = "professor_course",
//            joinColumns = @JoinColumn(name = "professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))


    private List<CourseEntity> courses;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
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

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Professor{" +
               "professorId=" + professorId +
               ", nom='" + lastName + '\'' +
               ", prenom='" + firstName + '\'' +
               ", users=" + user +
               ", formation=" + formation +
               ", courses=" + courses +
               '}';
    }
}