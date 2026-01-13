package br.com.example.personagens.model;


import br.com.example.personagens.exception.AtaqueExcessoException;
import br.com.example.personagens.exception.AtaqueNegativoException;
import br.com.example.personagens.exception.VidaExcessoException;
import br.com.example.personagens.exception.VidaNegativaException;

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
        if (nomeJogador == null){
            throw new Exception("Nome nao pode estar vazio");
        }
        this.nomeJogador = nomeJogador;
    }

    public void setNomePersonagem(String nomePersonagem) throws Exception {
        if (nomePersonagem.length() < 3) {
            throw new Exception("Nome do personagem deve conter 3 ou mais caracteres");
        }
        this.nomePersonagem = nomePersonagem;
    }

    public void setVida(int vida) throws VidaNegativaException {
        if (vida < 0){
            throw new VidaNegativaException("A vida deve ser maior que 0");
        } else if (vida > 100){
            throw new VidaExcessoException("Vida maxima de 100 pontos");
        }
        this.vida = vida;
    }

    public void setAtaque(int ataque) throws AtaqueNegativoException {
        if (ataque < 0) {
            throw new AtaqueNegativoException("O ataque deve ser maior que 0");
        } else if (ataque > 50) {
            throw new AtaqueExcessoException("Ataque maximo de 50 pontos");
        }
        this.ataque = ataque;
    }
}