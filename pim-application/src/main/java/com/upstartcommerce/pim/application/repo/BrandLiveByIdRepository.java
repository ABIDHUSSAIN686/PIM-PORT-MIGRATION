package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.brand.BrandLiveById;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
public interface BrandLiveByIdRepository {

    Optional<BrandLiveById> getBrandByKeyTenantIdAndKeyBrandId(String tenantId, String brandId);

    List<BrandLiveById> findByKeyTenantIdAndKeyBrandIdIn(String xUpstartTenant, List<String> brandIds);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);
}
