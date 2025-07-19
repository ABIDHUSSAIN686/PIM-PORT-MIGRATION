package com.upstartcommerce.port.domain.model.entity;

import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "pim_swatch", schema = "port_svc")
public class SwatchEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant")
    private String tenant;

    @Column(name = "swatch_id")
    private String swatchId;

    @Convert(converter = StringListConverter.class)
    @Column(name = "site_ids")
    private List<String> siteIds;

    @Type(type = "jsonb")
    @Column(name = "swatch_data")
    private SwatchMetadata swatchData;

    @Convert(converter = StringListConverter.class)
    @Column(name = "linked_items")
    private List<String> linkedItems;

    @Column(name = "collection_id")
    private String collectionId;

    @Column(name = "collection_type_id")
    private String collectionTypeId;

    @Column(name = "port_creation_timestamp")
    @CreationTimestamp
    private LocalDateTime portCreationTimestamp;

}
