package com.example;

import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        String nome = "";
        String email = "";
        int opcoes = 0;

        do {
            imprimirMensagemMesmaLinha("Digite seu nome completo:");
            nome = lerTexto();
            imprimirMensagemMesmaLinha("\nDigite seu e-mail principal:");
            email = lerTexto();

            imprimirMensagem("\nEscolha uma das opções: ");
            imprimirMensagem("0 - Sair");
            imprimirMensagem("1 - Visualizar no Formato HTML");
            imprimirMensagem("2 - Visualizar no Formato JSON");
            imprimirMensagem("Opção selecionada:");
            opcoes = lerNumeroInteiro();

            opcoes = verificarNumeroInvalidoMenu(opcoes);

            encerarPrograma(opcoes);

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

            verificarTipoDeFormatacao(opcoes, html, json);

            imprimirMensagem("\nDeseja inserir mais um nome ?\nDigite 1 para SIM\nDigite 0 para NÃO");

            opcoes = lerNumeroInteiro();

            verificarNumeroInvalido(opcoes);

            encerarPrograma(opcoes);

            read.nextLine();

        } while (opcoes != 0);

        read.close();
    };

    public static int verificarNumeroInvalido(int opcoes) {
        while (opcoes != 1 && opcoes != 0) {
            System.out.println("Número inválido, tenta novamente !");
            opcoes = read.nextInt();
        }
        System.out.println("Número válido !\n");
        return opcoes;
    };

    public static int verificarNumeroInvalidoMenu(int opcoes) {
        while (opcoes != 1 && opcoes != 2 && opcoes != 0) {
            System.out.println("Número inválido, tenta novamente !");
            opcoes = read.nextInt();
        }
        System.out.println("Número válido !\n");
        return opcoes;
    };

    public static void imprimirMensagem(String mensagem) {
        System.out.println(mensagem);
    };

    public static void imprimirMensagemMesmaLinha(String mensagem) {
        System.out.print(mensagem);
    };

    public static int lerNumeroInteiro() {
        return read.nextInt();
    };

    public static String lerTexto() {
        return read.nextLine();
    };

    public static void encerarPrograma(int opcoes) {
        if (opcoes == 0) {
            System.out.println("Programa Finalizado com suceso !");
            System.exit(0);
        }
    };

    public static void verificarTipoDeFormatacao(int opcoes, String html, String json) {
        if (opcoes == 1) {
            System.out.println("\n" + html);
        } else if (opcoes == 2) {
            System.out.println("\n" + json);
        }
    };
};