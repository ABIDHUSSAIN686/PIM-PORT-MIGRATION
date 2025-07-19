package com.upstartcommerce.port.domain.deserlizers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class StringToListDeserializer<T> extends JsonDeserializer<List<T>> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> type;

    public StringToListDeserializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String text = p.getValueAsString();
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        if (text.startsWith("[")) {
            return objectMapper.readValue(text, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
        }

        return Collections.emptyList();
    }

}
