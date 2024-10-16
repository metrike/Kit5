INSERT INTO users (users.created_at,users.label,users.password) VALUES (NOW(),"Anthony","azeAZE123"),(NOW(),"Livio","azeAZE123"),(NOW(),"Kevin","azeAZE123"),(NOW(),"Yass","azeAZE123"),(NOW(),"Abou","azeAZE123"),(NOW(),"Admin","azeAZE123"),(NOW(),"Prof","azeAZE123");

INSERT INTO student (first_name, last_name) 
VALUES 
    ("Anthony", "Doe"),
    ("Livio", "Doe"),
    ("Kevin", "Doe"),
    ("Yass", "Doe"),
    ("Abou", "Doe");

INSERT INTO user_student (users_id, student_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO admin (admin_id) 
VALUES (NULL);


INSERT INTO users_admin (users_id, admin_id) 
VALUES (6, 1);

INSERT INTO professor (first_name, last_name) 
VALUES ("Prof", "Doe");

INSERT INTO professor_user (users_id, professor_id) 
VALUES (7, 1);

INSERT INTO formation (name) 
VALUES 
    ("Informatique"),
    ("Mathématiques"),
    ("Physique"),
    ("Chimie");
INSERT INTO course (course_at, name) 
VALUES 
    (NOW(), "Programmation en Python"),
    (NOW(), "Algèbre Linéaire"),
    (NOW(), "Mécanique Quantique"),
    (NOW(), "Chimie Organique");
INSERT INTO subject (name) 
VALUES 
    ("Programmation"),
    ("Mathématiques"),
    ("Physique"),
    ("Chimie");
INSERT INTO formation_course (formation_id, course_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);
INSERT INTO course_subject (subject_id, student_id) 
VALUES 
    (1, 1), 
    (2, 2),
    (3, 3),
    (4, 4);
INSERT INTO student_course (student_id, course_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 1);
INSERT INTO professor_courses (professors_professor_id, courses_course_id) 
VALUES 
    (1, 1), 
    (1, 2), 
    (1, 3), 
    (1, 4); 
INSERT INTO student_formation (formation_id, student_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (1, 5);