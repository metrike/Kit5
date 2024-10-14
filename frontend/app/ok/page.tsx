import {Button} from "@/components/ui/button";
import {hello} from "@/ok";

export default function Ok() {
    return <Button variant="default">{hello()}</Button>
}