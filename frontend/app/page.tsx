import Connexion from "@/feature/connexion/Connexion";
import { AuthProvider } from "@/feature/connexion/AuthProvider";
import AbsencePresenceStudent from "@/feature/Student/StudentPage";

export default function Home() {
  return (
    <AuthProvider>
      <AbsencePresenceStudent />
    </AuthProvider>
  );
}
