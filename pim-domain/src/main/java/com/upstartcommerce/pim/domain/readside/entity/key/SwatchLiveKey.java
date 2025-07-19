package com.upstartcommerce.pim.domain.readside.entity.key;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@PrimaryKeyClass
public class SwatchLiveKey implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @PrimaryKeyColumn(name = "tenant_id", type = PrimaryKeyType.PARTITIONED)
    private String tenantId;
    @PrimaryKeyColumn(name = "swatch_id", type = PrimaryKeyType.CLUSTERED)
    private String swatchId;
    @PrimaryKeyColumn(name = "version", type = PrimaryKeyType.CLUSTERED)
    private Integer version;
}