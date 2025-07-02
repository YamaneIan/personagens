package com.example.CampeonatoDePersonagens.Principal;

import com.example.CampeonatoDePersonagens.Model.Combate;
import com.example.CampeonatoDePersonagens.command.PersonagemCommand;
import com.example.CampeonatoDePersonagens.turno.Turno;

import java.util.Scanner;

public class Principal {
    private Turno turno = new Turno();
    private int opcao = 1;
    Scanner leitura = new Scanner(System.in);

    public void lutar() {
        do {
            PersonagemCommand personagemCommand1 = new PersonagemCommand();
            PersonagemCommand personagemCommand2 = new PersonagemCommand();

            personagemCommand1.criarNomeJogador();
            personagemCommand1.criarNomePersonagem();
            personagemCommand1.criarVida();
            personagemCommand1.criarAtaque();

            personagemCommand2.criarNomeJogador();
            personagemCommand2.criarNomePersonagem();
            personagemCommand2.criarVida();
            personagemCommand2.criarAtaque();

            personagemCommand1.exibirStatus();
            personagemCommand2.exibirStatus();

            Combate combate = new Combate();
            combate.combateInfo(personagemCommand1.getPersonagem(), personagemCommand2.getPersonagem());

            combate.atacar(personagemCommand1.getPersonagem(),personagemCommand2.getPersonagem());

            turno.add(combate);
            System.out.println(combate);

            System.out.println("\nCriar novo combate = 1, \nEncerrar combates = 2");
            this.opcao = leitura.nextInt();

        } while (opcao == 1);

        System.out.println("Programa encerrado, imprimindo lista de combates: ");
        turno.exibirStatus();

//        this.lutar();
    }
}