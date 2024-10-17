package fr.projet.kitcinq.student.course;

import fr.projet.kitcinq.student.StudentService;

public interface StudentCourseService {

    record CreateStudentCourseResut(long courseId, long studentId) {}

    StudentCourseService.CreateStudentCourseResut create(long courseId, long studentId);

}
