// src/rest/UsuarioRestService.java
package utils;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.usuarios;
import services.usuarios_Service;

@Path("/usuarios")  //Sirve para crear un nuevo usuario desde la web.
public class UsuarioRestService {

    private usuarios_Service service = new usuarios_Service();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarUsuario(usuarios usuario) {
        boolean resultado = service.insertarUsuario(usuario);
        if (resultado) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error al insertar usuario").build();
        }
    }
}
