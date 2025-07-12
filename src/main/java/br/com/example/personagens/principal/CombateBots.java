package br.com.example.personagens.principal;

import br.com.example.personagens.command.BotCommand;
import br.com.example.personagens.command.PersonagemCommand;

import java.util.Scanner;

public class CombateBots {

    Scanner leitura = new Scanner(System.in);
    private int opcao = 1;

    public void combateBot(){
        do{
            PersonagemCommand personagem = new PersonagemCommand();
            BotCommand bot = new BotCommand();

            personagem.criarNomeJogador();
            personagem.criarNomePersonagem();
            personagem.criarVida();
            personagem.criarAtaque();
            personagem.criarAtaqueEspecial();
            personagem.criarDefesa();

            bot.criarNomeBot();
            bot.criarVidaBot();
            bot.criarAtaqueBot();

            personagem.exibirStatus();
            bot.exibirStatusBot();

            System.out.println("\nCriar novo combate = 1, \nEncerrar combate = 2\n");
            this.opcao = leitura.nextInt();

            if (opcao > 2){
                System.out.println("\n!!! Comando nao encontrado, ENCERRANDO COMBATE !!!");
            }
        } while (opcao == 1);
    }
}
