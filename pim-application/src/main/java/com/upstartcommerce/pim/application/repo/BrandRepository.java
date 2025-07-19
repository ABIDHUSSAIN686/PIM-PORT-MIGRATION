package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.key.BrandKey;
import com.upstartcommerce.pim.domain.writeside.entity.brand.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface BrandRepository {

    List<Brand> getAllBrandsEntities(String xUpstartTenant);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);
}
