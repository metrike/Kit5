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
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formationId;

    private String name;

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "student_formation",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "formation_professor",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professors;

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "formation_course",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}