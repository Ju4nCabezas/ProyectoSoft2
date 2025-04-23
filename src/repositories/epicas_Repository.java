package repositories;

import models.epicas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class epicas_Repository {
    private Connection connection;

    public epicas_Repository(Connection connection) {this.connection = connection;}

    public List<epicas> list() {
        List<epicas> epica = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from epicas");
            while (rs.next()) {
                epicas e = new epicas();
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

    public boolean create(epicas epica) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO epicas (id, proyecto_id, descripcion) VALUES (?,?,?)");
            ps.setString(1, epica.getId());
            ps.setString(2, epica.getProyecto_id());
            ps.setString(3, epica.getDescripcion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException er) {
            er.printStackTrace();
            return false;
        }
        return true;
    }
}
