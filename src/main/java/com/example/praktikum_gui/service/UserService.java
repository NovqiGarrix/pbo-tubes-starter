package com.example.praktikum_gui.service;

import com.example.praktikum_gui.DBConnectionUtils;
import com.example.praktikum_gui.entity.JenisKelamin;
import com.example.praktikum_gui.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void insertPesertaBaru(User user) throws SQLException {

        String insertSQL = "INSERT INTO users (nama, jk, email, no_hp, tgl_lahir, kategori_tiket, jlh_tiket) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Ini menggunakan teknik Try with Resources
        // Jadi jangan bingung ya!
        try (
                Connection connection21104065 = DBConnectionUtils.getConnection();
                PreparedStatement statement = connection21104065.prepareStatement(insertSQL)
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

    public User editPeserta(int id, User user) throws SQLException {

        String updateSQL = "UPDATE users SET nama = ?, jk = ?, email = ?, no_hp = ?, tgl_lahir = ?, kategori_tiket = ?, jlh_tiket = ? WHERE id = ?";

        try (
                Connection connection = DBConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(updateSQL)
                ) {

            statement.setString(1, user.getNama());
            statement.setString(2, user.getJk());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getNoHp());
            statement.setDate(5, user.getTglLahir());
            statement.setString(6, user.getKategoriTiket());
            statement.setInt(7, user.getJlhTiket());
            statement.setInt(8, id);

            return user;

        }

    }

    public List<User> getAllPeserta() {

        String selectQuery = "SELECT * FROM users";

        try (
                Connection connection = DBConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery)
        ) {

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setNama(resultSet.getString("nama"));
                user.setJk(resultSet.getString("jk"));
                user.setEmail(resultSet.getString("email"));
                user.setNoHp(resultSet.getString("no_hp"));
                user.setTglLahir(resultSet.getDate("tgl_lahir"));
                user.setKategoriTiket(resultSet.getString("kategori_tiket"));
                user.setJlhTiket(resultSet.getInt("jlh_tiket"));

                users.add(user);

            }

            return users;

        } catch (SQLException e) {
            System.out.println("Error ketika mengambil data jenis kelamin: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
