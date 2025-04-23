package main;

import controllers.UsuariosBean;
import models.usuarios;
import controllers.Grupos_semestralesBean;


import java.util.Scanner;

public class pruebaMain {
    public static void main(String[] args) {
        UsuariosBean usuariosBean = new UsuariosBean();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Gestión de Usuarios ===");
        System.out.print("¿Deseas crear un nuevo usuario? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            usuarios nuevoUsuario = new usuarios();

            System.out.print("ID: ");
            nuevoUsuario.setId(scanner.nextLine());

            System.out.print("Nombre completo: ");
            nuevoUsuario.setNombre_completo(scanner.nextLine());

            System.out.print("Correo: ");
            nuevoUsuario.setCorreo(scanner.nextLine());

            System.out.print("Username: ");
            nuevoUsuario.setUsername(scanner.nextLine());

            System.out.print("Password: ");
            nuevoUsuario.setPassword(scanner.nextLine());

            System.out.print("Rol (estudiante/profesor/administrador): ");
            nuevoUsuario.setRol(scanner.nextLine());

            usuariosBean.setUsuario(nuevoUsuario);
            usuariosBean.crearUsuario();
        }

        System.out.println("\n=== Lista de Usuarios ===");
        usuariosBean.getListaUsuarios().forEach(u -> {
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre: " + u.getNombre_completo());
            System.out.println("Correo: " + u.getCorreo());
            System.out.println("Username: " + u.getUsername());
            System.out.println("Rol: " + u.getRol());
            System.out.println("---------------------------");
        });

        Grupos_semestralesBean grupos_semestralesBean = new Grupos_semestralesBean();
        System.out.println("\n=== Lista de Grupos Semestrales ===");
        grupos_semestralesBean.getLista_grupos_semestrales().forEach(grupo -> {
            System.out.println("ID: " + grupo.getId());
            System.out.println("Nombre: " + grupo.getNombre());
            System.out.println("ID del profesor: " + grupo.getProfesor_id());
            System.out.println("Materia: " + grupo.getMateria());
            System.out.println("Descripcion: " + grupo.getDescripcion());
            System.out.println("Semestre: " + grupo.getSemestre());
            System.out.println("---------------------------");
        });

    }

}
