package com.upstartcommerce.pim.domain.readside.entity.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@PrimaryKeyClass
public class SwatchCollectionLiveKey implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @PrimaryKeyColumn(name = "tenant_id", type = PrimaryKeyType.PARTITIONED)
    private String tenantId;
    @PrimaryKeyColumn(name = "collection_id", type = PrimaryKeyType.CLUSTERED)
    private String collectionId;
}