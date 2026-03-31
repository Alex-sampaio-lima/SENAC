public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa("Alexsander Sampaio Lima");
        PessoaJuridica pj1 = new PessoaJuridica();
        PessoaJuridica pj2 = new PessoaJuridica("Carlos", 1234567891);

        PessoaFisica pf1 = new PessoaFisica();
        PessoaFisica pf2 = new PessoaFisica("Ana Julia Silva", 534419968);

        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario("Maria da Silva", 534412219, 342342342);

        // Pessoa
        System.out.println("Pessoas: \n" + p1.toString());
        System.out.println(p2.toString());

        // Pessoa Jurídica
        System.out.println("Pessoas Jurídicas: \n" + pj1.toString());
        System.out.println(pj2.toString());

        // Pessoa Física
        System.out.println("Pessoas Físicas: \n" + pf1.toString());
        System.out.println(pf2.toString());

        // Funcionário
        System.out.println("Funcionários: \n" + f1.toString());
        System.out.println(f2.toString());
    };
};