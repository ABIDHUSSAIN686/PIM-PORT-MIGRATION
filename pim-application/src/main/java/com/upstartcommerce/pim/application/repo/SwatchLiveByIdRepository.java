package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchLiveById;

import java.util.List;
import java.util.stream.Stream;

public interface SwatchLiveByIdRepository {

    List<SwatchLiveById> getAllSwatchesByTenantIdLatestVersion(String xUpstartTenant);

    List<SwatchLiveById> getAllSwatchesByIdLatestVersion(String xUpstartTenant, List<String> swatchIds);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);

    void updateSwatchByCollectionId(SwatchLiveById slbid2);
}
