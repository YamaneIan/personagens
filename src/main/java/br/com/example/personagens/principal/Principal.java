package br.com.example.personagens.principal;

import br.com.example.personagens.LogicaDeCombate;
import br.com.example.personagens.command.PersonagemCommand;
import br.com.example.personagens.turno.Turno;

import java.util.Scanner;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    private Turno turno = new Turno();
    private int opcao = 1;

    public void lutar() {
        do {
            PersonagemCommand personagemCommand1 = new PersonagemCommand();
            PersonagemCommand personagemCommand2 = new PersonagemCommand();

            personagemCommand1.criarNomeJogador();
            personagemCommand1.criarNomePersonagem();
            personagemCommand1.criarVida();
            personagemCommand1.criarAtaque();
            personagemCommand1.criarAtaqueEspecial();
            personagemCommand1.criarDefesa();

            personagemCommand2.criarNomeJogador();
            personagemCommand2.criarNomePersonagem();
            personagemCommand2.criarVida();
            personagemCommand2.criarAtaque();
            personagemCommand2.criarAtaqueEspecial();
            personagemCommand2.criarDefesa();

            personagemCommand1.exibirStatus();
            personagemCommand2.exibirStatus();

            LogicaDeCombate logicaDeCombate = new LogicaDeCombate();

            logicaDeCombate.guardarPersonagem(personagemCommand1.getPersonagem(), personagemCommand2.getPersonagem());

            logicaDeCombate.iniciarAcao(personagemCommand1.getPersonagem(),personagemCommand2.getPersonagem());

            turno.add(logicaDeCombate);
            System.out.println(logicaDeCombate);

            System.out.println("\nCriar novo combate = 1, \nEncerrar programa = 2\n");
            this.opcao = leitura.nextInt();

            if (opcao > 2){
                System.out.println("\n!!! Comando nao encontrado, ENCERRANDO COMBATE !!!");
            }

        } while (opcao == 1);

        System.out.println("\n!!! Programa encerrado, imprimindo lista de combates: !!! ");
        turno.exibirStatus();

    }

}