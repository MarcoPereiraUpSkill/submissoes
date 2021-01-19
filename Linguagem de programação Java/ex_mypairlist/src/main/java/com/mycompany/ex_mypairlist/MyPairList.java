
package com.mycompany.ex_mypairlist;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MyPairList<T extends Comparable<T>, E extends Comparable<E>>{
    private List<Pair<T, E>> listaPares;

    public MyPairList(List<Pair<T,E>> listaPares) {
        this.listaPares = listaPares;
    }

    public List<Pair<T, E>> getListaPares() {
        return listaPares;
    }

    public void setListaPares(List<Pair<T, E>> listaPares) {
        this.listaPares = listaPares;
    }

    @Override
    public String toString() {
        return "MyPairList{" + "listaPares=" + listaPares + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final MyPairList other = (MyPairList) obj;
        return Objects.equals(this.listaPares, other.listaPares);
    }   
    
    public <T extends Comparable, E extends Comparable> boolean adicionarDoisObjetos(T objeto1, E objeto2){
        Pair novoPair = new Pair(objeto1, objeto2);
        
        return listaPares.add(novoPair);
    }
    
    public void eliminarPair(Pair<T, E> pair){
        listaPares.remove(pair);
    }
    
    public List<Pair<T, E>> organizarLista(){
        Collections.sort(listaPares, new CompararGenericos());
        
        return listaPares;
    }
    
    public MyPairList<T, E> obterParMaior(Pair<T, E>)
}
