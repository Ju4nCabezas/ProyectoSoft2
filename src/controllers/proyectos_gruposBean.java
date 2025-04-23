package controllers;

import models.proyectos;
import models.proyectos_grupos;
import services.proyectos_grupos_Service;

import java.util.List;

public class proyectos_gruposBean {
    private proyectos_grupos_Service proyectos_grupos_service;
    private List<proyectos_grupos> listaProyectos_grupos;
    private proyectos_grupos proyectos_grupo;

    public proyectos_gruposBean(){
        proyectos_grupos_service = new proyectos_grupos_Service();
        this.listaProyectos_grupos = this.proyectos_grupos_service.getProyectos_grupos();

    }

    public void listarProyectos_grupos() {this.listaProyectos_grupos = this.proyectos_grupos_service.getProyectos_grupos();}

    public proyectos_grupos_Service getProyectos_grupos_service() {return proyectos_grupos_service;}

    public List<proyectos_grupos> getListaProyectos_grupos(){
        return listaProyectos_grupos;
    }

    public proyectos_grupos getProyectos_grupos() {return proyectos_grupo;}

    public void setProyecto_grupo(proyectos_grupos proyecto_grupo) {
        this.proyectos_grupo = proyecto_grupo;
    }

    public void createProyectos_grupo() {
        this.proyectos_grupos_service.createProyectos_grupo(this.proyectos_grupo);
        listarProyectos_grupos();
        this.proyectos_grupo = new proyectos_grupos();
        System.out.println("Proyectos grupos creado");
    }

}
