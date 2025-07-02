package com.example.CampeonatoDePersonagens.Model;

import java.util.Scanner;

public class Combate {

    private Personagem personagem1;
    private Personagem personagem2;

    public void combateInfo(Personagem personagem1, Personagem personagem2) {
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;

        personagem1.getNomePersonagem();
        personagem1.getAtaque();
        personagem1.getVida();

        personagem2.getNomePersonagem();
        personagem2.getAtaque();
        personagem2.getVida();

//        System.out.printf("Iniciando combate entre %s e %s"
//                ,personagem1.getNomePersonagem()
//                ,personagem2.getNomePersonagem());

    }

    public void atacar(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int vidaAtual1 = personagem1.getVida();
        int vidaAtual2 = personagem2.getVida();
        int atacarPrimeiro;

        do {
            System.out.println("\nQuem vai atacar? \nPersonagem1 : 1\nPersonagem2 : 2\nEncerrar 3");
            atacarPrimeiro = leitura.nextInt();

                if (atacarPrimeiro == 1) {
                    vidaAtual2 -= personagem1.getAtaque();

                    personagem2.setVida(vidaAtual2);

                } else if (atacarPrimeiro == 2) {
                    vidaAtual1 -= personagem2.getAtaque();

                    personagem1.setVida(vidaAtual1);
                }

                if (vidaAtual1 <= 0 || vidaAtual2 <= 0){
                    System.out.println("\n~~~ Combate encerrado. Personagem derrotado. ~~~\n");
                    break;
                }
        } while (atacarPrimeiro < 3);
            System.out.println("\n~~~ Combate encerrado. ~~~ \n");
    }

    @Override
    public String toString() {
        return "\nCombate entre: " + this.personagem1.getNomePersonagem() + " e "
                + this.personagem2.getNomePersonagem() + "\n" +

                this.personagem1.getNomePersonagem() +
                " ~~~ vida final: " + this.personagem1.getVida() + "\n" +

                this.personagem2.getNomePersonagem() +
                " ~~~ vida final: " + this.personagem2.getVida();
   }
}
