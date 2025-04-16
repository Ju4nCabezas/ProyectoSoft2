package services;

import models.grupos_semestrales;
import repositories.grupos_semestrales_Repository;
import utils.ConnectionDatabase;

import java.sql.Connection;
import java.util.List;


public class grupos_semestrales_Service {
    private Connection conection;
    private grupos_semestrales_Repository grupos_semestrales_repository;

    public grupos_semestrales_Service() {
        this.conection = ConnectionDatabase.getConnection();
        this.grupos_semestrales_repository = new grupos_semestrales_Repository(conection);
    }

    public List<grupos_semestrales> getGrupos_semestrales() {
        return this.grupos_semestrales_repository.list();
    }

    public boolean createGrupo_semestral(grupos_semestrales grupos_semestral){
        return this.grupos_semestrales_repository.create(grupos_semestral);
    }

}
