package lessons.lessons6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightService service = new FlightService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AIRLINE BOOKING SYSTEM =====");
            System.out.println("1. Show airplane map");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. Seat information");
            System.out.println("5. Exit");
            System.out.print("→ ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.showAllSeats();
                    break;
                case "2":
                    service.bookSeat();
                    break;
                case "3":
                    service.cancelBooking();
                    break;
                case "4":
                    service.showSeatInfo();
                    break;
                case "5":
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
