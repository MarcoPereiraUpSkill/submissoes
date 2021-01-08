/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_filmes;

import java.util.Objects;

/**
 *
 * @author marco
 */
public class Realizador {

    private String nome;
    private String nacionalidade;
    private Data dataNascimento;
    
    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final String NACIONALIDADE_POR_OMISSAO = "sem nacionalidade";
    private static final Data DATANASCIMENTO_POR_OMISSAO = new Data();
    
    public Realizador(String nome, String nacionalidade, Data dataNascimento){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }
    
    public Realizador(){
        nome = NOME_POR_OMISSAO;
        nacionalidade = NACIONALIDADE_POR_OMISSAO;
        dataNascimento = DATANASCIMENTO_POR_OMISSAO;
    }
    
    public Realizador(Realizador outroRealizador){
        nome = outroRealizador.nome;
        nacionalidade = outroRealizador.nacionalidade;
        dataNascimento = outroRealizador.dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        final Realizador other = (Realizador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        return Objects.equals(this.dataNascimento, other.dataNascimento);
    }

    @Override
    public String toString() {
        return "Realizador{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
}
