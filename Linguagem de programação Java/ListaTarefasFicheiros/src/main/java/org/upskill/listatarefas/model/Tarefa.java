package org.upskill.listatarefas.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa implements Comparable<Tarefa> {
    private String descricao;
    private LocalDateTime instante;
    private String prioridade;

    public Tarefa(String descricao, String prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }

    public final void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante = 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade, 
                stringDataTempoDeRegisto);
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if(prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }
        
        return prioridade.compareTo(outraTarefa.prioridade);
    }

}
