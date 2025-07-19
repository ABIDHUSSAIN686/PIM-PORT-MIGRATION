package com.upstartcommerce.pim.domain.readside.entity.swatches;

import com.upstartcommerce.common.enums.SwatchStateEnum;
import com.upstartcommerce.common.enums.SwatchStatusEnum;
import com.upstartcommerce.pim.domain.I18NString;
import com.upstartcommerce.pim.domain.readside.entity.key.SwatchByIdKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("swatch_by_id")
@Data
@EqualsAndHashCode(callSuper = false)
public class SwatchById {

  @PrimaryKey
  private SwatchByIdKey key;

  @Column("swatch_name")
  private String swatchName;

  @Column("image_url")
  private String imageUrl;

  @Column("image_alt_text")
  private String imageAltText;

  @Column("hex_code")
  private String hexCode;

  @Column("description")
  private I18NString description;

  @Column("vendor")
  private String vendor;

  @Column("collection_id")
  private String collectionId;

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

  @Column("collection_type_name")
  private String collectionTypeName;

  @Column("swatch_tags")
  private List<String> swatchTags;

  @Column("state")
  private SwatchStateEnum state;

  @Column("status")
  private SwatchStatusEnum status;

  @Column("linked_items")
  private List<String> linkedItems;

  @Column("site_ids")
  private List<String> siteIds;

  @Column("collection_hex_code")
  private String collectionHexCode;

  @Column("date_created")
  private LocalDateTime dateCreated;

  @Column("date_modified")
  private LocalDateTime dateModified;
}
