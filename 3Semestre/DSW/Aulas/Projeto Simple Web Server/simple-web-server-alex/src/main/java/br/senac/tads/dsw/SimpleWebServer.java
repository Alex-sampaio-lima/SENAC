package br.senac.tads.dsw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exemplo obtido em
 * https://www.baeldung.com/java-serversocket-simple-http-server
 * Alterado com apoio do Github Copilot para tratamento do request body
 *
 * @author fernando.tsuda
 */
public class SimpleWebServer {

	private final int port;
	private static final int THREAD_POOL_SIZE = 10;

	private static String nome = "";
	private static String email = "";
	private static String formatoSaida = "html";
	private static OpcaoSaida formatoJSON;
	private static OpcaoSaida formatoHTML;

	public static String getNome() {
		return nome;
	}

	public static String getEmail() {
		return email;
	}

	public static String getFormatoSaida() {
		return formatoSaida;
	}

	public SimpleWebServer(int port) {
		this.port = port;
	}

	public void start() throws IOException {

		// // PARA JAVA 21+ - usa virtual threads
		// ExecutorService threadPool = Executors.newVirtualThreadPerTaskExecutor();

		ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server started na porta " + port);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				threadPool.execute(() -> handleClient(clientSocket));
			}
		}
	}

	private void handleClient(Socket clientSocket) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

			String requestLine = ""; // A primeira linha da requisição é armazenada na requestLine
			StringBuilder requestHeaders = new StringBuilder(); // Os cabeçalhos(ex: Host, Content-length,etc) são
																// inseridos aqui
			boolean collectinRequestLine = true;

			// OBTENDO CABECALHOS DA REQUEST MESSAGE DO HTTP
			int contentLength = 0;
			String requestInputLine;
			while ((requestInputLine = in.readLine()) != null) {
				if (collectinRequestLine) {
					requestLine = requestInputLine;
					collectinRequestLine = false;
					continue;
				}
				if (requestInputLine.isEmpty()) {
					break;
				}
				requestHeaders.append(requestInputLine).append("\r\n");
				if (requestInputLine.toLowerCase().startsWith("content-length:")) {
					contentLength = Integer.parseInt(requestInputLine.split(":")[1].trim());
				}
			}
			String header = requestHeaders.toString();

			// OBTENDO CORPO DA REQUEST MESSAGE, BASEADO NO TAMANHO (CONTENT-LENGTH)
			String body = "";
			if (contentLength > 0) {
				char[] bodyChars = new char[contentLength];
				in.read(bodyChars, 0, contentLength);
				body = new String(bodyChars);
			}

			// RECONSTROI A REQUEST MESSAGE (PARA DEBUG/DIDATICO)
			String requestMessage = requestLine + "\r\n" + header + "\r\n" + body;
			System.out.println(requestMessage);

			// EXTRAIR PARÂMETROS DA URL
			String query = requestLine.contains("?") ? requestLine.split("\\?")[1].split(" ")[0] : "";
			String[] params = query.split("&");
			nome = "";
			email = "";
			for (String param : params) {
				String[] pair = param.split("=");
				if (pair.length == 2) {
					if (pair[0].equals("nome")) {
						nome = pair[1];
					}
					if (pair[0].equals("email")) {
						email = pair[1];
					}
				}
			}

			// DETECTANDO O TIPO DE SAIDA
			// OpcaoSaida opcao;
			// String formato = SimpleWebServer.getFormatoSaida();

			// if (formato.equals("json")) {
			// opcao = new SaidaJson();
			// } else {
			// opcao = new SaidaHtml();
			// }

			// String responseBodyNew = opcao.gerarResposta(nome, email, requestMessage);
			// out.write("HTTP/1.1 200 OK\r\n");
			// out.write("Content-Type: " + opcao.getContentType() + "\r\n");
			// out.write("Content-length: " + responseBodyNew.length() + "\r\n");
			// out.write("\r\n");
			// out.write(responseBodyNew);

			String responseBodyNew = "";

			if ("json".equalsIgnoreCase(formatoSaida)) {
				SaidaJson saidaJson = new SaidaJson(nome, email);
				responseBodyNew = saidaJson.toJson();
			} else if ("html".equalsIgnoreCase(formatoSaida)) {
				SaidaHtml saidaHtml = new SaidaHtml(nome, email);
				responseBodyNew = saidaHtml.toHtml();
			}

			// monta a resposta HTTP
			String contentType = ("json".equalsIgnoreCase(formatoSaida)) ? "application/json" : "text/html";

			String httpResponse = "HTTP/1.1 200 OK\r\n" +
					"Content-Type: " + contentType + "; charset=UTF-8\r\n" +
					"Content-Length: " + responseBodyNew.getBytes().length + "\r\n" +
					"\r\n" +
					responseBodyNew;

			out.write(httpResponse);
			out.flush();

			// PROCESSAMENTO - GERAR CORPO DA RESPONSE
			String bodyOutTemplate = """
					<!doctype html>
					<html>
						<head>
							<meta charset="UTF-8">
							<title>TADS DSW</title>
						</head>
						<body>
							<h1>Exemplo Servidor Web Java</h1>
							<p>Teste alteração</p>
							<hr>
							<h2>Mensagem Request</h2>
							<pre>{0}</pre>
							<hr>
						</body>
					</html>
					""";

			String responseBody = MessageFormat.format(bodyOutTemplate.replace("'", "''"), requestMessage).trim();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
			ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);

			int length = responseBody.length();

			// GERA RESPONSE LINE + CABECALHOS DA RESPONSE
			out.write("HTTP/1.1 200 OK\r\n");
			out.write("Date: " + formatter.format(now) + "\r\n");
			out.write("Server: Custom Server\r\n");
			out.write("Content-Type: text/html\r\n");
			out.write("Content-Length: " + length + "\r\n");
			out.write("\r\n");

			// ADICIONA CORPO NA RESPONSE
			out.write(responseBody);
		} catch (IOException ex) {
			System.err.println("Error handling client " + ex.getMessage());
		} finally {
			if (clientSocket != null) {
				try {
					clientSocket.close();
				} catch (IOException ex) {
					System.err.println("Error handling client " + ex.getMessage());
				}
			}
		}
	};

	public interface OpcaoSaida {
		String gerarResposta(String nome, String email, String requestMessage);

		String getContentType();
	};

	public class SaidaJson {
		private String nome;
		private String email;

		public SaidaJson(String nome, String email) {
			this.nome = nome;
			this.email = email;
		}

		public String toJson() {
			return "{ \"nome\": \"" + nome + "\", \"email\": \"" + email + "\" }";
		}
	}

	public class SaidaHtml {
		private String nome;
		private String email;

		public SaidaHtml(String nome, String email) {
			this.nome = nome;
			this.email = email;
		}

		public String toHtml() {
			return "<html><body>" +
					"<h1>Dados do Usuário</h1>" +
					"<p>Nome: " + nome + "</p>" +
					"<p>Email: " + email + "</p>" +
					"</body></html>";
		}
	}

	// MAIN
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		nome = scanner.nextLine();

		System.out.print("Digite seu e-mail: ");
		email = scanner.nextLine();

		System.out.print("Escolha o formato de saída (html/json): ");
		String formato = scanner.nextLine().trim().toLowerCase();
		formatoSaida = formato;

		System.out.println("\nServidor iniciado com os seguintes dados:");
		System.out.println("Nome: " + nome);
		System.out.println("Email: " + email);
		System.out.println("Formato: " + formatoSaida);

		int port = 8080;

		SimpleWebServer server = new SimpleWebServer(port);
		new Thread(() -> {
			try {
				server.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Monta a URL com os parâmetros
		String url = "http://localhost:8080/?nome=" + nome + "&email=" + email +
				"&formato=" + formatoSaida;

		// Faz a requisição HTTP
		try (Socket socket = new Socket("localhost", 8080);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			// Envia a requisição GET
			writer.write("GET " + url.substring("http://localhost:8080".length()) + " HTTP/1.1\r\n");
			writer.write("Host: localhost\r\n");
			writer.write("Connection: close\r\n");
			writer.write("\r\n");
			writer.flush();

			// Lê e imprime a resposta
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			System.err.println("Erro ao fazer requisição: " + e.getMessage());
		}
	}

};
