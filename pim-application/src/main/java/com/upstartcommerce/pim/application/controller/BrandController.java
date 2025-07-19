package com.upstartcommerce.pim.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstartcommerce.pim.application.service.BrandService;
import com.upstartcommerce.pim.domain.dtos.BrandDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.upstartcommerce.common.model.Constants.PUBLISHED;
import static com.upstartcommerce.common.model.Constants.WIP;

@Component
public class BrandController {

    private final BrandService brandService;
    private final ObjectMapper mapper;


    public BrandController(
            BrandService brandService,
            ObjectMapper mapper
    ) {
        this.brandService = brandService;
        this.mapper = mapper;
    }


    public List<BrandDto> getAllBrands(String xUpstartTenant, String view) {
        List<BrandDto> brands = new ArrayList<>();
        if (PUBLISHED.equals(view)) {
            brands = brandService.getAllLIVEBrands(xUpstartTenant);
        } else if (WIP.equals(view)) {
            brands = brandService.getAllWIPBrands(xUpstartTenant);
        }

        return brands;
    }
}
