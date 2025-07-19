package com.upstartcommerce.pim.application.repo.impl;

import com.upstartcommerce.pim.application.repo.BrandLiveRepository;
import com.upstartcommerce.pim.application.repo.CassandraBrandLiveRepo;
import com.upstartcommerce.pim.domain.writeside.entity.brand.BrandLive;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BrandRepositoryLiveImpl implements BrandLiveRepository {

    private final CassandraBrandLiveRepo brandLiveRepo;

    public BrandRepositoryLiveImpl(CassandraBrandLiveRepo brandLiveRepo) {
        this.brandLiveRepo = brandLiveRepo;
    }

    @Override
    public Stream<String> streamAllIdsByTenantId(String xUpstartTenant) {
        return brandLiveRepo.streamAllIdsByKeyTenantId(xUpstartTenant).map(e -> e.getKey().getBrandId()).distinct();
    }

    @Override
    public List<BrandLive> getAllBrandsByTenantId(String xUpstartTenant) {
        return brandLiveRepo.findAllByKeyTenantId(xUpstartTenant);
    }

}
