package org.upskill.listatarefas.controller;

import java.util.ArrayList;
import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;
import org.upskill.listatarefas.model.Tarefa;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
       this.lista = new ListaTarefas(new ArrayList<Tarefa>());
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, String prioridade) {
        Tarefa tarefa = new Tarefa(descricao, prioridade);
        
        return lista.addTarefa(tarefa);
    }

    public ListaTarefas getLista(){
        return lista;
    }
    
    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
       lista.clearLista();
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.removeLastItem();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.isEmpty();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefasInsercao() {
        return lista.getListaInsercao().toString();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
       return lista.getListaPrioridade().toString();
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
}
