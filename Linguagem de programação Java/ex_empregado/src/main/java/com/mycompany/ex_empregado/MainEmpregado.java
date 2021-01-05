package com.mycompany.ex_empregado;

import com.mycompany.utilitarios.Data;
import com.mycompany.utilitarios.Tempo;
import java.util.ArrayList;

public class MainEmpregado {

    public static void main(String[] args) {
        // Criar e visualizar uma instância de Data e mostrar a data atual
        System.out.println("###Criar e visualizar uma instância de Data e mostrar a data atual###");
        Data data = new Data(2021, 01, 05);
        System.out.println(data);

        //Criar e visualizar duas instâncias de Tempo
        System.out.println("\n###Criar e visualizar duas instâncias de Tempo###");
        Tempo tempo1 = new Tempo(10, 59, 0);
        Tempo tempo2 = new Tempo(0, 4, 20);
        System.out.println(tempo1);
        System.out.println(tempo2);

        //Crie duas instâncias de Empregado usando para o efeito as instâncias de Data e de Tempo criadas anteriormente;
        Empregado empregado1 = new Empregado("Marco", "Pereira", data, tempo1, tempo2);
        Empregado empregado2 = new Empregado("Ema", "Bonito", data, tempo1, tempo2);

        //Verifique se os atributos do tipo Data e Tempo dos empregados criados possuem referências partilhadas;
        System.out.println("\n###Verificar se os atributos do tipo Data dos empregados criados possuem referências partilhadas###");
        System.out.println("Data contrato igual:" + empregado1.getDataContrato().equals(empregado2.getDataContrato()));
        System.out.println("Hora entrada igual: " + empregado1.getHoraEntrada().equals(empregado2.getHoraEntrada()));
        System.out.println("Hora saída igual: " + empregado1.getHoraSaida().equals(empregado2.getHoraSaida()));

        //Altere o conteúdo do objeto Data e o conteúdo dos objetos Tempo inicialmente criados;
        data.setData(2020, 12, 12);
        tempo1.setTempo(13, 45, 0);
        tempo2.setTempo(23, 59, 20);

        //Visualize as instâncias de Data e de Tempo, bem como as instâncias de Empregado criadas;
        System.out.println("\n###Visualizar as instâncias de Data e de Tempo, bem como as instâncias de Empregado criadas###");
        System.out.println(data);
        System.out.println(tempo1);
        System.out.println(tempo2);
        System.out.println(empregado1);
        System.out.println(empregado2);

        //Altere a data de contrato e as horas de entrada e de saída do segundo empregado
        Data novaData = new Data(1999, 04, 14);
        Tempo novaHoraEntrada = new Tempo(11, 34, 30);
        Tempo novaHoraSaida = new Tempo(18, 25, 0);
        empregado2.setDataContrato(novaData);
        empregado2.setHoraEntrada(novaHoraEntrada);
        empregado2.setHoraSaida(novaHoraSaida);

        //Armazene as instâncias de Empregado criadas num contentor de objetos do tipo ArrayList;
        ArrayList<Empregado> empregados = new ArrayList<>();
        empregados.add(empregado1);
        empregados.add(empregado2);

        //Liste todos os empregados;
        System.out.println("\n###Listar todos os empregados###");
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println(empregados.get(i));
        }

        //Liste o nome, o número de horas de trabalho por semana e a antiguidade de cada um dos empregados.
        System.out.println("\n###Listar o nome, o número de horas de trabalho por semana e a antiguidade de cada um dos empregados###");
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println("Número de horas do empregado " + empregados.get(i).getPrimeiroNome() + " " + empregados.get(i).getUltimoNome()
                    + ": " + empregados.get(i).calcularHorasSemanais() + " horas");
            
            System.out.println("Antiguidade do empregado " + empregados.get(i).getPrimeiroNome() + " " + empregados.get(i).getUltimoNome() 
                    + ": " + empregados.get(i).determinarTempoContrato() + " dias");
        }
    }

}
