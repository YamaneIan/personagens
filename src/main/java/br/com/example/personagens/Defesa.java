package br.com.example.personagens;

import br.com.example.personagens.model.Personagem;

import java.util.Scanner;

public class Defesa {

    public void defender(Personagem personagem1, Personagem personagem2){
        Scanner leitura = new Scanner(System.in);
        int defender;

        System.out.printf("\nQuem vai defender? \n%s = 1\n%s = 2\nCancelar a defesa = 3 :\n"
                ,personagem1.getNome(),personagem2.getNome());
        defender = leitura.nextInt();

        if (defender == 1){

            personagem1.usarDefesa();

        } else if (defender == 2) {

            personagem2.usarDefesa();

        } else {
            System.out.println("\n!!! Comando nao encontrado !!!");

        }

    }
}
