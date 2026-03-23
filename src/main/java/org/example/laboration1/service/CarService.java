package org.example.laboration1.service;

import org.example.laboration1.domain.CreateCarRequest;
import org.example.laboration1.domain.UpdateCarRequest;
import org.example.laboration1.domain.entity.Car;
import java.util.List;
import java.util.UUID;

public interface CarService {

    Car createCar(CreateCarRequest request);

    List<Car> listCars();

    Car updateCar(Long carId, UpdateCarRequest request);

    void deleteCar(Long carId);
}
