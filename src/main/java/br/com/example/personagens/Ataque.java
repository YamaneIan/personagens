package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.Random;
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
        Random random = new Random();
        boolean criticoNormal = random.nextInt(100) < 25;
        double multiplicadorNormal = criticoNormal ? 2 : 1;
        boolean criticoEspecial = random.nextInt(100) < 5;
        double multiplicadorEspecial = criticoEspecial ? 1.5 : 1;

        System.out.println("\nQual ataque usar?\nAtaque normal = 1\nAtaque especial = 2 ");
        int escolherAtaque = leitura.nextInt();

        if (escolherAtaque == 1) {
            if (defensor.isDefendendo()){
                double ataqueFinal = atacante.getAtaque() - defensor.getDefesa();
                ataqueFinal *= multiplicadorNormal;
                defensor.subtrairVida(ataqueFinal);
            } else if (!defensor.isDefendendo()){
                double ataqueFinal = atacante.getAtaque() * multiplicadorNormal;
                defensor.subtrairVida(ataqueFinal);
            }

            System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o ataque normal de "
                    + (criticoNormal ? " com um CRÍTICO de "
                    + atacante.getAtaque() * multiplicadorNormal : atacante.getAtaque())
                    + " pontos de dano!!!"
                    + "\nVida atual de " + defensor.getNomePersonagem()
                    + ": " + defensor.getVida());

        } else if (escolherAtaque == 2 && !atacante.isAtaqueEspecialUsado()) {
            if (defensor.isDefendendo()){
                double ataqueFinal = atacante.getAtaqueEspecial() - defensor.getDefesa();
                ataqueFinal *= multiplicadorEspecial;
                defensor.subtrairVida(ataqueFinal);
            } else if (!defensor.isDefendendo()){
                double ataqueFinal = atacante.getAtaqueEspecial() * multiplicadorEspecial;
                defensor.subtrairVida(ataqueFinal);
            }

            System.out.println("\n" + atacante.getNomePersonagem() + " atacou com o ataque especial de "
                    + (criticoEspecial ? " com um CRÍTICO de "
                    + atacante.getAtaqueEspecial() * multiplicadorEspecial : atacante.getAtaqueEspecial())
                    + " pontos de dano!!!"
                    + "\nVida atual de " + defensor.getNomePersonagem()
                    + ": " + defensor.getVida());
            atacante.usarAtaqueEspecial();
        } else if (atacante.isAtaqueEspecialUsado()){
            System.out.println("Ataque especial ja foi utilizado");
        } else {
            System.out.println("Comando nao encontrado");
        }
    }
}
