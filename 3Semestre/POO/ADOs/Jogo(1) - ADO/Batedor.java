public class Batedor extends Inimigo {

    public Batedor() {
        super("Batedor", 2000, 600, new Bloqueio(10));
    }

    @Override
    public void fraseDeApresentacao() {
        // TODO Auto-generated method stub
        System.out.println("Olá Fracotes, me chamo Batedor, o Destruidor de Campeões !");
    };

    @Override
    public void fraseDeMorte() {
        System.out.println("SEU IMUNDO !!!!!!");
    };

};
