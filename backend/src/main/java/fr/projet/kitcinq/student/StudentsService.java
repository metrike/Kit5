package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentsService {

    List<StudentEntity> getAllStudents();
}
