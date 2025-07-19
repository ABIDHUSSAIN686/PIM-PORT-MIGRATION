package com.upstartcommerce.port.domain.model.entity;

import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;
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
@Table(name = "pim_brand", schema = "port_svc")
public class BrandEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant")
    private String tenant;

    @Column(name = "brand_id")
    private String brandId;

    @Convert(converter = StringListConverter.class)
    @Column(name = "site_ids")
    private List<String> siteIds;

    @Column(name = "name")
    private String name;

    @Convert(converter = StringListConverter.class)
    @Column(name = "linked_items")
    private List<String> linkedItems;

    @Type(type = "jsonb")
    @Column(name = "brand_data")
    private BrandMetaData brandData;

    @Column(name = "port_creation_timestamp")
    @CreationTimestamp
    private LocalDateTime portCreationTimestamp;
}
