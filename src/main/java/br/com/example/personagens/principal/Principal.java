package br.com.example.personagens.principal;

import java.util.Scanner;

public class Principal {

    public void executar(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual tipo de combate? \n1 = Combate entre 2 personagens\n2 = Combate contra inimigos randomizados");
        int opcao = leitura.nextInt();

        if (opcao == 1){
            CombatePersonagens combatePersonagens = new CombatePersonagens();
            combatePersonagens.combatePersonagem();
        } else if (opcao == 2) {
            CombateBots combateBots = new CombateBots();
            combateBots.combateBot();
        }
    }
}
