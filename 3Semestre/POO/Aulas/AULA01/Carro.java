public class Carro {
    int ano;
    String cor;
    double potencia;
    String modelo;
    String marca;
    boolean automatico;

    int tanque = 100;

    // Constructor
    Carro(int _ano, String _cor, double _potencia, String _modelo, String _marca, boolean _automatico) {
        System.out.println("\nEstou criando um carro " + _ano);
        this.ano = _ano;
        this.cor = _cor;
        this.potencia = _potencia;
        this.modelo = _modelo;
        this.marca = _marca;
        this.automatico = _automatico;
    }

    public void carroAnda() {
        if (this.tanque > 0) {
            System.out.printf("O nosso %.2f está andando...", potencia);
            System.out.println();
            this.tanque -= 10;
        } else {
            System.out.println("O carro está sem combustivel, não consegue andar.");
        }
    }

    public void abastecer() {
        this.tanque = 100;
    }

    public void mostrarIdade() {
        int idade = 2025 - this.ano;
        System.out.printf("O carro tem %d anos de idade.", idade);
    }

    public void mostrarInfor() {
        System.out.println(
                "ano = " + ano + "\n" +
                        "cor = " + cor + "\n" +
                        "potencia = " + potencia + "\n" +
                        "modelo = " + modelo + "\n" +
                        "marca = " + marca + "\n" +
                        "automatico = " + automatico + "\n"

        );
    }

}
