package services;


import models.proyectos_grupos;
import repositories.proyectos_grupos_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;

public class proyectos_grupos_Service {
    private proyectos_grupos_Repository proyectos_grupos_repository;
    private Connection connection;

    public proyectos_grupos_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.proyectos_grupos_repository = new proyectos_grupos_Repository(connection);
    }

    public List<proyectos_grupos> getProyectos_grupos(){
        return this.proyectos_grupos_repository.list();
    }

    public boolean createProyectos_grupo(proyectos_grupos proyecto_grupo){
        return this.proyectos_grupos_repository.create(proyecto_grupo);
    }

}
