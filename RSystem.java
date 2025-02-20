
import java.util.*;

class RSystem {
    private static Map<String, String> userDatabase = new HashMap<>();
    private static Map<String, String> reservations = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to simulate login
    private static boolean login() {
        System.out.println("=== Login Form ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
    }

    // Method to handle reservation
    private static void reserveTicket() {
        System.out.println("=== Reservation System ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        String pnr = UUID.randomUUID().toString().substring(0, 8); // Generate a unique PNR
        reservations.put(pnr, "Name: " + name + ", Train: " + trainNumber + ", Destination: " + destination + ", Date: " + date);

        System.out.println("Reservation successful! Your PNR: " + pnr);
    }

    // Method to handle ticket cancellation
    private static void cancelTicket() {
        System.out.println("=== Cancellation Form ===");
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.nextLine();

        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("Invalid PNR. No reservation found.");
        }
    }

    public static void main(String[] args) {
        // Add a default user for demonstration purposes
        userDatabase.put("admin", "password");

        System.out.println("Welcome to the Online Reservation System");

        if (login()) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        reserveTicket();
                        break;
                    case 2:
                        cancelTicket();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Online Reservation System!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
