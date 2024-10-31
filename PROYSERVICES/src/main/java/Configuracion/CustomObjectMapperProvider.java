package Configuracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import adapter.LocalDateAdapter;
import adapter.LocalDateTimeAdapter;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Provider
public class CustomObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;

    public CustomObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateAdapter.Serializer());
        module.addDeserializer(LocalDate.class, new LocalDateAdapter.Deserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeAdapter.Serializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeAdapter.Deserializer());
        mapper.registerModule(module);
        return mapper;
    }
}
