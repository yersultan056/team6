package controllers;

import modules.Cars;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class CarController {
    private final IUserRepository repo;

    public CarController(IUserRepository repo) {
        this.repo = repo;
    }

    public String getCar(int car_id) {
        Cars car = repo.getCar(car_id);
        return (car == null ? "User was not found!" : car.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        StringBuilder response = new StringBuilder();
        for (User user : users) {
            response.append(user.toString()).append("\n");
        }

        return response.toString();
    }
}
