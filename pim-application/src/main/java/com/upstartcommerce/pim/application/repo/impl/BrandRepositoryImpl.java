package com.upstartcommerce.pim.application.repo.impl;

import com.upstartcommerce.pim.application.repo.BrandRepository;
import com.upstartcommerce.pim.application.repo.CassandraBrandRepo;
import com.upstartcommerce.pim.domain.writeside.entity.brand.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BrandRepositoryImpl implements BrandRepository {
    private final CassandraBrandRepo brandRepo;

    public BrandRepositoryImpl(CassandraBrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    @Override
    public List<Brand> getAllBrandsEntities(String xUpstartTenant) {
        return brandRepo.findAllByKeyTenantId(xUpstartTenant);
    }

    @Override
    public Stream<String> streamAllIdsByTenantId(String xUpstartTenant) {
        return brandRepo.streamAllIdsByKeyTenantId(xUpstartTenant).map(e -> e.getKey().getBrandId());
    }
}
