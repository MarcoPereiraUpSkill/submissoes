
package com.mycompany.ex_filmes;

public class CategoriaInvalidaException extends IllegalArgumentException{
    public CategoriaInvalidaException(){
        super("Categoria inválida!!");
    }
    
    public CategoriaInvalidaException(String msg){
        super(msg);
    }
}
