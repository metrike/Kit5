import {env} from "@/env";
import {Authentication, MeResponse} from "@/repository/types";
import {StatusCodes} from "http-status-codes";
import User from "@/entity/User";

function generateBasicAuthHeader(authentication: Authentication) {
    return {
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

export const getAllCourse = async (user: User) => {
    try {
        const response = await fetch(`http://localhost:8080/course/AllCourse`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        });

        return await response.text(); //token
    } catch (error) {
        throw new Error("Erreur de connexion: " + error);
    }
};