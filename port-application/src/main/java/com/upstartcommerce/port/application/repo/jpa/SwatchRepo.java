package com.upstartcommerce.port.application.repo.jpa;

import com.upstartcommerce.port.domain.model.entity.SwatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SwatchRepo extends JpaRepository<SwatchEntity, Long> {
    Optional<SwatchEntity> findBySwatchId(String swatchId);
}