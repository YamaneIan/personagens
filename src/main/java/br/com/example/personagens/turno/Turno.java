package br.com.example.personagens.turno;

import br.com.example.personagens.LogicaDeCombate;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private List<LogicaDeCombate> combates = new ArrayList<>();

    public void add(LogicaDeCombate combate) {
        this.combates.add(combate);
    }

    public void exibirStatus(){
       for (LogicaDeCombate logicaDeCombate : this.combates) {
           System.out.println(logicaDeCombate.toString());
       }
    }
}