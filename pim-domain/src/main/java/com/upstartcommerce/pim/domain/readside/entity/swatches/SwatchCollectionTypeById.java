package com.upstartcommerce.pim.domain.readside.entity.swatches;

import com.upstartcommerce.common.enums.SwatchStateEnum;
import com.upstartcommerce.common.enums.SwatchStatusEnum;
import com.upstartcommerce.pim.domain.I18NString;
import com.upstartcommerce.pim.domain.readside.entity.key.SwatchCollectionTypeByIdKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("swatch_collection_type_by_id")
@Data
@EqualsAndHashCode(callSuper = false)
public class SwatchCollectionTypeById {

    @PrimaryKey
    private SwatchCollectionTypeByIdKey key;

    @Column("collection_type_name")
    private String collectionTypeName;

    @Column("collection_type_description")
    private I18NString collectionTypeDesc;

    @Column("collection_type_tags")
    private List<String> tags;

    @Column("state")
    private SwatchStateEnum state;

    @Column("status")
    private SwatchStatusEnum status;

    @Column("site_ids")
    private List<String> siteIds;

    @Column("date_created")
    private LocalDateTime dateCreated;

    @Column("date_modified")
    private LocalDateTime dateModified;
}
