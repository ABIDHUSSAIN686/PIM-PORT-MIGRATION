package com.upstartcommerce.pimport.main;


import com.upstartcommerce.pim.application.controller.SwatchController;
import com.upstartcommerce.pim.domain.dtos.SwatchDto;
import com.upstartcommerce.port.application.services.BrandServicePort;
import com.upstartcommerce.pim.domain.dtos.BrandDto;
import com.upstartcommerce.pim.application.controller.BrandController;
import com.upstartcommerce.port.application.services.SwatchServicePort;
import com.upstartcommerce.port.domain.pim.brand.BrandMetaData;
import com.upstartcommerce.port.domain.pim.swatches.SwatchMetadata;
import com.upstartcommerce.port.domain.transformers.BrandMetaDataTransformers;
import com.upstartcommerce.port.domain.transformers.SwatchMetaDataTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.upstartcommerce.pim","com.upstartcommerce.port"})
@EnableCassandraRepositories(basePackages = "com.upstartcommerce.pim.application.repo")
@EnableJpaRepositories("com.upstartcommerce.port.application.repo.jpa")
@EntityScan(basePackages = "com.upstartcommerce.port.domain.model.entity")

public class Main implements CommandLineRunner {

    @Autowired
    private BrandController brandController;

    @Autowired
    private SwatchController swatchController;

    @Autowired
    private BrandServicePort brandServicePort;

    @Autowired
    private SwatchServicePort swatchServicePort;

    @Autowired
    private BrandMetaDataTransformers brandMetaDataTransformers;

    @Autowired
    private SwatchMetaDataTransformers swatchMetaDataTransformers;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Override
    public void run(String args[]) {

        // Get all live brands data from PIM
        List<BrandDto> brands = brandController.getAllBrands("denvermattress", "LATEST");
        for (BrandDto brandDto : brands) {
            // Applying transformation to Payload
            BrandMetaData brandMetaData = brandMetaDataTransformers.convertToBrandMetaData(brandDto);
            // Inserting brand data in PORT
            brandServicePort.upsertBrand(brandMetaData);
            System.out.println("BrandName :: "+ brandMetaData.getBrandId());
        }

        // Get all live swatches from PIM
        List<SwatchDto> swatches = swatchController.getAllSwatches("denvermattress", "LATEST");
        for (SwatchDto swatchDto : swatches) {
            // Applying transformation to Payload
            SwatchMetadata swatchMetadata = swatchMetaDataTransformers.convertToSwatchMetaData(swatchDto);
            // Inserting swatches data in PORT
            swatchServicePort.upsertSwatch(swatchDto.getTenantId(),swatchDto.getSiteIds(),swatchMetadata);
            System.out.println("SwatchId :: "+ swatchDto.getSwatchId());
        }
    }
}