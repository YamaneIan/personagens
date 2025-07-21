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

        personagem.getNome();
        personagem.getAtaque();
        personagem.getVida();

    }

    @Override
    public String toString() {
        String resultado = "";

        if (personagem.getVida() > bot.getVida()) {
            resultado = personagem.getNome() + " venceu!!! ";
        } else if (personagem.getVida() < bot.getVida()) {
            resultado = bot.getNome() + " venceu!!! ";
        } else if (personagem.getVida() == bot.getVida()) {
            resultado = "O combate empatou!!! ";
        }

        return "\n~~~ Combate entre: " + this.personagem.getNome()
                + " (" + this.personagem.getNomeJogador()
                + ") e " + this.bot.getNome()
                +

                this.personagem.getNome() +
                " ~~~\nVida final: " + this.personagem.getVida() + "\n~~~ " +

                this.bot.getNome() +
                "~~~ \nVida final: " + this.bot.getVida() + "\n" +
                resultado;
    }
}
