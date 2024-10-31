package Configuracion;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;



@ApplicationPath("App")
public class Configuracion extends ResourceConfig {
    public Configuracion() {
        register(JacksonFeature.class);
        register(CustomObjectMapperProvider.class);
        packages("Resource"); // Paquete donde están tus recursos
    }
}
