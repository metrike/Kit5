package fr.projet.kitcinq.studentcall;

public interface StudentCallService {
    void launch(long courseId);
    void setStudentPresent(long courseId, long studentId);
    void setStudentAbsent(long courseId, long studentId);
}
