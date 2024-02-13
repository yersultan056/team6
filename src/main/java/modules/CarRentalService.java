package modules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalService {
    private List<Cars> cars;
    private List<Booking> bookings = new ArrayList<>();
    public CarRentalService(List<Cars> cars) {
        this.cars = cars;
    }

    public List<Cars> searchAvailableCarsForUser(User user) {
        String userRightsCategory = user.getRightsCategory();
        return cars.stream()
                .filter(car -> car.getCategory().equalsIgnoreCase(userRightsCategory) && isCarAvailable(car.getCar_id()))
                .collect(Collectors.toList());
    }

    public boolean createBooking(int userId, int carId, LocalDateTime startTime, LocalDateTime endTime) {
        boolean isAvailable = bookings.stream().noneMatch(booking ->
                booking.getCarId() == carId &&
                        (startTime.isBefore(booking.getEndTime()) && endTime.isAfter(booking.getStartTime()))
        );

        if (isAvailable) {
            Booking newBooking = new Booking(bookings.size() + 1, userId, carId, startTime, endTime);
            bookings.add(newBooking);
            System.out.println("Reservation successfully added: " + newBooking);
            return true;
        } else {
            System.out.println("The car is not available for booking during the selected period.");
            return false;
        }
    }

    private boolean isCarAvailable(int carId) {
        return bookings.stream().noneMatch(booking ->
                booking.getCarId() == carId &&
                        LocalDateTime.now().isBefore(booking.getEndTime())
        );
    }
}

