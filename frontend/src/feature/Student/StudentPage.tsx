"use client"; // Ajout nécessaire pour utiliser useState et useEffect

import React from "react";
import { useStudentPageData } from "./Service/studentPageService";

const daysOfWeek = ["Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"];

const WeekSchedule: React.FC = () => {
  const { studentCoursesData, isLoading } = useStudentPageData();

  if (isLoading) return <div>Chargement...</div>;

  return (
    <div className="container mx-auto p-4">
      <div className="grid grid-cols-6 gap-4">
        {daysOfWeek.map((day) => (
          <div key={day} className="text-center font-bold">
            {day}
          </div>
        ))}
      </div>

      <div className="grid grid-cols-6 gap-4 mt-4">
        {daysOfWeek.map((day) => (
          <div key={day} className="border p-2 space-y-4">
            {studentCoursesData
              .filter((course) => course.day === day)
              .map((course) => (
                <div
                  key={course.id}
                  className={`
                  p-2 rounded-lg text-white
                  ${course.status === "past" ? "bg-gray-400" : ""}
                  ${course.status === "current" ? "bg-blue-500 border-2 border-blue-700" : ""}
                  ${course.status === "upcoming" ? "bg-green-500" : ""}
                `}
                >
                  <span className="block font-semibold">{course.name}</span>
                  <span className="block text-sm">{course.time}</span>
                </div>
              ))}
          </div>
        ))}
      </div>
    </div>
  );
};

export default WeekSchedule;
