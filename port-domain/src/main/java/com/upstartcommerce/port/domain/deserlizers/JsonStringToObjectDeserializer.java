package com.upstartcommerce.port.domain.deserlizers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonStringToObjectDeserializer<T> extends JsonDeserializer<T> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> targetType;

    public JsonStringToObjectDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String json = p.getValueAsString();
        if (json == null || json.isEmpty()) {
            return null;
        }

        return objectMapper.readValue(json, targetType);
    }
}
