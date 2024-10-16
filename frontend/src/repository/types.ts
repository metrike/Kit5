import {z} from "zod";

export type Authentication = {
    username: string,
    password: string
}

export const MeResponse = z.object({
    role: z.string()
})

export type MeResponse = z.infer<typeof MeResponse>