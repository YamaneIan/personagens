package br.com.example.personagens.model;

public class Bot extends Personagem{


    @Override
    public void exibirStatus() {
        String status = "\nNome do bot: " + getNome()
                + "\nVida : " + getVida()
                + "\nAtaque: " + getAtaque();

        System.out.println(status);
    }


    public void exibirStatusBot() {
        String status = "\nNome do inimigo: " + getNome()
                + "\nVida : " + getVida()
                + "\nAtaque: " + getAtaque();

        System.out.println(status);
    }
}
