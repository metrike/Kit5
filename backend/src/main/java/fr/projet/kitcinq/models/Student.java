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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String nom;
    private String prenom;
    private String label;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "student")
    private Set<StudentFormation> studentFormations;

    @OneToOne
    private UserStudent userStudent;

    // Getters, Setters, Constructors
}
