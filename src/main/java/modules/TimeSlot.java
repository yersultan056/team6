package modules;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSlot {
    private LocalDateTime startTime; // Start time of the time slot
    private LocalDateTime endTime; // End time of the time slot
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // Formatter for formatting date and time

    // Constructor of the class, takes start time and end time of the time slot
    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter for the start time of the time slot
    public LocalDateTime getStartTime() {
        return startTime;
    }

    // Setter for the start time of the time slot
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    // Getter for the end time of the time slot
    public LocalDateTime getEndTime() {
        return endTime;
    }

    // Setter for the end time of the time slot
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // Override of the toString method to provide custom string representation of the object
    @Override
    public String toString() {
        return "TimeSlot{" +
                "startTime=" + startTime.format(formatter) +
                ", endTime=" + endTime.format(formatter) +
                '}';
    }
}
