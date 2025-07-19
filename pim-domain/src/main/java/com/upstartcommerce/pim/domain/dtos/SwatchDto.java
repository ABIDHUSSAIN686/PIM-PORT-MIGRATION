package com.upstartcommerce.pim.domain.dtos;

import com.upstartcommerce.common.enums.SwatchStateEnum;
import com.upstartcommerce.common.enums.SwatchStatusEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class SwatchDto extends BaseDto {

    private String tenantId;
    private List<String> siteIds;
    private String swatchId;
    private String swatchName;
    private String imageUrl;
    private String imageAltText;
    private String hexCode;
    private I18NStringDto description;
    private String vendor;
    private List<String> swatchTags;
    private SwatchStateEnum state;
    private SwatchStatusEnum status;
    private Integer version;
    private List<String> linkedItems;
    private String collectionId;
    private String collectionName;
    private I18NStringDto collectionDesc;
    private String collectionImageUrl;
    private String collectionImageAltText;
    private List<String> collectionTags;
    private String collectionHexCode;
    private String collectionTypeId;
    private String collectionTypeName;
    private I18NStringDto collectionTypeDescription;
    private List<String> collectionTypeTags;
    private Boolean hasDraft;
    private Boolean hasPublished;
    private LocalDateTime dateModified;
    private LocalDateTime dateCreated;
}
