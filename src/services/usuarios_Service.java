package services;

import models.usuarios;
import repositories.usuarios_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;


public class usuarios_Service {
    private usuarios_Repository usuarios_repository;
    private Connection connection;

    public usuarios_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.usuarios_repository = new usuarios_Repository(connection);
    }

    public List<usuarios> getUsuarios(){
        return this.usuarios_repository.list();
    }

    public boolean createUsuario(usuarios usuario){
        return this.usuarios_repository.create(usuario);
    }
}
