package br.com.example.personagens.command;

import br.com.example.personagens.exception.NomeInvalidoException;
import br.com.example.personagens.exception.ValorExcessivoException;
import br.com.example.personagens.exception.ValorNegativoException;
import br.com.example.personagens.model.Personagem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonagemCommand {

    Scanner leitura = new Scanner(System.in);
    Personagem personagem = new Personagem();

    public void criarNomeJogador() {
        try {
            System.out.println("Novo jogador, digite seu nome: ");
            this.personagem.setNomeJogador(leitura.nextLine());

        } catch (NomeInvalidoException e){
            System.out.println("Nome invalido");
            this.criarNomeJogador();
        }
    }

    public void criarNomePersonagem() {
        try {
            System.out.println("Digite o nome do personagem: ");
            this.personagem.setNome(leitura.nextLine());

        } catch (NomeInvalidoException e) {
            System.out.println("Nome do personagem deve conter 3 ou mais caracteres");
            this.criarNomePersonagem();
        }
    }

    public void criarVida() {
        try {
            System.out.println("Digite a vida de " + personagem.getNome() + ". Limite de 250");
            personagem.setVida(leitura.nextInt());

        } catch (ValorNegativoException e) {
            System.out.println("A vida deve ser maior que 0");
            this.criarVida();

        } catch (ValorExcessivoException e) {
            System.out.println("Vida maxima de 250 pontos");
            this.criarVida();

        } catch (InputMismatchException e) {
            System.out.println("Valor deve ser um numero inteiro");
            leitura.nextLine();
            this.criarVida();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void criarAtaque() {
        try {
            System.out.println("Digite o ataque de " + personagem.getNome() + ". Limite de 50");
            personagem.setAtaque(leitura.nextInt());

        } catch (ValorNegativoException e) {
            System.out.println("O ataque deve ser maior que 0");
            this.criarAtaque();

        } catch (ValorExcessivoException e) {
            System.out.println("Ataque maximo de 50 pontos");
            this.criarAtaque();

        } catch (InputMismatchException e) {
            System.out.println("Valor deve ser um numero positivo inteiro");
            leitura.nextLine();
            this.criarAtaque();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void criarAtaqueEspecial() {
        try {
            System.out.println("Digite o valor do ataque especial de " +
                    personagem.getNome() + ". Limite de 150");

            personagem.setAtaqueEspecial(leitura.nextInt());

        } catch (ValorNegativoException e) {
            System.out.println("O ataque especial deve ser maior que 0");
            this.criarAtaqueEspecial();

        } catch (ValorExcessivoException e) {
            System.out.println("Ataque especial maximo de 150 pontos");
            this.criarAtaqueEspecial();

        } catch (InputMismatchException e) {
            System.out.println("Valor deve ser um numero positivo inteiro");
            leitura.nextLine();
            this.criarAtaqueEspecial();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void criarDefesa() {
        try {
            System.out.println("Digite o valor da defesa de " +
                    personagem.getNome() + ". Limite de 30 ( Pontos de defesa sao utilizados apenas ao defender )");

            personagem.setDefesa(leitura.nextInt());

        } catch (ValorNegativoException e) {
            System.out.println("A defesa deve ser um numero positivo");
            this.criarAtaqueEspecial();

        } catch (ValorExcessivoException e) {
            System.out.println("Defesa de no maximo 30 pontos");
            this.criarAtaqueEspecial();

        } catch (InputMismatchException e) {
            System.out.println("Valor deve ser um numero positivo inteiro");
            leitura.nextLine();
            this.criarAtaqueEspecial();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void exibirStatus() {
        this.personagem.exibirStatus();
    }
}