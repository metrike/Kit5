import Connexion from "@/feature/connexion/Connexion";
import {AuthProvider} from "@/feature/connexion/AuthProvider";

export default function Home() {
  return (
      <AuthProvider>
        <Connexion />
      </AuthProvider>
  );
}
