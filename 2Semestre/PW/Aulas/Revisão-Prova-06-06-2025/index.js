function saudacao(nome) {
    return `Olá ${nome}!`;
};

// console.log(saudacao("Alice"));

let saudacao2 = function (nome) {
    return `Olá seu ${nome} !`;
}

// console.log(saudacao2("Marcio"));

let saudacao3 = (nome) => `Olá ${nome} sua anta !`;

// console.log(saudacao3("Carol"));

function saudacao4(nome = "visitante") {
    return `Olá, ${nome}`;
}

function somar(...numeros) {
    return numeros.reduce((total, num) => total + num, 0);
}

// console.log(somar(1, 2, 4, 5));

function processar(numero, callback) {
    let resultado = numero * 2;
    callback(resultado);
}

processar(5, resultado => {
    console.log(`Resultado : ${resultado}`);
});

function fatorial(n) {
    if (n <= 1) return 1;
    return n * fatorial(n - 1);
}

// console.log(fatorial(3));

(function () {
    console.log("IFE executada imediamente !");
})();


function* contagem() {
    yield 1;
    yield 2;
    yield 3;
    yield 4;
}

let iterador = contagem();

console.log();


async function buscarDados() {
    let resposta = await fetch("")
}