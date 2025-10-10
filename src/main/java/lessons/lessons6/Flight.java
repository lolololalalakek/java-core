package lessons.lessons6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departureDateTime; // дата и время вылета

}
