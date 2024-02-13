package modules;

import java.time.LocalDateTime;

public class Booking {
    // Unique identifier for the booking
    private int id;
    // User ID associated with this booking
    private int userId;
    // Car ID associated with this booking
    private int carId;
    // Start time of the booking
    private LocalDateTime startTime;
    // End time of the booking
    private LocalDateTime endTime;

    // Constructor to initialize a new booking
    public Booking(int id, int userId, int carId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // Overridden toString method for displaying booking details
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

