module com.example.praktikum_gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.praktikum_gui to javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;
    exports com.example.praktikum_gui;
}