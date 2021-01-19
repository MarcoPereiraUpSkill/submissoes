
package org.upskill.matrizgenerica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrizGenerica<E> {

    private List< List<E> > matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumeroDeLinhas() {
        return this.matrizGenerica.size();
    }
    
    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public void limpar() {
        this.matrizGenerica.clear();
    }
    
    private int tamanhoColuna(int indice){
        verificarIndiceColuna(indice);
        int numeroLinhas=0;
        for (List<E> linha : this.matrizGenerica) {
            if(indice<linha.size()){
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }
    
    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(
                    "Índice Linha: " + indice
                    + ", Tamanho: " + this.matrizGenerica.size());
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }
    
    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matrizGenerica.size()
                || indiceColuna < 0
                || indiceColuna >= this.matrizGenerica.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha) + 
                    mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matrizGenerica.size();
    }
    
    private String mensagemIndiceColunaInvalido(int indice) {
        return  " Índice Coluna: " + indice
                + ", Tamanho: " + this.matrizGenerica.get(indice).size();
    }
    
    private E obterElemento(int indiceLinha, int indiceColuna){
        verificarIndices(indiceLinha, indiceColuna);
        
        return matrizGenerica.get(indiceLinha).get(indiceColuna);
    }     

    private boolean adicionarLinha(Collection<? extends E> linha){
        List<E> novaLista = new ArrayList<>(linha);
        
        if(linha.size() > numeroMaximoColunas){
            numeroMaximoColunas = linha.size();
        }
        
        return matrizGenerica.add(novaLista);
    }
    
    private boolean temElemento(E elemento){
        boolean found = false;
        
        for(int i = 0; i < matrizGenerica.size(); i++){
            for(int a = 0; i < matrizGenerica.get(i).size(); i++){
                if(matrizGenerica.get(i).get(a).equals(elemento)){
                    found = true;
                }
            }
        }
        
        return found;
    }
    
    private void substituirElemento(int indiceLinha, int indiceColuna, E elemento){
        matrizGenerica.get(indiceLinha).set(indiceColuna, elemento);
    }
    
    private void removerLinha(int indiceLinha){
        matrizGenerica.remove(indiceLinha);
    }
    
    private E[] obterArray(int indiceColuna, E[] array){
        //Não entendi o enunciado
        return array;
    }
}
