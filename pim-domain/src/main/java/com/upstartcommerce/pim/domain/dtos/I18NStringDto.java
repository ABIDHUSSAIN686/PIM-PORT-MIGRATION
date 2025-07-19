package com.upstartcommerce.pim.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class I18NStringDto {

    private Map<String, String> localizations = new HashMap<>();

    public Map<String, String> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, String> localizations) {
        this.localizations = localizations;
    }
}
