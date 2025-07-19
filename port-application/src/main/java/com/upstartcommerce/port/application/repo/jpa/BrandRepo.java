package com.upstartcommerce.port.application.repo.jpa;

import com.upstartcommerce.port.domain.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BrandRepo extends JpaRepository<BrandEntity, Long> {

    Optional<BrandEntity> findByBrandId(String brandId);

}