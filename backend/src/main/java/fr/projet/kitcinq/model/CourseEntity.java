package fr.projet.kitcinq.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;

    private Boolean callPresence;

    private LocalDateTime courseAt;

    @ManyToOne
    @JoinColumn(name = "subject_id")  // Correct mapping to SubjectEntity
    private SubjectEntity subject;

    @OneToMany(mappedBy = "course")  // Correct mapping to StudentCourseEntity
    private Set<StudentCourseEntity> students;

    @ManyToMany(mappedBy = "courses")
    private List<ProfessorEntity> professors;

    @ManyToOne
    @JoinColumn(name = "formation_id")  // Correct mapping to FormationEntity
    private FormationEntity formation;

    // Getters and setters

    public Set<StudentCourseEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentCourseEntity> students) {
        this.students = students;
    }

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

    public void setCourseAt(LocalDateTime courseAt) {
        this.courseAt = courseAt;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
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

    public Boolean getCallPresence() {
        return callPresence;
    }

    public void setCallPresence(Boolean callPresence) {
        this.callPresence = callPresence;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", callPresence=" + callPresence +
                ", courseAt=" + courseAt +
                ", subject=" + subject +
                ", students=" + students +
                ", professors=" + professors +
                ", formation=" + formation +
                '}';
    }
}
