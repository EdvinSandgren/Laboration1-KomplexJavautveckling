package org.example.laboration1.domain.dto;

import org.example.laboration1.domain.entity.CarStatus;
import java.time.Year;

public record CarDto(
        Long id,
        String model,
        String description,
        Year modelyear,
        int price,
        int mileage,
        CarStatus status
) {
}