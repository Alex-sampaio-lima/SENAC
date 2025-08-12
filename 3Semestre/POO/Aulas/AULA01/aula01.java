
public class aula01 {

    public static void main(String[] args) {
        Carro c1 = new Carro(2013, "Vermelho", 2.0, "HB20", "Hyundai", true);
        // c1.mostrarInfor();
        // c1.carroAnda();
        // c1.mostrarIdade();

        Carro c2 = new Carro(2017, "Prata", 1.6, "WRV", "HONDA", true);
        // c2.mostrarInfor();
        // c2.abastecer();
        // c2.mostrarIdade();
        // c2.carroAnda();

        Carro c3 = new Carro(2003, "Azul", 1.4, "WRV", "HONDA", false);
        // c3.mostrarIdade();
        // c3.mostrarInfor();

        Carro c4 = new Carro(2025, "Preto", 5.0, "I4", "", true);
        c4.mostrarIdade();

        for (int i = 0; i < 11; i++) {
            c1.carroAnda();
        }
        c1.abastecer();
        c1.carroAnda();
    }
}
