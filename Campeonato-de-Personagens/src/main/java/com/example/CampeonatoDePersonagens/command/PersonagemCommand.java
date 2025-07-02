package com.example.CampeonatoDePersonagens.command;

import com.example.CampeonatoDePersonagens.Exception.AtaqueNegativoException;
import com.example.CampeonatoDePersonagens.Model.Personagem;

import java.util.Scanner;

public class PersonagemCommand {

    Scanner leitura = new Scanner(System.in);
    Personagem personagem = new Personagem();

    public void criarNomeJogador(){
        try {
            System.out.println("Digite seu nome: ");
            this.personagem.setNomeJogador(leitura.nextLine());
        } catch (Exception e){
            System.out.println(e);
            this.criarNomeJogador();
        }
//        this.nomeJogador = leitura.nextLine();
    }
    public void criarNomePersonagem(){
        try {
            System.out.println("Digite o nome do personagem: ");
            this.personagem.setNomePersonagem(leitura.nextLine());
        } catch (Exception e){
            System.out.println(e);
            this.criarNomePersonagem();
        }
    }

    public void criarVida(){

        try {
            System.out.println("Digite a vida de " + personagem.getNomePersonagem() + " Limite de 100");
            Integer vida = leitura.nextInt();
            personagem.setVida(vida);
        } catch (Exception e) {
            System.out.println("A vida deve ser um numero inteiro ");
            leitura.nextLine();
            this.criarVida();
        }
//        personagem.setVida(leitura.nextInt());
    }

    public void criarAtaque(){
        try {
            System.out.println("Digite o ataque de " + personagem.getNomePersonagem());
            personagem.setAtaque(leitura.nextInt());
        } catch (AtaqueNegativoException e){
            System.out.println("O ataque deve ser maior que 0");
            this.criarAtaque();
        } catch (Exception e) {
            System.out.println("O ataque deve ser um numero inteiro");
            leitura.nextLine();
            this.criarAtaque();
        }
    }

    public Personagem getPersonagem(){
        return personagem;
    }

    public void exibirStatus(){
        this.personagem.exibirStatus();
    }

}
