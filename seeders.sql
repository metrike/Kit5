-- Insérer des données dans la table admin
INSERT INTO `admin` (`admin_id`) VALUES
(1),
(2),
(3);

-- Insérer des données dans la table users
INSERT INTO `users` (`created_at`, `id`, `label`, `password`) VALUES
(NOW(), 1, 'admin_user', '$2a$10$ulpkVJEcJlWGMcrVyIVrBuJ95jzvDa1HFuAdz4mnY3LWx0YNHqOyu'),
(NOW(), 2, 'professor_user', '$2a$10$ulpkVJEcJlWGMcrVyIVrBuJ95jzvDa1HFuAdz4mnY3LWx0YNHqOyu'),
(NOW(), 3, 'student_user', '$2a$10$ulpkVJEcJlWGMcrVyIVrBuJ95jzvDa1HFuAdz4mnY3LWx0YNHqOyu');

-- Insérer des données dans la table users_admin
INSERT INTO `users_admin` (`admin_id`, `users_id`) VALUES
(1, 1);

-- Insérer des données dans la table student
INSERT INTO `student` (`student_id`, `first_name`, `last_name`) VALUES
(1, 'John', 'Doe'),
(2, 'Jane', 'Smith');

-- Insérer des données dans la table user_student
INSERT INTO `user_student` (`student_id`, `users_id`) VALUES
(1, 3);

-- Insérer des données dans la table professor
INSERT INTO `professor` (`professor_id`, `first_name`, `last_name`) VALUES
(1, 'Dr. Alan', 'Turing'),
(2, 'Dr. Ada', 'Lovelace');

-- Insérer des données dans la table professor_user
INSERT INTO `professor_user` (`professor_id`, `users_id`) VALUES
(1, 2);

-- Insérer des données dans la table course
INSERT INTO `course` (`call_presence`, `course_at`, `course_id`, `name`) VALUES
(b'1', NOW(), 1, 'Algebra Course'),
(b'1', NOW(), 2, 'Mechanics Course');

-- Insérer des données dans la table formation
INSERT INTO `formation` (`formation_id`, `name`) VALUES
(1, 'Engineering'),
(2, 'Science');

-- Insérer des données dans la table formation_course
INSERT INTO `formation_course` (`course_id`, `formation_id`) VALUES
(1, 1),
(2, 2);

-- Insérer des données dans la table professor_courses
INSERT INTO `professor_courses` (`courses_course_id`, `professors_professor_id`) VALUES
(1, 1),
(2, 2);

-- Insérer des données dans la table professor_formation
INSERT INTO `professor_formation` (`formation_id`, `professor_id`) VALUES
(1, 1),
(2, 2);

-- Insérer des données dans la table student_course
INSERT INTO `student_course` (`presence`, `course_id`, `student_id`) VALUES
(b'1', 1, 1),
(b'0', 2, 2);

-- Insérer des données dans la table student_formation
INSERT INTO `student_formation` (`formation_id`, `student_id`) VALUES
(1, 1),
(2, 2);

-- Insérer des données dans la table subject
INSERT INTO `subject` (`subject_id`, `name`) VALUES
(1, 'Algebra'),
(2, 'Mechanics');

-- Insérer des données dans la table course_subject
INSERT INTO `course_subject` (`student_id`, `subject_id`) VALUES
(1, 1),
(2, 2);
