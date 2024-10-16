package fr.projet.kitcinq.student.call;

public interface StudentCallService {
    void launch(long courseId);
    void setStudentPresent(long courseId, long studentId);
    void setStudentAbsent(long courseId, long studentId);
}
