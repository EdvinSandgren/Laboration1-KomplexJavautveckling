package org.example.laboration1.controller;

import jakarta.validation.Valid;
import org.example.laboration1.domain.CreateCarRequest;
import org.example.laboration1.domain.UpdateCarRequest;
import org.example.laboration1.domain.dto.CarDto;
import org.example.laboration1.domain.dto.CreateCarDto;
import org.example.laboration1.domain.dto.UpdateCarDto;
import org.example.laboration1.domain.entity.Car;
import org.example.laboration1.mapper.CarMapper;
import org.example.laboration1.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;


    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(
            @Valid @RequestBody CreateCarDto createCarDto
    ) {
        CreateCarRequest createCarRequest = carMapper.fromDto(createCarDto);
        Car car = carService.createCar(createCarRequest);
        CarDto createdCarDto = carMapper.toDto(car);
        return new ResponseEntity<>(createdCarDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> listCars(){
        List<Car> cars = carService.listCars();
        List<CarDto> carDtos = cars.stream().map(carMapper::toDto).toList();
        return ResponseEntity.ok(carDtos);
    }

    @PutMapping(path = "/{carId}")
    public ResponseEntity<CarDto> updateCar(
            @PathVariable Long carId,
            @Valid @RequestBody UpdateCarDto updateCarDto
    ){
        UpdateCarRequest updateCarRequest = carMapper.fromDto(updateCarDto);
        Car car = carService.updateCar(carId, updateCarRequest);
        CarDto carDto = carMapper.toDto(car);
        return ResponseEntity.ok(carDto);
    }

    @DeleteMapping(path = "/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}