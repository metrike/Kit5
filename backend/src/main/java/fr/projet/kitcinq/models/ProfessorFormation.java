package fr.projet.kitcinq.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "professor_formation")
public class ProfessorFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professorId")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "formationId")
    private Formation formation;

    // Getters, Setters, Constructors
}
