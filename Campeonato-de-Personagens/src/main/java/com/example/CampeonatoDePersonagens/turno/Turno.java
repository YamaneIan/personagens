package com.example.CampeonatoDePersonagens.turno;

import com.example.CampeonatoDePersonagens.Model.Combate;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private List<Combate> combates = new ArrayList<>();

    public void add(Combate combate) {
        this.combates.add(combate);
    }

    public void exibirStatus(){
       for (Combate combate : this.combates) {
           System.out.println(combate.toString());
       }
    }
}
