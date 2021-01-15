package org.upskill.listatarefas.ui;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserListaTarefasUI {

    private FileChooser fileChooser;

    private FileChooserListaTarefasUI(String descricao, String extensao) {
        fileChooser = new FileChooser();

        associarFiltro(descricao, extensao);
    }

    public static FileChooser criarFileChooserListaTarefas(String descricao, String extensao) {
        FileChooserListaTarefasUI fcListaTarefas = new FileChooserListaTarefasUI(descricao, extensao);

        return fcListaTarefas.fileChooser;
    }

    private void associarFiltro(String descricao, String extensao) {
        ExtensionFilter filtro = new ExtensionFilter(descricao, extensao);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
