import Image from "next/image";
import {Button} from "@/components/ui/button";
import Connexion from "@/feature/Connexion/Connexion";
import {AuthProvider} from "@/feature/Connexion/AuthProvider";

export default function Home() {
  return (
      <AuthProvider>
        <Connexion />

      </AuthProvider>
  );
}
