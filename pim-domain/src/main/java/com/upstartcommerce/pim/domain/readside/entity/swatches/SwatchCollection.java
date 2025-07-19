package com.upstartcommerce.pim.domain.readside.entity.swatches;

import com.upstartcommerce.common.enums.SwatchStateEnum;
import com.upstartcommerce.common.enums.SwatchStatusEnum;
import com.upstartcommerce.pim.domain.I18NString;
import com.upstartcommerce.pim.domain.readside.entity.key.SwatchCollectionKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("swatch_collection")
@Data
@EqualsAndHashCode(callSuper = false)
public class SwatchCollection {

    @PrimaryKey
    private SwatchCollectionKey key;

    @Column("collection_name")
    private String collectionName;

    @Column("collection_description")
    private I18NString collectionDesc;

    @Column("collection_image_url")
    private String collectionImageUrl;

    @Column("collection_image_alt_text")
    private String collectionImageAltText;

    @Column("collection_type_id")
    private String collectionTypeId;

    @Column("collection_tags")
    private List<String> collectionTags;

    @Column("state")
    private SwatchStateEnum state;

    @Column("status")
    private SwatchStatusEnum status;

    @Column("site_ids")
    private List<String> siteIds;

    @Column("hex_code")
    private String hexCode;

    @Column("date_created")
    private LocalDateTime dateCreated;

    @Column("date_modified")
    private LocalDateTime dateModified;
}
