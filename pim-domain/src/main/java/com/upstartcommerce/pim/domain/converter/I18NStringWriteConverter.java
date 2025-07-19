package com.upstartcommerce.pim.domain.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstartcommerce.pim.domain.I18NString;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@WritingConverter
public class I18NStringWriteConverter implements Converter<I18NString, String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    @SneakyThrows
    public String convert(I18NString source) {
        try {
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            log.error("JSON processing exception ############: " + source);
            e.printStackTrace();
            return mapper.writeValueAsString(new I18NString());
        }
    }
}
