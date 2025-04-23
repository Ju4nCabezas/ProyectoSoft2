package controllers;

import models.usuarios;
import services.usuarios_Service;

import java.util.List;

public class UsuariosBean {

    private usuarios_Service usuarios_service;
    private List<usuarios> listaUsuarios;
    private usuarios usuario;

    public UsuariosBean() {
        usuarios_service = new usuarios_Service();
        this.listaUsuarios = this.usuarios_service.getUsuarios();
    }

    public void listarUsuarios(){
        this.listaUsuarios = this.usuarios_service.getUsuarios();
    }

    public usuarios_Service getUsuarios_service() {
        return usuarios_service;
    }

    public List<usuarios> getListaUsuarios() {
        return listaUsuarios;
    }
    public usuarios getUsuario() {
        return usuario;
    }
    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public void crearUsuario(){
        this.usuarios_service.createUsuario(this.usuario);
        listarUsuarios();
        this.usuario = new usuarios();
        System.out.println("Usuario creado");
    }
}
