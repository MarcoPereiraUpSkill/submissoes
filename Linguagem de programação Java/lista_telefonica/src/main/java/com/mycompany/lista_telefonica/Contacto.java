
package com.mycompany.lista_telefonica;

import java.util.Objects;

public class Contacto {
    private String nome;
    private int telefone;
    private String email;
    
    private static final String NOME_POR_OMISSAO = "";
    private static final int TELEFONE_POR_OMISSAO = 0;
    private static final String EMAIL_POR_OMISSAO = "";

    public Contacto(String nome, int telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Contacto(){
        nome = NOME_POR_OMISSAO;
        telefone = TELEFONE_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nome=" + nome + ", telefone=" + telefone + ", email=" + email + '}';
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
        final Contacto other = (Contacto) obj;
        if (this.telefone != other.telefone) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }
    
    
}
