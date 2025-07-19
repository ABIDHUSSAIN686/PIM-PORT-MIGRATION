package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.key.BrandLiveKey;
import com.upstartcommerce.pim.domain.writeside.entity.brand.BrandLive;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface BrandLiveRepository {
    List<BrandLive> getAllBrandsByTenantId(String xUpstartTenant);

    Stream<String> streamAllIdsByTenantId(String xUpstartTenant);
}
