package org.hello.rest;



/**
 * Created by steiner on 06/07/16.
 */
public class Voo {
    String aeroChegada;
    String aeroPartida;
    String partida;
    String chegada;
    String companhia;
    String[] preco;
    String voo;



    public Voo(String aeroChegada,
               String aeroPartida,
               String data_partida,
               String data_chegada,
               String companhia,
               String[] preco,
               String voo){

        this.aeroChegada = aeroChegada;
        this.aeroPartida = aeroPartida;
        this.partida = data_partida;
        this.chegada = data_chegada;
        this.companhia = companhia;
        this.preco = preco;
        this.voo = voo;
    }

//    @JsonCreator
//    public Voo(@JsonProperty("aeroChegada") String aeroChegada,
//               @JsonProperty("aeroPartida") String aeroPartida,
//               @JsonProperty("data_partida") String data_partida,
//               @JsonProperty("data_chegada") String data_chegada,
//               @JsonProperty("companhia") String companhia,
//               @JsonProperty("preco") String[] preco,
//               @JsonProperty("voo") String voo){
//
//        this.aeroChegada = aeroChegada;
//        this.aeroPartida = aeroPartida;
//        this.partida = data_partida;
//        this.chegada = data_chegada;
//        this.companhia = companhia;
//        this.preco = preco;
//        this.voo = voo;
//    }

}
