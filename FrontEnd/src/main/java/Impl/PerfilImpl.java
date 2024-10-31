package Impl;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Modelos.Perfil;

public class PerfilImpl {

	
public List<Perfil> ListadoPerfil(){
		
		Response response=null;
		WebTarget webtarget;
		Client cliente=ClientBuilder.newClient();
		List<Perfil> lis=null;
		String responsejson=null;
		ObjectMapper objmap=new ObjectMapper();
		webtarget=cliente.target("http://localhost:8080/PROYSERVICES/App/Perfil/listar");

		Invocation.Builder invocationbuilder=webtarget.request(MediaType.APPLICATION_JSON);

		response=invocationbuilder.get();

		if(response.getStatus()!=200){

			System.out.println("fuera de rango");

 

		}//fin de la condicion...

		responsejson=response.readEntity(String.class);

		try {

			lis=objmap.readValue(responsejson,new TypeReference<List<Perfil>>(){});

		} catch (JsonParseException e) {
			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
 
		return lis;
	}

	public void CrearPerfil(Perfil perfil) {
	
		Client cliente = ClientBuilder.newClient();

		WebTarget wegtarget = cliente.target("http://localhost:8080/PROYSERVICES/App/Perfil/registrar");

		Invocation.Builder invocationbuilder = wegtarget.request(MediaType.APPLICATION_JSON);

		Response response = invocationbuilder.post(Entity.entity(perfil, MediaType.APPLICATION_JSON));

		if (response.getStatus() == 201) {

			System.out.println("Perfil creado existosamente en BD");

		} else {

			System.out.println("Error al crear el Perfil " + response.getStatus());

		} // fin del else...



	}  
	
	public void ActualizarPerfil(Perfil perfil) {
        Client cliente = ClientBuilder.newClient();
        WebTarget wegtarget = cliente.target("http://localhost:8080/PROYSERVICES/App/Perfil/actualizar/" + perfil.getIdPerfil());
        Invocation.Builder invocationbuilder = wegtarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationbuilder.put(Entity.entity(perfil, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200) {
            System.out.println("Perfil actualizado exitosamente en la base de datos.");
        } else {
            System.out.println("Error al actualizar el perfil. C�digo de estado: " + response.getStatus());
        } 
    }

	

	public void EliminarPerfil(int cod){

		Client cliente=ClientBuilder.newClient();

		String url="http://localhost:8080/PROYSERVICES/App/Perfil/eliminar/"+cod;

		WebTarget webtarget=cliente.target(url);

		Invocation.Builder invocationbuilder=webtarget.request(MediaType.APPLICATION_JSON);

		Response response=invocationbuilder.delete();

		if(response.getStatus()==201){

			System.out.println("Perfil eliminado correctamente");

		}else if(response.getStatus()==400){

			System.out.println("error : Perfil no encontrado");

		}

	} //fin del metodo eliminar autor...





}

