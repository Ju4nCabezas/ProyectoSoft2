package com.scrumapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.Proyectos;

public class ProyectosService {

    private Connection connection;

    public ProyectosService() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Proyectos> list() {
        List<Proyectos> proyecto = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM proyectos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proyectos pr = new Proyectos();
                pr.setId(rs.getString("id"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setCreado_por(rs.getString("creado_por"));
                proyecto.add(pr);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyecto;
    }

    public Boolean create(Proyectos pr) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO proyectos (id, nombre, descripcion, creado_por) VALUES (?, ?, ?, ?)");
            ps.setString(1, pr.getId());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getDescripcion());
            ps.setString(4, pr.getCreado_por());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
