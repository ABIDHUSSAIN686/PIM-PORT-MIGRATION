package com.upstartcommerce.port.application.repo.service;

import com.upstartcommerce.port.application.repo.jpa.BrandRepo;
import org.springframework.stereotype.Service;

@Service
public class BrandRepository {

    final BrandRepo brandRepo;

    public BrandRepository(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }
}
