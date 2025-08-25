package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        String nome = "";
        String email = "";
        int opcoes = 0;

        do {
            // System.out.println("Digite seu nome completo: ");
            mostrarInfo("Digite seu nome completo:");
            nome = read.nextLine();
            System.out.println("Digite seu e-mail principal:");
            email = read.nextLine();

            System.out.println("Escolha uma das opções: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Visualizar no Formato HTML");
            System.out.println("2 - Visualizar no Formato JSON");
            System.out.print("Opção selecionada:\n\n");
            opcoes = read.nextInt();

            if (opcoes == 0) {
                System.out.println("Programa finalizado com sucesso !");
                break;
            }

            String html = String.format("\n\n<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Revisão Java </title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <section>\r\n" + //
                    "        <table>\r\n" + //
                    "            <thead>\r\n" + //
                    "                <th>Informações de Contato</th>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <td>Nome: %s</td>\r\n" + //
                    "                </tr>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <td>Email: %s</td>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </section>\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html>", nome, email);

            String json = String.format("{\r\n" + //
                    "    \"nome\": \"%s\",\r\n" + //
                    "    \"e-mail\": \"%s\"\r\n" + //
                    "}\n", nome, email);

            if (opcoes == 1) {
                System.out.println("\n" + html);
            } else if (opcoes == 2) {
                System.out.println("\n" + json);
            }

            System.out.println("\nDeseja inserir mais um nome ?\nDigite 1 para SIM\nDigite 2 para NÃO");
            opcoes = read.nextInt();
            while (opcoes != 1 && opcoes != 2) {
                System.out.println("Número inválido, tente novamente !");
                opcoes = read.nextInt();
            }

            if (opcoes == 2) {
                System.out.println("Programa Finalizad com Sucesso !");
                break;
            }
            read.nextLine();
        } while (opcoes != 0);

        read.close();
    };

    public static boolean verificaNumeroInvalido(int opcoes) {

        return true;
    }

    public static void mostrarInfo(String mensagem) {
        System.out.println(mensagem);

    }
};