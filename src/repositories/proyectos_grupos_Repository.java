package repositories;

import models.proyectos_grupos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class proyectos_grupos_Repository {
    private Connection connection;

    public proyectos_grupos_Repository(Connection connection) { this.connection = connection; }

    public List<proyectos_grupos> list(){
        List<proyectos_grupos> proyecto_grupo = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM proyectos_grupos;");
            while(rs.next()){
                proyectos_grupos pg = new proyectos_grupos();
                pg.setProyecto_id(rs.getString("proyecto_id"));
                pg.setGrupo_id(rs.getString("grupo_id"));
                proyecto_grupo.add(pg);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyecto_grupo;
    }

    public boolean create(proyectos_grupos proyecto_grupo){
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO proyectos_grupos (proyecto_id, grupo_id) VALUES (?,?);");
            ps.setString(1, proyecto_grupo.getProyecto_id());
            ps.setString(2, proyecto_grupo.getGrupo_id());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
