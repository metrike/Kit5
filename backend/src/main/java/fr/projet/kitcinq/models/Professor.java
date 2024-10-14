package fr.projet.kitcinq.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String nom;
    private String prenom;

    @OneToOne
//    @JoinColumn(name = "user_id")
    @JoinTable(
            name = "professor_user",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToMany
//    @JoinTable(
//            name = "professor_course",
//            joinColumns = @JoinColumn(name = "professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}