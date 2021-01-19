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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
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

    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    private static final int SERIALIZACAO = 1;
    private static final String DESCRICAO_SERIALIZACAO = "Ficheiro Lista Telefónica";
    private static final String EXTENSAO_SERIALIZACAO = "*.ltf";

    private static final int TEXTO = 2;
    private static final String DESCRICAO_TEXTO = "Ficheiro de Texto";
    private static final String EXTENSAO_TEXTO = "*.txt";
    @FXML
    private MenuItem guardarComoTextoBtn;
    @FXML
    private MenuItem serializacaoBtn;
    @FXML
    private MenuItem mnuItemRemoverSelec;
    @FXML
    private MenuItem mnuItemRemoveAll;

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

    @FXML
    private void mnuShowingAction(Event event) {
        serializacaoBtn.setDisable(appController.listaVazia());
        guardarComoTextoBtn.setDisable(appController.listaVazia());
    }

    @FXML
    private void mnuAdicionarTarefa(ActionEvent event) throws IOException {
        novaTarefaStage.show();
    }

    @FXML
    private void mnuGuardarComoTexto(ActionEvent event) throws FileNotFoundException {
        try {
            Optional<ButtonType> confResult = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, "Tarefas", "Guardar dados",
                    "Deseja armazenar os dados num ficheiro de texto?").showAndWait();

            if (confResult.isPresent() && confResult.get() == ButtonType.OK) {
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
            } else {
                return;
            }
        } catch (FileNotFoundException e) {
            Alert errAlert = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Guardar ficheiro como texto", "Erro ao guardar ficheiro!",
                    "Não foi possível guardar o ficheiro como texto!");
            errAlert.show();
        }

        Alert sucAlert = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Guardar ficheiro como texto", "Ficheiro criado com sucesso!",
                "O ficheiro foi criado com sucesso!");
        sucAlert.show();
    }

    @FXML
    private void mnuSerializacao(ActionEvent event) {
        exportarLista(SERIALIZACAO);
    }

    @FXML
    private void mnuDesserializacao(ActionEvent event) {
        importarLista(SERIALIZACAO);
    }

    @FXML
    private void mnuSair(ActionEvent event) {
    }

    @FXML
    private void mnuRemoverSelecionada(ActionEvent event) {
        String tarefa = txtAreaTarefas.getSelectionModel().getSelectedItem();

        try {
            if (appController.removerTarefa(tarefa)) {
                atualizarListaTarefas();

                Alert sucAlert = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Tarefas", "Remover tarefa",
                        "Tarefa removida com sucesso");
                sucAlert.show();
            } else {
                throw new RuntimeException("Erro ao remover tarefa!");
            }
        } catch (RuntimeException e) {
            Alert errAlert = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Tarefas", "Remover tarefa",
                    e.getMessage());
            errAlert.show();
        }

    }

    @FXML
    private void mnuRemoverTodas(ActionEvent event) {
        appController.eliminarTarefas();
        atualizarListaTarefas();
    }

    private void exportarLista(int tipoFicheiro) {
        Optional<ButtonType> confResult = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, "Tarefas", "Guardar dados",
                "Deseja armazenar os dados num ficheiro binário?").showAndWait();

        if (confResult.isPresent() && confResult.get() == ButtonType.OK) {
            String descricao, extensao;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    descricao = DESCRICAO_SERIALIZACAO;
                    extensao = EXTENSAO_SERIALIZACAO;
                    break;

                case TEXTO:
                    descricao = DESCRICAO_TEXTO;
                    extensao = EXTENSAO_TEXTO;
                    break;

                default:
                    throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
            }

            FileChooser flChooser = FileChooserListaTarefasUI.criarFileChooserListaTarefas(descricao, extensao);
            File ficheiroExportar = flChooser.showSaveDialog(txtAreaTarefas.getScene().getWindow());

            if (ficheiroExportar != null) {
                boolean gravou = false;

                switch (tipoFicheiro) {
                    case SERIALIZACAO:
                        gravou = appController.serializar(ficheiroExportar);
                        break;

                    case TEXTO:
                        gravou = appController.exportarTexto(ficheiroExportar);
                        break;

                }
                if (gravou) {
                    AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                            "Tarefas exportadas com sucesso.").show();
                } else {
                    AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                            "Problema a exportar a lista de tarefas!").show();
                }
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Não foi seleccionado nenhum ficheiro!").show();
            }
        }
    }

    private void importarLista(int tipoFicheiro) {
        try {
            String descricao, extensao;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    descricao = DESCRICAO_SERIALIZACAO;
                    extensao = EXTENSAO_SERIALIZACAO;
                    break;

                case TEXTO:
                    descricao = DESCRICAO_TEXTO;
                    extensao = EXTENSAO_TEXTO;
                    break;

                default:
                    throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
            }

            FileChooser flChooser = FileChooserListaTarefasUI.criarFileChooserListaTarefas(descricao, extensao);
            File ficheiroImportar = flChooser.showOpenDialog(txtAreaTarefas.getScene().getWindow());

            if (ficheiroImportar != null) {
                int numTarefasImportadas = 0;

                switch (tipoFicheiro) {
                    case SERIALIZACAO:
                        numTarefasImportadas = appController.desserializar(ficheiroImportar);
                        break;

                    case TEXTO:
                        numTarefasImportadas = appController.importarTexto(ficheiroImportar);
                        break;
                }

                if (numTarefasImportadas > 0) {
                    atualizarListaTarefas();

                    AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                            String.format("%d tarefa(s) importada(s).", numTarefasImportadas)).show();
                } else {
                    AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                            "Ficheiro sem tarefas para importar!").show();
                }
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        "Não foi seleccionado nenhum ficheiro!").show();
            }
        } catch (RuntimeException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                    e.getMessage()).show();
        }
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
            Alert errAlert = AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Guardar documento como texto.", "Erro ao guardar documento!",
                    "Não foi possível guardar o documento como texto.");
            errAlert.show();
        }
    }

    @FXML
    private void taskMnuShowing(Event event) {
        mnuItemRemoverSelec.setDisable(txtAreaTarefas.getSelectionModel().isEmpty());
        mnuItemRemoveAll.setDisable(appController.listaVazia());
    }
}
