package org.example.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Usuario;
import org.example.service.UsuarioServices;

import java.sql.SQLException;

@Path("usuario")
public class UsuarioResources {

    UsuarioServices usuarioService = new  UsuarioServices();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirCadastro(Usuario usuario) {
        try {
            UsuarioServices.cadastrarUsuario(usuario);
            return Response.status(Response.Status.CREATED).entity("Usuário cadastrado com sucesso!").build();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("Falha ao cadastrar o usuário...." + e.getLocalizedMessage()).build();
        }
    }
}
