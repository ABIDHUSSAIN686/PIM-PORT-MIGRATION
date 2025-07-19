package com.upstartcommerce.pim.application.service;

import com.upstartcommerce.pim.domain.dtos.SwatchDto;

import java.util.List;

public interface SwatchService {

    List<SwatchDto> getAllSwatches(
            String xUpstartTenant, String view);

    List<String> getAllLiveSwatchIdsByTenantId(String xUpstartTenant);

}
