package org.hello.rest;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by steiner on 06/07/16.
 */

public class Viagem {
    private List<Voo> lista_voos=new ArrayList<Voo>();


    public Viagem(List<Voo> lista_voos){

        this.lista_voos=lista_voos;
    }

    public void setLista_voos(List<Voo> lista_voos){
        this.lista_voos=lista_voos;
    }

    public List<Voo> getLista_voos() {
        return lista_voos;
    }
}