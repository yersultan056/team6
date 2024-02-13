package controllers;

import modules.Cars;
import repositories.interfaces.ICarsRepository;

import java.util.List;

public class CarController {
    // Repository to interact with car data
    private final ICarsRepository repo;

    // Constructor to initialize the car controller with a car repository
    public CarController(ICarsRepository repo) {
        this.repo = repo;
    }

    // Retrieves a single car by its ID. Returns a string representation of the car or a not found message.
    public String getCar(int car_id) {
        Cars car = repo.getCar(car_id); // Attempt to retrieve the car from the repository

        // Conditional check to return the car details or a not found message
        return (car == null ? "Car was not found!" : car.toString());
    }

    // Retrieves all cars from the repository and returns them as a string.
    public String getAllCars() {
        List<Cars> cars = repo.getAllCars(); // Retrieve all cars

        // StringBuilder to accumulate car details
        StringBuilder response = new StringBuilder();
        for (Cars car : cars) {
            response.append(car.toString()).append("\n"); // Append each car's details
        }

        return response.toString(); // Return the aggregated string of car details
    }
}

