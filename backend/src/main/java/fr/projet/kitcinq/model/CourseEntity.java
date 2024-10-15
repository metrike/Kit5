package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;
    private LocalDateTime courseAt;

    @ManyToOne
//    @JoinColumn(name = "subject_id")
    @JoinTable(
            name = "course_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private SubjectEntity subject;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;

    @ManyToMany(mappedBy = "courses")
    private List<ProfessorEntity> professors;

    @ManyToOne
    @JoinColumn(name = "formation_id")
        @JoinTable(
            name = "formation_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private FormationEntity formation;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCourseAt() {
        return courseAt;
    }

    public void setCourseAt(LocalDateTime courseDate) {
        this.courseAt = courseDate;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorEntity> professors) {
        this.professors = professors;
    }

    public FormationEntity getFormation() {
        return formation;
    }

    public void setFormation(FormationEntity formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
               "courseId=" + courseId +
               ", name='" + name + '\'' +
               ", courseDate=" + courseAt +
               ", subject=" + subject +
               ", students=" + students +
               ", professors=" + professors +
               ", formation=" + formation +
               '}';
    }
}