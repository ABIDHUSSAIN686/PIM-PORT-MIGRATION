package com.upstartcommerce.port.domain.deserlizers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class CustomModelMapper {


    private static ModelMapper MODEL_MAPPER = null;

    private CustomModelMapper() {
    }


    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        return source.stream().map(element -> getModelMapper().map(element, targetClass)).toList();

    }

    public static <S, T> List<T> mapList(Set<S> source, Class<T> targetClass) {
        return source.stream().map(element -> getModelMapper().map(element, targetClass)).toList();
    }

    public static <S, T> Optional<T> mapOptional(Optional<S> element, Class<T> targetClass) {
        if (element.isEmpty()) return Optional.empty();
        else
            return Optional.of(getModelMapper().map(element.get(), targetClass));
    }

    public static ModelMapper getModelMapper() {
        if (MODEL_MAPPER == null) {
            MODEL_MAPPER = new ModelMapper();
            MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                    .setAmbiguityIgnored(true);
        }

        return MODEL_MAPPER;
    }

    public static <S, T> T map(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        return getModelMapper().map(source, targetClass);
    }
}

