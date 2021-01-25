/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.company.model.Terreno;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author marco
 */
@JsonPropertyOrder({"numero", "forma"})
@JacksonXmlRootElement(localName = "terreno")

public class TerrenoDTO {

    @JacksonXmlProperty(localName = "numero")
    private int numero;
    @JacksonXmlProperty(localName = "forma")
    private String forma;

    public TerrenoDTO() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

}
