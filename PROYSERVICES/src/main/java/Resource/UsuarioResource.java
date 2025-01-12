package Resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import javax.ws.rs.core.MediaType;

import Dao.UsuarioImp;

import model.Usuario;


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioImp cruduser = new UsuarioImp();

    @GET
    @Path("/listar")
    public Response listarUsuarios() {
        List<Usuario> usuarios = cruduser.listUsuarios();

        if (usuarios.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron usuarios").build();
        } else {
            return Response.ok(usuarios).build();
        }
    }

    
    @POST
    @Path("/registrar")
    public Response registrarUsuario(Usuario usuario) {
        if (cruduser.existCorreo(usuario.getCorreo())) {
            return Response.status(Status.CONFLICT).entity("El correo ya existe.").build();
        }
        cruduser.saveUser(usuario);
        return Response.status(Status.CREATED).entity("Usuario registrado exitosamente.").build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public Response actualizarUsuario(@PathParam("id") int id, Usuario usuario) {
        usuario.setIdUsuario(id);
        cruduser.updateUser(usuario);
        return Response.ok("Usuario actualizado exitosamente.").build();
    }

    @DELETE
    @Path("/eliminar/{id}")
    public Response eliminarUsuario(@PathParam("id") int id) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        cruduser.deleteUser(usuario);
        return Response.ok("Usuario eliminado exitosamente.").build();
    }
    
    

}