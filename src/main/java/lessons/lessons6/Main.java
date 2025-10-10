package lessons.lessons6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Поле класса для форматирования даты и времени
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airplane loadedAirplane = DataManager.loadData();

        // --- создаем тестовые рейсы ---
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("HY101", "Kaliningrad", LocalDateTime.of(2025, 10, 15, 14, 30)));
        flights.add(new Flight("HY202", "Moscow", LocalDateTime.of(2025, 10, 16, 9, 45)));
        flights.add(new Flight("HY303", "Istanbul", LocalDateTime.of(2025, 10, 17, 20, 15)));

        // --- создаем для каждого рейса самолёт ---
        List<Airplane> airplanes = new ArrayList<>();
        if (loadedAirplane != null) {
            airplanes.add(loadedAirplane);
        }
        for (Flight flight : flights) {
            if (loadedAirplane == null || !loadedAirplane.getFlight().getFlightNumber().equals(flight.getFlightNumber())) {
                airplanes.add(new Airplane("Airbus A320", flight, new ArrayList<>()));
            }
        }

        // --- главное меню ---
        while (true) {
            System.out.println("\n===== AIRLINE BOOKING SYSTEM =====");
            System.out.println("1. SHOW FLIGHTS");
            System.out.println("2. EXIT");
            System.out.print("→ ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showFlightsMenu(scanner, airplanes);
                    break;
                case "2":
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // --- Меню с выбором рейсов ---
    private static void showFlightsMenu(Scanner scanner, List<Airplane> airplanes) {
        while (true) {
            System.out.println("\n===== AVAILABLE FLIGHTS =====");
            for (int i = 0; i < airplanes.size(); i++) {
                Flight f = airplanes.get(i).getFlight();
                System.out.printf("%d. %s → %s (%s)%n",
                    i + 1,
                    "Tashkent",
                    f.getDestination(),
                    f.getDepartureDateTime().format(dtf)); // форматируем дату
            }
            System.out.println("0. BACK TO MAIN MENU");
            System.out.print("→ ");

            String input = scanner.nextLine();

            if (input.equals("0")) return;

            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < airplanes.size()) {
                    openFlightMenu(scanner, airplanes.get(index));
                } else {
                    System.out.println("Invalid flight number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // --- Меню конкретного рейса ---
    private static void openFlightMenu(Scanner scanner, Airplane airplane) {
        FlightService service = new FlightService(airplane);

        while (true) {
            System.out.println("\n===== FLIGHT MENU =====");
            System.out.println("Flight: " + airplane.getFlight().getFlightNumber());
            System.out.println("Destination: " + airplane.getFlight().getDestination());
            System.out.println("Departure: " + airplane.getFlight().getDepartureDateTime().format(dtf)); // форматируем дату
            System.out.println("-----------------------------------");
            System.out.println("1. SHOW SEATING MAP");
            System.out.println("2. BOOK A SEAT");
            System.out.println("3. CANCEL BOOKING");
            System.out.println("4. SEAT INFORMATION");
            System.out.println("5. PAY FOR SEAT");
            System.out.println("0. BACK TO FLIGHTS");
            System.out.print("→ ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.showAllSeats();
                    break;
                case "2":
                    service.bookSeat(scanner);
                    break;
                case "3":
                    service.cancelBooking(scanner);
                    break;
                case "4":
                    service.showSeatInfo(scanner);
                    break;
                case "5":
                    service.payForSeat(scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
