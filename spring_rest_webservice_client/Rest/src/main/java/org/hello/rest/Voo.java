package org.hello.rest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steiner on 06/07/16.
 */
public class Voo {
    @JsonProperty("aeroChegada") String aeroChegada;
    @JsonProperty("aeroPartida") String aeroPartida;
    @JsonProperty("data_partida") String partida;
    @JsonProperty("data_chegada") String chegada;
    @JsonProperty("companhia") String companhia;
    @JsonProperty("preco") List<String> preco =new ArrayList<String>();
    @JsonProperty("voo") String voo;


    @JsonCreator
    public Voo(@JsonProperty("aeroChegada") String aeroChegada,
               @JsonProperty("aeroPartida") String aeroPartida,
               @JsonProperty("data_partida") String data_partida,
               @JsonProperty("data_chegada") String data_chegada,
               @JsonProperty("companhia") String companhia,
               @JsonProperty("preco") List<String> preco,
               @JsonProperty("voo") String voo){

        this.aeroChegada = aeroChegada;
        this.aeroPartida = aeroPartida;
        this.partida = data_partida;
        this.chegada = data_chegada;
        this.companhia = companhia;
        this.preco = preco;
        this.voo = voo;
    }


}
