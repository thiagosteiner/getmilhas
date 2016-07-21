package org.hello.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private List<String> vooVoltaNumero = new ArrayList<String>();
    private List<String> vooVoltaDuracao = new ArrayList<String>();
    private List<String> vooVoltaAeroportoOrigem = new ArrayList<String>();
    private List<String> vooVoltaPreco3 = new ArrayList<String>();
    private List<String> vooIdaHoraSaida = new ArrayList<String>();
    private List<String> vooIdaPreco3 = new ArrayList<String>();
    private List<String> vooIdaAeroportoOrigem = new ArrayList<String>();
    private List<String> vooVoltaPreco1 = new ArrayList<String>();
    private List<String> vooIdaPreco2 = new ArrayList<String>();
    private List<String> vooVoltaHoraSaida = new ArrayList<String>();
    private List<String> vooIdaDuracao = new ArrayList<String>();
    private List<String> vooVoltaHoraChegada = new ArrayList<String>();
    private List<String> vooIdaHoraChegada = new ArrayList<String>();
    private List<String> vooIdaNumero = new ArrayList<String>();
    private List<String> vooIdaPreco1 = new ArrayList<String>();
    private List<String> vooVoltaAeroportoDestino = new ArrayList<String>();
    private List<String> vooVoltaPreco2 = new ArrayList<String>();
    private List<String> vooIdaAeroportoDestino = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Results() {
    }

    /**
     *
     * @param vooIdaAeroportoDestino
     * @param vooVoltaNumero
     * @param vooIdaPreco2
     * @param vooIdaPreco1
     * @param vooVoltaHoraSaida
     * @param vooIdaAeroportoOrigem
     * @param vooIdaHoraChegada
     * @param vooIdaPreco3
     * @param vooVoltaPreco1
     * @param vooIdaDuracao
     * @param vooVoltaPreco2
     * @param vooVoltaPreco3
     * @param vooVoltaHoraChegada
     * @param vooVoltaAeroportoDestino
     * @param vooVoltaDuracao
     * @param vooIdaHoraSaida
     * @param vooVoltaAeroportoOrigem
     * @param vooIdaNumero
     */
    @JsonCreator
    public Results(@JsonProperty("voo_volta_numero")List<String> vooVoltaNumero,
                   @JsonProperty("voo_volta_duracao") List<String> vooVoltaDuracao,
                   @JsonProperty("voo_ida_aeroporto_origem")List<String> vooIdaAeroportoOrigem,
                   @JsonProperty("voo_volta_preco_3")List<String> vooVoltaPreco3,
                   @JsonProperty("voo_ida_hora_saida") List<String> vooIdaHoraSaida,
                   @JsonProperty("voo_ida_preco_3")List<String> vooIdaPreco3,
                   @JsonProperty("voo_volta_aeroporto_origem")List<String> vooVoltaAeroportoOrigem,
                   @JsonProperty("voo_volta_preco_1")List<String> vooVoltaPreco1,
                   @JsonProperty("voo_ida_preco_2")List<String> vooIdaPreco2,
                   @JsonProperty("voo_volta_hora_saida")List<String> vooVoltaHoraSaida,
                   @JsonProperty("voo_ida_duracao") List<String> vooIdaDuracao,
                   @JsonProperty("voo_volta_hora_chegada")List<String> vooVoltaHoraChegada,
                   @JsonProperty("voo_ida_hora_chegada")List<String> vooIdaHoraChegada,
                   @JsonProperty("voo_ida_numero")List<String> vooIdaNumero,
                   @JsonProperty("voo_ida_preco_1")List<String> vooIdaPreco1,
                   @JsonProperty("voo_volta_aeroporto_destino") List<String> vooVoltaAeroportoDestino,
                   @JsonProperty("voo_volta_preco_2") List<String> vooVoltaPreco2,
                   @JsonProperty("voo_ida_aeroporto_destino") List<String> vooIdaAeroportoDestino) {
        this.vooVoltaNumero = vooVoltaNumero;
        this.vooVoltaDuracao = vooVoltaDuracao;
        this.vooVoltaAeroportoOrigem = vooVoltaAeroportoOrigem;
        this.vooVoltaPreco3 = vooVoltaPreco3;
        this.vooIdaHoraSaida = vooIdaHoraSaida;
        this.vooIdaPreco3 = vooIdaPreco3;
        this.vooIdaAeroportoOrigem = vooIdaAeroportoOrigem;
        this.vooVoltaPreco1 = vooVoltaPreco1;
        this.vooIdaPreco2 = vooIdaPreco2;
        this.vooVoltaHoraSaida = vooVoltaHoraSaida;
        this.vooIdaDuracao = vooIdaDuracao;
        this.vooVoltaHoraChegada = vooVoltaHoraChegada;
        this.vooIdaHoraChegada = vooIdaHoraChegada;
        this.vooIdaNumero = vooIdaNumero;
        this.vooIdaPreco1 = vooIdaPreco1;
        this.vooVoltaAeroportoDestino = vooVoltaAeroportoDestino;
        this.vooVoltaPreco2 = vooVoltaPreco2;
        this.vooIdaAeroportoDestino = vooIdaAeroportoDestino;
    }

    /**
     *
     * @return
     *     The vooVoltaNumero
     */
    public List<String> getVooVoltaNumero() {
        return vooVoltaNumero;
    }

    /**
     *
     * @param vooVoltaNumero
     *     The voo_volta_numero
     */
    public void setVooVoltaNumero(List<String> vooVoltaNumero) {
        this.vooVoltaNumero = vooVoltaNumero;
    }

    public Results withVooVoltaNumero(List<String> vooVoltaNumero) {
        this.vooVoltaNumero = vooVoltaNumero;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaDuracao
     */
    public List<String> getVooVoltaDuracao() {
        return vooVoltaDuracao;
    }

    /**
     *
     * @param vooVoltaDuracao
     *     The voo_volta_duracao
     */
    public void setVooVoltaDuracao(List<String> vooVoltaDuracao) {
        this.vooVoltaDuracao = vooVoltaDuracao;
    }

    public Results withVooVoltaDuracao(List<String> vooVoltaDuracao) {
        this.vooVoltaDuracao = vooVoltaDuracao;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaAeroportoOrigem
     */
    public List<String> getVooVoltaAeroportoOrigem() {
        return vooVoltaAeroportoOrigem;
    }

    /**
     *
     * @param vooVoltaAeroportoOrigem
     *     The voo_volta_aeroporto_origem
     */
    public void setVooVoltaAeroportoOrigem(List<String> vooVoltaAeroportoOrigem) {
        this.vooVoltaAeroportoOrigem = vooVoltaAeroportoOrigem;
    }

    public Results withVooVoltaAeroportoOrigem(List<String> vooVoltaAeroportoOrigem) {
        this.vooVoltaAeroportoOrigem = vooVoltaAeroportoOrigem;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaPreco3
     */
    public List<String> getVooVoltaPreco3() {
        return vooVoltaPreco3;
    }

    /**
     *
     * @param vooVoltaPreco3
     *     The voo_volta_preco_3
     */
    public void setVooVoltaPreco3(List<String> vooVoltaPreco3) {
        this.vooVoltaPreco3 = vooVoltaPreco3;
    }

    public Results withVooVoltaPreco3(List<String> vooVoltaPreco3) {
        this.vooVoltaPreco3 = vooVoltaPreco3;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaHoraSaida
     */
    public List<String> getVooIdaHoraSaida() {
        return vooIdaHoraSaida;
    }

    /**
     *
     * @param vooIdaHoraSaida
     *     The voo_ida_hora_saida
     */
    public void setVooIdaHoraSaida(List<String> vooIdaHoraSaida) {
        this.vooIdaHoraSaida = vooIdaHoraSaida;
    }

    public Results withVooIdaHoraSaida(List<String> vooIdaHoraSaida) {
        this.vooIdaHoraSaida = vooIdaHoraSaida;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaPreco3
     */
    public List<String> getVooIdaPreco3() {
        return vooIdaPreco3;
    }

    /**
     *
     * @param vooIdaPreco3
     *     The voo_ida_preco_3
     */
    public void setVooIdaPreco3(List<String> vooIdaPreco3) {
        this.vooIdaPreco3 = vooIdaPreco3;
    }

    public Results withVooIdaPreco3(List<String> vooIdaPreco3) {
        this.vooIdaPreco3 = vooIdaPreco3;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaAeroportoOrigem
     */
    public List<String> getVooIdaAeroportoOrigem() {
        return vooIdaAeroportoOrigem;
    }

    /**
     *
     * @param vooIdaAeroportoOrigem
     *     The voo_ida_aeroporto_origem
     */
    public void setVooIdaAeroportoOrigem(List<String> vooIdaAeroportoOrigem) {
        this.vooIdaAeroportoOrigem = vooIdaAeroportoOrigem;
    }

    public Results withVooIdaAeroportoOrigem(List<String> vooIdaAeroportoOrigem) {
        this.vooIdaAeroportoOrigem = vooIdaAeroportoOrigem;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaPreco1
     */
    public List<String> getVooVoltaPreco1() {
        return vooVoltaPreco1;
    }

    /**
     *
     * @param vooVoltaPreco1
     *     The voo_volta_preco_1
     */
    public void setVooVoltaPreco1(List<String> vooVoltaPreco1) {
        this.vooVoltaPreco1 = vooVoltaPreco1;
    }

    public Results withVooVoltaPreco1(List<String> vooVoltaPreco1) {
        this.vooVoltaPreco1 = vooVoltaPreco1;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaPreco2
     */
    public List<String> getVooIdaPreco2() {
        return vooIdaPreco2;
    }

    /**
     *
     * @param vooIdaPreco2
     *     The voo_ida_preco_2
     */
    public void setVooIdaPreco2(List<String> vooIdaPreco2) {
        this.vooIdaPreco2 = vooIdaPreco2;
    }

    public Results withVooIdaPreco2(List<String> vooIdaPreco2) {
        this.vooIdaPreco2 = vooIdaPreco2;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaHoraSaida
     */
    public List<String> getVooVoltaHoraSaida() {
        return vooVoltaHoraSaida;
    }

    /**
     *
     * @param vooVoltaHoraSaida
     *     The voo_volta_hora_saida
     */
    public void setVooVoltaHoraSaida(List<String> vooVoltaHoraSaida) {
        this.vooVoltaHoraSaida = vooVoltaHoraSaida;
    }

    public Results withVooVoltaHoraSaida(List<String> vooVoltaHoraSaida) {
        this.vooVoltaHoraSaida = vooVoltaHoraSaida;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaDuracao
     */
    public List<String> getVooIdaDuracao() {
        return vooIdaDuracao;
    }

    /**
     *
     * @param vooIdaDuracao
     *     The voo_ida_duracao
     */
    public void setVooIdaDuracao(List<String> vooIdaDuracao) {
        this.vooIdaDuracao = vooIdaDuracao;
    }

    public Results withVooIdaDuracao(List<String> vooIdaDuracao) {
        this.vooIdaDuracao = vooIdaDuracao;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaHoraChegada
     */
    public List<String> getVooVoltaHoraChegada() {
        return vooVoltaHoraChegada;
    }

    /**
     *
     * @param vooVoltaHoraChegada
     *     The voo_volta_hora_chegada
     */
    public void setVooVoltaHoraChegada(List<String> vooVoltaHoraChegada) {
        this.vooVoltaHoraChegada = vooVoltaHoraChegada;
    }

    public Results withVooVoltaHoraChegada(List<String> vooVoltaHoraChegada) {
        this.vooVoltaHoraChegada = vooVoltaHoraChegada;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaHoraChegada
     */
    public List<String> getVooIdaHoraChegada() {
        return vooIdaHoraChegada;
    }

    /**
     *
     * @param vooIdaHoraChegada
     *     The voo_ida_hora_chegada
     */
    public void setVooIdaHoraChegada(List<String> vooIdaHoraChegada) {
        this.vooIdaHoraChegada = vooIdaHoraChegada;
    }

    public Results withVooIdaHoraChegada(List<String> vooIdaHoraChegada) {
        this.vooIdaHoraChegada = vooIdaHoraChegada;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaNumero
     */
    public List<String> getVooIdaNumero() {
        return vooIdaNumero;
    }

    /**
     *
     * @param vooIdaNumero
     *     The voo_ida_numero
     */
    public void setVooIdaNumero(List<String> vooIdaNumero) {
        this.vooIdaNumero = vooIdaNumero;
    }

    public Results withVooIdaNumero(List<String> vooIdaNumero) {
        this.vooIdaNumero = vooIdaNumero;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaPreco1
     */
    public List<String> getVooIdaPreco1() {
        return vooIdaPreco1;
    }

    /**
     *
     * @param vooIdaPreco1
     *     The voo_ida_preco_1
     */
    public void setVooIdaPreco1(List<String> vooIdaPreco1) {
        this.vooIdaPreco1 = vooIdaPreco1;
    }

    public Results withVooIdaPreco1(List<String> vooIdaPreco1) {
        this.vooIdaPreco1 = vooIdaPreco1;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaAeroportoDestino
     */
    public List<String> getVooVoltaAeroportoDestino() {
        return vooVoltaAeroportoDestino;
    }

    /**
     *
     * @param vooVoltaAeroportoDestino
     *     The voo_volta_aeroporto_destino
     */
    public void setVooVoltaAeroportoDestino(List<String> vooVoltaAeroportoDestino) {
        this.vooVoltaAeroportoDestino = vooVoltaAeroportoDestino;
    }

    public Results withVooVoltaAeroportoDestino(List<String> vooVoltaAeroportoDestino) {
        this.vooVoltaAeroportoDestino = vooVoltaAeroportoDestino;
        return this;
    }

    /**
     *
     * @return
     *     The vooVoltaPreco2
     */
    public List<String> getVooVoltaPreco2() {
        return vooVoltaPreco2;
    }

    /**
     *
     * @param vooVoltaPreco2
     *     The voo_volta_preco_2
     */
    public void setVooVoltaPreco2(List<String> vooVoltaPreco2) {
        this.vooVoltaPreco2 = vooVoltaPreco2;
    }

    public Results withVooVoltaPreco2(List<String> vooVoltaPreco2) {
        this.vooVoltaPreco2 = vooVoltaPreco2;
        return this;
    }

    /**
     *
     * @return
     *     The vooIdaAeroportoDestino
     */
    public List<String> getVooIdaAeroportoDestino() {
        return vooIdaAeroportoDestino;
    }

    /**
     *
     * @param vooIdaAeroportoDestino
     *     The voo_ida_aeroporto_destino
     */
    public void setVooIdaAeroportoDestino(List<String> vooIdaAeroportoDestino) {
        this.vooIdaAeroportoDestino = vooIdaAeroportoDestino;
    }

    public Results withVooIdaAeroportoDestino(List<String> vooIdaAeroportoDestino) {
        this.vooIdaAeroportoDestino = vooIdaAeroportoDestino;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Results withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}