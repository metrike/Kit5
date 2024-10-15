package fr.projet.kitcinq.models;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String nom;
    private String prenom;

    @OneToOne
//    @JoinColumn(name = "users_id")
    @JoinTable(
            name = "professor_user",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private User users;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToMany
//    @JoinTable(
//            name = "professor_course",
//            joinColumns = @JoinColumn(name = "professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Professor{" +
               "professorId=" + professorId +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", users=" + users +
               ", formation=" + formation +
               ", courses=" + courses +
               '}';
    }
}