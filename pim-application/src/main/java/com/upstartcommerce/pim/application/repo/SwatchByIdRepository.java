package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchById;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface SwatchByIdRepository {

    List<Map<String, Object>> getAllSwatchIdsByTenantId(String xUpstartTenant);

    List<SwatchById> getAllByTenantId(String xUpstartTenant);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);

    List<SwatchById> getSwatchById(String xUpstartTenant, List<String> swatchIds);
}
