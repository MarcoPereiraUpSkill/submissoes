
package com.mycompany.ex_filmes;

public class IdentificadorInvalidoException extends IllegalArgumentException {
    public IdentificadorInvalidoException(){
        super("Identificador inválido!");
    }
    
    public IdentificadorInvalidoException(String msg){
        super(msg);
    }
}
