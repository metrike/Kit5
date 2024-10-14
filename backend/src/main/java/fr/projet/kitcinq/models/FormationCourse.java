package fr.projet.kitcinq.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class FormationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formationId")
    private Formation formation;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

}
