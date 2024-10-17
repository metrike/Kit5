import User from "@/entity/User";

export const connexionService = async (user: User) => {
    try {
        const response = await fetch(`http://localhost:8080/private`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                login:"livio",
                password:"livio"
            },
            body: JSON.stringify(user),
        });

        return await response.text(); //token
    } catch (error) {
        throw new Error("Erreur de connexion: " + error);
    }
};
