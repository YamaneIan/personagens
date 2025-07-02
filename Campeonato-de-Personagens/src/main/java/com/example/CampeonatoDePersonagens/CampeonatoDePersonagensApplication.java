package com.example.CampeonatoDePersonagens;

import com.example.CampeonatoDePersonagens.Model.Personagem;
import com.example.CampeonatoDePersonagens.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampeonatoDePersonagensApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoDePersonagensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.lutar();
	}
}
