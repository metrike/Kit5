package fr.projet.kitcinq.course;

import java.time.LocalDateTime;

public record Course(
        int id,
        String name,
        LocalDateTime courseAt,
        long formationId,
        String formationName,
        long subjectId,
        String subjectName
) {
}
