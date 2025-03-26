import prompt from 'prompt-sync';
import chalk from 'chalk';

const read = prompt();

class Media {

    constructor() {
        this.maNota = 0;
        this.meNota = Number.MAX_VALUE;
        this.qtdNotas = 0;
        this.soma = 0;
        this.media = 0;
        this.notas = [];
        this.count = 0;
    }

    pedirNotas() {
        console.log("Informe quantas notas serão apuradas: ");
        this.qtdNotas = Number(read());
    }

    verificaNota() {
        while (this.notas[this.count] > 10) {
            console.log(chalk.red("Nota inválida! INSIRA UMA NOTA VÁLIDA!"));
            this.notas[this.count] = Number(read());
        }
        console.log(chalk.blue("Nota Válida"));
        console.log(this.notas[this.count]);
        console.log(this.notas[this.notas.length - 1]);
        if (this.notas[this.notas.length - 1] <= 10) {
            // console.log("Passou no ultimo");
        }
        this.count++;
    }

    addNotas() {
        for (let i = 0; i < this.qtdNotas; i++) {
            console.log("Informe a nota: ");
            this.notas[i] = Number(read());
            this.verificaNota();
        }
    }

    maiorNota() {
        for (let i = 0; i < this.qtdNotas; i++) {
            if (this.notas[i] > this.maNota) {
                this.maNota = this.notas[i];
            }

        }
        console.log(`Maior Nota: ${this.maNota}`)
    }

    menorNota() {
        for (let i = 0; i < this.qtdNotas; i++) {
            if (this.notas[i] < this.meNota) {
                this.meNota = this.notas[i];
            }
        }
        console.log(`Menor Nota: ${this.meNota}\n`);
    }

    notaAzul() {
        for (let i = 0; i < this.qtdNotas; i++) {
            if (this.notas[i] > 5) {
                console.log('\x1b[34mNota Azul: \x1b[0m%s', `${this.notas[i]}`);
            } else {
                console.log(chalk.red('Nota Vermelha: ') + this.notas[i]);
            }
        }
    }
}


let media = new Media();

media.pedirNotas();
media.addNotas();
media.maiorNota();
media.menorNota();
media.notaAzul();
