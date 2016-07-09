package org.hello.rest;

/**
 * Created by steiner on 07/07/16.
 */
public class Request {

    private String cpf;
    private String senha;
    private String origem;
    private String destino;
    private String data_partida;
    private String data_retorno;

    Request(String cpf,String senha, String origem,String destino,String data_partida,String data_retorno){
        this.cpf=cpf;
        this.senha=senha;
        this.origem=origem;
        this.destino=destino;
        this.data_partida=data_partida;
        this.data_retorno=data_retorno;
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
        return this.senha;
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
    public String getDEstino(){
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
        return this.data_retorno;
    }


}
