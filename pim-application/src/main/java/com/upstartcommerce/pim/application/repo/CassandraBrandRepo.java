package com.upstartcommerce.pim.application.repo;


import com.upstartcommerce.pim.domain.readside.entity.key.BrandKey;
import com.upstartcommerce.pim.domain.writeside.entity.brand.Brand;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CassandraBrandRepo extends CassandraRepository<Brand, BrandKey> {

    List<Brand> findAllByKeyTenantId(String xUpstartTenant);

    @Query("SELECT brand_id FROM pim_writeside.brand WHERE tenant_id = :tenant")
    Stream<Brand> streamAllIdsByKeyTenantId(@Param("tenant") final String tenantId);
}
