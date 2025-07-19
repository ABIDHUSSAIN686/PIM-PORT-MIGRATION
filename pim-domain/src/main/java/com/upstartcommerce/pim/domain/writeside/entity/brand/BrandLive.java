package com.upstartcommerce.pim.domain.writeside.entity.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.upstartcommerce.common.enums.BrandState;
import com.upstartcommerce.common.enums.BrandStatus;
import com.upstartcommerce.pim.domain.I18NString;
import com.upstartcommerce.pim.domain.readside.entity.key.BrandLiveKey;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Convert;
import java.time.LocalDateTime;
import java.util.List;

@Table("brand_live")
@Data
public class BrandLive {

    @PrimaryKey
    private BrandLiveKey key;
    @Column("name")
    private String name;
    @Column("description")
    private I18NString description;
    @Column("site_ids")
    private List<String> siteIds;
    @Column("state")
    private BrandState state;
    @Column("status")
    private BrandStatus status;
    @Column("linked_items")
    private List<String> linkedItems;
    @Column("request_schema")
    private String requestSchema;
    @Column("date_created")
    private LocalDateTime dateCreated;
    @Column("date_modified")
    private LocalDateTime dateModified;

}
