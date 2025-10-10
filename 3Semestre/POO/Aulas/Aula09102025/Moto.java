public class Moto implements Veiculo {

    public static Moto minhaMoto;
    private String manca;
    private int ano;

    public Moto(String manca, int ano) {
        this.manca = manca;
        this.ano = ano;
    }

    @Override
    public void acelera() {
        System.out.println("Moto Acelerando");

    }

    @Override
    public void anda() {

        System.out.println("Moto andando");

    }

    @Override
    public void freia() {

        System.out.println("Moto freiando");

    }

}