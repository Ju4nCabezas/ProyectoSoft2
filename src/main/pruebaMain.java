package main;

import models.*;
import services.*;

import java.util.Scanner;

public class pruebaMain {
    public static void main(String[] args) {
        usuarios_Service usuariosService = new usuarios_Service();
        grupos_semestrales_Service gruposService = new grupos_semestrales_Service();
        proyectos_Service proyectosService = new proyectos_Service();
        proyectos_grupos_Service proyectosGruposService = new proyectos_grupos_Service();
        planificaciones_proyectos_Service planificacionesService = new planificaciones_proyectos_Service();
        epicas_Service epicasService = new epicas_Service();
        features_Service featuresService = new features_Service();
        backlog_items_Service backlogItemsService = new backlog_items_Service();

        Scanner scanner = new Scanner(System.in);

        // Crear usuario
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

            System.out.print("Password: ");
            nuevoUsuario.setPassword(scanner.nextLine());

            System.out.print("Rol (estudiante/profesor/administrador): ");
            nuevoUsuario.setRol(scanner.nextLine());

            boolean creado = usuariosService.createUsuario(nuevoUsuario);
            if (creado) {
                System.out.println("Usuario creado exitosamente.");
            } else {
                System.out.println("Error al crear el usuario.");
            }
        }

        // Mostrar usuarios
        System.out.println("\n=== Lista de Usuarios ===");
        usuariosService.getUsuarios().forEach(u -> {
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre: " + u.getNombre_completo());
            System.out.println("Correo: " + u.getCorreo());
            System.out.println("Rol: " + u.getRol());
            System.out.println("---------------------------");
        });

        // Crear grupo semestral
        System.out.println("\n=== Sistema de Gestión de Grupos Semestrales ===");
        System.out.print("¿Deseas crear un nuevo grupo semestral? (s/n): ");
        respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            grupos_semestrales nuevoGrupo = new grupos_semestrales();

            System.out.print("ID: ");
            nuevoGrupo.setId(scanner.nextLine());

            System.out.print("Nombre: ");
            nuevoGrupo.setNombre(scanner.nextLine());

            System.out.print("ID del profesor: ");
            nuevoGrupo.setProfesor_id(scanner.nextLine());

            System.out.print("Materia: ");
            nuevoGrupo.setMateria(scanner.nextLine());

            System.out.print("Descripción: ");
            nuevoGrupo.setDescripcion(scanner.nextLine());

            System.out.print("Semestre: ");
            nuevoGrupo.setSemestre(scanner.nextLine());

            boolean creadoGrupo = gruposService.createGrupo_semestral(nuevoGrupo);
            if (creadoGrupo) {
                System.out.println("Grupo semestral creado exitosamente.");
            } else {
                System.out.println("Error al crear el grupo semestral.");
            }
        }
        // Mostrar grupos semestrales
        System.out.println("\n=== Lista de Grupos Semestrales ===");
        gruposService.getGrupos_semestrales().forEach(grupo -> {
            System.out.println("ID: " + grupo.getId());
            System.out.println("Nombre: " + grupo.getNombre());
            System.out.println("Profesor ID: " + grupo.getProfesor_id());
            System.out.println("Materia: " + grupo.getMateria());
            System.out.println("Descripción: " + grupo.getDescripcion());
            System.out.println("Semestre: " + grupo.getSemestre());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de proyectos ===");
        proyectosService.getProyectos().forEach(proyecto -> {
            System.out.println("ID: " + proyecto.getId());
            System.out.println("Nombre: " + proyecto.getNombre());
            System.out.println("Descripcion: " + proyecto.getDescripcion());
            System.out.println("Creado por: " + proyecto.getCreado_por());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de proyectos grupales ===");
        proyectosGruposService.getProyectos_grupos().forEach(proyecto -> {
            System.out.println("proyectoID: " + proyecto.getProyecto_id());
            System.out.println("grupoID: " + proyecto.getGrupo_id());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de planificaciones ===");
        planificacionesService.getplanificaciones_proyectos().forEach(planificacion -> {
            System.out.println("ID: " + planificacion.getId());
            System.out.println("proyectoID: " + planificacion.getProyecto_id());
            System.out.println("objetivos: " + planificacion.getObjetivos());
            System.out.println("metas: " + planificacion.getMetas());
            System.out.println("metodologia: " + planificacion.getMetodologia());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de epicas ===");
        epicasService.getEpicas().forEach(epica -> {
            System.out.println("ID: " + epica.getId());
            System.out.println("proyectoID: " + epica.getProyecto_id());
            System.out.println("nombre: " + epica.getNombre());
            System.out.println("descripcion: " + epica.getDescripcion());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de features ===");
        featuresService.getfeatures().forEach(feature -> {
            System.out.println("ID: " + feature.getId());
            System.out.println("epica_id: " + feature.getEpica_id());
            System.out.println("nombre: " + feature.getNombre());
            System.out.println("descripcion: " + feature.getDescripcion());
            System.out.println("---------------------------");
        });

        System.out.println("\n=== Lista de backlogs items ===");
        backlogItemsService.get_backlog_items().forEach(backlogItem -> {
            System.out.println("ID: " + backlogItem.getId());
            System.out.println("feature id: " + backlogItem.getFeature_id());
            System.out.println("nombre: " + backlogItem.getNombre());
            System.out.println("descripcion: " + backlogItem.getDescripcion());
            System.out.println("Puntos de esfuerzo: " + backlogItem.getPuntos_esfuerzo());
            System.out.println("---------------------------");
        });
    }
}
