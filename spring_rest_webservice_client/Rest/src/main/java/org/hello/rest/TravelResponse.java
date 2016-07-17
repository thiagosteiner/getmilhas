package org.hello.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by volpi on 7/16/16.
 */
public final class TravelResponse {
    public final Results results;
    public final String created;

    @JsonCreator
    public TravelResponse(@JsonProperty("results") Results results, @JsonProperty("created") String created){
        this.results = results;
        this.created = created;
    }

    public static final class Results {
        public final String[] voo_ida_hora_saida;
        public final String[] voo_ida_aeroporto_origem;
        public final String[] voo_ida_hora_chegada;
        public final String[] voo_ida_aeroporto_destino;
        public final String[] voo_ida_numero;
        public final String[] voo_ida_duracao;
        public final String[] voo_ida_preco_1;
        public final String[] voo_ida_preco_2;
        public final String[] voo_ida_preco_3;
        public final String[] voo_volta_hora_saida;
        public final String[] voo_volta_aeroporto_origem;
        public final String[] voo_volta_hora_chegada;
        public final String[] voo_volta_aeroporto_destino;
        public final String[] voo_volta_numero;
        public final String[] voo_volta_duracao;
        public final String[] voo_volta_preco_1;
        public final String[] voo_volta_preco_2;
        public final String[] voo_volta_preco_3;

        @JsonCreator
        public Results(@JsonProperty("voo_ida_hora_saida") String[] voo_ida_hora_saida, @JsonProperty("voo_ida_aeroporto_origem") String[] voo_ida_aeroporto_origem, @JsonProperty("voo_ida_hora_chegada") String[] voo_ida_hora_chegada, @JsonProperty("voo_ida_aeroporto_destino") String[] voo_ida_aeroporto_destino, @JsonProperty("voo_ida_numero") String[] voo_ida_numero, @JsonProperty("voo_ida_duracao") String[] voo_ida_duracao, @JsonProperty("voo_ida_preco_1") String[] voo_ida_preco_1, @JsonProperty("voo_ida_preco_2") String[] voo_ida_preco_2, @JsonProperty("voo_ida_preco_3") String[] voo_ida_preco_3, @JsonProperty("voo_volta_hora_saida") String[] voo_volta_hora_saida, @JsonProperty("voo_volta_aeroporto_origem") String[] voo_volta_aeroporto_origem, @JsonProperty("voo_volta_hora_chegada") String[] voo_volta_hora_chegada, @JsonProperty("voo_volta_aeroporto_destino") String[] voo_volta_aeroporto_destino, @JsonProperty("voo_volta_numero") String[] voo_volta_numero, @JsonProperty("voo_volta_duracao") String[] voo_volta_duracao, @JsonProperty("voo_volta_preco_1") String[] voo_volta_preco_1, @JsonProperty("voo_volta_preco_2") String[] voo_volta_preco_2, @JsonProperty("voo_volta_preco_3") String[] voo_volta_preco_3){
            this.voo_ida_hora_saida = voo_ida_hora_saida;
            this.voo_ida_aeroporto_origem = voo_ida_aeroporto_origem;
            this.voo_ida_hora_chegada = voo_ida_hora_chegada;
            this.voo_ida_aeroporto_destino = voo_ida_aeroporto_destino;
            this.voo_ida_numero = voo_ida_numero;
            this.voo_ida_duracao = voo_ida_duracao;
            this.voo_ida_preco_1 = voo_ida_preco_1;
            this.voo_ida_preco_2 = voo_ida_preco_2;
            this.voo_ida_preco_3 = voo_ida_preco_3;
            this.voo_volta_hora_saida = voo_volta_hora_saida;
            this.voo_volta_aeroporto_origem = voo_volta_aeroporto_origem;
            this.voo_volta_hora_chegada = voo_volta_hora_chegada;
            this.voo_volta_aeroporto_destino = voo_volta_aeroporto_destino;
            this.voo_volta_numero = voo_volta_numero;
            this.voo_volta_duracao = voo_volta_duracao;
            this.voo_volta_preco_1 = voo_volta_preco_1;
            this.voo_volta_preco_2 = voo_volta_preco_2;
            this.voo_volta_preco_3 = voo_volta_preco_3;
        }
    }
}
