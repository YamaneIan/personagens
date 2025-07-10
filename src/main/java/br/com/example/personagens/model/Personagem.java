package br.com.example.personagens.model;

import br.com.example.personagens.LogicaDeCombate;
import br.com.example.personagens.exception.NomeInvalidoException;
import br.com.example.personagens.exception.ValorExcessivoException;
import br.com.example.personagens.exception.ValorNegativoException;

public class Personagem {
    private String nomeJogador;
    private String nomePersonagem;
    private int vida;
    private int ataque;
    private int ataqueEspecial;
    private int defesa;
    private boolean ataqueEspecialUsado = false;
    private boolean podeDefender = true;
    private boolean estaDefendendo = false;

    public void exibirStatus() {
        String status = "\nNome do jogador: " + nomeJogador
                + "\nNome do Personagem: " + nomePersonagem
                + "\nVida : " + vida
                + "\nAtaque: " + ataque
                + "\nAtaque Especial: " + ataqueEspecial
                + "\nDefesa: " + defesa;

        System.out.println(status);
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }


    public void setNomeJogador(String nomeJogador) {

        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            throw new NomeInvalidoException("Nome nao pode estar vazio");
        }

        String nomeLimpo = nomeJogador.trim();

        nomeLimpo = nomeLimpo.replaceAll("\\s+", " ");

        this.nomeJogador = nomeLimpo;
    }

    public void setNomePersonagem(String nomePersonagem) {

        if (nomePersonagem.length() < 3) {
            throw new NomeInvalidoException("Nome do personagem deve conter 3 ou mais caracteres");
        }

        String nomeLimpo = nomePersonagem.trim();

        nomeLimpo = nomeLimpo.replaceAll("\\s+", " ");

        this.nomePersonagem = nomeLimpo;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            throw new ValorNegativoException("A vida deve ser maior que 0");
        } else if (vida > 250) {
            throw new ValorExcessivoException("Vida maxima de 250 pontos");
        }
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        if (ataque < 0) {
            throw new ValorNegativoException("O ataque deve ser maior que 0");
        } else if (ataque > 50) {
            throw new ValorExcessivoException("Ataque maximo de 50 pontos");
        }
        this.ataque = ataque;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        if (ataqueEspecial < 0) {
            throw new ValorNegativoException("O ataque especial deve ser maior que 0");
        } else if (ataqueEspecial > 150) {
            throw new ValorExcessivoException("Ataque maximo de 150 pontos");
        }
        this.ataqueEspecial = ataqueEspecial;
    }

    public void setDefesa(int defesa) {
        if (defesa < 0) {
            throw new ValorNegativoException("A defesa deve ser um numero positivo");
        } else if (defesa > 30) {
            throw new ValorExcessivoException("Defesa maxima de 30 pontos");
        }
        this.defesa = defesa;
    }

    public boolean isAtaqueEspecialUsado() {
        return ataqueEspecialUsado;
    }

    public void usarAtaqueEspecial() {
        this.ataqueEspecialUsado = true;
    }

    public void usarDefesa() {
        if (podeDefender) {
            estaDefendendo = true;
            podeDefender = false;
            System.out.println(nomePersonagem + " esta defendendo");
        } else {
            System.out.println("\n!!! Defesa nao pode ser usada duas vezes sem receber golpes !!!");
        }
    }

    public boolean isDefendendo() {
        return estaDefendendo;
    }

    public void subtrairVida(double valor) {
        this.vida -= valor;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

}