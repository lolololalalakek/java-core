package lessons.lessons6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightService {
    private final Airplane airplane;
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public FlightService(Airplane airplane) {
        this.airplane = airplane;
        if (airplane.getSeats() == null || airplane.getSeats().isEmpty()) {
            airplane.setSeats(initializeSeats());
        }
    }

    private List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();
        // Business: 5 рядов, 4 места
        for (int i = 1; i <= 5; i++) {
            for (char c : new char[]{'A', 'C', 'D', 'F'}) {
                seats.add(new Seat(i + String.valueOf(c), "Business", false, null, SeatStatus.FREE, null, 0));
            }
        }
        // Economy: 16 рядов, 6 мест
        for (int i = 6; i <= 21; i++) {
            for (char c = 'A'; c <= 'F'; c++) {
                seats.add(new Seat(i + String.valueOf(c), "Economy", false, null, SeatStatus.FREE, null, 0));
            }
        }
        return seats;
    }

    // ---------------- Показ схемы ----------------
    public void showAllSeats() {
        checkExpiredBookings();
        System.out.println("\n===== AIRPLANE SEATING MAP =====");
        System.out.println("Flight: " + airplane.getFlight().getFlightNumber());
        System.out.println("Destination: " + airplane.getFlight().getDestination());
        System.out.println("Departure: " + airplane.getFlight().getDepartureDateTime().format(dtf));
        System.out.println("-----------------------------------");

        System.out.println("\n=== BUSINESS CLASS ===");
        for (int i = 1; i <= 5; i++) printRow(i, new char[]{'A', 'C', 'D', 'F'});
        System.out.println("\n=== ECONOMY CLASS ===");
        for (int i = 6; i <= 21; i++) printRow(i, new char[]{'A', 'B', 'C', 'D', 'E', 'F'});

        System.out.println("\n-----------------------------------");
        System.out.println("Press 1 to return to Flight Menu");
        while (true) {
            System.out.print("→ ");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) break;
            System.out.println("Invalid input. Please press 1 to return.");
        }
    }

    private void printRow(int rowNumber, char[] seatsInRow) {
        StringBuilder row = new StringBuilder();
        for (char c : seatsInRow) {
            String seatNum = rowNumber + String.valueOf(c);
            Seat seat = findSeat(seatNum);
            String symbol;
            if (seat == null || seat.getStatus() == SeatStatus.FREE) symbol = "[O]";
            else if (seat.getStatus() == SeatStatus.BOOKED) symbol = "[B]";
            else if (seat.getStatus() == SeatStatus.PAID) symbol = "[X]";
            else symbol = "[?]";
            row.append(String.format("%3s%-2s ", seatNum, symbol));
        }
        System.out.println(row);
    }

    private Seat findSeat(String seatNum) {
        for (Seat s : airplane.getSeats()) {
            if (s.getSeatNumber().equalsIgnoreCase(seatNum)) return s;
        }
        return null;
    }

    // ---------------- Проверка просроченных броней ----------------
    public void checkExpiredBookings() {
        LocalDateTime now = LocalDateTime.now();
        boolean updated = false;
        for (Seat seat : airplane.getSeats()) {
            if (seat.getStatus() == SeatStatus.BOOKED && seat.isBookingExpired()) {
                seat.setStatus(SeatStatus.FREE);
                seat.setBooked(false);
                seat.setPassenger(null);
                seat.setBookingTime(null);
                updated = true;
                System.out.println("Booking expired for seat " + seat.getSeatNumber());
            }
        }
        if (updated) DataManager.saveData(airplane);
    }

    // ---------------- Бронирование ----------------
    public void bookSeat(Scanner scanner) {
        System.out.print("Enter seat number (e.g., 1A): ");
        String seatNum = scanner.nextLine().trim().toUpperCase();
        Seat seat = findSeat(seatNum);
        if (seat == null) {
            System.out.println("Seat not found!");
            return;
        }
        if (seat.isBooked() || seat.getStatus() == SeatStatus.PAID) {
            System.out.println("Seat already booked or paid!");
            return;
        }

        System.out.print("Enter passenger full name: ");
        String fullName = scanner.nextLine();

        seat.setBooked(true);
        seat.setPassenger(new Passenger(fullName));
        seat.setStatus(SeatStatus.BOOKED);
        seat.setBookingTime(LocalDateTime.now());

        DataManager.saveData(airplane); // сохраняем после брони
        System.out.println("Seat " + seatNum + " booked for " + fullName + " (24 minutes to pay)");
    }

    // ---------------- Отмена брони ----------------
    public void cancelBooking(Scanner scanner) {
        System.out.print("Enter seat number to cancel: ");
        String seatNum = scanner.nextLine().trim().toUpperCase();
        Seat seat = findSeat(seatNum);
        if (seat == null || !seat.isBooked()) {
            System.out.println("Seat not booked or not found!");
            return;
        }

        seat.setBooked(false);
        seat.setPassenger(null);
        seat.setStatus(SeatStatus.FREE);
        seat.setBookingTime(null);

        DataManager.saveData(airplane); // сохраняем
        System.out.println("Booking for seat " + seatNum + " cancelled.");
    }

    // ---------------- ОПЛАТА МЕСТА ----------------
    public void payForSeat(Scanner scanner) {
        System.out.println("\n===== PAYMENT MENU =====");
        System.out.println("1. Instant buy (direct payment for free seat)");
        System.out.println("2. Pay for booking (for already booked seat)");
        System.out.print("→ ");
        String paymentType = scanner.nextLine().trim();

        if (!paymentType.equals("1") && !paymentType.equals("2")) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine().trim().toUpperCase();
        Seat seat = findSeat(seatNum);

        if (seat == null) {
            System.out.println("Seat not found!");
            return;
        }

        // Проверяем, не истекла ли бронь
        if (seat.getStatus() == SeatStatus.BOOKED && seat.isBookingExpired()) {
            System.out.println("Booking expired! Seat is now free.");
            seat.setStatus(SeatStatus.FREE);
            seat.setBooked(false);
            seat.setPassenger(null);
            seat.setBookingTime(null);
        }

        // Общая проверка: если место уже куплено, нельзя платить снова
        if (seat.getStatus() == SeatStatus.PAID) {
            System.out.println("This seat is already paid and cannot be purchased again!");
            return;
        }

        // Instant buy
        if (paymentType.equals("1")) {
            if (seat.getStatus() == SeatStatus.BOOKED) {
                System.out.println("This seat is booked by someone else. Choose 'Pay for booking' instead.");
                return;
            }

            System.out.print("Enter your full name: ");
            String fullName = scanner.nextLine().trim();

            System.out.print("Enter card number (16 digits, simulated): ");
            String card = scanner.nextLine().trim();
            if (card.length() != 16) {
                System.out.println("Invalid card number!");
                return;
            }

            Passenger buyer = new Passenger(fullName);
            seat.instantBuy(buyer);
            System.out.println("Seat " + seatNum + " successfully purchased!");
            DataManager.saveData(airplane);

        } else if (paymentType.equals("2")) { // Pay for booking
            if (seat.getStatus() != SeatStatus.BOOKED) {
                System.out.println("Seat is not booked or already paid!");
                return;
            }

            System.out.print("Enter card number (16 digits, simulated): ");
            String card = scanner.nextLine().trim();
            if (card.length() != 16) {
                System.out.println("Invalid card number!");
                return;
            }

            seat.payForBooking();
            System.out.println("Seat " + seatNum + " successfully purchased!");
            DataManager.saveData(airplane);
        }
    }

    // ---------------- Информация о месте ----------------
    public void showSeatInfo(Scanner scanner) {
        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine().trim().toUpperCase();
        Seat seat = findSeat(seatNum);
        if (seat == null) {
            System.out.println("Seat not found.");
            return;
        }

        System.out.println(seat);
        if (seat.isBooked() && seat.getPassenger() != null && seat.getBookingTime() != null) {
            System.out.println("Passenger: " + seat.getPassenger().getFullName());
            System.out.println("Booking time: " + seat.getBookingTime().format(dtf));
        }
    }
}
