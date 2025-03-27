// Simples
export function calcularDobro(numero: number): number {
    return numero * 2
}

export function calcularNumero(numero: number, numero2: number): number {
    return numero + numero2;
}

export function calcularMedia(nota1: number, nota2: number, nota3: number): number {
    return (nota1 + nota2 + nota3) / 3;
}

export function calcularPrecoAcai(qtdPequeno: number, qtdMedio: number, qtdGrande: number): number {
    return (qtdPequeno * 13.50 + qtdMedio * 15.00 + qtdGrande * 17.50);
}

// Condição

// Ex1
export function diaSemana(dia: number): string {
    let diaDaSemana = '';
    switch (dia) {
        case 0:
            diaDaSemana = ('Domingo');
            break;
        case 1:
            diaDaSemana = ('Segunda-Feira');
            break;
        case 2:
            diaDaSemana = ('Terça-Feira');
            break;
        case 3:
            diaDaSemana = ('Quarta-Feira');
            break;
        case 4:
            diaDaSemana = ('Quinta-Feira');
            break;
        case 5:
            diaDaSemana = ('Sexta-Feira');
            break;
        case 6:
            diaDaSemana = ('Sábado');
            break;
        default:
            diaDaSemana = ('Dia da semana inválido');
            break;
    }

    return diaDaSemana;
}


// Ex2
export function calcularEntrada(entrada: string, qtdEntrda: number): number {

    let precoEntrada: number = 28.50;
    let total: number = 0;

    if (entrada == 'meia') {
        total = (precoEntrada / 2) * qtdEntrda;
    }
    if (entrada == 'inteira') {
        total = precoEntrada * qtdEntrda;
    }

    return total;
}

// Ex3

export function avaliarSituacao(nota1: number, nota2: number, nota3: number) {

    let situacao: string = '';
    let media: number = (nota1 + nota2 + nota3) / 3;

    if (media >= 8) {
        situacao = 'Aprovado com sucesso !';
    } else if (media >= 6 && media <= 8) {
        situacao = 'Aprovado';
    } else if (media >= 3 && media <= 6) {
        situacao = 'Recuperação';
    } else if (media < 3) {
        situacao = 'Reprovado';
    } else {
        situacao = 'Desistente';
    }

    return { media, situacao };
}

// Ex4 

export function corResultante(cor1: string, cor2: string): string {

    let resultado: string = '';

    if ((cor1 == 'vermelho' && cor2 == 'azul') || (cor1 == 'azul' && cor2 == 'vermelho')) {
        resultado = 'Roxo';
    } else if ((cor1 == 'amarelo' && cor2 == 'azul') || (cor2 == 'azul' && cor1 == 'amarelo')) {
        resultado = 'Verde';
    } else if ((cor1 == 'amarelo' && cor2 == 'verde') || (cor2 == 'verde' && cor1 == 'amarelo')) {
        resultado = 'azul'
    } else if (cor1 == cor2) {
        resultado = cor1;
    } else {
        resultado = 'Apenas cores primárias são aceitas';
    }

    return resultado;
}

// Ex5 

export function vestibular(notaCandidato: number, notaDeCorte: number, notaMin: number) {
    let situacao = '';

    if (notaCandidato >= notaMin && notaCandidato <= notaDeCorte) {
        situacao = 'Candidato está na lista de espera...';
    } else if (notaCandidato >= notaMin) {
        situacao = 'Candidato Aprovado!';
    } else {
        situacao = 'Candidato não passou!';
    }


    return situacao;
}

// Repetição

// Ex1

export function vetorRegressivo(numeroInicio: number, numeroFim: number): void {
    for (let i = numeroInicio; i >= numeroFim; i--) {
        console.log(i);
    }
}

// Ex2

export function tabuada(numeroTab: number): void {
    let calculo: number = 0;

    for (let i = 1; i <= 10; i++) {
        calculo = numeroTab * i;
        console.log(`${numeroTab} x ${i} = ${calculo}`);
    }
}

// Ex4 

export function calculaNaturais(numeroNatural: number): number {

    let soma: number = 0;

    for (let i = 1; i <= numeroNatural; i++) {
        soma += i;
    }

    return soma;
}


// Ex5

export function desenharQuadrado(numeroDoQuadrado: number): void {
    for (let i = 0; i < numeroDoQuadrado; i++) {

        for (let j = 0; j < numeroDoQuadrado; j++) {
            process.stdout.write("* ");
        }
        console.log();
    }
}

// Vetor

// Ex1

export function arrayDobro(vetor: number[]): void {

    console.log("Array Inicial: ");
    vetor.forEach(item => {
        process.stdout.write(`${item}` + " ");
    });

    console.log('\n');

    console.log("Array com Dobros: ")
    vetor.forEach(item => {
        process.stdout.write(`${item * 2}` + " ");
    });
}

// Ex2


export function numerosOrdenados(vetor: number[]): string {

    let verificaCrescente: boolean = true;
    let verificaDecrescente: boolean = true;
    let situacao: string = '';

    for (let i = 0; i < vetor.length - 1; i++) {
        let proximoIndice = vetor[i + 1];
        let valorMaisUm = vetor[i] + 1;
        let valorMenosUm = vetor[i] - 1;

        if (valorMaisUm != proximoIndice) {
            verificaCrescente = false;
        }

        if (valorMenosUm != proximoIndice) {
            verificaDecrescente = false;
        }
    }


    if (verificaCrescente) {
        situacao = 'Ordem Crescente!\n'
    } else if (verificaDecrescente) {
        situacao = 'Ordem Descrescente!\n';
    } else {
        situacao = 'Desordenados!\n'
    }

    return situacao;
}