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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.ListaTarefas;

public class JanelaPrincipalSceneController implements Initializable {

    @FXML
    private Button btnAdicionarTarefas;
    @FXML
    private Button btnLimparTarefas;
    @FXML
    private TextArea txtAreaTarefas;

    private Stage stage;
    private AplicacaoController appController;
    private KeyCodeCombination ctrlZ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Adicionar Nova Tarefa");
            stage.setResizable(false);
            stage.setScene(scene);

            appController = new AplicacaoController();

            AdicionarTarefaSceneController adicionarTarefaUI = loader.getController();
            adicionarTarefaUI.associarParentUI(this);

            final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);

        } catch (IOException ex) {
            System.out.println("Error handling");
        }
    }

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) {
        stage.show();
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        appController.eliminarTarefas();
        atualizarListaTarefas();
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            appController.eliminarUltimaTarefa();
            atualizarListaTarefas();
        }

        if (event.isControlDown() && event.getCode() == KeyCode.P) {
            appController.getListaTarefasPorPrioridade();
            atualizarListaTarefas();
        }

        if (event.isControlDown() && event.getCode() == KeyCode.O) {
            appController.getListaTarefasInsercao();
            atualizarListaTarefas();
        }
    }

    public void atualizarListaTarefas() {
        ListaTarefas listaTarefas = appController.getLista();

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < listaTarefas.getListaTarefas().size(); i++) {
            s.append(listaTarefas.getListaTarefas().get(i).getDescricao()).append(" - ");
            s.append(listaTarefas.getListaTarefas().get(i).getPrioridade()).append(" - ");
            s.append(listaTarefas.getListaTarefas().get(i).getInstante().toString()).append("\n");
        }

        txtAreaTarefas.setText(s.toString().trim());
        this.toggleCleanBtn();
    }

    public void toggleCleanBtn() {
        ListaTarefas listaTarefas = appController.getLista();

        boolean canClean = listaTarefas.getListaTarefas().isEmpty();

        btnLimparTarefas.setDisable(canClean);
    }
}
