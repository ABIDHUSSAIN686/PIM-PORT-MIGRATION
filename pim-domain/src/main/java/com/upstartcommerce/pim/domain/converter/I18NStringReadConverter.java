package com.upstartcommerce.pim.domain.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstartcommerce.pim.domain.I18NString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ReadingConverter
public class I18NStringReadConverter implements Converter<String, I18NString> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public I18NString convert(String source) {
        try {
            if (source.trim().isEmpty()) {
                return new I18NString();
            }
            return mapper.readValue(source, I18NString.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("JSON processing exception ############: " + source);
            return new I18NString();
        }
    }
}
