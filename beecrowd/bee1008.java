package beecrowd;

import java.util.Scanner;

public class bee1008 {
    public static void Main(String[] args) {
        Scanner read = new Scanner(System.in);

        int numeroFuncionario = 0;
        int horasTrabalhadas = 0;
        double salarioPorHora = 0;
        double calculoSalario = 0;

        numeroFuncionario = read.nextInt();
        horasTrabalhadas = read.nextInt();
        salarioPorHora = read.nextDouble();

        calculoSalario = horasTrabalhadas * salarioPorHora;
        
        System.out.printf("NUMBER = %d\n", numeroFuncionario);

        System.out.printf("SALARY = %.2f", calculoSalario);

    };
};
