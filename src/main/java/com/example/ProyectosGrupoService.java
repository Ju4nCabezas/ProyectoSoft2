package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.scrumapp.models.Proyectos;

import com.scrumapp.utils.DatabaseConnection;

public class ProyectosGrupoService {
    private Connection connection;

    public ProyectosGrupoService() { connection = DatabaseConnection.getConnection(); }

    public List<Proyectos> list() {
        List<Proyectos> proyectos = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM proyectos;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proyectos p = new Proyectos();
                p.setId(rs.getString("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCreado_por(rs.getString("creado_por"));
                proyectos.add(p);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyectos;
    }

    public boolean create(Proyectos proyecto) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(
                "INSERT INTO proyectos (id, nombre, descripcion, creado_por) VALUES (?, ?, ?, ?);"
            );
            ps.setString(1, proyecto.getId());
            ps.setString(2, proyecto.getNombre());
            ps.setString(3, proyecto.getDescripcion());
            ps.setString(4, proyecto.getCreado_por());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
