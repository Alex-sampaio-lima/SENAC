public class Aula10 {

    // Classe Concreta não pode ter método abstrato
    // Pontilhado significa que é uma interface
    public static void main(String[] args) throws Exception {
        System.out.println("OI");

        Moto minhaMoto = new Moto("Yamaha", 2025);

        // minhaMoto.acelera();
        // minhaMoto.anda();
        // minhaMoto.freia();
        // minhaMoto.daGrau();

        RH rh = new RH();
        SistemaDeEnsino sistemaDeEnsino = new SistemaDeEnsino();
        Portaria portaria = new Portaria();
        Oficina oficina = new Oficina();

        Visitante v1 = new Visitante(1111, "Marcela");
        Visitante v2 = new Visitante(1112, "Pedro");
        Visitante v3 = new Visitante(1113, "Joana");

        Professor p1 = new Professor(2111, "Ludovica", 500);
        Professor p2 = new Professor(2112, "Marcos", 50000);
        Professor p3 = new Professor(2113, "Carlos", 1000);

        Aluno a1 = new Aluno(3111, "Maria");
        Aluno a2 = new Aluno(3112, "João");
        Aluno a3 = new Aluno(3113, "Enzo");

        ProfessorDeMecanica pm1 = new ProfessorDeMecanica(1, "Roberto", 40000);
        ProfessorDeMecanica pm2 = new ProfessorDeMecanica(2, "Márcia", 400);
        ProfessorDeMecanica pm3 = new ProfessorDeMecanica(3, "Jose", 4000);

        AlunoMecanica am1 = new AlunoMecanica(1, "Maria");
        AlunoMecanica am2 = new AlunoMecanica(2, "João");

        // Portaria
        portaria.adicionaPessoa(v1);
        portaria.adicionaPessoa(v2);
        portaria.adicionaPessoa(v3);
        portaria.adicionaPessoa(p1);
        portaria.adicionaPessoa(p2);
        portaria.adicionaPessoa(p3);
        portaria.adicionaPessoa(a1);
        portaria.adicionaPessoa(a2);
        portaria.adicionaPessoa(a3);

        portaria.liberaAcesso(1111);
        portaria.liberaAcesso(2113);

        // RH
        rh.adicionaProfessor(p1);
        rh.adicionaProfessor(p2);
        rh.adicionaProfessor(p3);

        // Oficina
        oficina.adicionaMecanico(pm1);
        oficina.adicionaMecanico(pm2);
        oficina.adicionaMecanico(am1);
        oficina.adicionaMecanico(am2);
        oficina.liberaAcesso(pm1.getId());
        oficina.liberaAcesso(pm2.getId());
        oficina.liberaAcesso(am1.getId());
        oficina.liberaAcesso(am2.getId());


        // Sistema de Ensino
        sistemaDeEnsino.adicionaAluno(a1);
        sistemaDeEnsino.adicionaAluno(a2);
        sistemaDeEnsino.adicionaAluno(a3);
        sistemaDeEnsino.adicionaAluno(am1);
        sistemaDeEnsino.adicionaAluno(am2);

        sistemaDeEnsino.fazAvaliacao(a1.getId(), 9.6);
        sistemaDeEnsino.fazAvaliacao(a2.getId(), 8.4);
        sistemaDeEnsino.fazAvaliacao(a3.getId(), 8.5);

    };
};