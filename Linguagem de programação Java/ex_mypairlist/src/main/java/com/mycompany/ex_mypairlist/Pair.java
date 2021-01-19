/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_mypairlist;

import java.util.Objects;

/**
 *
 * @author marco
 * @param <T>
 * @param <E>
 */
public class Pair<T extends Comparable<T>, E extends Comparable<E>> {

    private T primeiroObjeto;
    private E segundoObjeto;

    public Pair(T primeiroObjeto, E segundoObjeto) {
        this.primeiroObjeto = primeiroObjeto;
        this.segundoObjeto = segundoObjeto;
    }

    public T getPrimeiroObjeto() {
        return primeiroObjeto;
    }

    public void setPrimeiroObjeto(T primeiroObjeto) {
        this.primeiroObjeto = primeiroObjeto;
    }

    public E getSegundoObjeto() {
        return segundoObjeto;
    }

    public void setSegundoObjeto(E segundoObjeto) {
        this.segundoObjeto = segundoObjeto;
    }

    @Override
    public String toString() {
        return "Pair:" + "\nPrimeiroObjeto=" + primeiroObjeto + "\nSegundoObjeto=" + segundoObjeto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!Objects.equals(this.primeiroObjeto, other.primeiroObjeto)) {
            return false;
        }
        return Objects.equals(this.segundoObjeto, other.segundoObjeto);
    }

}
