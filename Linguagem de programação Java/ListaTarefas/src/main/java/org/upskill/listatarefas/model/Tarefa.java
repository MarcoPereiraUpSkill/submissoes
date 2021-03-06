package org.upskill.listatarefas.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.upskill.listatarefas.model.ListaTarefas.ORDENACAO;

public final class Tarefa implements Comparable<Tarefa> {

    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    public static ORDENACAO ordenacao;

    public Tarefa(String descricao, String prioridade) {
        setDescricao(descricao);
        setPrioridade(this.determinarPrioridade(prioridade));
        instante = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
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

    public final void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;

    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante
                = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade,
                stringDataTempoDeRegisto);
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if (ordenacao == ORDENACAO.INSERCAO) {
            if (prioridade.equals(outraTarefa.prioridade)) {
                return instante.compareTo(outraTarefa.instante);
            }

            return prioridade.compareTo(outraTarefa.prioridade);
        } else {
            if (instante.equals(outraTarefa.instante)) {
                return prioridade.compareTo(outraTarefa.prioridade);
            }

            return instante.compareTo(outraTarefa.instante);
        }
    }

    public Prioridade determinarPrioridade(String prioridade) {
        Prioridade[] listaPrioridades = Prioridade.values();

        for (int i = 0; i < listaPrioridades.length; i++) {
            if (listaPrioridades[i].toString().equalsIgnoreCase(prioridade)) {
                return listaPrioridades[i];
            }
        }

        return Prioridade.NORMAL;
    }
}
