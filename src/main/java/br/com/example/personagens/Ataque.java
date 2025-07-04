package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.Scanner;

public class Ataque {

    public void atacar(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int vidaAtual1 = personagem1.getVida();
        int vidaAtual2 = personagem2.getVida();
        int atacarPrimeiro;
        int escolherAtaque;

        System.out.printf("\nQuem vai atacar? \n%s = 1\n%s = 2\nCancelar o ataque = 3 : "
                ,personagem1.getNomePersonagem(),personagem2.getNomePersonagem());

        atacarPrimeiro = leitura.nextInt();

        //Jogador 1 vai atacar
        if (atacarPrimeiro == 1) {
            System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
            escolherAtaque = leitura.nextInt();

            if (escolherAtaque == 1) {
                if (personagem2.isEstaDefendendo()){
                    int ataqueFinal = personagem1.getAtaque() - personagem2.getDefesa();
                    vidaAtual2 -= ataqueFinal;
                } else if (!personagem2.isEstaDefendendo()){
                    vidaAtual2 -= personagem1.getAtaque();
                }
                if (vidaAtual2 < 0) {
                    vidaAtual2 = 0;
                }

                personagem2.setVida(vidaAtual2);
                System.out.println("\n" + personagem1.getNomePersonagem() + " atacou com o ataque normal de "
                        + personagem1.getAtaque()
                        + " pontos de dano!!!\nVida atual de " + personagem2.getNomePersonagem()
                        + ": " + vidaAtual2);

            } else if (escolherAtaque == 2 && !personagem1.isAtaqueEspecialUsado()) {
                if (personagem2.isEstaDefendendo()){
                    int ataqueFinal = personagem1.getAtaqueEspecial() - personagem2.getDefesa();
                    vidaAtual2 -= ataqueFinal;
                } else if (!personagem2.isEstaDefendendo()) {
                    vidaAtual2 -= personagem1.getAtaqueEspecial();
                }
                if (vidaAtual2 < 0) {
                    vidaAtual2 = 0;
                }

                personagem1.usarAtaqueEspecial();
                personagem2.setVida(vidaAtual2);
                System.out.println("\n" + personagem1.getNomePersonagem() + " atacou com o especial de "
                        + personagem1.getAtaqueEspecial()
                        + " pontos de dano!!!\nVida atual de " + personagem2.getNomePersonagem()
                        + ": " + vidaAtual2);

            } else {
                System.out.println("Escolha uma das opcoes ou seu ataque especial ja foi utilizado");
            }

            //Jogador 2 vai atacar
        } else if (atacarPrimeiro == 2) {
            System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
            escolherAtaque = leitura.nextInt();

            if (escolherAtaque == 1) {
                if (personagem1.isEstaDefendendo()){
                    int ataqueFinal = personagem2.getAtaque() - personagem1.getDefesa();
                    vidaAtual1 -= ataqueFinal;
                } else if (!personagem1.isEstaDefendendo()){
                    vidaAtual1 -= personagem2.getAtaque();
                }
                if (vidaAtual1 < 0) {
                    vidaAtual1 = 0;
                }

                personagem1.setVida(vidaAtual1);
                System.out.println("\n" + personagem2.getNomePersonagem() + " atacou com o ataque normal de "
                        + personagem2.getAtaque()
                        + " pontos de dano!!!\nVida atual de " + personagem1.getNomePersonagem()
                        + ": " + vidaAtual1);

            } else if (escolherAtaque == 2 && !personagem2.isAtaqueEspecialUsado()) {
                if (personagem1.isEstaDefendendo()){
                    int ataqueFinal = personagem2.getAtaqueEspecial() - personagem1.getDefesa();
                    vidaAtual1 -= ataqueFinal;
                } else if (!personagem1.isEstaDefendendo()) {
                    vidaAtual1 -= personagem2.getAtaqueEspecial();
                }
                if (vidaAtual1 < 0) {
                    vidaAtual1 = 0;
                }

                personagem2.usarAtaqueEspecial();
                personagem1.setVida(vidaAtual1);
                System.out.println("\n" + personagem2.getNomePersonagem() + " atacou com o especial de "
                        + personagem2.getAtaqueEspecial()
                        + " pontos de dano!!!\nVida atual de " + personagem1.getNomePersonagem()
                        + ": " + vidaAtual1);

            } else {
                System.out.println("Escolha uma das opcoes ou seu ataque especial ja foi utilizado");
            }

        } else if (atacarPrimeiro == 3) {
            System.out.println("Cancelando o ataque Testando Ataque.class ");
        } else{
            System.out.println("!!! Comando nao encontrado !!!");
        }

    }

}
