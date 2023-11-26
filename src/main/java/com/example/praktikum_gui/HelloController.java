package com.example.praktikum_gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBoxJk;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBoxJk.getItems().add("Pilih jenis kelamin");
        choiceBoxJk.getItems().add("Laki - Laki");
        choiceBoxJk.getItems().add("Perempuan");

        choiceBoxJk.setValue("Pilih jenis kelamin");

    }
}