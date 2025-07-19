package com.upstartcommerce.port.application.services.impl;


import com.upstartcommerce.port.application.services.BrandServicePort;
import com.upstartcommerce.port.domain.Util;
import com.upstartcommerce.port.domain.model.entity.BrandEntity;
import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;
import com.upstartcommerce.port.application.repo.jpa.BrandRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServicePortImpl implements BrandServicePort {
    BrandRepo brandRepo;

    @Autowired
    public BrandServicePortImpl(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    @Override
    public void upsertBrand(BrandMetaData brandMetaData) {
        Optional<BrandEntity> oldBrandIfAny = brandRepo.findByBrandId(brandMetaData.getBrandId());
        BrandEntity newBrandEntity = Util.prepareBrandEntityFromMetadata(brandMetaData, oldBrandIfAny);
        brandRepo.save(newBrandEntity);
    }

}