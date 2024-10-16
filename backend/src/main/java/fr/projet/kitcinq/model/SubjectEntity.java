package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject")
//    @JoinTable(
//            name = "subject_course",
//            joinColumns = @JoinColumn(name = "subject_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Subject{" +
               "subjectId=" + subjectId +
               ", name='" + name + '\'' +
               ", courses=" + courses +
               '}';
    }
}
