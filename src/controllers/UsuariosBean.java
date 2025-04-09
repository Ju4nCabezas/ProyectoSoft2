package controllers;

import models.usuarios;
import services.usuarios_Service;

import java.util.List;

public class UsuariosBean {

    private usuarios_Service usuariosService;
    private List<usuarios> listaUsuarios;
    private usuarios usuario;

    public UsuariosBean() {
        usuariosService = new usuarios_Service();
        this.listaUsuarios = this.usuariosService.getUsuarios();
    }

    public void listarUsuarios(){
        this.listaUsuarios = this.usuariosService.getUsuarios();
    }

    public usuarios_Service getUsuariosService() {
        return usuariosService;
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
        this.usuariosService.createUsuario(this.usuario);
        listarUsuarios();
        this.usuario = new usuarios();
        System.out.println("Usuario creado");
    }
}
