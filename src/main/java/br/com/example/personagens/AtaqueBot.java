package br.com.example.personagens;

import br.com.example.personagens.model.Bot;
import br.com.example.personagens.model.Personagem;

import java.util.Random;
import java.util.Scanner;

public class AtaqueBot {

    public void atacar(Personagem personagem, Bot bot) {
        Scanner leitura = new Scanner(System.in);
        int atacarPrimeiro;

        System.out.printf("\nQuem vai atacar? \n%s = 1\n%s = 2\nCancelar o ataque = 3 : "
                ,personagem.getNome(),bot.getNome());

        atacarPrimeiro = leitura.nextInt();

        if (atacarPrimeiro == 1) {
            acao(personagem, bot, leitura);
        } else if (atacarPrimeiro == 2) {
            acao(personagem, bot, leitura);
        } else if (atacarPrimeiro == 3) {
            System.out.println("Cancelando o ataque Testando Ataque.class ");
        } else {
            System.out.println("!!! Comando nao encontrado !!!");
        }
    }

    private void acao(Personagem atacante, Bot bot, Scanner leitura) {
        Random random = new Random();
        boolean criticoNormal = random.nextInt(100) < 25;
        double multiplicadorNormal = criticoNormal ? 1.5 : 1;
        boolean criticoEspecial = random.nextInt(100) < 10;
        double multiplicadorEspecial = criticoEspecial ? 1.25 : 1;

        System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
        int escolherAtaque = leitura.nextInt();

        if (escolherAtaque == 1) {
            double ataqueFinal = atacante.getAtaque() * multiplicadorNormal;
            bot.subtrairVida(ataqueFinal);

            double danoCausado = criticoNormal
                    ? atacante.getAtaque() * multiplicadorNormal
                    : atacante.getAtaque();

            System.out.println("\n" + atacante.getNome() + " atacou com o ataque normal "
                    + (criticoNormal ? " com um CRÍTICO de " : " com ")
                    + danoCausado
                    + " pontos de dano!!!"
                    + "\nVida atual de " + bot.getNome()
                    + ": " + bot.getVida());

        } else if (escolherAtaque == 2 && !atacante.isAtaqueEspecialUsado()) {

            double ataqueFinal = atacante.getAtaqueEspecial() * multiplicadorEspecial;
            bot.subtrairVida(ataqueFinal);

            double danoCausado = criticoEspecial
                    ? atacante.getAtaqueEspecial() * multiplicadorEspecial
                    : atacante.getAtaqueEspecial();

            System.out.println("\n" + atacante.getNome() + " atacou com o ataque especial"
                    + (criticoEspecial ? " com um CRÍTICO de " : " com " )
                    + danoCausado
                    + " pontos de dano!!!"
                    + "\nVida atual de " + bot.getNome()
                    + ": " + bot.getVida());
            atacante.usarAtaqueEspecial();
        } else if (atacante.isAtaqueEspecialUsado()) {
            System.out.println("Ataque especial ja foi utilizado");
        } else {
            System.out.println("Comando nao encontrado");
        }
    }
}
