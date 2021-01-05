
package com.mycompany.ex_empregado;

import com.mycompany.utilitarios.Data;
import com.mycompany.utilitarios.Tempo;


public class Empregado {
    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;
    
    private static final String PRIMEIRONOME_POR_OMISSAO = "";
    private static final String ULTIMONOME_POR_OMISSAO = "";
    private static final Data DATA_POR_OMISSAO = new Data(1999, 01, 01);
    private static final Tempo HORAENTRADA_POR_OMISSAO = new Tempo(0, 0, 0);
    private static final Tempo HORASAIDA_POR_OMISSAO = new Tempo(0, 0, 0);
    
    
    public Empregado(){
        primeiroNome = PRIMEIRONOME_POR_OMISSAO;
        ultimoNome = ULTIMONOME_POR_OMISSAO;
        dataContrato = DATA_POR_OMISSAO;
        horaEntrada = HORAENTRADA_POR_OMISSAO;
        horaSaida = HORASAIDA_POR_OMISSAO;
    }
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = dataContrato;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Data getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Tempo getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "Empregado{" + "primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", dataContrato=" + dataContrato + ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + '}';
    }
    
    public int calcularHorasSemanais(){
        int difSegundosSemanal = (this.horaEntrada.diferencaEmSegundos(this.horaSaida)) * 5;
        return difSegundosSemanal / 3600;
    }
    
    public int determinarTempoContrato(){
        return Data.dataAtual().diferenca(dataContrato);
    }
}
