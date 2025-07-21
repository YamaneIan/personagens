package br.com.example.personagens.model;

public class Bot {

    private String nomeBot;
    private double vida;
    private double ataque;

    public void exibirStatus() {
        String status = "\nNome do bot: " + nomeBot
                + "\nVida : " + vida
                + "\nAtaque: " + ataque;

        System.out.println(status);
    }

    public String getNomeBot() {
        return nomeBot;
    }

    public double getVida() {
        return vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void exibirStatusBot() {
        String status = "\nNome do inimigo: " + nomeBot
                + "\nVida : " + vida
                + "\nAtaque: " + ataque;

        System.out.println(status);
    }

    public void setNomeBot(String nomeBot) {
        this.nomeBot = nomeBot;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }
}
