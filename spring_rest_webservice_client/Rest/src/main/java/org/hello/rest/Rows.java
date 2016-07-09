package org.hello.rest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steiner on 06/07/16.
 */
public final class Rows {
    @JsonProperty("cpf") public String cpf;
    @JsonProperty("senha") public String senha;
    @JsonProperty("origem") public String origem;
    @JsonProperty("destino") public String destino;
    @JsonProperty("data_partida") public String data_partida;
    @JsonProperty("data_retorno") public String data_retorno;
    @JsonProperty("lista_idas") public List<Viagem> lista_idas =new ArrayList<Viagem>();
    @JsonProperty("lista_voltas") public List<Viagem> lista_voltas=new ArrayList<Viagem>();
    @JsonProperty("error") public String error;

    @JsonCreator
    public Rows(@JsonProperty("cpf")String cpf,
                @JsonProperty("senha")String senha,
                @JsonProperty("origem")String origem,
                @JsonProperty("destino")String destino,
                @JsonProperty("data_partida")String data_partida,
                @JsonProperty("data_retorno")String data_retorno,
                @JsonProperty("lista_idas")List<Viagem> lista_idas,
                @JsonProperty("lista_voltas")List<Viagem> lista_voltas,
                @JsonProperty("error")String error) {
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

    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public String getCpf(){
        return this.cpf;
    }

    public void setSenha(String senha){
        this.senha=senha;
    }
    public String getSenha(){
        return this.cpf;
    }

    public void setOrigem(String origem){
        this.origem=origem;
    }
    public String getOrigem(){
        return this.origem;
    }

    public void setDestino(String destino){
        this.destino=destino;
    }
    public String getDestino(){
        return this.destino;
    }

    public void setData_partida(String data_partida){
        this.data_partida=data_partida;
    }
    public String getData_partida(){
        return this.data_partida;
    }

    public void setData_retorno(String data_retorno){
        this.data_retorno=data_retorno;
    }
    public String getData_retorno(){
        return this.data_partida;
    }

    public void setLista_idas(List<Viagem> lista_idas){
        this.lista_idas=lista_idas;
    }
    public List<Viagem> getLista_idas(){
        return this.lista_idas;
    }

    public void setLista_voltas(List<Viagem> lista_voltas){
        this.lista_voltas=lista_voltas;
    }
    public List<Viagem> getLista_voltas(){
        return this.lista_voltas;
    }

    public void setError(String error){
        this.error=error;
    }
    public String getError(){
        return this.error;
    }


}