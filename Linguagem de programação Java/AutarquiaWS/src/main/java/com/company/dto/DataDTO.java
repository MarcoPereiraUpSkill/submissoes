/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

// Determinar a ordem da serialização das propriedades
@JsonPropertyOrder({"dia", "mes", "ano"})
// Determinar nome do root element
@JacksonXmlRootElement(localName = "data")
public class DataDTO {

    @JacksonXmlProperty(localName = "dia")
    private int dia;
    @JacksonXmlProperty(localName = "mes")
    private int mes;
    @JacksonXmlProperty(localName = "ano")
    private int ano;

    //Construtor vazio
    public DataDTO() {
    }

    public DataDTO(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        
    }
}

