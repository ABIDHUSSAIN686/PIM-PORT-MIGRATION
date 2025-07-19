package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.key.SwatchLiveKey;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchLive;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CassandraSwatchLiveRepo extends CassandraRepository<SwatchLive, SwatchLiveKey> {

    Optional<SwatchLive> findFirstByKeyTenantIdAndKeySwatchIdOrderByKeySwatchIdDescKeyVersionDesc(
            String xUpstartTenant, String swatchId);

    Optional<SwatchLive> findByKeyTenantIdAndKeySwatchIdAndKeyVersion(String xUpstartTenant, String swatchId, Integer previousVersionNumber);

    @Query("select swatch_id from swatch_live where tenant_id = ?0")
    List<Map<String, Object>> findAllSwatchIdsByTenant(String xUpstartTenant);

    List<SwatchLive> findAllByKeyTenantIdAndKeySwatchIdIn(String xUpstartTenant, List<String> swatchIds);

    @Query("SELECT swatch_id FROM swatch_live WHERE tenant_id = :tenant")
    Stream<SwatchLive> streamAllIdsByKeyTenantId(@Param("tenant") final String tenantId);

    List<SwatchLive> findAllByKeyTenantId(String xUpstartTenant);
}
