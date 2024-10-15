package fr.projet.kitcinq.model;
import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private StudentCourseId id;


    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;


    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Column(name = "presence")
    private boolean presence = false;

    @Override
    public String toString() {
        return "StudentCourseEntity{" +
                "StudentCourseId=" + id +
                ", student=" + student +
                ", course=" + course +
                ", presence=" + presence +
                '}';
    }
}
