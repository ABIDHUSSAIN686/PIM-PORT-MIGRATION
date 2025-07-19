package com.upstartcommerce.port.domain.transformers;

import com.upstartcommerce.pim.domain.dtos.BrandDto;
import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;
import org.springframework.stereotype.Component;

@Component

public class BrandMetaDataTransformers {

    public BrandMetaData convertToBrandMetaData(BrandDto brandDto) {
        BrandMetaData brandMetaData = new BrandMetaData();
        brandMetaData.setFields(brandDto.getRequestSchema());
        brandMetaData.setBrandId(brandDto.getBrandId());
        brandMetaData.setTenantId(brandDto.getTenantId());
        brandMetaData.setSiteIds(brandDto.getSiteIds());
        brandMetaData.setName(brandDto.getName());
        brandMetaData.setLinkedItems(brandDto.getLinkedItems());
        brandMetaData.setDescription(brandDto.getDescription());

        return brandMetaData;
    }
}
