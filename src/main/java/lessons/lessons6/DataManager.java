package lessons.lessons6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_NAME = "flight_data.txt";

    // -------------------- СОХРАНЕНИЕ --------------------
    public static void saveData(Airplane airplane) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            // Сохраняем информацию о рейсе
            Flight flight = airplane.getFlight();
            writer.println("#FLIGHT;" + flight.getFlightNumber() + ";" +
                flight.getDestination() + ";" +
                flight.getDepartureDateTime());

            // Сохраняем все места
            for (Seat seat : airplane.getSeats()) {
                writer.println(seat.getSeatNumber() + ";" +
                    seat.getSeatClass() + ";" +
                    seat.isBooked() + ";" +
                    (seat.getPassenger() != null ? seat.getPassenger().getFullName() : "null") + ";" +
                    (seat.getStatus() != null ? seat.getStatus().name() : "FREE") + ";" +
                    (seat.getBookingTime() != null ? seat.getBookingTime() : "null"));
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error while saving data: " + e.getMessage());
        }
    }

    // -------------------- ЗАГРУЗКА --------------------
    public static Airplane loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return null; // если файл отсутствует — данных нет
        }

        List<Seat> seats = new ArrayList<>();
        Flight flight = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#FLIGHT")) {
                    // Читаем информацию о рейсе
                    String[] parts = line.split(";");
                    flight = new Flight(parts[1], parts[2], LocalDateTime.parse(parts[3]));
                } else {
                    // Читаем места
                    // Читаем места
                    String[] parts = line.split(";");

// безопасная обработка цены
                    double price = 0; // дефолт
                    if (parts.length > 6) {
                        price = Double.parseDouble(parts[6]);
                    }

                    Seat seat = new Seat(
                        parts[0],                                           // seatNumber
                        parts[1],                                           // seatClass
                        Boolean.parseBoolean(parts[2]),                    // booked
                        parts[3].equals("null") ? null : new Passenger(parts[3]), // passenger
                        SeatStatus.valueOf(parts[4]),                      // status
                        parts[5].equals("null") ? null : LocalDateTime.parse(parts[5]), // bookingTime
                        price                                              // price
                    );

                    seats.add(seat);


                    seats.add(seat);
                }
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error while loading data: " + e.getMessage());
        }

        // Если рейс не найден — создаём дефолтный
        if (flight == null) {
            flight = new Flight("SU123", "Moscow", LocalDateTime.now().plusHours(2));
        }

        // Возвращаем объект самолёта
        return new Airplane("Airbus A320", flight, seats);
    }
}
