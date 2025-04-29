package com.scrumapp.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.Epicas;


public class EpicService {

    public List<Epicas> list() {
        String query = "SELECT * FROM epicas";
        List<Epicas> epica = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Epicas e = new Epicas();
                e.setId(rs.getString("id"));
                e.setProyecto_id(rs.getString("proyecto_id"));
                e.setDescripcion(rs.getString("descripcion"));
                epica.add(e);

            }
            stmt.close();
            rs.close();
        } catch (SQLException er) {
            er.printStackTrace();
        }
        return epica;
    }

    public boolean create(Epicas epica) {
        String query = "INSERT INTO epicas (id, proyecto_id, descripcion) VALUES (?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, epica.getId());
            stmt.setString(2, epica.getProyecto_id());
            stmt.setString(3, epica.getDescripcion());
            stmt.executeUpdate();

        } catch (SQLException er) {
            er.printStackTrace();
            return false;
        }
        return true;
    }
}
