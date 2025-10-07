package lessons.lessons6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_NAME = "flight_data.txt";

    public static void saveData(List<Seat> seats) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Seat seat : seats) {
                writer.println(seat.getSeatNumber() + ";" +
                    seat.getSeatClass() + ";" +
                    seat.isBooked() + ";" +
                    (seat.getPassenger() != null ? seat.getPassenger().getFullName() : "null"));
            }
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }

    public static List<Seat> loadData() {
        List<Seat> seats = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return seats;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Seat seat = new Seat(parts[0], parts[1], Boolean.parseBoolean(parts[2]),
                    parts[3].equals("null") ? null : new Passenger(parts[3]));
                seats.add(seat);
            }
        } catch (IOException e) {
            System.out.println("Error while loading data: " + e.getMessage());
        }
        return seats;
    }
}
