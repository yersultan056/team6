package repositories.interfaces;

import modules.Cars;

import java.util.List;

public interface ICarsRepository {
    boolean createUser(Cars car);
   Cars getCars(int car_id);
    List<Cars> getAllCars();
}
