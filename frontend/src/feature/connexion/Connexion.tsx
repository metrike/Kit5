"use client"; // Pour indiquer que ce composant est un Client Component

import { useState } from "react";
import { connexionService } from "@/feature/connexion/service/ConnexionService";
import User from "@/entity/User";

import { useAuth } from "@/feature/connexion/AuthProvider";


export const Connexion = () => {
    const [user, setUser] = useState<User>({
        username: "",
        password: ""
    });

    const { login } = useAuth();

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            const response = await login(user);
        } catch (error) {
            console.error("Erreur de connexion", error);
        }
    };

    return (
        <div className="bg-gray-50 h-screen flex items-center justify-center">
            <div className="bg-white p-8 rounded-lg shadow-lg">
                <h1 className="text-3xl font-bold text-center">Connexion</h1>
                <form className="mt-4 space-y-4" onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="label" className="block text-sm font-medium text-gray-700">
                            Adresse e-mail
                        </label>
                        <input
                            type="text"
                            id="label"
                            name="label"
                            value={user.username}
                            onChange={e => setUser({ ...user, username: e.target.value })}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700">
                            Mot de passe
                        </label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={user.password}
                            onChange={e => setUser({ ...user, password: e.target.value })}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                        />
                    </div>
                    <div>
                        <button
                            type="submit"
                            className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                        >
                            Connexion
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Connexion;
