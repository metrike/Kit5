"use client"; // Indique que ce composant est un Client Component
import { useEffect, useState } from "react";
import { getAllCourse, getAllStudent } from "@/repository";
import Courses from "@/entity/Courses";
import Students from "@/entity/Students";

const Page = () => {
    const [courses, setCourses] = useState<Courses[]>([]);
    const [selectedCourse, setSelectedCourse] = useState<string>(""); // Pour garder en mémoire le cours sélectionné
    const [students, setStudents] = useState<Students[]>([]);
    const [selectedStudent, setSelectedStudent] = useState<string>(""); // Pour garder en mémoire l'étudiant sélectionné

    // Récupérer les cours et les étudiants lors du montage du composant
    useEffect(() => {
        getAllCourse()
            .then((courses) => setCourses(courses))
            .catch((error) => console.error(error));

        getAllStudent()
            .then((students) => setStudents(students))
            .catch((error) => console.error(error));
    }, []);

    // Gestion de la sélection du cours
    const handleCourseChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedCourse(event.target.value);
    };

    // Gestion de la sélection de l'étudiant
    const handleStudentChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedStudent(event.target.value);
    };

    return (
        <div className="bg-gray-50 h-screen flex items-center justify-center">
            <div className="bg-white p-8 rounded-lg shadow-lg">
                <h1 className="text-3xl font-bold text-center mb-4">Sélectionner un cours et un étudiant</h1>

                {/* Liste déroulante des cours */}
                <div className="mb-4">
                    <label htmlFor="courses" className="block text-sm font-medium text-gray-700">
                        Liste des cours
                    </label>
                    <select
                        id="courses"
                        name="courses"
                        className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        value={selectedCourse}
                        onChange={handleCourseChange}
                    >
                        <option value="">Sélectionnez un cours</option>
                        {courses.map((course) => (
                            <option key={course.id} value={course.id}>
                                {course.name}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Liste déroulante des étudiants */}
                <div className="mb-4">
                    <label htmlFor="students" className="block text-sm font-medium text-gray-700">
                        Liste des étudiants
                    </label>
                    <select
                        id="students"
                        name="students"
                        className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        value={selectedStudent}
                        onChange={handleStudentChange}
                    >
                        <option value="">Sélectionnez un étudiant</option>
                        {students.map((student) => (
                            <option key={student.studentId} value={student.studentId}>
                                {student.firstName} {student.lastName}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Affichage du cours sélectionné */}
                {selectedCourse && (
                    <div className="mt-4">
                        <p className="text-sm text-gray-700">
                            Cours sélectionné : {courses.find(course => course.id === parseInt(selectedCourse))?.name}
                        </p>
                    </div>
                )}

                {/* Affichage de l'étudiant sélectionné */}
                {selectedStudent && (
                    <div className="mt-4">
                        <p className="text-sm text-gray-700">
                            Étudiant sélectionné : {students.find(student => student.studentId === parseInt(selectedStudent))?.firstName}{" "}
                            {students.find(student => student.studentId === parseInt(selectedStudent))?.lastName}
                        </p>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Page;
