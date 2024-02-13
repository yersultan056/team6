package modules;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class TimeSlot {
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
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

        @Override
        public String toString() {
            return "TimeSlot{" +
                    "startTime=" + startTime.format(formatter) +
                    ", endTime=" + endTime.format(formatter) +
                    '}';
        }
    }


