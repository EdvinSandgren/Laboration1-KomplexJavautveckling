package org.example.laboration1.domain;

import org.example.laboration1.domain.entity.CarStatus;
import java.time.Year;

public record UpdateCarRequest(
        String model,
        String description,
        Year modelyear,
        int price,
        int mileage,
        CarStatus status
) {
}
