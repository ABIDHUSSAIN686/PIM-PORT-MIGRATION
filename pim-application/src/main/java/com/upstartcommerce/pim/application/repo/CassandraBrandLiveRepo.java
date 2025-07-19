package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.key.BrandLiveKey;
import com.upstartcommerce.pim.domain.writeside.entity.brand.BrandLive;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CassandraBrandLiveRepo extends CassandraRepository<BrandLive, BrandLiveKey> {

    List<BrandLive> findAllByKeyTenantId(String xUpstartTenant);

    @Query("SELECT brand_id FROM pim_writeside.brand_live WHERE tenant_id = :tenant")
    Stream<BrandLive> streamAllIdsByKeyTenantId(@Param("tenant") final String tenantId);
}
