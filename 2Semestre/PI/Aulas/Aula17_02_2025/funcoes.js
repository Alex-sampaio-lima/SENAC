import prompt from "prompt-sync";

const read = prompt();

export function ler() {
    return Number(prompt());
}

export function escrever(msg) {
    console.log(msg)
}

export function adicionarValoresVetor(vetor) {
    for (let i = 0; i < vetor.length; i++) {
        console.log("Informe as notas: ");
        vetor[i] = Number(read());
    }
    console.log("");
    return vetor;
}


export function media(vetor) {
    adicionarValoresVetor(vetor);
    maiorNota(vetor);
    menorNota(vetor);
    notaAzul(vetor);
    somaEmedia(vetor);
}

export function somaEmedia(vetor) {
    let soma = 0;
    let media = 0;
    for (let i = 0; i < vetor.length; i++) {
        soma += vetor[i];
    }

    media = soma / vetor.length;
    console.log(`A média do Aluno é de: ${media.toFixed(2)}`);
}

export function maiorNota(vetor) {
    let mNota = 0;
    for (let i = 0; i < vetor.length; i++) {
        if (vetor[i] > mNota) {
            mNota = vetor[i];
        }
    }
    console.log(`Maior Nota: ${mNota}`);
}

export function menorNota(vetor) {
    let mNota = Number.MAX_VALUE;
    for (let i = 0; i < vetor.length; i++) {
        if (vetor[i] < mNota) {
            mNota = vetor[i];
        }
        
    }
    console.log(`Menor Nota: ${mNota}`);
    console.log("");
}

export function notaAzul(vetor) {
    for (let i = 0; i < vetor.length; i++) {
        if (vetor[i] > 5) {
            console.log('\x1b[34m%s\x1b[0m', `Notas Azuis: ${vetor[i]}`);
        }
    }
    console.log("");
}





