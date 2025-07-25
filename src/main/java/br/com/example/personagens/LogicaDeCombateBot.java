package br.com.example.personagens;

import br.com.example.personagens.model.Bot;
import br.com.example.personagens.model.Personagem;

import java.util.Scanner;


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

    public void iniciaAcao(Personagem personagem, Bot bot) {
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Qual vai ser a sua acao?\n1 = atacar\n2 = defender\n 3 = encerrar combate");
            opcao = leitura.nextInt();

            if (opcao == 1) {

            } else if (opcao == 2) {

            } else if (opcao == 3) {

            } else {

            }
        } while (true);
    }

    @Override
    public String toString() {
        String resultado = "";

        if (personagem.getVida() > bot.getVida()) {
            resultado = personagem.getNomeJogador() + " venceu!!! ";
        } else if (personagem.getVida() < bot.getVida()) {
            resultado = bot.getNome() + " venceu!!! ";
        } else if (personagem.getVida() == bot.getVida()) {
            resultado = "O combate empatou!!! ";
        }

        return "\n~~~ Combate entre: " + this.personagem.getNomeJogador()
                + " (" + this.personagem.getNomeJogador()
                + ") e " + this.bot.getNome()
                +

                this.personagem.getNomeJogador() +
                " ~~~\nVida final: " + this.personagem.getVida() + "\n~~~ " +

                this.bot.getNome() +
                "~~~ \nVida final: " + this.bot.getVida() + "\n" +
                resultado;
    }
}
