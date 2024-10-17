import {Authentication} from "@/repository/types";
import {create} from "zustand";
import {devtools} from "zustand/middleware/devtools";
import {createJSONStorage, persist} from "zustand/middleware/persist";

export interface AuthenticationState {
    authentication: Authentication | null,
    setAuthentication: (by: Authentication) => void,
}

export const useAuth = create<AuthenticationState>()(
    devtools(
        persist(
            (set) => ({
                authentication: null,
                setAuthentication: (by) => { set({authentication: by}) },
            }),
            {
                name: "login-storage",
                storage: createJSONStorage(() => localStorage)
            }
        )
    )
)