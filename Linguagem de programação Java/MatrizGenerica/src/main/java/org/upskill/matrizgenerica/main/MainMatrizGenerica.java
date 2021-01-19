
package org.upskill.matrizgenerica.main;

import org.upskill.matrizgenerica.model.MatrizGenerica;
import org.upskill.matrizgenerica.model.Trabalhador;
import org.upskill.matrizgenerica.model.TrabalhadorPeca;

public class MainMatrizGenerica {

    public static void main(String[] args) {
        MatrizGenerica<TrabalhadorPeca> matrizTrabalhador = new MatrizGenerica<>();
        MatrizGenerica<Integer> matrizInteger = new MatrizGenerica<>();
        MatrizGenerica<Comparable> matrizInterface= new MatrizGenerica<>();
        
        // MatrizGenerica<Trabalhador> matrizSupTrabalhador = matrizTrabalhador; Erro
    }
    
}
