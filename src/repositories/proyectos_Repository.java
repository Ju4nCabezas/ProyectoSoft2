package repositories;
import  models.proyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class proyectos_Repository {
    private Connection connection;

    public proyectos_Repository(Connection connection) {
        this.connection = connection;
    }

    public List<proyectos> list() {
        List<proyectos> proyecto = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM proyectos");
            while (rs.next()) {
                proyectos pr = new proyectos();
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

    public Boolean create(proyectos pr) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO proyectos (id, nombre, descripcion, creado_por) VALUES (?, ?, ?, ?)");
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
