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

import Dao.TareaImp;

import model.Tarea;


@Path("/Tareas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TareaResource {

    private TareaImp crudTarea = new TareaImp();

    @GET
    @Path("/listar")
    public Response listarTareas() {
        List<Tarea> Tareas = crudTarea.list();

        if (Tareas.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron Tareas").build();
        } else {
           
            return Response.ok(Tareas).build();
        }
    }
    
    @POST
    @Path("/registrar")
    public Response registrarTarea(Tarea Tarea) {        
        crudTarea.save(Tarea);
        return Response.status(Status.CREATED).entity("Tarea registrado exitosamente.").build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public Response actualizarTarea(@PathParam("id") int id, Tarea Tarea) {
        Tarea.setIdTarea(id);
        crudTarea.update(Tarea);
        return Response.ok("Tarea actualizado exitosamente.").build();
    }

    @DELETE
    @Path("/eliminar/{id}")
    public Response eliminarTarea(@PathParam("id") int id) {
        Tarea Tarea = new Tarea();
        Tarea.setIdTarea(id);
        crudTarea.delete(Tarea);
        return Response.ok("Tarea eliminado exitosamente.").build();
    }    
}