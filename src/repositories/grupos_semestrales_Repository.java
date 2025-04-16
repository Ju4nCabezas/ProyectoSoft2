package repositories;

import models.grupos_semestrales;
import utils.ConnectionDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class grupos_semestrales_Repository {
    private Connection connection;

    public grupos_semestrales_Repository(Connection connection) {
        this.connection = connection;
    }

    public List<grupos_semestrales> list() {
        List<grupos_semestrales> grupo_semestral = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM grupos_semestrales");
            while (rs.next()) {
                grupos_semestrales gs = new grupos_semestrales();
                gs.setId(rs.getString("id"));
                gs.setNombre(rs.getString("nombre"));
                gs.setProfesor_id(rs.getString("profesor_id"));
                gs.setMateria(rs.getString("materia"));
                gs.setDescripcion(rs.getString("descripcion"));
                gs.setSemestre(rs.getString("semestre"));
                grupo_semestral.add(gs);
            }
            stmt.close();
            rs.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return grupo_semestral;
    }

    public Boolean create(grupos_semestrales grupo_semestral) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(
                    "INSERT INTO grupos_semestrales (id,nombre,profesor_id,materia,descripcion,semestre) VALUES (?,?,?,?,?,?)");
            ps.setString(1, grupo_semestral.getId());
            ps.setString(2, grupo_semestral.getNombre());
            ps.setString(3, grupo_semestral.getProfesor_id());
            ps.setString(4, grupo_semestral.getMateria());
            ps.setString(5, grupo_semestral.getDescripcion());
            ps.setString(6, grupo_semestral.getSemestre());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
