/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex_contador_cliques;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class FXMLController implements Initializable {

    @FXML
    private Label clickNumberLabel;
    private int numCliques = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnClickAddAction(ActionEvent event) {
        numCliques++;
        clickNumberLabel.setText("Número de Cliques: " + numCliques);
    }
    
}
