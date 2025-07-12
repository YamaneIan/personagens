package br.com.example.personagens.command;

import br.com.example.personagens.model.Bot;

public class BotCommand {

    Bot bot = new Bot();

    public void criarNomeBot(){
        this.bot.setNomeBot("Luiz");
    }

    public void criarVidaBot(){
        bot.setVida(50);
    }

    public void criarAtaqueBot(){
        bot.setAtaque(10);
    }

    public void exibirStatusBot(){
        this.bot.exibirStatusBot();
    }
}
