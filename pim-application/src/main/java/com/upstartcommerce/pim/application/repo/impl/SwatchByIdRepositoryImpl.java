package com.upstartcommerce.pim.application.repo.impl;


import com.upstartcommerce.pim.application.repo.CassandraSwatchByIdRepo;
import com.upstartcommerce.pim.application.repo.SwatchByIdRepository;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchById;
import com.upstartcommerce.pim.domain.readside.entity.key.SwatchByIdKey;

import java.util.List;
import java.util.Map;

import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class SwatchByIdRepositoryImpl implements SwatchByIdRepository {

    private final CassandraSwatchByIdRepo cassandraSwatchByIdRepo;

    public SwatchByIdRepositoryImpl(CassandraSwatchByIdRepo cassandraSwatchByIdRepo) {
        this.cassandraSwatchByIdRepo = cassandraSwatchByIdRepo;
    }

    @Override public List<Map<String, Object>> getAllSwatchIdsByTenantId(String xUpstartTenant) {
        return cassandraSwatchByIdRepo.findAllSwatchIdsInDraftByTenant(xUpstartTenant);
    }

    @Override
    public List<SwatchById> getAllByTenantId(String xUpstartTenant) {
        return cassandraSwatchByIdRepo.findAllByKeyTenantId(xUpstartTenant);
    }

    @Override
    public Stream<String> streamAllIdsByTenantId(String xUpstartTenant) {
        return cassandraSwatchByIdRepo.streamAllIdsByKeyTenantId(xUpstartTenant).map(e -> e.getKey().getSwatchId()).distinct();
    }

    @Override
    public List<SwatchById> getSwatchById(String xUpstartTenant, List<String> swatchIds) {
        return cassandraSwatchByIdRepo.findAllByKeyTenantIdAndKeySwatchIdIn(xUpstartTenant,swatchIds);
    }
}

