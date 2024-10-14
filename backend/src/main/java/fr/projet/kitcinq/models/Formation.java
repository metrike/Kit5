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
@Table(name = "formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formationId;

    private String name;

    @OneToMany(mappedBy = "formation")
    private Set<FormationCourse> formationCourses;

    @OneToMany(mappedBy = "formation")
    private Set<ProfessorFormation> professorFormations;

    @OneToMany(mappedBy = "formation")
    private Set<StudentFormation> studentFormations;

    // Getters, Setters, Constructors
}