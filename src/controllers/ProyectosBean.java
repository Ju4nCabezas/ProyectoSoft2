package controllers;

import models.proyectos;
import services.proyectos_Service;

import java.util.List;


public class ProyectosBean {
    private proyectos_Service proyectos_service;
    private List<proyectos> listProyectos;
    private proyectos proyecto;

    public ProyectosBean() {
        proyectos_service = new proyectos_Service();
        this.listProyectos = proyectos_service.getProyectos();
    }

    public void listarProyectos() {
        this.listProyectos = proyectos_service.getProyectos();
    }

    public proyectos_Service getProyectos_service() {
        return proyectos_service;
    }

    public List<proyectos> getListProyectos() {
        return listProyectos;
    }

    public proyectos getProyecto() {
        return proyecto;
    }

    public void setProyecto(proyectos proyecto) {
        this.proyecto = proyecto;
    }

    public void crearProyecto() {
        this.proyectos_service.createProyecto(this.proyecto);
        listarProyectos();
        this.proyecto = new proyectos();
        System.out.println("Proyecto creado");
    }
}
