import { z } from "zod";

export type Authentication = {
  username: string;
  password: string;
};

export const MeResponse = z.object({
  role: z.string(),
});

export type MeResponse = z.infer<typeof MeResponse>;

export const GetCoursesResponse = z.array(
  z.object({
    id: z.number(),
    name: z.string(),
    courseAt: z.string(),
    courseEnd: z.string(),
    formationId: z.number(),
    formationName: z.string(),
    subjectId: z.number(),
    subjectName: z.string(),
  })
);

export type GetCoursesResponse = z.infer<typeof GetCoursesResponse>;

export interface Course {
  id: number;
  name: string;
  day: string;
  time: string;
  status: "past" | "current" | "upcoming";
}
