package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.Scanner;

public class Ataque {

    private void acao(Personagem atacante, Personagem defensor, Scanner leitura) {
        int escolherAtaque;

        System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
        escolherAtaque = leitura.nextInt();

        if (escolherAtaque == 1) {
            if (defensor.possuiDefesa()){
                int ataqueFinal = atacante.getAtaque() - defensor.getDefesa();
                defensor.subtraiVida(ataqueFinal);
                System.out.println("\nDefesa Usada!!!\n" + defensor.getNomePersonagem());
            } else {
                defensor.subtraiVida(atacante.getAtaque());
            }
            System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o ataque normal de "
                + atacante.getAtaque()
                + " pontos de dano!!!\nVida atual de " + defensor.getNomePersonagem()
                + ": " + defensor.getVida());

        } else if (escolherAtaque == 2) {
            if (!atacante.isAtaqueEspecialUsado()) {
                if (defensor.possuiDefesa()){
                    int ataqueFinal = atacante.getAtaqueEspecial() - defensor.getDefesa();
                    defensor.subtraiVida(ataqueFinal);
                } else {
                    defensor.subtraiVida(atacante.getAtaqueEspecial());
                }
                atacante.usarAtaqueEspecial();
                System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o especial de "
                    + atacante.getAtaqueEspecial()
                    + " pontos de dano!!!\nVida atual de " + defensor.getNomePersonagem()
                    + ": " + defensor.getVida());
            }
        } else {
            System.out.println("Escolha uma das opcoes ou seu ataque especial ja foi utilizado");
        }
    }

    public void atacar(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int atacarPrimeiro;

        System.out.printf("\nQuem vai atacar? \n%s = 1\n%s = 2\nCancelar o ataque = 3 : "
                ,personagem1.getNomePersonagem(),personagem2.getNomePersonagem());

        atacarPrimeiro = leitura.nextInt();

        //Jogador 1 vai atacar
        if (atacarPrimeiro == 1) {
            acao(personagem1, personagem2, leitura);
            //Jogador 2 vai atacar
        } else if (atacarPrimeiro == 2) {
            acao(personagem2, personagem1, leitura);
        } else if (atacarPrimeiro == 3) {
            System.out.println("Cancelando o ataque Testando Ataque.class ");
        } else{
            System.out.println("!!! Comando nao encontrado !!!");
        }

    }

}
