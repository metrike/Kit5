import User from "@/entity/User";

export const connexionService = async (user: User) => {
    try {
        const response = await fetch(`http://localhost:8080/user/connect`, {
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
