package br.com.example.personagens.command;

import br.com.example.personagens.model.Bot;

public class BotCommand{
    Bot bot = new Bot();

    public void criarNomeBot(){
        this.bot.setNomeBot("BOT");
    }

    public void criarVida() {
        this.bot.setVida(80);
    }

    public void criarAtaque() {
        this.bot.setAtaque(25);
    }

    public void exibirStatusBot(){
        this.bot.exibirStatusBot();
    }

    public Bot getBot(){
        return bot;
    }

}
