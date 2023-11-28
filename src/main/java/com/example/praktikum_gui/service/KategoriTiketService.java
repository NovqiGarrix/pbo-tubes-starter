package com.example.praktikum_gui.service;

import com.example.praktikum_gui.DBConnectionUtils;
import com.example.praktikum_gui.entity.JenisKelamin;
import com.example.praktikum_gui.entity.KategoriTiket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KategoriTiketService {

    public List<KategoriTiket> getAllKategoriTiket() {

        String selectQuery = "SELECT id, kategori FROM kategori_tiket";

        try (
                Connection connection = DBConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery)
        ) {

            List<KategoriTiket> kategoriTiketList = new ArrayList<>();

            while (resultSet.next()) {
                KategoriTiket kategoriTiket = new KategoriTiket();
                kategoriTiket.setId(resultSet.getString("id"));
                kategoriTiket.setKategori(resultSet.getString("kategori"));

                kategoriTiketList.add(kategoriTiket);
            }

            return kategoriTiketList;

        } catch (SQLException e) {
            System.out.println("Error ketika mengambil data kategori tiket: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
