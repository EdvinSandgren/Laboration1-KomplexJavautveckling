package org.example.laboration1.mapper;

import org.example.laboration1.domain.CreateCarRequest;
import org.example.laboration1.domain.UpdateCarRequest;
import org.example.laboration1.domain.dto.CarDto;
import org.example.laboration1.domain.dto.CreateCarDto;
import org.example.laboration1.domain.dto.UpdateCarDto;
import org.example.laboration1.domain.entity.Car;

public interface CarMapper {

    CreateCarRequest fromDto(CreateCarDto dto);

    UpdateCarRequest fromDto(UpdateCarDto dto);

    CarDto toDto(Car car);

}
