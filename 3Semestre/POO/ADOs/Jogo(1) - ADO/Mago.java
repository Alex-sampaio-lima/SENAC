public class Mago extends Inimigo {

    public Mago() {
        super("Mago", 2500, 190, new Bloqueio(23));
    }

    @Override
    public void fraseDeApresentacao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Me chamo Mago, o melhor na arte da feitiçaria !");
    }

    @Override
    public void fraseDeMorte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Impossível que você tenha me derrotado !");
    }

}
