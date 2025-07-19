package com.upstartcommerce.port.application.services;


import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;

public interface BrandServicePort {
    void upsertBrand(BrandMetaData brandMetaData);
}
