package lessons.lessons6;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Seat {
    private String seatNumber;
    private String seatClass; // Business or Economy
    private boolean booked;
    private Passenger passenger;

    @Override
    public String toString() {
        return "Seat " + seatNumber + " (" + seatClass + ") - " + (booked ? "Booked" : "Available");
    }
}
