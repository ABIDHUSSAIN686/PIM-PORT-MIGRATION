package com.upstartcommerce.pim.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstartcommerce.pim.application.service.SwatchService;
import com.upstartcommerce.pim.domain.dtos.SwatchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class SwatchController {

    private final SwatchService swatchService;
    private final ObjectMapper mapper;

    public SwatchController(
            SwatchService swatchService,
            ObjectMapper mapper
    ) {
        this.swatchService = swatchService;
        this.mapper = mapper;
    }


    public List<SwatchDto> getAllSwatches(
            String xUpstartTenant,
            String view) {
        List<SwatchDto> swatchDto =
                swatchService.getAllSwatches(xUpstartTenant, view);

        return swatchDto;
    }

}
