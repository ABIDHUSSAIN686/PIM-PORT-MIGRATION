package com.upstartcommerce.pim.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class I18NString {
    private Map<String, String> localizations = new HashMap<>();

    public Map<String, String> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, String> localizations) {
        this.localizations = localizations;
    }
}
