package com.example.praktikum_gui;

import com.example.praktikum_gui.entity.JenisKelamin;
import com.example.praktikum_gui.entity.KategoriTiket;
import com.example.praktikum_gui.entity.User;
import com.example.praktikum_gui.service.JenisKelaminService;
import com.example.praktikum_gui.service.KategoriTiketService;
import com.example.praktikum_gui.service.UserService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBoxJk;

    @FXML
    private ChoiceBox<String> choiceBoxKategoriTiket;

    @FXML
    private Button buttonSubmit;

    @FXML
    private TextField textFielTglLahir;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldJlhTiket;

    @FXML
    private TextField textFieldNama;

    @FXML
    private TextField textFieldNoHP;

    @FXML
    private TableView<User> tabelPeserta;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> jkColumn;

    @FXML
    private TableColumn<User, String> jlhTiketColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> noHpColumn;

    @FXML
    private TableColumn<User, String> tglLahirColumn;

    @FXML
    private TableColumn<User, String> tiketColumn;

    private final UserService userService = new UserService();
    private final JenisKelaminService jenisKelaminService = new JenisKelaminService();
    private final KategoriTiketService kategoriTiketService = new KategoriTiketService();

    public Task<Void> loadListKategoriTiket() {

        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                var kategoriTiketList = kategoriTiketService.getAllKategoriTiket();

                Platform.runLater(() -> {
                    choiceBoxKategoriTiket.getItems().add("Pilih kategori tiket");
                    for (KategoriTiket kategoriTiket : kategoriTiketList) {
                        choiceBoxKategoriTiket.getItems().add(kategoriTiket.getKategori());
                    }
                    choiceBoxKategoriTiket.setValue("Pilih kategori tiket");
                });

                return null;
            }
        };

        return task;

    }

    public Task<Void> loadListJenisKelamin() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                var jenisKelaminList = jenisKelaminService.getAllJenisKelamin();

                Platform.runLater(() -> {
                    choiceBoxJk.getItems().add("Pilih jenis kelamin");
                    for (JenisKelamin jenisKelamin : jenisKelaminList) {
                        choiceBoxJk.getItems().add(jenisKelamin.getLabel());
                    }
                    choiceBoxJk.setValue("Pilih jenis kelamin");
                });

                return null;
            }
        };

        return task;
    }

    public Task<Void> loadListUsers() {

        return new Task<>() {
            @Override
            protected Void call() {

                var users = userService.getAllPeserta();
                Platform.runLater(() -> tabelPeserta.getItems().addAll(users));

                return null;
            }
        };

    }

    void setDefaultJk() {
        choiceBoxJk.setValue("Pilih jenis kelamin");
    }

    void setDefaultKategoriTiket() {
        choiceBoxKategoriTiket.setValue("Pilih kategori tiket");
    }

    public void setTabelPesertaColumn() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        jkColumn.setCellValueFactory(new PropertyValueFactory<>("jk"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        noHpColumn.setCellValueFactory(new PropertyValueFactory<>("noHp"));
        tglLahirColumn.setCellValueFactory(new PropertyValueFactory<>("tglLahir"));
        tiketColumn.setCellValueFactory(new PropertyValueFactory<>("kategoriTiket"));
        jlhTiketColumn.setCellValueFactory(new PropertyValueFactory<>("jlhTiket"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        buttonSubmit.setOnMouseClicked(mouseEvent -> {

            User user = new User();
            user.setNama(textFieldNama.getText());
            user.setJk(choiceBoxJk.getValue());
            user.setEmail(textFieldEmail.getText());
            user.setNoHp(textFieldNoHP.getText());
            user.setTglLahir(Date.valueOf(textFielTglLahir.getText()));
            user.setKategoriTiket(choiceBoxKategoriTiket.getValue());
            user.setJlhTiket(Integer.parseInt(textFieldJlhTiket.getText()));

            // Simpan ke DB
            try {
                userService.insertPesertaBaru(user);

                // Kosongkan kembali inputnya
                textFieldNama.setText("");
                setDefaultJk();
                textFieldEmail.setText("");
                textFieldNoHP.setText("");
                textFielTglLahir.setText("");
                setDefaultKategoriTiket();
                textFieldJlhTiket.setText("");


            } catch (SQLException e) {
                // Handle error
                System.out.println("Error ketika mendaftarkan peserta: " + e.getMessage());
            }

        });

    }
}