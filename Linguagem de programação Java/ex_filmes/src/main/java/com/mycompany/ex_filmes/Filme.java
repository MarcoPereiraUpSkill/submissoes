/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_filmes;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Filme {
    public enum Categorias{
        COMEDIA, ACAO, TERROR, DRAMA, ANIMACAO
    }
    
    private String titulo;
    private int anoRealizacao;
    private Realizador realizador;
    private Categorias categoria;
    
    private static final String TITULO_POR_OMISSAO = "sem titulo";
    private static final int ANOREALIZACAO_POR_OMISSAO = 2021; 
    private static final Realizador REALIZADOR_POR_OMISSAO = new Realizador();
    private static final Categorias CATEGORIA_POR_OMISSAO = Categorias.ACAO;

    public Filme(String titulo, int anoRealizacao, Realizador realizador, Categorias categoria) {
        this.titulo = titulo;
        this.anoRealizacao = anoRealizacao;
        this.realizador = realizador;
        this.categoria = categoria;
    }
    
    public Filme(String titulo, int anoRealizacao, Realizador realizador) {
        this.titulo = titulo;
        this.anoRealizacao = anoRealizacao;
        this.realizador = realizador;
        this.categoria = CATEGORIA_POR_OMISSAO;
    }
    
    public Filme(){
        titulo = TITULO_POR_OMISSAO;
        anoRealizacao = ANOREALIZACAO_POR_OMISSAO;
        realizador = REALIZADOR_POR_OMISSAO;
        categoria = CATEGORIA_POR_OMISSAO;
    }
    
    public Filme(Filme outroFilme){
        this.titulo = outroFilme.titulo;
        this.anoRealizacao = outroFilme.anoRealizacao;
        this.realizador = outroFilme.realizador;
        this.categoria = outroFilme.categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    public void setAnoRealizacao(int anoRealizacao) {
        Calendar dataAtual = Calendar.getInstance();
        if(anoRealizacao < 1850 || anoRealizacao > dataAtual.get(Calendar.YEAR)){
            throw new AnoInvalidoException(anoRealizacao + " não é um ano válido!");
        }
        this.anoRealizacao = anoRealizacao;
    }

    public Realizador getRealizador() {
        return realizador;
    }

    public void setRealizador(Realizador realizador) {
        this.realizador = realizador;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if(!checkCategoria(categoria)){
            throw new CategoriaInvalidaException(categoria + " não é uma categoria válida!");
        }
        
        this.categoria = Categorias.valueOf(categoria);
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
        final Filme other = (Filme) obj;
        if (this.anoRealizacao != other.anoRealizacao) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.realizador, other.realizador)) {
            return false;
        }
        return this.categoria == other.categoria;
    }
    
    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", anoRealizacao=" + anoRealizacao + ", realizador=" + realizador + ", categoria=" + categoria + '}';
    }
    
    private boolean checkCategoria(String categoria){
        for(Categorias c : Categorias.values()){
            if(c.name().equals(categoria)){
                return true;
            }
        }
        
        return false;
    }
}
