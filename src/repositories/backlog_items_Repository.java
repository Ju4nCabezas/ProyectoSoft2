package repositories;

import models.backlog_items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class backlog_items_Repository {
    private Connection connection;

    public backlog_items_Repository(Connection connection) {this.connection = connection;}

    public List<backlog_items> list() {
        List<backlog_items> backlog_item = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backlog_items");
            while (rs.next()) {
                backlog_items backlogItems = new backlog_items();
                backlogItems.setId(rs.getString("id"));
                backlogItems.setFeature_id(rs.getString("feature_id"));
                backlogItems.setDescripcion(rs.getString("descripcion"));
                backlogItems.setPuntos_esfuerzo(rs.getInt("puntos_esfuerzo"));
                backlogItems.setNombre(rs.getString("nombre"));
                backlog_item.add(backlogItems);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return backlog_item;
    }

    public boolean create(backlog_items backlogItem) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO backlog_items (id,feature_id,descripcion,puntos_esfuerzo,nombre) VALUES (?,?,?,?,?)");
            ps.setString(1, backlogItem.getId());
            ps.setString(2, backlogItem.getFeature_id());
            ps.setString(3, backlogItem.getDescripcion());
            ps.setInt(4, backlogItem.getPuntos_esfuerzo());
            ps.setString(5, backlogItem.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
