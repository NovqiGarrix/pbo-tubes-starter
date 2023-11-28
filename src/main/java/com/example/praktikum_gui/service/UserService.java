package com.example.praktikum_gui.service;

import com.example.praktikum_gui.DBConnectionUtils;
import com.example.praktikum_gui.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public void insertPesertaBaru(User user) throws SQLException {

        String insertSQL = "INSERT INTO users (nama, jk, email, no_hp, tgl_lahir, kategori_tiket, jlh_tiket) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Ini menggunakan teknik Try with Resources
        // Jadi jangan bingung ya!
        try (
                Connection connection = DBConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertSQL)
        ) {

            statement.setString(1, user.getNama());
            statement.setString(2, user.getJk());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getNoHp());
            statement.setDate(5, user.getTglLahir());
            statement.setString(6, user.getKategoriTiket());
            statement.setInt(7, user.getJlhTiket());

            statement.execute();

        } catch (SQLException e) {
            System.out.println("Error ketika insert data peserta: " + e.getMessage());
        }

    }

}
