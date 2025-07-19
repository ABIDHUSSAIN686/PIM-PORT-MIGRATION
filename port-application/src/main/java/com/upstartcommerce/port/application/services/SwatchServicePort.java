package com.upstartcommerce.port.application.services;

import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;

import java.util.List;

public interface SwatchServicePort {
    void upsertSwatch(String xUpstartTenant, List<String> xUpstartSite, SwatchMetadata swatchMetadata);

}
