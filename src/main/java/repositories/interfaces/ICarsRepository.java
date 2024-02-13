package repositories.interfaces;

import modules.Cars;

import java.util.List;

public interface ICarsRepository {
    boolean createCar(Cars car);
    Cars getUser(int car_id);
    List<Cars> getAllCars();
}
