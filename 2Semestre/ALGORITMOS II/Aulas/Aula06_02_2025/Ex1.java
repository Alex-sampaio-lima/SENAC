import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int primeiroNumero = 0;
        int segundoNumero = 0;

        String nome = "";

        System.out.print("Escreva o primeiro número: ");
        primeiroNumero = read.nextInt();

        System.out.print("Escreva o nome do aluno: ");
        nome = read.next();

        System.out.print("Escreva o segundo número: ");
        segundoNumero = read.nextInt();



        primeiroNumero = primeiroNumero - segundoNumero;

        System.out.printf("O %s tem %d anos", nome, primeiroNumero);

        read.close();

    }

}
