package services;

import models.proyectos;
import repositories.proyectos_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;


public class proyectos_Service {
    private proyectos_Repository proyectos_repository;
    private Connection connection;

    public proyectos_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.proyectos_repository = new proyectos_Repository(connection);
    }

    public List<proyectos> getProyectos() {
        return this.proyectos_repository.list();
    }

    public boolean createProyecto(proyectos proyecto) {
        return this.proyectos_repository.create(proyecto);
    }

}
