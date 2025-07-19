package com.upstartcommerce.pim.application.repo.impl;

import com.upstartcommerce.common.model.Constants;
import com.upstartcommerce.pim.application.repo.CassandraSwatchLiveRepo;
import com.upstartcommerce.pim.application.repo.SwatchLiveRepository;
import com.upstartcommerce.pim.domain.readside.entity.key.SwatchLiveKey;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchLive;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Stream;

@Service
public class SwatchLiveRepositoryImpl implements SwatchLiveRepository {

    private final CassandraSwatchLiveRepo cassandraSwatchLiveRepo;

    public SwatchLiveRepositoryImpl(CassandraSwatchLiveRepo cassandraSwatchLiveRepo) {
        this.cassandraSwatchLiveRepo = cassandraSwatchLiveRepo;
    }

    @Override public List<String> findAllSwatchIdsByTenant(String xUpstartTenant) {
        List<Map<String, Object>> swatchIdsColumn = cassandraSwatchLiveRepo.findAllSwatchIdsByTenant(xUpstartTenant);
        Set<Map<String, Object>> uniqueList = new HashSet<>(swatchIdsColumn);
        return uniqueList.stream().map(item -> (String) item.get(Constants.COLUMN_SWATCH_ID)).toList();
    }

    @Override
    public List<SwatchLive> findAllSwatches(String xUpstartTenant) {
        return cassandraSwatchLiveRepo.findAllByKeyTenantId(xUpstartTenant);
    }

    @Override
    public Stream<String> streamAllIdsByTenantId(String tenantId) {
        return cassandraSwatchLiveRepo.streamAllIdsByKeyTenantId(tenantId).map(e -> e.getKey().getSwatchId()).distinct();
    }
}
