package org.example.laboration1.exception;


public class CarNotFoundException extends RuntimeException {

    private final Long id;

    public CarNotFoundException(Long id) {
        super(String.format("Car listing with ID '%s' does not exist", id));
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}