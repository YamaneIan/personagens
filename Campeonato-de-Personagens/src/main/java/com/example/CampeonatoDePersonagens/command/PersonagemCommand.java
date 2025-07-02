package com.example.CampeonatoDePersonagens.command;

import com.example.CampeonatoDePersonagens.Exception.AtaqueExcessoException;
import com.example.CampeonatoDePersonagens.Exception.AtaqueNegativoException;
import com.example.CampeonatoDePersonagens.Exception.VidaExcessoException;
import com.example.CampeonatoDePersonagens.Exception.VidaNegativaException;
import com.example.CampeonatoDePersonagens.Model.Personagem;

import java.util.Scanner;

public class PersonagemCommand {

    Scanner leitura = new Scanner(System.in);
    Personagem personagem = new Personagem();

    public void criarNomeJogador(){
        try {
            System.out.println("Novo jogador, digite seu nome: ");
            this.personagem.setNomeJogador(leitura.nextLine());

        } catch (Exception e){
            System.out.println("Nome nao pode estar vazio");
            this.criarNomeJogador();
        }
//        this.nomeJogador = leitura.nextLine();
    }
    public void criarNomePersonagem(){
        try {
            System.out.println("Digite o nome do personagem: ");
            this.personagem.setNomePersonagem(leitura.nextLine());

        } catch (Exception e){
            System.out.println("Nome do personagem deve conter 3 ou mais caracteres");
            this.criarNomePersonagem();
        }
    }

    public void criarVida(){
        try {
            System.out.println("Digite a vida de " + personagem.getNomePersonagem() + ". Limite de 100");
            personagem.setVida(leitura.nextInt());

        } catch (VidaNegativaException e) {
            System.out.println("A vida deve ser maior que 0");
            this.criarVida();

        } catch (VidaExcessoException e){
            System.out.println("Vida maxima de 100 pontos");
            this.criarVida();

        } catch (Exception e){
            System.out.println(e);
            this.criarVida();
        }
//        personagem.setVida(leitura.nextInt());
    }

    public void criarAtaque(){
        try {
            System.out.println("Digite o ataque de " + personagem.getNomePersonagem() + ". Limite de 50");
            personagem.setAtaque(leitura.nextInt());

        } catch (AtaqueNegativoException e) {
            System.out.println("O ataque deve ser maior que 0");
            this.criarAtaque();

        } catch (AtaqueExcessoException e){
            System.out.println("Ataque maximo de 50 pontos");
            this.criarAtaque();

        } catch (Exception e) {
            System.out.println(e);
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
