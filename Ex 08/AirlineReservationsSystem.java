import javax.swing.JOptionPane;

public class AirlineReservationsSystem {
    private static boolean[] seats = new boolean[10];
    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    "Please type 1 for First Class\nPlease type 2 for Economy\n\nType 'exit' to exit the system",
                    "Airline Reservations System", JOptionPane.PLAIN_MESSAGE);
            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }
            int seatType = Integer.parseInt(input);
            int seatNumber = assignSeat(seatType);
            if (seatNumber == -1) {
                JOptionPane.showMessageDialog(null,
                        "I'm sorry, the flight is full. The next flight leaves in 3 hours.", "Airline Reservations System",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String seatSection = (seatNumber <= 5) ? "First Class" : "Economy";
                JOptionPane.showMessageDialog(null,
                        "Boarding Pass:\nSeat Number: " + seatNumber + "\nSeat Section: " + seatSection,
                        "Airline Reservations System", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static int assignSeat(int seatType) {
        int seatNumber = -1;
        if (seatType == 1) { 
            seatNumber = assignFirstClassSeat();
        } else if (seatType == 2) {
            seatNumber = assignEconomySeat();
        }
        return seatNumber;
    }

    private static int assignFirstClassSeat() {
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i + 1;
            }
        }
        int answer = JOptionPane.showConfirmDialog(null,
                "The first-class section is full. Would you like to be placed in the economy section?",
                "Airline Reservations System", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            return assignEconomySeat();
        } else {
            return -1;
        }
    }

    private static int assignEconomySeat() {
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i + 1;
            }
        }
        int answer = JOptionPane.showConfirmDialog(null,
                "The economy section is full. Would you like to be placed in the first-class section?",
                "Airline Reservations System", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            return assignFirstClassSeat();
        } else {
            return -1;
        }
    }
}
