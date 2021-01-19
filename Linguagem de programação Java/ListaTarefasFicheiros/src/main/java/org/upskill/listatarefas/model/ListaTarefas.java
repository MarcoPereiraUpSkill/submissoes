package org.upskill.listatarefas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListaTarefas implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    public ListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
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
            return false;
        } else {
            return listaTarefas.add(tarefa);
        }
    }

    public Tarefa getTarefaFromString(String tarefaStr) {
        String[] tarefaParams = tarefaStr.split("-", 3);

        Tarefa tarefa = new Tarefa(tarefaParams[0].trim(), tarefaParams[1].trim());

        return tarefa;
    }

    public int adicionarListaTarefas(ListaTarefas outraListaTarefas) {
        int totalTarefasAdicionadas = 0;

        for (Tarefa tarefa : outraListaTarefas.listaTarefas) {
            boolean tarefaAdicionada = addTarefa(tarefa);

            if (tarefaAdicionada) {
                totalTarefasAdicionadas++;
            }
        }
        return totalTarefasAdicionadas;
    }

    public void clearLista() {
        listaTarefas.clear();
    }

    public boolean removeLastItem() {
        Tarefa removedItem = listaTarefas.remove(listaTarefas.size() - 1);

        return !listaTarefas.contains(removedItem);
    }

    public boolean removerTarefa(String tarefa) {
        boolean removeu = false;

        for (Tarefa t : listaTarefas) {
            if (t.toString().equals(tarefa)) {
                listaTarefas.remove(t);
                return true;
            } else {
                removeu = false;
            }
        }

        return removeu;
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

    public String[] getListaComoArray() {
        String[] listaTarefasStr = new String[listaTarefas.size()];
        int i = 0;

        for (String tarefa : listaTarefasStr) {
            listaTarefasStr[i++] = tarefa;
        }

        return listaTarefasStr;
    }

}
