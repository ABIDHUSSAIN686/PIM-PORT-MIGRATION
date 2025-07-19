package com.upstartcommerce.port.domain.pim.swatches;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.upstartcommerce.pim.domain.dtos.I18NStringDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwatchCollectionType {

    private String id;
    private String name;
    private I18NStringDto description;
    private List<String> tags;

}
