package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.model.AdminEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public interface AdminService {

     void addProfessorCourse(Long professorId, Long courseId);

     void addStudentCourse(Long studentId, Long courseId);

     record CreateAdminResult(Long adminId, Long userId) {}

     CreateAdminResult create(long userId);
}
