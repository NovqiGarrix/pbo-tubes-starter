module com.example.praktikum_gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.praktikum_gui to javafx.fxml;
    opens com.example.praktikum_gui.entity to javafx.base;
    requires com.zaxxer.hikari;
    requires java.sql;
    exports com.example.praktikum_gui;
}