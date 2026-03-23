package org.example.laboration1.domain.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.Year;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name= "cars")
public class Car {

    public Car() {
    }

    public Car(Long id, String model, String description, Year modelyear, int price, int mileage, CarStatus status, Instant created, Instant updated) {
        this.id = id;
        this.model = model;
        this.description = description;
        this.modelyear = modelyear;
        this.price = price;
        this.mileage = mileage;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "model",  nullable = false)
    private String model;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "modelyear")
    private Year modelyear;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CarStatus status;

    @Column(name = "created", updatable = false, nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Year getModelyear() {
        return modelyear;
    }

    public void setModelyear(Year modelyear) {
        this.modelyear = modelyear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", modelyear=" + modelyear +
                ", price=" + price +
                ", mileage=" + mileage +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
