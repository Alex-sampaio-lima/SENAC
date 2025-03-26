function somar() {
    const a = Number(document.getElementById("number1").value);
    const b = Number(document.getElementById("number2").value);
    const soma = a + b;
    document.getElementById("resultado").textContent = `${soma.toFixed(1)}`;
    // alert(`A soma dos produtos são ${soma}`);
};

function mostrarMensagem() {
    alert(`Aqui está primeiro número ${a}`);
};



