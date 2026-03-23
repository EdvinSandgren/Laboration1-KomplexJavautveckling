package org.example.laboration1.domain.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;
import java.time.Year;

public record CreateCarDto(
        @NotBlank(message = ERROR_MESSAGE_MODEL_LENGTH)
        @Length(max = 50, message = ERROR_MESSAGE_MODEL_LENGTH)
        String model,
        @Nullable
        @Length(max = 1000, message = ERROR_MESSAGE_DESC_LENGTH)
        String description,
        @PastOrPresent(message = ERROR_MESSAGE_MODELYEAR_FUTURE)
        @Nullable
        Year modelyear,
        @PositiveOrZero(message = ERROR_MESSAGE_PRICE_NEGATIVE)
        @NotNull
        int price,
        @PositiveOrZero(message = ERROR_MESSAGE_MILEAGE_NEGATIVE)
        @NotNull
        int mileage
) {
    private static final String ERROR_MESSAGE_MODEL_LENGTH = "Model name must be between 1 and 50 characters";
    private static final String ERROR_MESSAGE_DESC_LENGTH = "Description must be less than 1000 characters";
    private static final String ERROR_MESSAGE_MODELYEAR_FUTURE = "Model year cannot be in the future";
    private static final String ERROR_MESSAGE_PRICE_NEGATIVE = "Price cannot be negative";
    private static final String ERROR_MESSAGE_MILEAGE_NEGATIVE = "Mileage cannot be negative";
}
