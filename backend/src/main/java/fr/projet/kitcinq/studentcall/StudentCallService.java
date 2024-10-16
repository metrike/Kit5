package fr.projet.kitcinq.studentcall;

public interface StudentCallService {
    void launch(int courseId);  // Lancer l'appel pour un cours
    void setStudentPresent(int courseId, int studentId);  // Marquer un étudiant présent
    void setStudentAbsent(int courseId, int studentId);  // Marquer un étudiant absent
}
