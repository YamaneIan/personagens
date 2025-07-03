package br.com.example.personagens.principal;

import br.com.example.personagens.command.PersonagemCommand;
import br.com.example.personagens.model.Combate;
import br.com.example.personagens.turno.Turno;

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