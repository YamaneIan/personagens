package br.com.example.personagens.command;

import br.com.example.personagens.exception.ValorExcessivoException;
import br.com.example.personagens.exception.ValorNegativoException;
import br.com.example.personagens.model.Personagem;

import java.util.InputMismatchException;
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

        } catch (ValorNegativoException e) {
            System.out.println("A vida deve ser maior que 0");
            this.criarVida();

        } catch (ValorExcessivoException e){
            System.out.println("Vida maxima de 100 pontos");
            this.criarVida();

        } catch (InputMismatchException e){
            System.out.println("Valor deve ser um numero inteiro");
            leitura.nextLine();
            this.criarVida();

        } catch (Exception e){
            System.out.println(e);
        }
//        personagem.setVida(leitura.nextInt());
    }

    public void criarAtaque(){
        try {
            System.out.println("Digite o ataque de " + personagem.getNomePersonagem() + ". Limite de 50");
            personagem.setAtaque(leitura.nextInt());

        } catch (ValorNegativoException e) {
            System.out.println("O ataque deve ser maior que 0");
            this.criarAtaque();

        } catch (ValorExcessivoException e){
            System.out.println("Ataque maximo de 50 pontos");
            this.criarAtaque();

        } catch (InputMismatchException e){
            System.out.println("Valor deve ser um numero positivo inteiro");
            leitura.nextLine();
            this.criarAtaque();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public Personagem getPersonagem(){
        return personagem;
    }

    public void exibirStatus(){
        this.personagem.exibirStatus();
    }

}
