package fr.projet.kitcinq.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean callPresence = false;

    @Column(nullable = false)
    private LocalDateTime courseAt;

    @ManyToOne
    @JoinTable(
            name = "course_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private SubjectEntity subject;

    @OneToMany(mappedBy = "course")
    private List<StudentCourseEntity> students = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<ProfessorEntity> professors= new ArrayList<>();

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

    public List<StudentCourseEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentCourseEntity> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "CourseEntity{" +
               "courseId=" + courseId +
               ", name='" + name + '\'' +
                ", call=" + callPresence +
               ", courseDate=" + courseAt +
               ", subject=" + subject +
//               ", students=" + students +
//               ", professors=" + professors +
//               ", formation=" + formation +
               '}';
    }
}