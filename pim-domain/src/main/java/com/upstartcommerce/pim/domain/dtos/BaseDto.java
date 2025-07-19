package com.upstartcommerce.pim.domain.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@ToString
public class BaseDto {

    private LocalDateTime dateCreated;

    public LocalDateTime getDateCreated() {

        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
