package com.upstartcommerce.pim.application.repo;

import com.upstartcommerce.pim.domain.readside.entity.key.SwatchByIdKey;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchById;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public interface CassandraSwatchByIdRepo extends CassandraRepository<SwatchById, SwatchByIdKey> {

    List<SwatchById> findAllByKeyTenantId(String xUpstartTenant);

    List<SwatchById> findAllByKeyTenantIdAndKeySwatchIdIn(String xUpstartTenant, List<String> swatchIds);

    @Query("select swatch_id from swatch_by_id  where tenant_id = ?0")
    List<Map<String, Object>> findAllSwatchIdsInDraftByTenant(String xUpstartTenant);

    @Query("SELECT swatch_id FROM swatch_by_id WHERE tenant_id = :tenant")
    Stream<SwatchById> streamAllIdsByKeyTenantId(@Param("tenant") final String tenantId);
}
