"use client";

import { useState, useEffect } from "react";
import { Course, GetCoursesResponse } from "@/repository/types";
import dayjs from "dayjs";
import "dayjs/locale/fr";
import { getCourses } from "@/repository/index";
dayjs.locale("fr");

const calculateStatus = (courseAt: string, courseEnd: string): "past" | "current" | "upcoming" => {
  const now = dayjs();
  const startTime = dayjs(courseAt);
  const endTime = dayjs(courseEnd);

  if (now.isBefore(startTime)) return "upcoming";
  if (now.isAfter(endTime)) return "past";
  return "current";
};

const useStudentPageData = (): { studentCoursesData: Course[]; isLoading: boolean } => {
  const [studentCoursesData, setStudentCoursesData] = useState<Course[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const apiCourses = await getCourses();
        const transformedCourses = apiCourses.map((apiCourse) => {
          const startTime = dayjs(apiCourse.courseAt).format("HH:mm");
          const endTime = dayjs(apiCourse.courseEnd).format("HH:mm");
          const day = dayjs(apiCourse.courseAt).format("dddd");
          const status = calculateStatus(apiCourse.courseAt, apiCourse.courseEnd);

          return {
            id: apiCourse.id,
            name: apiCourse.subjectName,
            day: day.charAt(0).toUpperCase() + day.slice(1),
            time: `${startTime} - ${endTime}`,
            status,
          };
        });

        setStudentCoursesData(transformedCourses);
      } catch (error) {
        console.error("Erreur lors de la récupération des cours:", error);
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();
  }, []);

  return { studentCoursesData, isLoading };
};

export { useStudentPageData };
