package com.scrumapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.GruposSemestrales;

public class GruposService {

    public List<GruposSemestrales> GrupoSemestral() {

        String query = "SELECT * FROM grupos_semestrales";
        List<GruposSemestrales> grupo_semestral = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                grupo_semestral.add(getGrupo(rs));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return grupo_semestral;
    }

    private GruposSemestrales getGrupo(ResultSet rs) throws SQLException {
        GruposSemestrales gs = new GruposSemestrales();
        gs.setId(rs.getString("id"));
        gs.setNombre(rs.getString("nombre"));
        gs.setProfesor_id(rs.getString("profesor_id"));
        gs.setMateria(rs.getString("materia"));
        gs.setDescripcion(rs.getString("descripcion"));
        gs.setSemestre(rs.getString("semestre"));
        return gs;
    }

    public Boolean create(GruposSemestrales grupo_semestral) {
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO grupos_semestrales (id,nombre,profesor_id,materia,descripcion,semestre) VALUES (?,?,?,?,?,?)");) {
        
            ps.setString(1, grupo_semestral.getId());
            ps.setString(2, grupo_semestral.getNombre());
            ps.setString(3, grupo_semestral.getProfesor_id());
            ps.setString(4, grupo_semestral.getMateria());
            ps.setString(5, grupo_semestral.getDescripcion());
            ps.setString(6, grupo_semestral.getSemestre());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
