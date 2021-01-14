package org.upskill.listatarefas.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FicheiroListaTarefas {

    public static final String NOME_FICHEIRO_SERIALIZAR = "ListaTarefas.ltf";

    public FicheiroListaTarefas() {

    }

    public boolean serializar(ListaTarefas listaTarefas) {
        return serializar(NOME_FICHEIRO_SERIALIZAR, listaTarefas);
    }

    public boolean serializar(File ficheiro, ListaTarefas listaTarefas) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(listaTarefas);

                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }
}
