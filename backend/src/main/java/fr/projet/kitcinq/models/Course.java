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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "course")
    private Set<ProfessorCourse> professorCourses;

    @OneToMany(mappedBy = "course")
    private Set<FormationCourse> formationCourses;

    @OneToMany(mappedBy = "course")
    private Set<SubjectCourse> subjectCourses;

    // Getters, Setters, Constructors
}