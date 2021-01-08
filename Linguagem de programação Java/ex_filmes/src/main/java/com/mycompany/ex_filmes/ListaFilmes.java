/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_filmes;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class ListaFilmes {

    private ArrayList<Filme> listaFilmes;
    private String identificador;

    private static final ArrayList<Filme> LISTAFILMES_POR_OMISSAO = new ArrayList<>();
    private static final String IDENTIFICADOR_POR_OMISSAO = "Sem identificador";

    public ListaFilmes(ArrayList<Filme> listaFilmes, String identificador) {
        this.listaFilmes = listaFilmes;
        this.identificador = identificador;
    }

    public ListaFilmes() {
        listaFilmes = LISTAFILMES_POR_OMISSAO;
        identificador = IDENTIFICADOR_POR_OMISSAO;
    }

    public ArrayList<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        char c = identificador.charAt(0);

        if (!Character.isUpperCase(c)) {
            throw new IdentificadorInvalidoException("Identificador inválido!");
        }

        this.identificador = identificador;
    }

    public void setListaFilmes(ArrayList<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
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
        final ListaFilmes other = (ListaFilmes) obj;
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return Objects.equals(this.listaFilmes, other.listaFilmes);
    }

    @Override
    public String toString() {
        return "ListaFilmes{" + "listaFilmes=" + listaFilmes + ", identificador=" + identificador + '}';
    }
    
    public void addFilme(Filme filme){
        listaFilmes.add(filme);
    }

}
