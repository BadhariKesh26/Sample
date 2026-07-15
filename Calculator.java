import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");
        System.out.println("Choose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");

        int choice;
        while (true) {
            System.out.print("Enter choice (1-5): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 5) break;
            } else {
                sc.next(); // discard invalid token
            }
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }

        System.out.print("Enter first number: ");
        double a = readDouble(sc);

        System.out.print("Enter second number: ");
        double b = readDouble(sc);

        switch (choice) {
            case 1:
                System.out.println("Result: " + (a + b));
                break;
            case 2:
                System.out.println("Result: " + (a - b));
                break;
            case 3:
                System.out.println("Result: " + (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
            case 5:
                if (b == 0) {
                    System.out.println("Error: Modulus by zero is not allowed.");
                } else {
                    // Modulus is typically for integers. We convert to long.
                    long x = (long) a;
                    long y = (long) b;
                    System.out.println("Result: " + (x % y));
                }
                break;
            default:
                // Should never happen due to validation.
                System.out.println("Invalid operation.");
        }

        sc.close();
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
            System.out.print("Invalid number. Re-enter: ");
            sc.next(); // discard invalid token
        }
    }
}

