package fr.projet.kitcinq.models;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
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

    public Long getFormationId() {
        return formationId;
    }

    public void setFormationId(Long formationId) {
        this.formationId = formationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Formation{" +
               "formationId=" + formationId +
               ", name='" + name + '\'' +
               ", students=" + students +
               ", professors=" + professors +
               ", courses=" + courses +
               '}';
    }
}