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
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String name;

    @OneToMany(mappedBy = "subject")
//    @JoinTable(
//            name = "subject_course",
//            joinColumns = @JoinColumn(name = "subject_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}
