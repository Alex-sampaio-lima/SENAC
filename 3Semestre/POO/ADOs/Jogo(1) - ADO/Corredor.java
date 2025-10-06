public class Corredor extends Inimigo {

    public Corredor() {
        super("Corredor", 1200, 300, new Esquiva(45));
    };

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Olá a todos, me chamo CORREDOR, o ser mais rápido vivo no universo !");
    };

    @Override
    public void fraseDeMorte() {
        System.out.println("Não é possível que você conseguiu me ma... !");
    };

    @Override
    public void fazAtaque(Criatura criaturaAtacada) {
        System.out.println("Corredor realizou ataque !");
        int esquivaEAtaca = this.defesa.getEsquivaEAtaca(50);
        super.tomaDano(esquivaEAtaca);
    };

};
