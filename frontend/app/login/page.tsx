"use client"

import {Button} from "@/components/ui/button";
import {Label} from "@/components/ui/label";
import {Input} from "@/components/ui/input";
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from "@/components/ui/card";
import {useState} from "react";


export default function LoginPage() {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    
    const handleConnect = () => {
        
    }
    
    return (
        <div className="grid justify-center mt-40">
            <Card className="w-[350px]">
                <CardHeader>
                    <CardTitle>Connection</CardTitle>
                    <CardDescription>Entrez vos informations</CardDescription>
                </CardHeader>
                <CardContent>
                    <form>
                        <div className="grid w-full items-center gap-4">
                            <div className="flex flex-col space-y-1.5">
                                <Label htmlFor="name">Nom d&#39;utilisateur</Label>
                                <Input id="name" placeholder="Votre nom d&#39;utilisateur" onChange={(e) => setUsername(e.target.value)} value={username}/>
                            </div>
                            <div className="flex flex-col space-y-1.5">
                                <Label htmlFor="name">Mot de passe</Label>
                                <Input id="name" placeholder="Votre mot de passe" type="password" onChange={(e) => setPassword(e.target.value)} value={password}/>
                            </div>
                        </div>
                    </form>
                </CardContent>
                <CardFooter className="flex justify-between">
                    <div></div>
                    <Button onClick={event => {
                        event.preventDefault()
                        handleConnect()
                    }}>Se connecter</Button>
                </CardFooter>
            </Card>
        </div>
        
    )
}