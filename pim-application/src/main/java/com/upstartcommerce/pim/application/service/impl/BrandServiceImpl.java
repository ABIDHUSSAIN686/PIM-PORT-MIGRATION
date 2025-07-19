package com.upstartcommerce.pim.application.service.impl;

import com.upstartcommerce.pim.application.repo.BrandLiveRepository;
import com.upstartcommerce.pim.application.repo.BrandRepository;
import com.upstartcommerce.pim.application.service.BrandService;
import com.upstartcommerce.pim.domain.dtos.I18NStringDto;
import com.upstartcommerce.pim.domain.dtos.BrandDto;
import com.upstartcommerce.pim.domain.writeside.entity.brand.Brand;
import com.upstartcommerce.pim.domain.writeside.entity.brand.BrandLive;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.upstartcommerce.common.model.CustomModelMapper.map;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandLiveRepository brandLiveRepository;

    public BrandServiceImpl( BrandRepository brandRepository,
                             BrandLiveRepository brandLiveRepository) {
        this.brandRepository = brandRepository;
        this.brandLiveRepository = brandLiveRepository;
    }

    @Override
    public List<BrandDto> getAllWIPBrands(String xUpstartTenant) {
        List<Brand> brand = brandRepository.getAllBrandsEntities(xUpstartTenant);
        List<BrandDto> response = new ArrayList<>();
        for (Brand itr : brand) {
            BrandDto dto = new BrandDto();
            dto.setBrandId(itr.getKey().getBrandId());
            dto.setTenantId(itr.getKey().getTenantId());
            dto.setName(itr.getName());
            dto.setLinkedItems(itr.getLinkedItems());
            dto.setDescription(map(itr.getDescription(), I18NStringDto.class));
            dto.setSiteIds(itr.getSiteIds());
            dto.setStatus(itr.getStatus());
            dto.setState(itr.getState());
            dto.setRequestSchema(itr.getRequestSchema());
            dto.setDateCreated(itr.getDateCreated());
            dto.setDateModified(itr.getDateModified());
            response.add(dto);
        }
        return response;
    }

    @Override

    public  List<BrandDto> getAllLIVEBrands(String xUpstartTenant) {
        List<BrandLive> brand = brandLiveRepository.getAllBrandsByTenantId(xUpstartTenant);
        List<BrandDto> response = new ArrayList<>();
        for (BrandLive itr : brand) {
            BrandDto dto = new BrandDto();
            dto.setBrandId(itr.getKey().getBrandId());
            dto.setTenantId(itr.getKey().getTenantId());
            dto.setName(itr.getName());
            dto.setLinkedItems(itr.getLinkedItems());
            dto.setDescription(map(itr.getDescription(), I18NStringDto.class));
            dto.setSiteIds(itr.getSiteIds());
            dto.setStatus(itr.getStatus());
            dto.setState(itr.getState());
            dto.setRequestSchema(itr.getRequestSchema());
            dto.setDateCreated(itr.getDateCreated());
            dto.setDateModified(itr.getDateModified());
            response.add(dto);
        }
        return response;
    }
}
