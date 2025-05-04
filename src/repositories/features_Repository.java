package repositories;

import models.features;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class features_Repository {
    private Connection connection;

    public features_Repository(Connection connection) {this.connection = connection;}

    public List<features> list() {
        List<features> feature = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM features");
            while (rs.next()) {
                features f = new features();
                f.setId(rs.getString("id"));
                f.setEpica_id(rs.getString("epica_id"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setNombre(rs.getString("nombre"));
                feature.add(f);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feature;
    }

    public boolean create(features f) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO features (id,epica_id,descripcion,nombre)VALUES (?,?,?,?)");
            ps.setString(1, f.getId());
            ps.setString(2, f.getEpica_id());
            ps.setString(3, f.getDescripcion());
            ps.setString(4, f.getNombre());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
