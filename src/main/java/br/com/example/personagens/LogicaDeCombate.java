package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

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
            System.out.println("Atacar = 1\nDefender = 2\nEncerrar combate = 3\n");
            opcao = leitura.nextInt();

            if (opcao == 1) {
                Ataque ataque = new Ataque();
                ataque.atacar(personagem1,personagem2);
                System.out.println("~~~ Acao de ataque encerrada ~~~ ");

                if (personagem1.getVida() == 0 || personagem2.getVida() == 0){
                    System.out.println("\n!!! Personagem derrotado !!!");
                    break;
                }

            } else if (opcao == 2) {
                //Logica de defesa
                System.out.println("~~~ Acao de defesa encerrada ~~~");

            } else if (opcao == 3) {
                System.out.println("~~~ Combate encerrado pelo jogador ~~~");
                break;

            } else {
                System.out.println("!!! Este comando nao foi encontrado !!!");
                this.iniciarAcao(personagem1,personagem2);

            }

        } while (true);
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
