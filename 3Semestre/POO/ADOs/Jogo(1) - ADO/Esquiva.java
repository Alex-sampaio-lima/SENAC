import java.util.Random;

public class Esquiva extends Defesa {
    private int chance;

    Esquiva(int chance) {
        this.chance = chance;
    }

    @Override
    public int getDanoReduzido(int dano) {
        Random rd = new Random();
        int sorteio = rd.nextInt(0, 100);
        if (sorteio < this.chance) {
            // --esquiva bem sucedida;
            System.out.println("Esquivou!!!!!!");
            return 0;
        }
        // --Esquiva falhou
        return dano;
    }

    @Override
    public int getEsquivaEAtaca(int dano) {
        Random rand = new Random();
        int chanceDeDesviar = rand.nextInt(0, 537);
        if (chanceDeDesviar > this.chance) {
            System.out.println("Corredor esquivou e contra atacou !");
            return dano * 2 + chanceDeDesviar;
        }
        return dano;
    }

}
