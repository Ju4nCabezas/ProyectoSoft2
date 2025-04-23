package services;

import models.epicas;
import repositories.epicas_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;


public class epicas_Service {
    private epicas_Repository epicas_repository;
    private Connection connection;

    public epicas_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.epicas_repository = new epicas_Repository(connection);
    }

    public List<epicas> getEpicas() {
        return this.epicas_repository.list();
    }

    public boolean createEpicas(epicas epica) {
        return this.epicas_repository.create(epica);
    }
}
