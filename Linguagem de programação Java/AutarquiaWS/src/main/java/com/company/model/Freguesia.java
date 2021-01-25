/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Freguesia implements Serializable {

    private String nome;
    private ArrayList<Terreno> terrenos;

    private static final String NOME_POR_OMISSAO = "sem nome";

    public Freguesia(String nome) {
        this.nome = nome;
        this.terrenos = new ArrayList<>();
    }

    public Freguesia(Freguesia freguesia) {
        this.nome = freguesia.nome;
        this.terrenos = new ArrayList<>();
    }

    public Freguesia() {
        nome = NOME_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Terreno> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(ArrayList<Terreno> terrenos) {
        this.terrenos = terrenos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Freguesia other = (Freguesia) obj;
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "Freguesia{" + "nome=" + nome + '}';
    }

    public void addTerreno(Terreno terreno){
        this.terrenos.add(terreno);
    }
}
