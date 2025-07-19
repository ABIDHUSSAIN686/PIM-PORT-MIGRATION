package com.upstartcommerce.pim.application.repo;


import com.upstartcommerce.pim.domain.readside.entity.key.SwatchLiveKey;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchLive;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface SwatchLiveRepository {

    List<String> findAllSwatchIdsByTenant(String xUpstartTenant);
    List<SwatchLive> findAllSwatches(String xUpstartTenant);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);
}
