package services;

import models.calificaciones_proyectos;
import repositories.calificaciones_proyectos_Repository;

import utils.ConnectionDatabase;
import java.sql.Connection;
import java.util.List;

public class calificaciones_proyectos_Service {
    private calificaciones_proyectos_Repository calificaciones_proyectos_repository;
    private Connection connection;

    public calificaciones_proyectos_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.calificaciones_proyectos_repository = new calificaciones_proyectos_Repository(connection);
    }
    public List<calificaciones_proyectos> getCalificacionesProyectos() {
        return this.calificaciones_proyectos_repository.list();
    }
    public boolean createCalificacion_proyecto(calificaciones_proyectos calificacion_proyectos) {
        return this.calificaciones_proyectos_repository.create(calificacion_proyectos);
    }

}
