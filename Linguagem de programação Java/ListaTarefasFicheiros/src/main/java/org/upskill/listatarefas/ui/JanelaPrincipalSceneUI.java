/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;

/**
 *
 * @author marco
 */
public class JanelaPrincipalSceneUI implements Initializable {

    private AplicacaoController appController;
    private Stage novaTarefaStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarNovoContactoScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Novo Contacto");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);

            appController = new AplicacaoController();
            atualizaTextAreaListaTarefas();

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
    private void mnuAdicionarTarefa(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void mnuGuardarComoTexto(ActionEvent event) {
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

    private void atualizaTextAreaListaTarefas() {

    }
    
    public AplicacaoController getController(){
        return appController;
    }

}
