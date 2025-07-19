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
public class SwatchMetadata {

    private SwatchCollection collection;
    private String hexCode;
    private String collectionId;
    private String collectionTypeId;
    private String id;
    private String name;
    private String imageAltText;
    private String imageUrl;
    private I18NStringDto description;
    private String vendor;
    private List<String> tags;
    private List<String> linkedItems;

}
