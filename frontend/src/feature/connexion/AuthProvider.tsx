"use client"; // Pour indiquer que ce composant est un Client Component
import { createContext, useContext, useState, useEffect, ReactNode } from "react";
import Cookies from "universal-cookie";
import { connexionService } from "@/feature/connexion/service/ConnexionService";
import User from "@/entity/User";

const cookies = new Cookies();

interface AuthContextType {
    isAuthenticated: boolean;
    login: (user: User) => Promise<void>;
    logout: () => void;
}

const defaultContextValue: AuthContextType = {
    isAuthenticated: false,
    login: async () => {},
    logout: () => {}
};

const AuthContext = createContext<AuthContextType>(defaultContextValue);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);

    const login = async (user: User) => {
        try {
            const token = await connexionService(user); 
            console.log(token);
            
            setIsAuthenticated(true);
        } catch (error) {
            console.error("Erreur de connexion:", error);
        }
    };

    const logout = () => {
        cookies.remove("token", { path: "/" });
        setIsAuthenticated(false);
    };

    useEffect(() => {
        const token = cookies.get("token");
        if (token) {
            setIsAuthenticated(true); // si un token est trouvé, l'utilisateur est authentifié
        } else {
            setIsAuthenticated(false);
        }
    }, []);

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
    {children}
    </AuthContext.Provider>
);
};

export const useAuth = () => useContext(AuthContext);
