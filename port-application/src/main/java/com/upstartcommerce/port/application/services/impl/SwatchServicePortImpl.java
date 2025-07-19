package com.upstartcommerce.port.application.services.impl;


import com.upstartcommerce.port.application.repo.jpa.SwatchRepo;
import com.upstartcommerce.port.application.services.SwatchServicePort;
import com.upstartcommerce.port.domain.Util;
import com.upstartcommerce.port.domain.model.entity.SwatchEntity;
import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SwatchServicePortImpl implements SwatchServicePort {
    private final SwatchRepo swatchRepo;

    public SwatchServicePortImpl(SwatchRepo swatchRepo) {
        this.swatchRepo = swatchRepo;
    }

    @Override
    public void upsertSwatch(String xUpstartTenant, List<String> xUpstartSite, SwatchMetadata swatchMetadata) {
        Optional<SwatchEntity> oldSwatchIfAny = swatchRepo.findBySwatchId(swatchMetadata.getId());
        SwatchEntity newSwatchEntity = Util.prepareSwatchEntityFromMetadata(xUpstartTenant, xUpstartSite, swatchMetadata, oldSwatchIfAny);
        swatchRepo.save(newSwatchEntity);
    }

}
