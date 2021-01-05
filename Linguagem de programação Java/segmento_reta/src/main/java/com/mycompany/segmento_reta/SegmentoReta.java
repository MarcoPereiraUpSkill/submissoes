
package com.mycompany.segmento_reta;

public class SegmentoReta {
    private Ponto inicio;
    private Ponto fim;
    
    public void Ponto(Ponto inicio, Ponto fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    public Ponto getInicio() {
        return inicio;
    }

    public void setInicio(Ponto inicio) {
        this.inicio = inicio;
    }

    public Ponto getFim() {
        return fim;
    }

    public void setFim(Ponto fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "SegmentoReta{" + "inicio=" + inicio + ", fim=" + fim + '}';
    }
    
    public double determinarComprimento(){
        return Math.sqrt((fim.getY() - inicio.getY()) * (fim.getY() - inicio.getY()) + 
                (fim.getX() - inicio.getX()) * (fim.getX() - inicio.getX()));
    }
    
    public double calcularDeclive(){
        return (inicio.getY() - fim.getY()) / (inicio.getX() - fim.getX());
    }
    
    public void deslocarSegmento(int dx, int dy){
        inicio.moverPonto(dx, dy);
        fim.moverPonto(dx, dy);
    }
}
