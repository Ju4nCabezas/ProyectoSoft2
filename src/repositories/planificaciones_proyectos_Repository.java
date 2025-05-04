package repositories;

import models.planificaciones_proyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class planificaciones_proyectos_Repository {
    private Connection connection;

    public planificaciones_proyectos_Repository(Connection connection) {this.connection = connection;}

    public List<planificaciones_proyectos> list() {
        List<planificaciones_proyectos> planificacion_proyecto = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM planificaciones_proyectos");
            while (rs.next()) {
                planificaciones_proyectos pp = new planificaciones_proyectos();
                pp.setId(rs.getString("id"));
                pp.setProyecto_id(rs.getString("proyecto_id"));
                pp.setObjetivos(rs.getString("objetivos"));
                pp.setMetas(rs.getString("metas"));
                pp.setMetodologia(rs.getString("metodologia"));
                planificacion_proyecto.add(pp);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planificacion_proyecto;
    }

    public boolean create(planificaciones_proyectos pp) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO planificaciones_proyectos (id,proyecto_id,objetivos,metas,metodologia) VALUES (?,?,?,?,?)");
            ps.setString(1,pp.getId());
            ps.setString(2,pp.getProyecto_id());
            ps.setString(3,pp.getObjetivos());
            ps.setString(4,pp.getMetas());
            ps.setString(5,pp.getMetodologia());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
