package br.com.example.personagens.model;


import br.com.example.personagens.exception.*;

public class Personagem {
    private String nomeJogador;
    private String nomePersonagem;
    private int vida;
    private int ataque;

//    Scanner leitura  = new Scanner(System.in);

    //    public void criarPersonagem(){
//        System.out.println("Digite seu nome: ");
//        this.nomeJogador = leitura.nextLine();
//
//        System.out.println("Digite o nome do personagem: ");
//        this.nomePersonagem = leitura.nextLine();
//
//    }
//
//    public void criarStatus(){
//        System.out.println("vida de " + nomePersonagem);
//        vida = leitura.nextInt();
//        System.out.println("ataque de " + nomePersonagem);
//        ataque = leitura.nextInt();
//    }
    public void exibirStatus(){
        String status = "\nNome do jogador: " + nomeJogador
                + "\nNome do Personagem: " + nomePersonagem
                + "\nVida : " + vida
                + "\nAtaque: " + ataque;

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


    public void setNomeJogador(String nomeJogador) throws Exception{

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

    public void setVida(int vida) throws ValorNegativoException,ValorExcessivoException {
        if (vida < 0){
            throw new ValorNegativoException("A vida deve ser maior que 0");
        } else if (vida > 100){
            throw new ValorExcessivoException("Vida maxima de 100 pontos");
        }
        this.vida = vida;
    }

    public void setAtaque(int ataque) throws ValorNegativoException,ValorExcessivoException {
        if (ataque < 0) {
            throw new ValorNegativoException("O ataque deve ser maior que 0");
        } else if (ataque > 50) {
            throw new ValorExcessivoException("Ataque maximo de 50 pontos");
        }
        this.ataque = ataque;
    }

}