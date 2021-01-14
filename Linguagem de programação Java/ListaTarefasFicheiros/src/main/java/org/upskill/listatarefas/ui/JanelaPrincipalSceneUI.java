/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.ListaTarefas;

/**
 *
 * @author marco
 */
public class JanelaPrincipalSceneUI implements Initializable {

    private AplicacaoController appController;
    private Stage novaTarefaStage;
    @FXML
    private ListView<String> txtAreaTarefas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Nova Tarefa");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);

            appController = new AplicacaoController();
            atualizarListaTarefas();

            AdicionarTarefaSceneUI novaTarefaUI = loader.getController();
            novaTarefaUI.associarParentUI(this);
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {

    }

    @FXML
    private void mnuAdicionarTarefa(ActionEvent event) throws IOException {
        novaTarefaStage.show();
    }

    @FXML
    private void mnuGuardarComoTexto(ActionEvent event) throws FileNotFoundException {
        try {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(novaTarefaStage);

            StringBuilder s = new StringBuilder();

            for (int i = 0; i < appController.getLista().getListaTarefas().size(); i++) {
                s.append(appController.getLista().getListaTarefas().get(i).toString()).append("\n");
            }

            if (file != null) {
                guardarComoTexto(s.toString(), file);
            }
        } catch (FileNotFoundException e) {
            Alert errAlert = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Guardar ficheiro como texto", "Erro ao guardar ficheiro!", "Não foi possível guardar o ficheiro como texto!");
            errAlert.show();
        }

        Alert sucAlert = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Guardar ficheiro como texto", "Ficheiro criado com sucesso!", "O ficheiro foi criado com sucesso!");
        sucAlert.show();
    }

    @FXML
    private void mnuSerializacao(ActionEvent event) {

    }

    @FXML
    private void mnuDesserializacao(ActionEvent event) {
    }

    @FXML
    private void mnuSair(ActionEvent event) {
    }

    @FXML
    private void mnuRemoverSelecionada(ActionEvent event) {
    }

    @FXML
    private void mnuRemoverTodas(ActionEvent event) {
    }

    public void atualizarListaTarefas() {
        ListaTarefas listaTarefas = appController.getLista();

        ObservableList<String> items = FXCollections.observableArrayList();

        for (int i = 0; i < listaTarefas.getListaTarefas().size(); i++) {
            items.add(listaTarefas.getListaTarefas().get(i).toString());
        }

        txtAreaTarefas.setItems(items);
    }

    public AplicacaoController getController() {
        return appController;
    }

    private void guardarComoTexto(String content, File file) throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(file);
            try {
                writer.println(content);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            Alert errAlert = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Guardar documento como texto.", "Erro ao guardar documento!", "Não foi possível guardar o documento como texto.");
            errAlert.show();
        }
    }
}
