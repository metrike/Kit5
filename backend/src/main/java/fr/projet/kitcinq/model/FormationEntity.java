package fr.projet.kitcinq.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formations")
public class FormationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formationId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "student_formation",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> students=new ArrayList<>();

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "formation_professor",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<ProfessorEntity> professors=new ArrayList<>();

    @OneToMany(mappedBy = "formation")
//    @JoinTable(
//            name = "formation_course",
//            joinColumns = @JoinColumn(name = "formation_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses=new ArrayList<>();

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

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Formation{" +
               "formationId=" + formationId +
               ", name='" + name + '\'' +
//               ", students=" + students +
//               ", professors=" + professors +
//               ", courses=" + courses +
               '}';
    }
}