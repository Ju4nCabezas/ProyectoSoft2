package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.models.Proyectos;
import com.scrumapp.utils.DatabaseConnection;

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

    public Proyectos obtenerProyectoPorUsuario(String userId) {
    Proyectos proyecto = null;
    String query = "SELECT * FROM proyectos WHERE creado_por = ? LIMIT 1";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            proyecto = new Proyectos();
            proyecto.setId(rs.getString("id"));
            proyecto.setNombre(rs.getString("nombre"));
            proyecto.setDescripcion(rs.getString("descripcion"));
            proyecto.setCreado_por(rs.getString("creado_por"));
        }

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
