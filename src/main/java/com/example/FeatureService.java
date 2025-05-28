package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.utils.DatabaseConnection;

public class FeatureService {
    public List<Feature> obtenerFeaturesPorEpica(String epicaId) {
    List<Feature> features = new ArrayList<>();
    String query = "SELECT * FROM features WHERE epica_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, epicaId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Feature f = new Feature(
                rs.getString("id"),
                rs.getString("epica_id"),
                rs.getString("descripcion"),
                rs.getString("nombre")
            );
            features.add(f);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return features;
}

}
