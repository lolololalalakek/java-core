package lessons.lessons6;

import java.util.List;
import java.util.Scanner;

public class FlightService {
    private final List<Seat> seats;
    private final Scanner scanner = new Scanner(System.in);

    public FlightService() {
        seats = DataManager.loadData();
        if (seats.isEmpty()) initializeSeats();
    }

    //бизнес-класс, (5 рядов, A C проход D F)
    private void initializeSeats() {
        for (int i = 1; i <= 5; i++) {
            for (char c : new char[]{'A', 'C', 'D', 'F'}) {
                seats.add(new Seat(i + String.valueOf(c), "Business", false, null));
            }
        }
        //эконом-класс, (10 рядов по 6 мест) (A–F)
        for (int i = 6; i <= 15; i++) {
            for (char c = 'A'; c <= 'F'; c++) {
                seats.add(new Seat(i + String.valueOf(c), "Economy", false, null));
            }
        }
    }

    public void showAllSeats() {
        System.out.println("\n===== AIRPLANE SEATING MAP =====\n");
        System.out.println("=== BUSINESS CLASS ===\n");

        for (int i = 1; i <= 5; i++) {
            printRow(i, new char[]{'A', 'C', 'D', 'F'});
        }

        System.out.println("\n=== ECONOMY CLASS ===\n");
        for (int i = 6; i <= 15; i++) {
            printRow(i, new char[]{'A', 'B', 'C', 'D', 'E', 'F'});
        }

        System.out.println("\nPress 1 to return to Main Menu");
        while (true) {
            System.out.print("→ ");
            String input = scanner.nextLine();
            if (input.equals("1")) break;
            else System.out.println("Invalid input. Press 1 to return.");
        }
    }

    private void printRow(int rowNumber, char[] seatsInRow) {
        StringBuilder row = new StringBuilder();
        for (char c : seatsInRow) {
            String seatNum = rowNumber + String.valueOf(c);
            Seat seat = findSeat(seatNum);
            String symbol = (seat != null && seat.isBooked()) ? "[X]" : "[O]";
            row.append(String.format("%3s%-2s ", seatNum, symbol));
        }
        System.out.println(row);
    }

    public void bookSeat() {
        System.out.print("Enter seat number (e.g. 1A): ");
        String seatNum = scanner.nextLine().trim().toUpperCase();

        Seat seat = findSeat(seatNum);
        if (seat == null) {
            System.out.println("Seat not found!");
            return;
        }
        if (seat.isBooked()) {
            System.out.println("Seat already booked!");
            return;
        }

        System.out.print("Enter passenger full name: ");
        String fullName = scanner.nextLine();

        seat.setBooked(true);
        seat.setPassenger(new Passenger(fullName));
        DataManager.saveData(seats);
        System.out.println("Seat " + seatNum + " successfully booked for " + fullName + "!");

        postBookingMenu();
    }

    private void postBookingMenu() {
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Show airplane map");
            System.out.println("2. Book another seat");
            System.out.println("3. Back to main menu");
            System.out.print("→ ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAllSeats();
                    break;
                case "2":
                    bookSeat();
                    return;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void cancelBooking() {
        System.out.print("Enter seat number to cancel booking: ");
        String seatNum = scanner.nextLine().trim().toUpperCase();

        Seat seat = findSeat(seatNum);
        if (seat == null || !seat.isBooked()) {
            System.out.println("Seat is not booked!");
            return;
        }

        seat.setBooked(false);
        seat.setPassenger(null);
        DataManager.saveData(seats);
        System.out.println("Booking for seat " + seatNum + " cancelled.");
    }

    public void showSeatInfo() {
        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine().trim().toUpperCase();

        Seat seat = findSeat(seatNum);
        if (seat == null) {
            System.out.println("Seat not found.");
            return;
        }

        System.out.println(seat);
        if (seat.isBooked())
            System.out.println("Passenger: " + seat.getPassenger().getFullName());
    }

    private Seat findSeat(String seatNum) {
        for (Seat s : seats) {
            if (s.getSeatNumber().equalsIgnoreCase(seatNum))
                return s;
        }
        return null;
    }
}
