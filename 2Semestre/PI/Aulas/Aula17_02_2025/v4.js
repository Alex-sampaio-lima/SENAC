import prompt from 'prompt-sync';


const read = prompt();

let valoresMedia = {
    soma: 0,
    maiorNota: 0,
    menorNota: Number.MAX_VALUE,
    qtdNotas: 0,
    nota: 0,
    media: 0
}

console.log("Informe quantas notas serão apuradas: ");
valoresMedia.qtdNotas = Number(read());

const notas = Array.from({ length: valoresMedia.qtdNotas });

for (let i = 0; i < notas.length; i++) {
    console.log("Informe as notas: ");
    valoresMedia.nota = Number(read());
    notas[i] = valoresMedia.nota;

    if (notas[i] < valoresMedia.menorNota) {
        valoresMedia.menorNota = notas[i];
    }
    if (notas[i] > valoresMedia.maiorNota) {
        valoresMedia.maiorNota = notas[i];
    }

    valoresMedia.soma += notas[i];
}

console.log("");

for (let i = 0; i < notas.length; i++) {
    if (notas[i] > 5) {
        console.log('\x1b[34m%s\x1b[0m', `Notas Azuis ${notas[i]}`);
    }
}

console.log("");
valoresMedia.media = valoresMedia.soma / notas.length;

console.log(`Maior Nota do Aluno: ${valoresMedia.maiorNota}`);
console.log(`Menor Nota do Aluno: ${valoresMedia.menorNota}`);
console.log(`Média do Aluno: ${valoresMedia.menorNota}`);


