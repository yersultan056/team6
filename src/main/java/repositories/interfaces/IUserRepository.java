package repositories.interfaces;

import modules.Cars;
import modules.User;

import java.util.List;

public interface IUserRepository {

    Cars getCar(int car_id);

    List<Cars> getAllCars();
}
