package com.example.praktikum_gui.service;

import com.example.praktikum_gui.DBConnectionUtils;
import com.example.praktikum_gui.entity.JenisKelamin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisKelaminService {

    public List<JenisKelamin> getAllJenisKelamin() {

        String selectQuery = "SELECT id, label FROM jenis_kelamin";

        try (
                Connection connection = DBConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery)
        ) {

            List<JenisKelamin> jenisKelaminList = new ArrayList<>();

            while (resultSet.next()) {
                JenisKelamin jenisKelamin = new JenisKelamin();
                jenisKelamin.setId(resultSet.getString("id"));
                jenisKelamin.setLabel(resultSet.getString("label"));

                jenisKelaminList.add(jenisKelamin);
            }

            return jenisKelaminList;

        } catch (SQLException e) {
            System.out.println("Error ketika mengambil data jenis kelamin: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
