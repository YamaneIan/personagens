package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicaDeCombate {

    private Personagem personagem1;
    private Personagem personagem2;

    public void guardarPersonagem(Personagem personagem1, Personagem personagem2) {

        System.out.println("\nAviso: Personagens guardados (LogicaDeCombate.class/guardarPersonagem)");
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;

        personagem1.getNomePersonagem();
        personagem1.getAtaque();
        personagem1.getVida();

        personagem2.getNomePersonagem();
        personagem2.getAtaque();
        personagem2.getVida();

    }

    public void iniciarAcao(Personagem personagem1, Personagem personagem2) {
        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nQual sera a proxima acao?\nAtacar = 1\nDefender = 2\nEncerrar combate = 3\n");
            opcao = leitura.nextInt();

            if (opcao == 1) {
                try {
                    Ataque ataque = new Ataque();
                    ataque.atacar(personagem1, personagem2);
                    System.out.println("~~~ Acao de ataque encerrada ~~~ ");
                } catch (InputMismatchException e) {
                    System.out.println("\n!!! Escolha uma opcao valida !!!");
                    System.out.println("~~~ Acao de ataque encerrada ~~~ ");
                }

                if (personagem1.getVida() == 0 || personagem2.getVida() == 0) {
                    System.out.println("\n!!! Personagem derrotado !!!");
                    break;
                }

            } else if (opcao == 2) {
                Defesa defesa = new Defesa();
                defesa.defender(personagem1, personagem2);
                System.out.println("~~~ Acao de defesa encerrada ~~~");

            } else if (opcao == 3) {
                System.out.println("~~~ Combate encerrado pelo jogador ~~~");
                break;

            } else {
                System.out.println("!!! Comando nao encontrado !!!");
                this.iniciarAcao(personagem1, personagem2);

            }

        } while (true);


    }

    @Override
    public String toString() {
        String resultado = "";
        
        if (personagem1.getVida() > personagem2.getVida()) {
            resultado = personagem1.getNomePersonagem() + " venceu!!! ";
        } else if (personagem1.getVida() < personagem2.getVida()) {
            resultado = personagem2.getNomePersonagem() + " venceu!!! ";
        } else if (personagem1.getVida() == personagem2.getVida()) {
            resultado = "O combate empatou!!! ";
        }

        return "\n~~~ Combate entre: " + this.personagem1.getNomePersonagem()
                + " (" + this.personagem1.getNomeJogador()
                + ") e " + this.personagem2.getNomePersonagem()
                + " (" + this.personagem2.getNomeJogador()
                + ") ~~~\n~~~ " +

                this.personagem1.getNomePersonagem() +
                " ~~~\nVida final: " + this.personagem1.getVida() + "\n~~~ " +

                this.personagem2.getNomePersonagem() +
                "~~~ \nVida final: " + this.personagem2.getVida() + "\n" +
                resultado;
    }
}