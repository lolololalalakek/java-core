package lessons.lessons6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    private String airplaneModel; // например, Airbus A320
    private Flight flight;        // сам рейс
    private List<Seat> seats;     // все места

    /**
     * Ищет место по номеру (например "12A").
     * @param seatNumber номер места
     * @return объект Seat или null, если не найдено
     */
    public Seat findSeat(String seatNumber) {
        if (seats == null || seatNumber == null) return null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)) {
                return seat;
            }
        }
        return null;
    }
}
