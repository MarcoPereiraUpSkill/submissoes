
package com.mycompany.segmento_reta;

public class Ponto {
    private int x;
    private int y;
    
    private static final int X_POR_OMISSAO = 0;
    private static final int Y_POR_OMISSAO = 0;
    
    public void Ponto(){
        x = X_POR_OMISSAO;
        y = Y_POR_OMISSAO;
    }
    
    public void Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ponto(" + "x=" + x + ", y=" + y + '}';
    }
    
    public void alterarPonto(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }
    
    public void moverPonto(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
}
