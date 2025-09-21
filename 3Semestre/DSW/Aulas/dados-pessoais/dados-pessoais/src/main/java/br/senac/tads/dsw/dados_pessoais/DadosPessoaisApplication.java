package br.senac.tads.dsw.dados_pessoais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @Configuration
public class DadosPessoaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DadosPessoaisApplication.class, args);
    }

    // @Bean
    // public PessoaService pessoaService() {
    //     return new PessoaService();
    // }

}
