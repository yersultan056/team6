package modules;

import java.util.List;
import java.util.stream.Collectors;

public class CarRentalService {
    private List<Cars> cars;
    public CarRentalService(List<Cars> cars) {
        this.cars = cars;
    }
    public List<Cars> searchAvailableCarsForUser(User user) {
        String userRightsCategory = user.getRightsCategory();
        return cars.stream()
                .filter(car -> car.getCategory().equalsIgnoreCase(userRightsCategory))
                .collect(Collectors.toList());
    }
}
