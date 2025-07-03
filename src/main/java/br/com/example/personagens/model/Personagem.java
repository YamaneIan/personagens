package br.com.example.personagens.model;

import br.com.example.personagens.exception.ValorExcessivoException;
import br.com.example.personagens.exception.ValorNegativoException;

public class Personagem {
    private String nomeJogador;
    private String nomePersonagem;
    private int vida;
    private int ataque;
    private int ataqueEspecial;
    private boolean ataqueEspecialUsado = false;

    public void exibirStatus(){
        String status = "\nNome do jogador: " + nomeJogador
                + "\nNome do Personagem: " + nomePersonagem
                + "\nVida : " + vida
                + "\nAtaque: " + ataque
                + "\nAtaque Especial " + ataqueEspecial;

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

    public int getAtaqueEspecial(){ return ataqueEspecial;}


    public void setNomeJogador(String nomeJogador) throws Exception {

        if (nomeJogador == null || nomeJogador.trim().isEmpty()){
            throw new Exception("Nome nao pode estar vazio");
        }

        String nomeLimpo = nomeJogador.trim();

        nomeLimpo = nomeLimpo.replaceAll("\\s+", " ");

        this.nomeJogador = nomeLimpo;
    }

    public void setNomePersonagem(String nomePersonagem) throws Exception {

        if (nomePersonagem.length() < 3) {
            throw new Exception("Nome do personagem deve conter 3 ou mais caracteres");
        }

        String nomeLimpo = nomePersonagem.trim();

        nomeLimpo = nomeLimpo.replaceAll("\\s+", " ");

        this.nomePersonagem = nomeLimpo;
    }

    public void setVida(int vida) {
        if (vida < 0){
            throw new ValorNegativoException("A vida deve ser maior que 0");
        } else if (vida > 250){
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

    public boolean isAtaqueEspecialUsado(){
        return ataqueEspecialUsado;
    }

    public void usarAtaqueEspecial(){
        this.ataqueEspecialUsado = true;
    }

}