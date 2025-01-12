package Resource;


import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import Dao.ProyectoImp;
import Dto.ProyectoDTO;
import Dto.ProyectoDTOSTRING;

import model.Proyecto;




@Path("/proyectos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProyectoResource {

    private ProyectoImp crud = new ProyectoImp();


        @GET
        @Path("/listar")
        public Response listarProyectos() {
            List<Proyecto> proyectos = crud.ListProyectos();

            if (proyectos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontró ningún proyecto").build();
            } else {
                List<ProyectoDTO> proyectoDTOs = proyectos.stream()
                        .map(proyecto -> new ProyectoDTO.Builder()
                                .nombre(proyecto.getNombre())
                                .descripcion(proyecto.getDescripcion())
                                .fechaInicio(proyecto.getFechaInicio())
                                .fechaFin(proyecto.getFechaFin())
                                .estado(proyecto.getEstado())
                                .fechaRegistro(proyecto.getFechaRegistro())
                                .build())
                        .collect(Collectors.toList());

                return Response.ok(proyectoDTOs).build();
            }
        }
    
    
    @POST
    @Path("/registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarProyecto(ProyectoDTOSTRING proyectoDto){
        Proyecto proyecto = convertirDtoAEntidad(proyectoDto); // Convertir DTO a entidad
        crud.saveProyecto(proyecto);
        return Response.status(Response.Status.CREATED)
                .entity("EL Proyecto " + proyecto.getNombre()+ " Se ha registrado Correctamente").build();
    }

    // M�todo para convertir DTO ProyectoDTOSTRING a entidad Proyecto
    private Proyecto convertirDtoAEntidad(ProyectoDTOSTRING proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setFechaInicio(LocalDate.parse(proyectoDTO.getFechaInicio())); // Convertir String a fecha
        proyecto.setFechaFin(LocalDate.parse(proyectoDTO.getFechaFin()));       // Convertir String a fecha
        proyecto.setEstado(proyectoDTO.getEstado());
        proyecto.setUsuarioRegistro(proyectoDTO.getUsuarioRegistro()); 
        return proyecto;
    }
    @DELETE
    @Path("/eliminar/{id}")
    public Response eliminarPerfil(@PathParam("id") int id) {
        Proyecto p =new Proyecto();
        p.setIdProyecto(id);
        crud.deleteProyecto(p);
        return Response.ok("Perfil eliminado exitosamente.").build();
    }
    



}
