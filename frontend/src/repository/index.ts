import {env} from "@/env";
import {Authentication, MeResponse} from "@/repository/types";
import {StatusCodes} from "http-status-codes";

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