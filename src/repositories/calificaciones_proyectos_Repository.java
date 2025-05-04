package repositories;

import models.backlog_items;
import models.calificaciones_proyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class calificaciones_proyectos_Repository {
    private Connection connection;

    public calificaciones_proyectos_Repository(Connection connection) {
        this.connection = connection;
    }

    public List<calificaciones_proyectos> list() {
        List<calificaciones_proyectos> calificacion_proyecto = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM calificaciones_proyectos");
            while (rs.next()) {
                calificaciones_proyectos cal = new calificaciones_proyectos();
                cal.setId(rs.getString("id"));
                cal.setEstudiante_id(rs.getString("estudiante_id"));
                cal.setProyecto_id(rs.getString("proyecto_id"));
                cal.setCalificacion(rs.getFloat(("calificacion")));
                cal.setComentario(rs.getString("comentario"));
                cal.setFecha_calificacion(rs.getTimestamp("fecha_calificacion"));
                calificacion_proyecto.add(cal);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calificacion_proyecto;
    }

    public boolean create(calificaciones_proyectos cal) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(
                    "INSERT INTO calificaciones_proyectos (id, estudiante_id, proyecto_id, calificacion, comentario, fecha_calificacion) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, cal.getId());
            ps.setString(2, cal.getEstudiante_id());
            ps.setString(3, cal.getProyecto_id());
            ps.setFloat(4, cal.getCalificacion());
            ps.setString(5, cal.getComentario());
            ps.setTimestamp(6, cal.getFecha_calificacion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
