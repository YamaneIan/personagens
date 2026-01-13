package br.com.example.personagens;

import br.com.example.personagens.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonagensApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonagensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.lutar();
	}
}