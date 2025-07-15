package br.com.example.personagens.principal;

import br.com.example.personagens.LogicaDeCombateBot;
import br.com.example.personagens.command.BotCommand;
import br.com.example.personagens.command.PersonagemCommand;

import java.util.Scanner;

public class CombateBots {

    Scanner leitura = new Scanner(System.in);
    private int opcao = 1;

    public void combateBot(){
        do{
            PersonagemCommand personagemCommand = new PersonagemCommand();
            BotCommand botCommand = new BotCommand();

            personagemCommand.criarNomeJogador();
            personagemCommand.criarNomePersonagem();
            personagemCommand.criarVida();
            personagemCommand.criarAtaque();
            personagemCommand.criarAtaqueEspecial();
            personagemCommand.criarDefesa();

            botCommand.criarNomeBot();
            botCommand.criarVida();
            botCommand.criarAtaque();

            personagemCommand.exibirStatus();
            botCommand.exibirStatusBot();

            LogicaDeCombateBot logicaDeCombateBot = new LogicaDeCombateBot();
            logicaDeCombateBot.guardarPersonagem(personagemCommand.getPersonagem(), botCommand.getBot());

            System.out.println("\nCriar novo combate = 1, \nEncerrar combate = 2\n");
            this.opcao = leitura.nextInt();

            if (opcao > 2){
                System.out.println("\n!!! Comando nao encontrado, ENCERRANDO COMBATE !!!");
            }
        } while (opcao == 1);
    }
}