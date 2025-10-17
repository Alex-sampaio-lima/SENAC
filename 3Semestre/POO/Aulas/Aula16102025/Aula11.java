import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Aula11 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Rascunho
        Pessoa p1 = new Pessoa("Maria", 30);
        Pessoa p2 = new Pessoa("João", 20);
        Pessoa p3 = new Pessoa("José", 50);
        Pessoa p4 = new Pessoa("Maria", 30);

        // System.out.println(p1.equals(p1));
        System.out.println(p1.equals(p4));

        // O ArrayList usa o constains dentro dele
        List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();

        listaDePessoas.add(p1);
        listaDePessoas.add(p2);
        listaDePessoas.add(p3);
        // listaDePessoas.add(p4);

        System.out.println("\n--");
        System.out.println(listaDePessoas.contains(p1));
        System.out.println(listaDePessoas.contains(p4));
        System.out.println(listaDePessoas.contains(new Pessoa("João", 20)));

        // O Set não aceita duplicação de elementos
        Set<Pessoa> setPessoas = new HashSet<>();

        System.out.println("\n--");
        setPessoas.add(p1);
        setPessoas.add(p2);
        setPessoas.add(p3);
        setPessoas.add(p1);
        setPessoas.add(p4);

        for (Pessoa p : setPessoas) {
            System.out.println(p);
        }
        System.out.println("\n\nAtletismo");
        System.out.println("#################");

        // Final Rascunho
        String caminho = "C:\\Users\\alexsander.slima\\Documents\\Aula16102025\\";

        File file = new File(caminho + "dados_atletismo_paris_24.txt");
        Scanner read = new Scanner(file, StandardCharsets.UTF_8);

        Map<ChavePais, Pais> mapDePaises = new HashMap<>();

        while (read.hasNextLine()) {
            String linha = read.nextLine();
            if (linha.charAt(0) != '#') {
                // System.out.println(linha);

                String[] dados = linha.split(",");
                String modalidade = dados[0];
                String paisOuro = dados[1];
                String paisPrata = dados[2];
                String paisBronze = dados[3];

                System.out.println(modalidade);
                System.out.println(paisOuro);
                System.out.println(paisPrata);
                System.out.println(paisBronze);

                // Map<String, Pais> mapDePaises = new HashMap();

                // Pais brasil = new Pais(paisBronze);
                // mapDePaises.put("Brasil", brasil);

                // Pais meuPais = mapDePaises.get("Brasil");

                ChavePais chaveOuro = new ChavePais(paisOuro, 1);
                ChavePais chavePrata = new ChavePais(paisPrata, 2);
                ChavePais chaveBronze = new ChavePais(paisBronze, 3);

                if (!mapDePaises.containsKey(chaveOuro)) {
                    mapDePaises.put(chaveOuro, new Pais(paisOuro));
                }
                if (!mapDePaises.containsKey(chavePrata)) {
                    mapDePaises.put(chavePrata, new Pais(paisPrata));
                }
                if (!mapDePaises.containsKey(chaveBronze)) {
                    mapDePaises.put(chaveBronze, new Pais(paisBronze));
                }

                mapDePaises.get(chaveOuro).adicionaOuro();
                mapDePaises.get(chavePrata).adicionaPrata();
                mapDePaises.get(chaveBronze).adicionaBronze();
            }
        }

        List<Pais> listaDePaises = new ArrayList(mapDePaises.values());

        listaDePaises.sort(Comparator.comparing(Pais::getOuro));

        Collections.reverse(listaDePaises);

        for (Pais p : listaDePaises) {
            System.out.println(p);
        }
    };
};
