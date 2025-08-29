public class Main {
    public static void main(String[] args) {

        Maquina m1 = new Maquina(
                "FSD5N22",
                150034,
                "Latitude 3410",
                2015,
                "DELL",
                "20/12/25",
                "20/12/25");

        VetorObjeto primeiroVetor = new VetorObjeto(4);

        System.out.println(primeiroVetor);
        // System.out.println(m1.getMarca());

        // m1.setMarca("HP");

        System.out.println(m1);

        // System.out.println(m1.getMarca());
    }
};