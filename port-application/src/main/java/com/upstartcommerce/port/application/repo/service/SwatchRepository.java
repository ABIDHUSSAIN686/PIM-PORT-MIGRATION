package com.upstartcommerce.port.application.repo.service;

import com.upstartcommerce.port.application.repo.jpa.SwatchRepo;
import org.springframework.stereotype.Service;

@Service
public class SwatchRepository {
final SwatchRepo swatchRepo;

    public SwatchRepository(SwatchRepo swatchRepo) {
        this.swatchRepo = swatchRepo;
    }
}
