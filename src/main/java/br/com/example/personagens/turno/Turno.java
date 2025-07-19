package br.com.example.personagens.turno;

import br.com.example.personagens.LogicaDeCombate;
import br.com.example.personagens.LogicaDeCombateBot;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private List<LogicaDeCombate> combates = new ArrayList<>();
    private List<LogicaDeCombateBot> combatesBot = new ArrayList<>();

    public void add(LogicaDeCombate combate) {
        this.combates.add(combate);
    }
    public void addBot(LogicaDeCombateBot combateBot) {
        this.combatesBot.add(combateBot);
    }

    public void exibirStatus(){
       for (LogicaDeCombate logicaDeCombate : this.combates) {
           System.out.println(logicaDeCombate.toString());
       }
    }

    public void exibirStatusBot(){
        for (LogicaDeCombateBot logicaDeCombateBot : this.combatesBot) {
            System.out.println(logicaDeCombateBot.toString());
        }
    }
}