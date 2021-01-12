/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import com.sun.media.sound.InvalidFormatException;
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
    
    private int dia, mes, ano;
    private Data data;

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

    private Data readDate() {
        try {
            String[] dateArgs = dateTxtField.getText().split("/", 3);
            ano = Integer.parseInt(dateArgs[0]);
            mes = Integer.parseInt(dateArgs[1]);
            dia = Integer.parseInt(dateArgs[2]);

            data = new Data(ano, mes, dia);

        } catch (DiaInvalidoException die) {
            Alert alertDia = new Alert(AlertType.ERROR);
            alertDia.setContentText("Dia " + dia + " não válido!");

            alertDia.show();
        } catch (MesInvalidoException mie) {
            Alert alertMes = new Alert(AlertType.ERROR);
            alertMes.setContentText("Mês " + mes + " não válido!");

            alertMes.show();
        } catch (RuntimeException e){
            Alert alertFormat = new Alert(AlertType.ERROR);
            alertFormat.setContentText("Formato inválido!");
            
            alertFormat.show();
        }

        return data;
    }

}
