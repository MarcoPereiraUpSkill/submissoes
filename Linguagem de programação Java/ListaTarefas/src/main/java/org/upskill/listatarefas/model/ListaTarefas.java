package org.upskill.listatarefas.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListaTarefas {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    public ListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @Override
    public String toString() {
        return "ListaTarefas{" + "listaTarefas=" + listaTarefas + '}';
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
        final ListaTarefas other = (ListaTarefas) obj;
        return Objects.equals(this.listaTarefas, other.listaTarefas);
    }

    public boolean addTarefa(Tarefa tarefa) {
        if (listaTarefas.contains(tarefa)) {
            throw new IllegalArgumentException("Tarefa já existe!");
        } else {
            return listaTarefas.add(tarefa);
        }
    }

    public void clearLista() {
        listaTarefas.clear();
    }

    public boolean removeLastItem() {
        Tarefa removedItem = listaTarefas.remove(listaTarefas.size() - 1);

        return !listaTarefas.contains(removedItem);
    }

    public boolean isEmpty() {
        return listaTarefas.isEmpty();
    }

    public List<Tarefa> getListaInsercao() {
        Tarefa.ordenacao = ORDENACAO.INSERCAO;
        Collections.sort(listaTarefas);
        return listaTarefas;
    }

    public List<Tarefa> getListaPrioridade() {
        Tarefa.ordenacao = ORDENACAO.PRIORIDADE;
        Collections.sort(listaTarefas);
        return listaTarefas;
    }
}
