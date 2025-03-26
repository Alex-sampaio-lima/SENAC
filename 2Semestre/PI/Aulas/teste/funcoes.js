import prompt from "prompt-sync";

export function ler() {
    const read = prompt();
    console.log("Olá a todos!");
    return read;
}

export function escrever(msg) {
    console.log(msg)
}