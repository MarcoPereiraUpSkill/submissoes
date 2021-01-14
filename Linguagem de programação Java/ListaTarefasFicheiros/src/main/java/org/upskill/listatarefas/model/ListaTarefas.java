package org.upskill.listatarefas.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTarefas {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);
        Collections.sort(copia);

        StringBuilder s = new StringBuilder();
        for (Tarefa tarefa : copia) {
            s.append(tarefa);
            s.append("\n");
        }

        return s.toString().trim();
    }

    public boolean isVazia() {
        return listaTarefas.isEmpty();
    }

    //implementar todas as funcionalidades necessárias
}
