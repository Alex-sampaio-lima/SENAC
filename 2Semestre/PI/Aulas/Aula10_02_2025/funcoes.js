import prompt from 'prompt-sync';

const read = prompt();

export function ler() {
    let msg = read();
    return msg;
}

export function escrever(msg) {
    console.log(msg);
}