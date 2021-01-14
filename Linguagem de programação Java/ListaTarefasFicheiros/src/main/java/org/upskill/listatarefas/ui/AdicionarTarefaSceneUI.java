/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Prioridade;

/**
 *
 * @author marco
 */
public class AdicionarTarefaSceneUI implements Initializable {

    JanelaPrincipalSceneUI janelaPrincipalUI;

    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    @FXML
    private void cancelarAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbPrioridade.getItems().addAll(Prioridade.values());
    }

    void associarParentUI(JanelaPrincipalSceneUI aThis) {
        this.janelaPrincipalUI = aThis;
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        AplicacaoController appController = janelaPrincipalUI.getController();

        try {
            String tarefa = txtTarefa.getText().trim();

            if (tarefa.isEmpty()) {
                throw new IllegalArgumentException("Nome de tarefa inválido!");
            }

            if (cmbPrioridade.getSelectionModel().isEmpty()) {
                throw new IllegalArgumentException("Selecione uma prioridade!");
            }

            String prioridade = cmbPrioridade.getValue().toString();

            if (appController.adicionarTarefa(tarefa, prioridade)) {
                janelaPrincipalUI.atualizarListaTarefas();
            } else {
                System.out.println("Erro a adicionar tarefa à lista");
            }

            Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Nova tarefa", "Adicionar tarefa", "Tarefa adicionada com sucesso!");
            alerta.show();
        } catch (RuntimeException e) {
            Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Não foi possível criar a tarefa!", "Houve um erro na criação de uma nova tarefa.", e.getMessage());
            alerta.show();
        }
    }
}
