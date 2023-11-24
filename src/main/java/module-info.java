module com.example.praktikum_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.praktikum_gui to javafx.fxml;
    exports com.example.praktikum_gui;
}