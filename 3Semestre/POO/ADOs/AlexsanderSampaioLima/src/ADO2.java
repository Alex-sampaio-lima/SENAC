import java.io.*;
import java.util.*;

public class ADO2 {
    private Map<String, Clube> clubes = new HashMap<>();
    private Map<String, Estado> estados = new HashMap<>();
    private Map<String, String> clubeParaEstado = new HashMap<>();
    private Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        ADO2 app = new ADO2();
        app.iniciar();
    }

    public void iniciar() {
        carregarDados();

        System.out.println("Análise de Dados POO");

        while (true) {
            exibirMenu();
            int opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 1:
                    exercicio1();
                    break;
                case 2:
                    exercicio2();
                    break;
                case 3:
                    exercicio4();
                    break;
                case 4:
                    exercicio5();
                    break;
                case 5:
                    exercicio7();
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado!");
                    read.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("\nPressione Enter para continuar...");
            read.nextLine();
        }
    };

    private void exibirMenu() {
        System.out.println("1 - Gols por ano");
        System.out.println("2 - Gols totais");
        System.out.println("3 - Ranking títulos");
        System.out.println("4 - Ranking pontos");
        System.out.println("5 - Ordenação gen.");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    };

    // Exercício 1
    private void exercicio1() {
        System.out.println("\n=== EXERCÍCIO 1: GOLS POR ANO ESPECÍFICO ===");

        System.out.print("Digite o ano que deseja analisar (ex: 2023): ");
        String ano = read.nextLine().trim();
        String arquivo = "data/" + ano + ".txt";

        System.out.println("TESTE = " + arquivo);

        Map<String, Integer> golsAno = lerDadosAnoEspecifico(arquivo);
        if (golsAno == null || golsAno.isEmpty()) {
            System.out.println("Não foi possível ler os data do ano " + ano);
            return;
        }

        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(golsAno.entrySet());
        listaOrdenada.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nRESULTADO - Ano " + ano);
        System.out.println("Posição | Clube | Gols Marcados");

        for (int i = 0; i < listaOrdenada.size(); i++) {
            Map.Entry<String, Integer> entry = listaOrdenada.get(i);
            System.out.printf("%-8d| %-25s| %d gols%n",
                    (i + 1), entry.getKey(), entry.getValue());
        }
    };

    // Exercício 2
    private void exercicio2() {
        System.out.println("\n=== EXERCÍCIO 2: GOLS TOTAIS (2003-2023) ===");

        List<Clube> listaClubes = new ArrayList<>(clubes.values());
        listaClubes.sort(new GolsComparator<>());

        System.out.println("Posição | Clube | Gols Totais");

        for (int i = 0; i < listaClubes.size(); i++) {
            Clube clube = listaClubes.get(i);
            System.out.printf("%-8d| %-25s| %d gols%n",
                    (i + 1), clube.getNome(), clube.getGolsMarcados());
        }
    }

    // Exercício 4
    private void exercicio4() {
        System.out.println("\n=== EXERCÍCIO 4: RANKING POR TÍTULOS ===");

        List<Clube> listaClubes = new ArrayList<>(clubes.values());
        listaClubes.sort(new TitulosComparator<>());

        System.out.println("Posição |   Clube   |    Títulos |    Vices |     3ºs");

        for (int i = 0; i < listaClubes.size(); i++) {
            Clube clube = listaClubes.get(i);
            System.out.printf("%-8d| %-25s| %-7d| %-5d| %-3d%n",
                    (i + 1), clube.getNome(), clube.getTitulos(),
                    clube.getViceTitulos(), clube.getTerceiros());
        }
    }

    // Exercício 5
    private void exercicio5() {
        System.out.println("\n=== EXERCÍCIO 5: RANKING POR PONTUAÇÃO (9-4-1) ===");

        List<Clube> listaClubes = new ArrayList<>(clubes.values());
        PontuacaoComparator<Clube> comparator = new PontuacaoComparator<>(9, 4, 1);
        listaClubes.sort(comparator);

        System.out.println("Posição | Clube | Pontos  | Tít  | Vic  | 3ºs ");

        for (int i = 0; i < listaClubes.size(); i++) {
            Clube clube = listaClubes.get(i);
            int pontos = clube.getTitulos() * 9 + clube.getViceTitulos() * 4 + clube.getTerceiros() * 1;
            System.out.printf("%-8d| %-25s| %-6d  | %-3d  | %-3d  | %-3d%n",
                    (i + 1), clube.getNome(), pontos, clube.getTitulos(),
                    clube.getViceTitulos(), clube.getTerceiros());
        }
    }

    // Exercício 7
    private void exercicio7() {
        System.out.println("\n=== EXERCÍCIO 7: ORDENAÇÃO GENÉRICA ===");

        System.out.println("1 - Clubes por gols");
        System.out.println("2 - Clubes por títulos");
        System.out.println("3 - Estados por gols");
        System.out.println("4 - Estados por títulos");
        System.out.print("Escolha uma opção: ");

        int opcao = read.nextInt();
        read.nextLine();
        switch (opcao) {
            case 1:
                ordenarEExibir(new ArrayList<>(clubes.values()), new GolsComparator<>(), "CLUBES POR GOLS");
                break;
            case 2:
                ordenarEExibir(new ArrayList<>(clubes.values()), new TitulosComparator<>(), "CLUBES POR TÍTULOS");
                break;
            case 3:
                ordenarEExibir(new ArrayList<>(estados.values()), new GolsComparator<>(), "ESTADOS POR GOLS");
                break;
            case 4:
                ordenarEExibir(new ArrayList<>(estados.values()), new TitulosComparator<>(), "ESTADOS POR TÍTULOS");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    // Método genérico para ordenação (Exercício 7)
    private <T> void ordenarEExibir(List<T> lista, Comparator<T> comparator, String titulo) {
        lista.sort(comparator);

        System.out.println("\n" + titulo);
        System.out.println("=".repeat(titulo.length()));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    };

    private Map<String, Integer> lerDadosAnoEspecifico(String arquivo) {
        Map<String, Integer> golsPorClube = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",");
                if (partes.length >= 8) {
                    try {
                        String nomeClube = partes[1].trim();
                        int gols = Integer.parseInt(partes[7].trim());
                        golsPorClube.put(nomeClube, gols);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro = " + e);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + arquivo);
        }

        return golsPorClube;
    }

    private void carregarDados() {
        carregarMapeamentoEstados();
        processarTodosOsAnos();
    }

    private void carregarMapeamentoEstados() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/estados.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    clubeParaEstado.put(partes[0].trim(), partes[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar data/estados.txt");
        }
    }

    private void processarTodosOsAnos() {
        File pastaDados = new File("data");
        File[] arquivos = pastaDados.listFiles((dir, nome) -> nome.matches("\\d{4}\\.txt"));

        if (arquivos == null) {
            System.out.println("Nenhum arquivo de data encontrado na pasta 'data'!");
            return;
        }

        for (File arquivo : arquivos) {
            processarArquivoAno(arquivo);
        }
    };

    private void processarArquivoAno(File arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                processarLinha(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler: " + arquivo.getName());
        }
    }

    private void processarLinha(String linha) {
        String[] partes = linha.split(",");
        if (partes.length >= 8) {
            try {
                int posicao = Integer.parseInt(partes[0].trim());
                String nomeClube = partes[1].trim();
                int gols = Integer.parseInt(partes[7].trim());

                // Processar clube (Exercício 3 implícito)
                Clube clube = clubes.getOrDefault(nomeClube, new Clube(nomeClube));
                clube.addGols(gols);
                if (posicao == 1) {
                    clube.addTitulo();
                } else if (posicao == 2) {
                    clube.addViceTitulo();
                } else if (posicao == 3) {
                    clube.addTerceiro();
                }
                clubes.put(nomeClube, clube);

                // Processar estado (Exercício 6 implícito)
                String estadoNome = clubeParaEstado.get(nomeClube);
                if (estadoNome != null) {
                    Estado estado = estados.getOrDefault(estadoNome, new Estado(estadoNome));
                    estado.addClube(clube);
                    estados.put(estadoNome, estado);
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro = " + e);
            }
        }
    }
}