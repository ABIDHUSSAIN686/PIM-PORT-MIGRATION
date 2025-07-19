package com.upstartcommerce.pim.application.service;

import com.upstartcommerce.pim.domain.dtos.BrandDto;

import java.util.List;

public interface BrandService {

    List<BrandDto> getAllWIPBrands(String xUpstartTenant);

    List<BrandDto> getAllLIVEBrands(String xUpstartTenant);

}
