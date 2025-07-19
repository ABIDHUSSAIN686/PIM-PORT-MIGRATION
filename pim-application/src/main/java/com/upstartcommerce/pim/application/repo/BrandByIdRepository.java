package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.brand.BrandById;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
public interface BrandByIdRepository {

    List<BrandById> getAllBrandsByTenant(String xUpstartTenant);

    Optional<BrandById> getBrandByKeyTenantIdAndKeyBrandId(String tenantId, String brandId);

    List<BrandById> findByKeyTenantIdAndKeyBrandIdIn(String xUpstartTenant, List<String> brandIds);


    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);
}
