/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.FreguesiaDuplicadaException;
import com.company.exception.FreguesiaInvalidaException;
import com.company.exception.NifDuplicadoException;
import com.company.exception.NumeroFuncionarioDuplicadoException;
import com.company.exception.TerrenoDuplicadoException;
import com.company.exception.TerrenoInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;

public class Autarquia implements Serializable {

    // static final long serialVersionUID = 5069974398830319675L;
    private String nome;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Freguesia> freguesias;

    public Autarquia(String nome) {
        this.nome = nome;
        this.pessoas = new ArrayList<>();
        this.freguesias = new ArrayList<>();
    }

    public ArrayList<Pessoa> getAllPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copiaPessoa = new Pessoa(pessoa);
                lista.add(copiaPessoa);
            } else {
                Funcionario funcionarioFuncionario = new Funcionario((Funcionario) pessoa);
                lista.add(funcionarioFuncionario);
            }
        }
        return lista;
    }
//////////////////////////////////////////////////

    public ArrayList<Pessoa> getPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copia = new Pessoa(pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addPessoa(Pessoa pessoa) throws NifDuplicadoException {
        Pessoa p = getPessoaByNif(pessoa.getNif());
        if (p == null) {
            this.pessoas.add(pessoa);
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Pessoa getPessoa(long nif) {
        return getPessoaByNif(nif);
    }

    public void removePessoa(long nif) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                if (!(pessoa instanceof Funcionario)) {
                    this.pessoas.remove(i);
                    return;
                } else {
                    throw new ElementoNaoExistenteException(nif + ": N~ao ´euma pessoa, ´eum funcion´ario");
                }
            }
        }
        throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
    }

    public void updatePessoa(long nif, Pessoa p) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        boolean updated = false;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                pessoa = p;
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
        }
    }

    private Pessoa getPessoaByNif(long nif) {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                Pessoa copia = new Pessoa(pessoa);
                return copia;
            }
        }
        return null;
    }
///////////////////////////////////////////////
// Funcion´arios

    public ArrayList<Funcionario> getFuncionarios() {
        Pessoa pessoa;
        ArrayList<Funcionario> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                Funcionario copia = new Funcionario((Funcionario) pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addFuncionario(Funcionario funcionario) throws NumeroFuncionarioDuplicadoException,
            NifDuplicadoException {
        Pessoa p = getPessoaByNif(funcionario.getNif());
        if (p == null) {
            Funcionario f = getFuncionarioByNr(funcionario.getNumeroFuncionario());
            if (f == null) {
                addPessoa(funcionario);
            } else {
                throw new NumeroFuncionarioDuplicadoException(f.getNumeroFuncionario() + ": Número de Funcionário já existe");
            }
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Funcionario getFuncionario(int nr) {
        Funcionario funcionario = getFuncionarioByNr(nr);
        if (funcionario != null) {
            Funcionario copia = new Funcionario(funcionario);
            return copia;
        }
        return null;
    }

    public void removeFuncionario(int nr) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                if (pessoa instanceof Funcionario) {
                    funcionario = (Funcionario) pessoa;
                    if (funcionario.getNumeroFuncionario() == nr) {
                        this.pessoas.remove(i);
                        return;
                    }
                }
            }
        }
        throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcion´ario");
    }

    public void updateFuncionario(int nr, Funcionario f) throws ElementoNaoExistenteException {
        boolean updated = false;
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    funcionario = f;
                    updated = true;
                }
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcionario");
        }
    }

    private Funcionario getFuncionarioByNr(int nr) {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    ///////////////////////////////////////////////
    // Freguesias
    public ArrayList<Freguesia> getFreguesias() {
        Freguesia freguesia;
        ArrayList<Freguesia> lista = new ArrayList<>();
        for (int i = 0; i < this.freguesias.size(); i++) {
            freguesia = this.freguesias.get(i);
            Freguesia copia = new Freguesia(freguesia);
            lista.add(copia);
        }
        return lista;
    }

    public void addFreguesia(Freguesia freguesia) throws FreguesiaDuplicadaException {
        boolean duplicada = false;

        System.out.println(this.freguesias);

        if (this.freguesias.size() > 0) {
            for (Freguesia f : freguesias) {
                if (f.getNome().equalsIgnoreCase(freguesia.getNome())) {
                    duplicada = true;
                    throw new FreguesiaDuplicadaException("A freguesia já existe!");
                }
            }
        }

        if (!duplicada) {
            freguesias.add(freguesia);
        }
    }

    public Freguesia getFreguesia(String nome) {
        boolean existente = false;
        Freguesia freguesia = null;

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                existente = true;
                freguesia = f;
            }
        }

        if (!existente) {
            throw new FreguesiaInvalidaException("Freguesia não existe!");
        } else {
            return freguesia;
        }
    }

    public void removeFreguesia(String nome) {
        boolean existente = false;
        Freguesia fRemove = null;

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                existente = true;
                fRemove = f;
            }
        }

        if (!existente) {
            throw new FreguesiaInvalidaException("Freguesia não existe!");
        } else {
            this.freguesias.remove(fRemove);
        }
    }

    public void updateFreguesia(String nome, Freguesia freguesia) {
        boolean updated = false;

        System.out.println("########" + nome);
        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                f.setNome(freguesia.getNome());
                updated = true;
            }
        }

        if (!updated) {
            throw new FreguesiaInvalidaException("Freguesia não existe");
        }
    }

    ///////////////////////////////////////////////
    // Terrenos
    public ArrayList<Terreno> getTerrenos(String freguesia) {
        boolean freguesiaEncontrada = false;
        ArrayList<Terreno> lista = new ArrayList<>();

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(freguesia)) {
                freguesiaEncontrada = true;
                lista = f.getTerrenos();
            }
        }

        if (!freguesiaEncontrada) {
            throw new FreguesiaInvalidaException("Freguesia não existente!");
        }

        return lista;
    }

    public void addTerreno(Terreno terreno, String freguesia) throws TerrenoDuplicadoException {
        boolean duplicada = false;
        boolean fregEncontrada = false;
        Freguesia fregAdd = null;

        if (this.freguesias.size() > 0) {
            for (Freguesia f : freguesias) {
                if (f.getNome().equalsIgnoreCase(freguesia)) {
                    fregEncontrada = true;
                    fregAdd = f;
                    for (Terreno t : f.getTerrenos()) {
                        if (t.getNumero() == terreno.getNumero()) {
                            duplicada = true;
                            throw new TerrenoDuplicadoException("O terreno já existe nessa freguesia!");
                        }
                    }

                }
            }
        }

        if (!fregEncontrada) {
            throw new FreguesiaInvalidaException("Freguesia não encontrada!");
        } else {
            if (!duplicada) {
                fregAdd.addTerreno(terreno);
            }
        }

    }

    public Terreno getTerreno(String freguesia, int terreno) {
        boolean fregEncontrada = false;
        boolean terrEncontrado = false;

        Terreno terr = null;

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(freguesia)) {
                fregEncontrada = true;
                for (Terreno t : f.getTerrenos()) {
                    if (t.getNumero() == terreno) {
                        terrEncontrado = true;
                        terr = t;
                    }
                }
            }
        }

        if (!fregEncontrada) {
            throw new FreguesiaInvalidaException("Freguesia não existe!");
        }

        if (!terrEncontrado) {
            throw new TerrenoInvalidoException("Terreno não encontrado!");
        }

        return terr;
    }

    public void updateTerreno(String nome, Terreno terreno) {
        boolean updated = false;
        boolean freguesiaEncontrada = false;
        boolean terrenoEncontrado = false;

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                freguesiaEncontrada = true;
                for (Terreno t : f.getTerrenos()) {
                    if (t.getNumero() == terreno.getNumero()) {
                        terrenoEncontrado = true;
                        t.setNumero(terreno.getNumero());
                        t.setForma(terreno.getForma().name());
                        updated = true;
                    }
                }
            }
        }

        if (!freguesiaEncontrada) {
            throw new FreguesiaInvalidaException("Freguesia não encontrada!");
        }

        if (!terrenoEncontrado) {
            throw new TerrenoInvalidoException("Terreno não encontrado");
        }

        if (!updated) {
            throw new RuntimeException("Erro ao atualizar");
        }
    }

    public void removeTerreno(String nome, int numero) {
        boolean removed = false;
        boolean freguesiaEncontrada = false;
        boolean terrenoEncontrado = false;

        for (Freguesia f : freguesias) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                freguesiaEncontrada = true;
                for(Terreno t: f.getTerrenos()){
                    if(t.getNumero() == numero){
                        terrenoEncontrado = true;
                        f.getTerrenos().remove(t);
                        removed = true;
                    }
                }
            }
        }

        if(!freguesiaEncontrada){
            throw new FreguesiaInvalidaException("Freguesia não encontrada!");
        }
        
        if(!terrenoEncontrado){
            throw new TerrenoInvalidoException("Terreno não encontrado!");
        }
        
        if(!removed){
            throw new RuntimeException("Erro ao eliminar terreno!");
        }
    }
}
