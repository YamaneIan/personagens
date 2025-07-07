package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.Scanner;

public class Ataque {

    public void atacar(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int atacarPrimeiro;

        System.out.printf("\nQuem vai atacar? \n%s = 1\n%s = 2\nCancelar o ataque = 3 : "
                ,personagem1.getNomePersonagem(),personagem2.getNomePersonagem());

        atacarPrimeiro = leitura.nextInt();

        if (atacarPrimeiro == 1) {
            acao(personagem1, personagem2,leitura);
        } else if (atacarPrimeiro == 2) {
            acao(personagem2, personagem1,leitura);
        } else if (atacarPrimeiro == 3) {
            System.out.println("Cancelando o ataque Testando Ataque.class ");
        } else{
            System.out.println("!!! Comando nao encontrado !!!");
        }
    }

    private void acao(Personagem atacante, Personagem defensor, Scanner leitura){
        System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
        int escolherAtaque = leitura.nextInt();

        if (escolherAtaque == 1) {
            if (defensor.isDefendendo()){
                int ataqueFinal = atacante.getAtaque() - defensor.getDefesa();
                defensor.subtrairVida(ataqueFinal);
            } else if (!defensor.isDefendendo()){
                defensor.subtrairVida(atacante.getAtaque());
            }

            System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o ataque normal de "
                    + atacante.getAtaque()
                    + " pontos de dano!!!\nVida atual de " + defensor.getNomePersonagem()
                    + ": " + defensor.getVida());

        } else if (escolherAtaque == 2 && !atacante.isAtaqueEspecialUsado()) {
            if (defensor.isDefendendo()){
                int ataqueFinal = atacante.getAtaqueEspecial() - defensor.getDefesa();
                defensor.subtrairVida(ataqueFinal);
            } else if (!defensor.isDefendendo()) {
                defensor.subtrairVida(atacante.getAtaqueEspecial());
            }

            atacante.usarAtaqueEspecial();
            System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o especial de "
                    + atacante.getAtaqueEspecial()
                    + " pontos de dano!!!\nVida atual de " + defensor.getNomePersonagem()
                    + ": " + defensor.getVida());

        } else if (atacante.isAtaqueEspecialUsado()){
            System.out.println("Ataque especial ja foi utilizado");
        } else {
            System.out.println("Comando nao encontrado");
        }
    }
}
