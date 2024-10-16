package fr.projet.kitcinq.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourseEntity {

    @EmbeddedId
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

    // Getters, setters, et toString

    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    @Override
    public String toString() {
        return "StudentCourseEntity{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", presence=" + presence +
                '}';
    }
}
