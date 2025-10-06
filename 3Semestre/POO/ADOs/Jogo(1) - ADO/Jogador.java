import java.util.Random;
import java.util.Scanner;

public class Jogador extends Criatura {

    Arma[] armas;

    public Jogador(String nome, Arma[] armas) {
        super(nome, 1000);
        this.armas = armas;
    }

    @Override
    public void fazAtaque(Criatura criaturaAtacada) {

        Scanner sc = new Scanner(System.in);

        // --MENSAGEM
        System.out.println("Escolha sua arma: ");
        int n = 1;
        for (Arma arma : armas) {
            System.out.print(n + ") ");
            arma.mensagem();
            n++;
        }

        // --ESCOLHA
        int escolha = sc.nextInt();
        while (escolha < 1 || escolha >= n) {
            System.out.println("Número inválido, digite novamente:");
            escolha = sc.nextInt();
        }

        // --APLICA DANO
        int danoDaArma = armas[escolha - 1].getDano();
        criaturaAtacada.tomaDano(danoDaArma);

    }

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Não contava com minha astúcia!");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("Pipipipipipipipipi");
    }

}