package services;

import models.planificaciones_proyectos;
import repositories.planificaciones_proyectos_Repository;

import utils.ConnectionDatabase;
import java.sql.Connection;
import java.util.List;

public class planificaciones_proyectos_Service {
    private planificaciones_proyectos_Repository planificaciones_repository;
    private Connection connection;

    public planificaciones_proyectos_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.planificaciones_repository = new planificaciones_proyectos_Repository(connection);
    }

    public List<planificaciones_proyectos> getplanificaciones_proyectos() {
        return this.planificaciones_repository.list();
    }

    public boolean createplanificacion_proyecto(planificaciones_proyectos planificacion_proyecto) {
        return this.planificaciones_repository.create(planificacion_proyecto);
    }
}
