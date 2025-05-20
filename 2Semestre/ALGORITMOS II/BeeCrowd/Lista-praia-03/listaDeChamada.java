
import java.util.*;

public class listaDeChamada {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = 0;
        int k = 0;
        
        n = read.nextInt();
        k = read.nextInt();
        read.nextLine();
        
        String[] alunos = new String[n];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = read.nextLine();
        }
        organizaEsorteiaAlunos(alunos, k);
        read.close();
    };
    
    public static void organizaEsorteiaAlunos(String[] alunos, int k) {
        int min;
        String aux;
        String alunoSorteado = "";
        for (int i = 0; i < alunos.length - 1; i++) {
            min = i;
            for (int j = min + 1; j < alunos.length; j++) {
                if (alunos[j].compareTo(alunos[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                aux = alunos[i];
                alunos[i] = alunos[min];
                alunos[min] = aux;
            }
        }
        
        for (int i = 0; i < k; i++) {
            alunoSorteado = alunos[i];
        }
        System.out.println(alunoSorteado);
    };
};

// String[] alunos = { "maria", "joao", "carlos", "vanessa", "jose" };