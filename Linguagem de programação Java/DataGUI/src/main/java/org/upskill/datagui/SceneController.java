/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.upskill.datagui.model.Data;
import org.upskill.datagui.model.DiaInvalidoException;
import org.upskill.datagui.model.MesInvalidoException;

/**
 * FXML Controller class
 *
 * 
 */
public class SceneController implements Initializable {

    @FXML
    private TextField dateTxtField;
    @FXML
    private TextField weekDayTxtField;
    @FXML
    private Label fullDateLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getDiaDaSemanaBtn(ActionEvent event) {
        weekDayTxtField.setText(readDate().diaDaSemana());
    }

    @FXML
    private void getFullDateBtn(ActionEvent event) {
        fullDateLabel.setText(readDate().toString());
    }

    @FXML
    private void cleanBtn(ActionEvent event) {
        dateTxtField.clear();
        weekDayTxtField.clear();
        fullDateLabel.setText("");
    }
    
    private Data readDate(){
        String[] dateArgs = dateTxtField.getText().split("/", 3);
        int ano = Integer.parseInt(dateArgs[0]);
        int mes = Integer.parseInt(dateArgs[1]);
        int dia = Integer.parseInt(dateArgs[2]);
        Data data = new Data(ano, mes, dia);
        
        return data;
    }

}
