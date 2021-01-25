/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.FormaInvalidaException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Terreno implements Serializable {

    public enum Forma {
        CIRCULAR,
        RETANGULAR,
        TRIANGULAR
    }

    private int numero;
    private Forma forma;
    private ArrayList<Pessoa> donos;

    public Terreno(int numero, String forma) {
        this.numero = numero;
        this.donos = new ArrayList<>();
        if (forma.equalsIgnoreCase("Circular")) {
            this.forma = Forma.CIRCULAR;
        } else if (forma.equalsIgnoreCase("Retangular")) {
            this.forma = Forma.RETANGULAR;
        } else if (forma.equalsIgnoreCase("Triangular")) {
            this.forma = Forma.TRIANGULAR;
        } else {
            throw new FormaInvalidaException("Forma inválida!");
        }

    }

    public Terreno() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(String forma) {
        if (forma.equalsIgnoreCase("Circular")) {
            this.forma = Forma.CIRCULAR;
        } else if (forma.equalsIgnoreCase("Retangular")) {
            this.forma = Forma.RETANGULAR;
        } else if (forma.equalsIgnoreCase("Triangular")) {
            this.forma = Forma.TRIANGULAR;
        } else {
            throw new FormaInvalidaException("Forma inválida!");
        }
    }

    public ArrayList<Pessoa> getDonos() {
        return donos;
    }

    public void setDonos(ArrayList<Pessoa> donos) {
        this.donos = donos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terreno other = (Terreno) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.forma == other.forma;
    }

    @Override
    public String toString() {
        return "Terreno{" + "number=" + numero + ", shape=" + forma + '}';
    }

    public void addNewDono(Pessoa dono){
        donos.add(dono);
    }
}
