package Impl;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;


import Modelos.Usuario;


public class UsuarioImpl {
	
	private final Gson gson;

	public UsuarioImpl() {
	    gson = new Gson();
	}


    public List<Usuario> ListadoUsuario() {
        Response response = null;
        Client cliente = ClientBuilder.newClient();
        List<Usuario> listaUsuarios = null;

        WebTarget webTarget = cliente.target("http://localhost:8080/PROYSERVICES/App/usuarios/listar");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        response = invocationBuilder.get();
        if (response.getStatus() != 200) {
            System.out.println("Error al obtener los datos. C�digo de estado: " + response.getStatus());
            return listaUsuarios; // Devolver lista vac�a o null en caso de error
        }

        String responseJson = response.readEntity(String.class);

        try {
            // Deserializar usando Gson
            Usuario[] usuariosArray = gson.fromJson(responseJson, Usuario[].class);
            listaUsuarios = Arrays.asList(usuariosArray);
        } catch (Exception e) {
            // Manejar la excepci�n de manera adecuada
            System.out.println("Error al procesar la respuesta JSON: " + e.getMessage());
            listaUsuarios = new ArrayList<>(); // Devuelve una lista vac�a en caso de error
        }

        return listaUsuarios;
    }

    
    public List<Usuario> obtenerUsuariosPaginados(int pagina, int registrosPorPagina) {
        Client cliente = ClientBuilder.newClient();
        List<Usuario> listaUsuarios = new ArrayList<>();

        // Construir la URL del servicio REST para obtener usuarios paginados
        WebTarget webTarget = cliente.target("http://localhost:8080/PROYSERVICES/App/usuarios/listar")
                                    .queryParam("pagina", pagina)
                                    .queryParam("registrosPorPagina", registrosPorPagina);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        if (response.getStatus() == 200) {
            listaUsuarios = response.readEntity(new GenericType<List<Usuario>>() {});
        } else {
            System.out.println("Error al obtener los datos. C�digo de estado: " + response.getStatus());
        }

        cliente.close(); // Cerrar el cliente despu�s de usarlo

        return listaUsuarios;
    }
    
    
    
    
    
    
    
    
    
    
    
	public void CrearUsuario(Usuario usuario) {
		Client cliente = ClientBuilder.newClient();
		WebTarget wegtarget = cliente.target("http://localhost:8080/PROYSERVICES/App/usuarios/registrar");
		Invocation.Builder invocationbuilder = wegtarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationbuilder.post(Entity.entity(usuario, MediaType.APPLICATION_JSON));

		if (response.getStatus() == 201) {

			System.out.println("usuario creado existosamente en BD");

		} else {

			System.out.println("Error al crear el Usuario " + response.getStatus());

		}
	} 
	
	public void ActualizarUsuario(Usuario usuario) {
        Client cliente = ClientBuilder.newClient();
        WebTarget wegtarget = cliente.target("http://localhost:8080/PROYSERVICES/App/usuarios/actualizar/" + usuario.getIdUsuario());
        Invocation.Builder invocationbuilder = wegtarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationbuilder.put(Entity.entity(usuario, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200) {
            System.out.println("Usuario actualizado exitosamente en la base de datos.");
        } else {
            System.out.println("Error al actualizar el Usuario. C�digo de estado: " + response.getStatus());
        } 
    }
	
	
	public void EliminarUsuario(int cod){

		Client cliente=ClientBuilder.newClient();

		String url="http://localhost:8080/PROYSERVICES/App/usuarios/eliminar/"+cod;

		WebTarget webtarget=cliente.target(url);

		Invocation.Builder invocationbuilder=webtarget.request(MediaType.APPLICATION_JSON);

		Response response=invocationbuilder.delete();

		if(response.getStatus()==201){

			System.out.println("Usuario eliminado correctamente");

		}else if(response.getStatus()==400){

			System.out.println("error : Usuario no encontrado");

		}

	} 
	
}
