package com.mycompany.ex_filmes;

import java.util.Scanner;

public class FilmesMain {

    public static void main(String[] args) {
        boolean idFlag = true, yearFlag = true;
        Scanner ler = new Scanner(System.in);

        Data data1 = new Data(1993, 04, 14);
        Data data2 = new Data(1984, 10, 10);
        Data data3 = new Data(1990, 12, 28);
        Data data4 = new Data(1975, 3, 8);

        Realizador realizador1 = new Realizador("Marco Pereira", "Portugues", data1);
        Realizador realizador2 = new Realizador("Michael Bay", "Americano", data2);
        Realizador realizador3 = new Realizador("Juan Esteves", "Espanhol", data3);
        Realizador realizador4 = new Realizador("François Bacon", "Francês", data4);

        Filme filme1 = new Filme("Parque Jurássico", 2001, realizador1);
        Filme filme2 = new Filme("Bagulhada maluca", 2019, realizador2);
        Filme filme3 = new Filme("Atão meu, tás a gozar não?", 2020, realizador3);
        Filme filme4 = new Filme("A serra", 1998, realizador4);

        ListaFilmes listaFilmes1 = new ListaFilmes();

        listaFilmes1.addFilme(filme1);
        listaFilmes1.addFilme(filme2);
        listaFilmes1.addFilme(filme3);
        listaFilmes1.addFilme(filme4);

        do {
            try {
                System.out.println("Insira um identificador");
                String id = ler.nextLine();
                listaFilmes1.setIdentificador(id);
                idFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (idFlag);

        do {
            try {
                System.out.println("Insira um ano de realização");
                int ano = ler.nextInt();
                filme1.setAnoRealizacao(ano);
                yearFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (yearFlag);

    }

}
