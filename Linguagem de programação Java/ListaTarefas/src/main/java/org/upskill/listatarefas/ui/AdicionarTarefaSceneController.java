package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Prioridade;

public class AdicionarTarefaSceneController implements Initializable {

    private JanelaPrincipalSceneController janelaPrincipalUI;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbPrioridade.getItems().addAll(Prioridade.values());
    }

    public void associarParentUI(JanelaPrincipalSceneController janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {

        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoController();

            String tarefa = txtTarefa.getText().trim();
            String prioridade = cmbPrioridade.getValue().toString();

            if (appController.adicionarTarefa(tarefa, prioridade)) {
                janelaPrincipalUI.atualizarListaTarefas();
            } else {
                System.out.println("Erro a adicionar tarefa à lista");
            }
        } catch (Exception e) {
            System.out.println("erro idk");
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
    }

}
