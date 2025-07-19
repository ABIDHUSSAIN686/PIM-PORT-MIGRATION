package com.upstartcommerce.port.domain;


import com.upstartcommerce.port.domain.model.entity.BrandEntity;
import com.upstartcommerce.port.domain.model.entity.SwatchEntity;
import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;
import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Util {

    public static BrandEntity prepareBrandEntityFromMetadata(BrandMetaData brandMetaData, Optional<BrandEntity> oldBrandIfAny) {
        BrandEntity newBrandEntity = new BrandEntity();
        newBrandEntity.setBrandId(brandMetaData.getBrandId());
        newBrandEntity.setTenant(brandMetaData.getTenantId());
        newBrandEntity.setSiteIds(brandMetaData.getSiteIds());
        newBrandEntity.setName(brandMetaData.getName());
        newBrandEntity.setLinkedItems(brandMetaData.getLinkedItems());
        newBrandEntity.setBrandData(brandMetaData);
        newBrandEntity.setPortCreationTimestamp(LocalDateTime.now());
        if (oldBrandIfAny.isPresent()) {
            newBrandEntity.setId(oldBrandIfAny.get().getId());
            newBrandEntity.setPortCreationTimestamp(oldBrandIfAny.get().getPortCreationTimestamp());
        }
        return newBrandEntity;
    }

    public static SwatchEntity prepareSwatchEntityFromMetadata(String xUpstartTenant, List<String> xUpstartSite, SwatchMetadata swatchMetadata,
                                                               Optional<SwatchEntity> oldSwatchIfAny) {
        SwatchEntity newSwatchEntity = new SwatchEntity();
        newSwatchEntity.setTenant(xUpstartTenant);
        newSwatchEntity.setSwatchId(swatchMetadata.getId());
        newSwatchEntity.setSiteIds(xUpstartSite);
        newSwatchEntity.setSwatchData(swatchMetadata);
        newSwatchEntity.setLinkedItems(swatchMetadata.getLinkedItems());
        newSwatchEntity.setCollectionId(swatchMetadata.getCollectionId());
        newSwatchEntity.setCollectionTypeId(swatchMetadata.getCollectionTypeId());
        newSwatchEntity.setPortCreationTimestamp(LocalDateTime.now());
        oldSwatchIfAny.ifPresent(item -> {
            newSwatchEntity.setId(item.getId());
            newSwatchEntity.setPortCreationTimestamp(item.getPortCreationTimestamp());
        });
        return newSwatchEntity;
    }
}
