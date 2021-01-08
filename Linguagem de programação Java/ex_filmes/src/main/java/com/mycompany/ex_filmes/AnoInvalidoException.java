package com.mycompany.ex_filmes;

public class AnoInvalidoException extends IllegalArgumentException {

    public AnoInvalidoException() {
        super("Argumento fora dos limites !!!");
    }

    public AnoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
