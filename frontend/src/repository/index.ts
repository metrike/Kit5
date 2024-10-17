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