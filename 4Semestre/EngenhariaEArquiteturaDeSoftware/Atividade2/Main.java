public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa("Alexsander Sampaio Lima");
        PessoaJuridica pj1 = new PessoaJuridica();
        PessoaJuridica pj2 = new PessoaJuridica(1234567891);
        pj2.setNome("Ana Beatriz");

        PessoaFisica pf1 = new PessoaFisica();
        PessoaFisica pf2 = new PessoaFisica(53441);

        Funcionario f1 = new Funcionario();

        // Pessoa
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        // Pessoa Jurídica
        System.out.println(pj1.toString());
        System.out.println(pj2.toString());

        // Pessoa Física
        System.out.println(pf1.toString());
        System.out.println(pf2.toString());

        // Funcionário
        System.out.println(f1.toString());
    };
};