package controllers;

import models.grupos_semestrales;
import services.grupos_semestrales_Service;

import java.util.List;

public class grupos_semestralesBean {

    private grupos_semestrales_Service grupos_semestrales_service;
    private List<grupos_semestrales> lista_grupos_semestrales;
    private grupos_semestrales grupo_semestral;

    public grupos_semestralesBean() {
        grupos_semestrales_service = new grupos_semestrales_Service();
        this.lista_grupos_semestrales = this.grupos_semestrales_service.getGrupos_semestrales();
    }

    public void listarGrupos_semestrales(){this.lista_grupos_semestrales = this.grupos_semestrales_service.getGrupos_semestrales();}

    public grupos_semestrales_Service getGrupos_semestrales_service() {return grupos_semestrales_service;}

    public List<grupos_semestrales> getLista_grupos_semestrales() {
        return lista_grupos_semestrales;
    }
    public grupos_semestrales getGrupos_semestral() {
        return grupo_semestral;
    }

    public void setGrupo_semestral(grupos_semestrales grupo_semestral) {
        this.grupo_semestral = grupo_semestral;
    }

    public void crearGrupo_semestral() {
        this.grupos_semestrales_service.createGrupo_semestral(this.grupo_semestral);
        listarGrupos_semestrales();
        this.grupo_semestral = new grupos_semestrales();
        System.out.println("Grupo semestral creado");
    }
}
