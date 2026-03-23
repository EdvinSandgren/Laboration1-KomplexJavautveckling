package org.example.laboration1.repository;

import org.example.laboration1.domain.entity.Car;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends ListCrudRepository<Car, Long> {
}
