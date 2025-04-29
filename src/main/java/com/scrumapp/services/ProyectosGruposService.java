package com.scrumapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.ProyectoGrupos;

public class ProyectosGruposService {

    private Connection connection;

    public ProyectosGruposService() { connection = DatabaseConnection.getConnection(); }

    public List<ProyectoGrupos> list(){
        List<ProyectoGrupos> proyecto_grupo = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM proyectos_grupos;");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ProyectoGrupos pg = new ProyectoGrupos();
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

    public boolean create(ProyectoGrupos proyecto_grupo){
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
