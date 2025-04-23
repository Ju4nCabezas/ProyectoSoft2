package controllers;

import models.epicas;
import services.epicas_Service;

import java.util.List;


public class epicasBean {

    private epicas_Service epicas_service;
    private List<epicas> listaEpicas;
    private epicas epica;

    public epicasBean() {
        epicas_service = new epicas_Service();
        this.listaEpicas = this.epicas_service.getEpicas();
    }

    public void listarEpicas() {this.listaEpicas = epicas_service.getEpicas();}

    public epicas_Service getEpicasService() {return epicas_service;}

    public List<epicas> getListaEpicas() {return listaEpicas;}

    public epicas getEpica() {return epica;}

    public void setEpica(epicas epica) {this.epica = epica;}

    public void crearEpica() {
        this.epicas_service.createEpicas(this.epica);
        listarEpicas();
        this.epica = new epicas();
        System.out.println("Epica creada");
    }
}
