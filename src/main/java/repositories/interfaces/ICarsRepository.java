package repositories.interfaces;

import modules.Cars;

import java.util.List;

public interface ICarsRepository {
    // Attempts to add a new car to the database.
    // Returns true if the car was successfully added, false otherwise.
    boolean createCar(Cars car);

    // Retrieves a car by its unique identifier (car_id) from the database.
    // Returns a Cars object if found, null otherwise.
    Cars getCar(int car_id);

    // Fetches a list of all cars available in the database.
    // Returns a list of Cars objects, which may be empty if no cars are found.
    List<Cars> getAllCars();
}

