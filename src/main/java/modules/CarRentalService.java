package modules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalService {
    private List<Cars> cars; // List to store all cars available for rental
    private List<Booking> bookings = new ArrayList<>(); // List to store all bookings

    // Constructor to initialize the service with a list of cars
    public CarRentalService(List<Cars> cars) {
        this.cars = cars;
    }

    // Searches for cars that match the user's rights category and are available for booking
    public List<Cars> searchAvailableCarsForUser(User user) {
        String userRightsCategory = user.getRightsCategory(); // Retrieve the user's rights category
        // Filter cars by category and availability, then collect into a list
        return cars.stream()
                .filter(car -> car.getCategory().equalsIgnoreCase(userRightsCategory) && isCarAvailable(car.getCar_id()))
                .collect(Collectors.toList());
    }

    // Attempts to create a booking for a car if it is available during the requested period
    public boolean createBooking(int userId, int carId, LocalDateTime startTime, LocalDateTime endTime) {
        // Check if the car is available (not booked during the requested time period)
        boolean isAvailable = bookings.stream().noneMatch(booking ->
                booking.getCarId() == carId &&
                        (startTime.isBefore(booking.getEndTime()) && endTime.isAfter(booking.getStartTime()))
        );

        if (isAvailable) {
            // If available, create a new booking and add it to the bookings list
            Booking newBooking = new Booking(bookings.size() + 1, userId, carId, startTime, endTime);
            bookings.add(newBooking);
            System.out.println("Reservation successfully added: " + newBooking);
            return true;
        } else {
            // If not available, inform the user
            System.out.println("The car is not available for booking during the selected period.");
            return false;
        }
    }

    // Checks if a car is available for booking by comparing existing bookings' dates
    private boolean isCarAvailable(int carId) {
        // A car is available if there are no bookings that overlap with the current time
        return bookings.stream().noneMatch(booking ->
                booking.getCarId() == carId &&
                        LocalDateTime.now().isBefore(booking.getEndTime())
        );
    }
}


