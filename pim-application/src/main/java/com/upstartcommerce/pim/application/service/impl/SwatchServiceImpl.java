package com.upstartcommerce.pim.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstartcommerce.common.model.Constants;
import com.upstartcommerce.pim.application.repo.SwatchByIdRepository;
import com.upstartcommerce.pim.application.repo.SwatchLiveRepository;
import com.upstartcommerce.pim.application.service.SwatchService;
import com.upstartcommerce.pim.domain.dtos.I18NStringDto;
import com.upstartcommerce.pim.domain.dtos.SwatchDto;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchById;
import com.upstartcommerce.pim.domain.readside.entity.swatches.SwatchLive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.upstartcommerce.common.model.CustomModelMapper.map;


@Service
@Slf4j
public class SwatchServiceImpl implements SwatchService {

    public static final int versionOne = 1;
    private final ObjectMapper mapper;

    private final SwatchLiveRepository swatchLiveRepository;

    private final SwatchByIdRepository swatchByIdRepository;


    public SwatchServiceImpl(ObjectMapper mapper, SwatchLiveRepository swatchLiveRepository, SwatchByIdRepository swatchByIdRepository) {
        this.mapper = mapper;
        this.swatchLiveRepository = swatchLiveRepository;
        this.swatchByIdRepository = swatchByIdRepository;
    }

    @Override
    public List<SwatchDto> getAllSwatches(String xUpstartTenant, String view) {
        if (Constants.PUBLISHED.equals(view)) {
            return swatchLiveRepository.findAllSwatches(xUpstartTenant).stream().collect(Collectors.groupingBy(
                    swatch -> swatch.getKey().getSwatchId(),
                    Collectors.collectingAndThen(
                            Collectors.maxBy(Comparator.comparing(swatch -> swatch.getKey().getVersion())),
                            latestSwatch -> latestSwatch.map(this::prepareLiveDto).orElse(null)
                    )
            )).values().stream().filter(Objects::nonNull).toList();
        } else if (Constants.WIP.equals(view)) {
            return swatchByIdRepository.getAllByTenantId(xUpstartTenant).stream().map(this::prepareDraftDto).toList();
        } else {
            return Collections.emptyList();
        }
    }

    public SwatchDto prepareLiveDto(SwatchLive iteratorLive) {
        SwatchDto swatchDto = new SwatchDto();
        swatchDto.setTenantId(iteratorLive.getKey().getTenantId());
        swatchDto.setSwatchId(iteratorLive.getKey().getSwatchId());
        swatchDto.setSwatchName(iteratorLive.getSwatchName());
        swatchDto.setVersion(iteratorLive.getKey().getVersion());
        swatchDto.setDescription(map(iteratorLive.getDescription(), I18NStringDto.class));
        swatchDto.setVendor(iteratorLive.getVendor());
        swatchDto.setImageUrl(iteratorLive.getImageUrl());
        swatchDto.setCollectionImageAltText(iteratorLive.getCollectionImageAltText());
        swatchDto.setState(iteratorLive.getState());
        swatchDto.setStatus(iteratorLive.getStatus());
        swatchDto.setSwatchTags(iteratorLive.getSwatchTags());
        swatchDto.setCollectionId(iteratorLive.getCollectionId());
        swatchDto.setCollectionName(iteratorLive.getCollectionName());
        swatchDto.setCollectionDesc(map(iteratorLive.getCollectionDesc(), I18NStringDto.class));
        swatchDto.setCollectionTypeId(iteratorLive.getCollectionTypeId());
        swatchDto.setCollectionTypeName(iteratorLive.getCollectionTypeName());
        swatchDto.setSiteIds(iteratorLive.getSiteIds());
        swatchDto.setHexCode(iteratorLive.getHexCode());
        swatchDto.setCollectionHexCode(iteratorLive.getCollectionHexCode());
        swatchDto.setDateCreated(iteratorLive.getDateCreated());
        swatchDto.setDateModified(iteratorLive.getDateModified());
        return swatchDto;
    }

    public SwatchDto prepareDraftDto(SwatchById iteratorDraft) {
        SwatchDto swatchDto = new SwatchDto();
        swatchDto.setTenantId(iteratorDraft.getKey().getTenantId());
        swatchDto.setSwatchId(iteratorDraft.getKey().getSwatchId());
        swatchDto.setSwatchName(iteratorDraft.getSwatchName());
        swatchDto.setDescription(map(iteratorDraft.getDescription(), I18NStringDto.class));
        swatchDto.setVendor(iteratorDraft.getVendor());
        swatchDto.setImageUrl(iteratorDraft.getImageUrl());
        swatchDto.setState(iteratorDraft.getState());
        swatchDto.setStatus(iteratorDraft.getStatus());
        swatchDto.setSwatchTags(iteratorDraft.getSwatchTags());
        swatchDto.setCollectionId(iteratorDraft.getCollectionId());
        swatchDto.setCollectionName(iteratorDraft.getCollectionName());
        swatchDto.setCollectionDesc(map(iteratorDraft.getCollectionDesc(), I18NStringDto.class));
        swatchDto.setCollectionImageUrl(iteratorDraft.getCollectionImageUrl());
        swatchDto.setCollectionImageAltText(iteratorDraft.getCollectionImageAltText());
        swatchDto.setCollectionTypeId(iteratorDraft.getCollectionTypeId());
        swatchDto.setCollectionTypeName(iteratorDraft.getCollectionTypeName());
        swatchDto.setSiteIds(iteratorDraft.getSiteIds());
        swatchDto.setHexCode(iteratorDraft.getHexCode());
        swatchDto.setCollectionHexCode(iteratorDraft.getCollectionHexCode());
        swatchDto.setDateCreated(iteratorDraft.getDateCreated());
        swatchDto.setDateModified(iteratorDraft.getDateModified());
        return swatchDto;
    }
    @Override
    public List<String> getAllLiveSwatchIdsByTenantId(String xUpstartTenant) {
        return swatchLiveRepository.findAllSwatchIdsByTenant(xUpstartTenant);
    }
}
