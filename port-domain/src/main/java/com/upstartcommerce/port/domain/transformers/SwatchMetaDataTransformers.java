package com.upstartcommerce.port.domain.transformers;

import com.upstartcommerce.pim.domain.dtos.I18NStringDto;
import com.upstartcommerce.pim.domain.dtos.SwatchDto;
import com.upstartcommerce.port.domain.pim.swatches.SwatchCollection;
import com.upstartcommerce.port.domain.pim.swatches.SwatchCollectionType;
import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;
import org.springframework.stereotype.Component;

import static com.upstartcommerce.common.model.CustomModelMapper.map;

@Component
public class SwatchMetaDataTransformers {
    public SwatchMetadata convertToSwatchMetaData(SwatchDto swatchDto) {

        SwatchMetadata swatchMetadata = new SwatchMetadata();
        SwatchCollectionType swatchCollectionType = new SwatchCollectionType();
        swatchCollectionType.setId(swatchDto.getCollectionTypeId());
        swatchCollectionType.setName(swatchDto.getCollectionTypeName());
        swatchCollectionType.setTags(swatchDto.getCollectionTypeTags());
        swatchCollectionType.setDescription(swatchDto.getCollectionTypeDescription());
        SwatchCollection swatchCollection = new SwatchCollection();
        swatchCollection.setCollectionType(swatchCollectionType);
        swatchCollection.setId(swatchDto.getCollectionId());
        swatchCollection.setName(swatchDto.getCollectionName());
        swatchCollection.setDescription(swatchDto.getCollectionDesc());
        swatchCollection.setImageAltText(swatchDto.getCollectionImageAltText());
        swatchCollection.setImageUrl(swatchDto.getCollectionImageUrl());
        swatchCollection.setTags(swatchDto.getCollectionTags());
        swatchMetadata.setId(swatchDto.getSwatchId());
        swatchMetadata.setName(swatchDto.getSwatchName());
        swatchMetadata.setDescription(map(swatchDto.getDescription(), I18NStringDto.class));
        swatchMetadata.setVendor(swatchDto.getVendor());
        swatchMetadata.setImageUrl(swatchDto.getImageUrl());
        swatchMetadata.setCollectionId(swatchDto.getCollectionId());
        swatchMetadata.setCollectionTypeId(swatchDto.getCollectionTypeId());
        swatchMetadata.setHexCode(swatchDto.getHexCode());
        swatchMetadata.setImageAltText(swatchDto.getImageAltText());
        swatchMetadata.setTags(swatchDto.getSwatchTags());
        swatchMetadata.setCollection(swatchCollection);

        return swatchMetadata;
    }

}
