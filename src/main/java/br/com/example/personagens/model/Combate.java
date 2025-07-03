package br.com.example.personagens.model;

import java.util.Scanner;

public class Combate {

    private Personagem personagem1;
    private Personagem personagem2;

    public void guardarPersonagem(Personagem personagem1, Personagem personagem2) {

        System.out.println("\nAviso: Personagens guardados (Combate guardarPersonagem)");
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;

        personagem1.getNomePersonagem();
        personagem1.getAtaque();
        personagem1.getVida();

        personagem2.getNomePersonagem();
        personagem2.getAtaque();
        personagem2.getVida();

    }

    public void atacar(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int vidaAtual1 = personagem1.getVida();
        int vidaAtual2 = personagem2.getVida();
        int atacarPrimeiro;
        int escolherAtaque;

        do {
            System.out.printf("\nQuem vai atacar? \n%s = 1\n%s = 2\nEncerrar o combate = 3 : "
                    ,personagem1.getNomePersonagem(),personagem2.getNomePersonagem());

            atacarPrimeiro = leitura.nextInt();

            //Jogador 1 vai atacar
            if (atacarPrimeiro == 1) {
                System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
                escolherAtaque = leitura.nextInt();

                if (escolherAtaque == 1) {

                    vidaAtual2 -= personagem1.getAtaque();
                    if (vidaAtual2 < 0) {
                        vidaAtual2 = 0;
                    }
                    personagem2.setVida(vidaAtual2);
                    System.out.println("\n" + personagem1.getNomePersonagem() + " atacou com o ataque normal de "
                            + personagem1.getAtaque()
                            + " pontos de dano!!!\nVida atual de " + personagem2.getNomePersonagem()
                            + ": " + personagem2.getVida());

                } else if (escolherAtaque == 2 && !personagem1.isAtaqueEspecialUsado()) {
                    vidaAtual2 -= personagem1.getAtaqueEspecial();
                    if (vidaAtual2 < 0) {
                        vidaAtual2 = 0;
                    }
                    personagem1.usarAtaqueEspecial();
                    personagem2.setVida(vidaAtual2);
                    System.out.println("\n" + personagem1.getNomePersonagem() + " atacou com o especial de "
                            + personagem1.getAtaqueEspecial()
                            + " pontos de dano!!!\nVida atual de " + personagem2.getNomePersonagem()
                            + ": " + personagem2.getVida());

                } else {
                    System.out.println("Escolha uma das opcoes ou seu ataque especial ja foi utilizado");
                }

                //Jogador 2 vai atacar
            } else if (atacarPrimeiro == 2) {
                System.out.println("Ataque normal = 1\nAtaque especial = 2 ");
                escolherAtaque = leitura.nextInt();

                if (escolherAtaque == 1){
                    vidaAtual1 -= personagem2.getAtaque();
                    if (vidaAtual1 < 0){
                        vidaAtual1 = 0;
                    }
                    personagem1.setVida(vidaAtual1);
                    System.out.println("\n" + personagem2.getNomePersonagem() + " atacou com o ataque normal de "
                            + personagem2.getAtaque()
                            + " pontos de dano!!!\nVida atual de " + personagem1.getNomePersonagem()
                            + ": " + personagem1.getVida());

                }else if (escolherAtaque == 2 && !personagem2.isAtaqueEspecialUsado()) {
                    vidaAtual1 -= personagem2.getAtaqueEspecial();
                    if (vidaAtual1 < 0) {
                        vidaAtual1 = 0;
                    }
                    personagem2.usarAtaqueEspecial();
                    personagem1.setVida(vidaAtual1);
                    System.out.println("\n" + personagem2.getNomePersonagem() + " atacou com o especial de "
                            + personagem2.getAtaqueEspecial()
                            + " pontos de dano!!!\nVida atual de " + personagem1.getNomePersonagem()
                            + ": " + personagem1.getVida());

                } else {
                    System.out.println("Escolha uma das opcoes ou seu ataque especial ja foi utilizado");
                }

            } else if (atacarPrimeiro == 3) {
                System.out.println("~~~ Combate encerrado pelo jogador ~~~");
            }

            if (vidaAtual1 == 0 || vidaAtual2 == 0){
                System.out.println("\n~~~ Personagem derrotado ~~~");
                break;
            }
        } while (true);
        System.out.println("\n~~~ Combate encerrado ~~~");
    }

    @Override
    public String toString() {
        return "\n~~~ Combate entre: " + this.personagem1.getNomePersonagem() + " e "
                + this.personagem2.getNomePersonagem() + " ~~~\n~~~ " +

                this.personagem1.getNomePersonagem() +
                " ~~~\nVida final: " + this.personagem1.getVida() + "\n~~~ " +

                this.personagem2.getNomePersonagem() +
                "~~~ \nVida final: " + this.personagem2.getVida();
    }
}
