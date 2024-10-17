import { env } from "@/env";
import { Authentication, MeResponse, GetCoursesResponse } from "@/repository/types";
import { StatusCodes } from "http-status-codes";

function generateBasicAuthHeader(authentication: Authentication) {
  return {
    Authorization: "Basic " + btoa(`${authentication.username}:${authentication.password}`),
  };
}

async function getMe(authentication: Authentication) {
  const res = await fetch(env.BACKEND_URL + "/me", {
    method: "GET",
    headers: generateBasicAuthHeader(authentication),
  });

  if (res.status === StatusCodes.OK) {
    return MeResponse.parse(await res.json());
  }

  throw new Error("Invalid response");
}

async function getCourses(authentication: Authentication, formation?: string, start?: string, end?: string) {
  let url = env.BACKEND_URL + "/courses";

  const params: string[] = [];
  if (formation) {
    params.push("formation=" + encodeURIComponent(formation));
  }
  if (start) {
    params.push("start=" + encodeURIComponent(start));
  }
  if (end) {
    params.push("end=" + encodeURIComponent(end));
  }

  if (params.length > 0) {
    url += "?" + params.join("&");
  }

  const res = await fetch(url, {
    method: "GET",
    headers: generateBasicAuthHeader(authentication),
  });

  if (res.status === StatusCodes.OK) {
    return GetCoursesResponse.parse(await res.json());
  }

  throw new Error("Invalid response");
}

export { getMe, getCourses };
