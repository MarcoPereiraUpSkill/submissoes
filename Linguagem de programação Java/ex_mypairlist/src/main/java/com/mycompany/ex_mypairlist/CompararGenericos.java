/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_mypairlist;

import java.util.Comparator;

/**
 *
 * @author marco
 * @param <T>
 * @param <E>
 */
public class CompararGenericos<T extends Comparable<T>, E extends Comparable<E>> implements Comparator<Pair<T, E>> {

    @Override
    public int compare(Pair<T, E> o1, Pair<T, E> o2) {
        if(o1.getPrimeiroObjeto().compareTo(o2.getPrimeiroObjeto()) == 0){
            if(o1.getSegundoObjeto().compareTo(o2.getSegundoObjeto()) == 0){
                return 0;
            } else {
                return o1.getSegundoObjeto().compareTo(o2.getSegundoObjeto());
            }
        } else {
            return o1.getPrimeiroObjeto().compareTo(o2.getPrimeiroObjeto());
        }
    }

}
