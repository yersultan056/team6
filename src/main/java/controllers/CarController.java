package controllers;

import modules.Cars;
import repositories.interfaces.ICarsRepository;

import java.util.List;

public class CarsController {
    private final ICarsRepository repo;

    public CarsController(ICarsRepository repo) {
        this.repo = repo;
    }

    public String getCar(int car_id) {
        Cars car = repo.getCar(car_id);

        return (car == null ? "User was not found!" : car.toString());
    }

    public String getAllCars() {
        List<Cars> cars = repo.getAllCars();

        StringBuilder response = new StringBuilder();
        for (Cars car : cars) {
            response.append(car.toString()).append("\n");
        }

        return response.toString();
    }
}
