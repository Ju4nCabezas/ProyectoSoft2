package services;

import models.backlog_items;
import repositories.backlog_items_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;

public class backlog_items_Service {
    private backlog_items_Repository backlog_items_repository;
    private Connection connection;

    public backlog_items_Service() {
        this.connection = ConnectionDatabase.getConnection();
        this.backlog_items_repository = new backlog_items_Repository(connection);
    }

    public List<backlog_items> get_backlog_items() {
        return this.backlog_items_repository.list();
    }

    public boolean create_backlog_item(backlog_items backlog_item) {
        return this.backlog_items_repository.create(backlog_item);
    }

}
