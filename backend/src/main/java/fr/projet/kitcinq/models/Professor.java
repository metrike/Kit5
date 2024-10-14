package fr.projet.kitcinq.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user_admin")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "professor")
    private Set<ProfessorCourse> professorCourses;

    @OneToMany(mappedBy = "professor")
    private Set<ProfessorFormation> professorFormations;

    @OneToOne
    private UserProfessor userProfessor;

    // Getters, Setters, Constructors
}