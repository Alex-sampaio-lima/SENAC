public class Batalha {
    public static void main(String[] args) {
        Criatura jogador = new Jogador(
                "Chapolin Colorado",
                new Arma[] {
                        new Faca(),
                        new ArcoEFlecha(),
                        new Espada(),
                        new Pistola()
                });

        Criatura inimigo = new Malignus();

        Criatura corredor = new Corredor();

        System.out.println("A BATALHA");
        System.out.println("################\n");
        jogador.fraseDeApresentacao();
        inimigo.fraseDeApresentacao();
        corredor.fraseDeApresentacao();

        while (true) {

            System.out.println("Vez do Jogador: ");
            jogador.fazAtaque(inimigo);

            corredor.fazAtaque(jogador);
            if (inimigo.estaVivo()) {
                System.out.println("Vez do Inimigo: ");
                inimigo.fazAtaque(jogador);
            }

            if (!jogador.estaVivo()) {
                jogador.fraseDeMorte();
                System.out.println("Inimigo Venceu");
                break;
            } else if (!inimigo.estaVivo()) {
                inimigo.fraseDeMorte();
                System.out.println("Jogador Venceu");
                break;
            } else {
                jogador.mostraVida();
                inimigo.mostraVida();
            }

        }

    }
}
