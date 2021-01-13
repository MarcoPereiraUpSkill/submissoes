package com.mycompany.ex_shift;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    @FXML
    private TextField qtdLetrasInput;
    @FXML
    private Label lettersField;

    private final String[] letters = {"A", "B", "C", "D", "E", "F", "G"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void qtdLetrasBtnAction(ActionEvent event) {
        try {
            readLetterNum();
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    private void shiftLeftBtnAction(ActionEvent event) {
        String[] availableLetters = lettersField.getText().split(" ");
        String lastElement = availableLetters[availableLetters.length - 1];

        for (int i = availableLetters.length - 1; i >= 0; i--) {
            availableLetters[i] = availableLetters[i - 1];
        }

        availableLetters[0] = lastElement;

        updateLetters(availableLetters, availableLetters.length);
    }

    @FXML
    private void shiftRightBtnAction(ActionEvent event) {
        String[] availableLetters = lettersField.getText().split(" ");
        String firstElement = availableLetters[0];

        for (int i = 0; i < availableLetters.length - 1; i++) {
            availableLetters[i] = availableLetters[i + 1];
        }

        availableLetters[availableLetters.length - 1] = firstElement;

        updateLetters(availableLetters, availableLetters.length);
    }

    private void readLetterNum() {
        int qtdLetras;

        try {
            qtdLetras = Integer.parseInt(qtdLetrasInput.getText());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Formato inválido!");
        }

        if (qtdLetras < 3 || qtdLetras > 7) {
            throw new IllegalArgumentException("Deve ser introduzido um valor entre 3 e 7!");
        }

        updateLetters(letters, qtdLetras);
    }

    private void showAlert(Alert.AlertType tipo, String msg) {
        Alert alert = new Alert(tipo);
        alert.setContentText(msg);

        alert.show();
    }

    private void updateLetters(String[] letters, int qtdLetras) {
        StringBuilder lettersText = new StringBuilder();
        for (int i = 0; i < qtdLetras; i++) {
            lettersText.append(letters[i]);
            lettersText.append(" ");
        }

        lettersField.setText(lettersText.toString().trim());
    }
}
