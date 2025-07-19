package com.upstartcommerce.port.domain.pim.brand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.upstartcommerce.pim.domain.dtos.I18NStringDto;
import com.upstartcommerce.port.domain.deserlizers.JsonStringToObjectDeserializer;
import com.upstartcommerce.port.domain.deserlizers.StringToListDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.List;

import static com.upstartcommerce.common.model.Constants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandMetaData {
    private String tenantId;

    private String brandId;

    private List<String> siteIds;

    private I18NStringDto description;

    private String name;

    private BrandState state;

    private BrandStatus status;

    private String website;

    private String socialMediaLinks;

    private String contactInformation;

    private List<String> linkedItems;

    private String logo;

    private String countryOfOrigin;

    private Boolean hasDraft;

    private Boolean hasPublished;

    private LocalDateTime dateModified;

    private LocalDateTime dateCreated;

    @SneakyThrows
    public void setFields(String requestSchema) {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(requestSchema);
        JsonNode countryOfOriginNode = rootNode.get(COUNTRY_OF_ORIGIN);
        JsonNode websiteNode = rootNode.get(WEBSITE);


        if (countryOfOriginNode != null) {
            this.countryOfOrigin = countryOfOriginNode.asText();
        }
        if (websiteNode != null) {
            this.website = websiteNode.asText();
        }

        this.logo =
                isInValidLogoObject(rootNode)
                        ? EMPTY_JSON
                        : rootNode.get(LOGO).asText();

        this.socialMediaLinks =
                isInValidSmlObject(rootNode)
                        ? EMPTY_JSON
                        : rootNode.get(SOCIAL_MEDIA_LINKS).toString();

        this.contactInformation =
                isInValidCiObject(rootNode)
                        ? EMPTY_JSON
                        : rootNode.get(CONTACT_INFORMATION).toString();


    }
    private static class BrandSocialMediaLinksDeserializer extends StringToListDeserializer<BrandSocialMediaLinks> {
        public BrandSocialMediaLinksDeserializer() {
            super(BrandSocialMediaLinks.class);
        }
    }

    private static class BrandContactInformationDeserializer extends StringToListDeserializer<BrandContactInformation> {
        public BrandContactInformationDeserializer() {
            super(BrandContactInformation.class);
        }
    }

    private static class BrandLogoDeserializer extends JsonStringToObjectDeserializer<BrandLogo> {
        public BrandLogoDeserializer() {
            super(BrandLogo.class);
        }
    }

    boolean isInValidLogoObject(JsonNode rootNode) {
        return rootNode.get(LOGO) == null || rootNode.get(LOGO) instanceof NullNode;
    }

    boolean isInValidSmlObject(JsonNode rootNode) {
        return rootNode.get(SOCIAL_MEDIA_LINKS) == null || rootNode.get(SOCIAL_MEDIA_LINKS) instanceof NullNode;
    }

    boolean isInValidCiObject(JsonNode rootNode) {
        return rootNode.get(CONTACT_INFORMATION) == null || rootNode.get(CONTACT_INFORMATION) instanceof NullNode;
    }
}
