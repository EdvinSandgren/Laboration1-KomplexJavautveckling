package org.example.laboration1.domain;

import java.time.Year;

public record CreateCarRequest(
        String model,
        String description,
        Year modelyear,
        int price,
        int mileage
) {
}
