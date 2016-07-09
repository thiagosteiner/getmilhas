package org.hello.rest;


/**
 * Created by steiner on 06/07/16.
 */
public final class Rows {
    String cpf;
    String senha;
    String origem;
    String destino;
    String data_partida;
    String data_retorno;
    Viagem[] lista_idas;
    Viagem[] lista_voltas;
    String error;


    public Rows(String cpf,String senha,String origem,String destino,String data_partida,
                String data_retorno,Viagem[] lista_idas,Viagem[] lista_voltas,String error) {
        this.cpf = cpf;
        this.senha=senha;
        this.origem=origem;
        this.destino=destino;
        this.data_partida = data_partida;
        this.data_retorno = data_retorno;
        this.lista_idas=lista_idas;
        this.lista_voltas=lista_voltas;
        this.error=error;

    }


}