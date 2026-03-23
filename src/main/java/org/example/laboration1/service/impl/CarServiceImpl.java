package org.example.laboration1.service.impl;

import org.example.laboration1.domain.CreateCarRequest;
import org.example.laboration1.domain.UpdateCarRequest;
import org.example.laboration1.domain.entity.Car;
import org.example.laboration1.domain.entity.CarStatus;
import org.example.laboration1.exception.CarNotFoundException;
import org.example.laboration1.repository.CarRepository;
import org.example.laboration1.service.CarService;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(CreateCarRequest request) {
        Instant now = Instant.now();

        Car car = new Car(
                null,
                request.model(),
                request.description(),
                request.modelyear(),
                request.price(),
                request.mileage(),
                CarStatus.FOR_SALE,
                now,
                now
        );

        return carRepository.save(car);
    }

    @Override
    public List<Car> listCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Long carId, UpdateCarRequest request) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));

        car.setModel(request.model());
        car.setDescription(request.description());
        car.setModelyear(request.modelyear());
        car.setPrice(request.price());
        car.setMileage(request.mileage());
        car.setStatus(request.status());
        car.setUpdated(Instant.now());

        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
