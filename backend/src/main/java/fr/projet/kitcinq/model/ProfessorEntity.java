package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String lastName;
    private String firstName;

    @OneToOne
//    @JoinColumn(name = "users_id")
    @JoinTable(
            name = "professor_user",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private UserEntity users;

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
    private List<CourseEntity> courses=new ArrayList<>();

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
               ", users=" + users +
               ", formation=" + formation +
               ", courses=" + courses +
               '}';
    }
}