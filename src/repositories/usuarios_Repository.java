package repositories;

import models.usuarios;
import utils.ConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usuarios_Repository {
    private Connection connection;

    public usuarios_Repository(Connection connection) {
        this.connection = connection;
    }

    public List<usuarios> list(){
        List<usuarios> usuario = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                usuarios us = new usuarios();
                us.setId(rs.getString("id"));
                us.setNombre_completo(rs.getString("nombre_completo"));
                us.setCorreo(rs.getString("correo"));
                us.setUsername(rs.getString("username"));
                us.setPassword(rs.getString("password"));
                us.setRol(rs.getString("rol"));
                usuario.add(us);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    /*
    Por el momento, obviare la clase de identificar el profesor, el admin, etc.
     */

    public boolean create(usuarios usuario) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO usuarios (id,nombre_completo,correo,username,password,rol) VALUES (?,?,?,?,?,?)");
            ps.setString(1,usuario.getId());
            ps.setString(2,usuario.getNombre_completo());
            ps.setString(3,usuario.getCorreo());
            ps.setString(4,usuario.getUsername());
            ps.setString(5,usuario.getPassword());
            ps.setString(6,usuario.getRol());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertar(usuarios usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, clave) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getId());
            ps.setString(2, usuario.getNombre_completo());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getUsername());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, usuario.getRol());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
