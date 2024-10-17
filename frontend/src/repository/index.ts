import {env} from "@/env";
import {Authentication, MeResponse} from "@/repository/types";
import {StatusCodes} from "http-status-codes";
import User from "@/entity/User";
import Courses from "@/entity/Courses";
import Cookies from "universal-cookie";
import Students from "@/entity/Students";


function generateBasicAuthHeader(authentication: Authentication) {
   return{
        // 'Authorization': 'Basic ' + btoa(`${authentication.username}:${authentication.password}`)
        'Authorization': 'Basic ' + btoa(`${authentication.username}:${authentication.password}`)

    }
}

async function getMe(authentication: Authentication) {
    const res = await fetch(env.BACKEND_URL + '/me', {
        method: 'GET',
        headers: generateBasicAuthHeader(authentication)
    })
    
    if (res.status === StatusCodes.OK) {
        return MeResponse.parse(await res.json())
    }
    
    throw new Error('Invalid response')
}

export const getAllCourse = async ():Promise<Courses[]> => {
    const cookies = new Cookies();

    const authentication: Authentication = {
        username: 'livio',
        password: 'livio'
    }

    try {
        const response = await fetch(`http://localhost:8080/course/all-course`, {
            method: 'GET',
            headers: generateBasicAuthHeader(authentication)
        });

        return await response.json() as Courses[];
    } catch (error) {
        throw new Error("Erreur de connexion: " + error);
    }
};

export const getAllStudent = async ():Promise<Students[]> => {
    const cookies = new Cookies();


    const authentication: Authentication = {
        username: 'livio',
        password: 'livio'
    }

    try {
        const response = await fetch(`http://localhost:8080/student/all-students`, {
            method: 'GET',
            headers: generateBasicAuthHeader(authentication)
        });

        return await response.json() as Students[];
    } catch (error) {
        throw new Error("Erreur de connexion: " + error);
    }
}

export const addStudentCourse = async (studentId: number, courseId: number):Promise<void> => {

    const authentication: Authentication = {
        username: 'livio',
        password: 'livio'
    }

    const body = JSON.stringify({
        studentId: studentId,
        courseId: courseId
    });

    try {
        // const response = await fetch(`http://localhost:8080/admin/student-course`, {
        //     method: 'POST',
        //     headers: generateBasicAuthHeader(authentication),
        //     'Content-Type': 'application/json',         // Spécifie que le corps de la requête est JSON
        //     body: body,
        //
        // });

        const url = new URL(`http://localhost:8080/admin/student-course`+`/${courseId}/${studentId}`);
        // url.searchParams.append('courseId', courseId.toString());
        // url.searchParams.append('studentId', studentId.toString());

        // Effectuer la requête GET avec query parameters
        const response = await fetch(url.toString(), {
            method: 'POST',  // Vous pouvez aussi utiliser GET si nécessaire
            headers: generateBasicAuthHeader(authentication)
        });

        if (!response.ok) {
            throw new Error(`Erreur du serveur : ${response.status}`);
        }

    } catch (error) {
        throw new Error("Erreur de connexion: " + error);
    }
}