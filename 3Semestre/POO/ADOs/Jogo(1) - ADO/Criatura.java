public abstract class Criatura {

    private final String nome;
    private int vida;

    public Criatura(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public abstract void fazAtaque(Criatura criaturaAtacada);

    public abstract void fraseDeApresentacao();

    public abstract void fraseDeMorte();

    public void tomaDano(int dano) {
        System.out.println(this.nome + " toma dano de " + dano);
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public boolean estaVivo() {
        return (this.vida > 0);
    }

    public void mostraVida() {
        System.out.println(this.nome + " está com " + this.vida + " de vida.");
    }

}