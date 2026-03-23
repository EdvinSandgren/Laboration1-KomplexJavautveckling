package org.example.laboration1.mapper.impl;

import org.example.laboration1.domain.CreateCarRequest;
import org.example.laboration1.domain.UpdateCarRequest;
import org.example.laboration1.domain.dto.CarDto;
import org.example.laboration1.domain.dto.CreateCarDto;
import org.example.laboration1.domain.dto.UpdateCarDto;
import org.example.laboration1.domain.entity.Car;
import org.example.laboration1.mapper.CarMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CreateCarRequest fromDto(CreateCarDto dto) {
        return new CreateCarRequest(
                dto.model(),
                dto.description(),
                dto.modelyear(),
                dto.price(),
                dto.mileage()
        );
    }

    @Override
    public UpdateCarRequest fromDto(UpdateCarDto dto) {
        return new UpdateCarRequest(
                dto.model(),
                dto.description(),
                dto.modelyear(),
                dto.price(),
                dto.mileage(),
                dto.status()
        );
    }

    @Override
    public CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getModel(),
                car.getDescription(),
                car.getModelyear(),
                car.getPrice(),
                car.getMileage(),
                car.getStatus()
        );
    }
}
