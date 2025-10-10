package lessons.lessons6;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Seat {

    private String seatNumber;          // Seat number (e.g., 12A)
    private String seatClass;           // Business or Economy
    private boolean booked;             // true = booked
    private Passenger passenger;        // Who booked or bought it
    private SeatStatus status;          // FREE, BOOKED, PAID
    private LocalDateTime bookingTime;  // Time when booking was made
    private double price;               // Ticket price


    @Override
    public String toString() {
        String base = String.format("Seat %s (%s) - %s",
            seatNumber, seatClass,
            status == SeatStatus.FREE ? "Available" :
                status == SeatStatus.BOOKED ? "Booked" : "Paid");
        if (passenger != null) {
            base += " | " + passenger.getFullName();
        }
        return base;
    }

    // Checks if 24 minutes passed since booking
    public boolean isBookingExpired() {
        if (bookingTime == null || status == SeatStatus.PAID) {
            return false;
        }
        Duration duration = Duration.between(bookingTime, LocalDateTime.now());
        return duration.toMinutes() >= 24;
    }

    // ---- 💳 PAYMENT METHODS ----

    // Paying for existing booking
    public boolean payForBooking() {
        if (status != SeatStatus.BOOKED) {
            System.out.println("❌ You can only pay for a booked seat!");
            return false;
        }
        this.status = SeatStatus.PAID;
        this.booked = true;
        if (passenger != null) passenger.setPaymentDone(true);
        System.out.println("✅ Seat " + seatNumber + " successfully paid by " + passenger.getFullName());
        return true;
    }

    // Instant purchase (without prior booking)
    public boolean instantBuy(Passenger buyer) {
        if (status == SeatStatus.PAID) {
            System.out.println("❌ This seat is already paid!");
            return false;
        }
        this.passenger = buyer;
        this.status = SeatStatus.PAID;
        this.booked = true;
        this.bookingTime = LocalDateTime.now();
        buyer.setPaymentDone(true);
        System.out.println("✅ Seat " + seatNumber + " instantly bought by " + buyer.getFullName());
        return true;
    }
}
