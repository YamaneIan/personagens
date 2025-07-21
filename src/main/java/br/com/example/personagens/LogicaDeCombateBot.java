package br.com.example.personagens;

import br.com.example.personagens.model.Bot;
import br.com.example.personagens.model.Personagem;


public class LogicaDeCombateBot {

    private Personagem personagem;
    private Bot bot;

    public void guardarPersonagem(Personagem personagem,Bot bot) {
        System.out.println("\nAviso: Personagens guardados (LogicaDeCombateBot.class/guardarPersonagem)");

        this.personagem = personagem;
        this.bot = bot;

        personagem.getNomePersonagem();
        personagem.getAtaque();
        personagem.getVida();

    }

    @Override
    public String toString() {
        String resultado = "";

        if (personagem.getVida() > bot.getVida()) {
            resultado = personagem.getNomePersonagem() + " venceu!!! ";
        } else if (personagem.getVida() < bot.getVida()) {
            resultado = bot.getNomeBot() + " venceu!!! ";
        } else if (personagem.getVida() == bot.getVida()) {
            resultado = "O combate empatou!!! ";
        }

        return "\n~~~ Combate entre: " + this.personagem.getNomePersonagem()
                + " (" + this.personagem.getNomeJogador()
                + ") e " + this.bot.getNomeBot()
                +

                this.personagem.getNomePersonagem() +
                " ~~~\nVida final: " + this.personagem.getVida() + "\n~~~ " +

                this.bot.getNomeBot() +
                "~~~ \nVida final: " + this.bot.getVida() + "\n" +
                resultado;
    }
}
