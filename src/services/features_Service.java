package services;

import models.features;
import repositories.features_Repository;

import utils.ConnectionDatabase;
import java.sql.Connection;
import java.util.List;

public class features_Service {
    private features_Repository features_repository;
    private Connection connection;

    public features_Service() {
        connection = ConnectionDatabase.getConnection();
        features_repository = new features_Repository(connection);
    }

    public List<features> getfeatures() {
        return this.features_repository.list();
    }

    public boolean create(features feature) {
        return features_repository.create(feature);
    }
}
