// Experiment - 1 (Menu-Driven Calculator)

// Import 'Scanner' class for user input
import java.util.Scanner;

// Calculator class definition
public class Calculator {
    // Methods (Operations)
    // Addition
    public int addNum(int n1, int n2) {
        return n1 + n2;
    }

    // Subtraction
    public int subtractNum(int n1, int n2) {
        return n1 - n2;
    }

    // Multiplication
    public int mulNum(int n1, int n2) {
        return n1 * n2;
    }

    // Division
    public float divNum(int n1, int n2) {
        if (n2 == 0) {
            System.out.println("Division by zero not allowed");
            return 0;
        }
        return (float) n1 / n2;
    }

    // Modulus (Reminder)
    public int modNum(int n1, int n2) {
        if (n2 == 0) {
            System.out.println("Modulus by zero not allowed");
            return 0;
        }
        return n1 % n2;
    }

    // MAIN Method (program execution starts here)
    public static void main(String[] args) {
        // Calculator object to access non-static methods
        Calculator c = new Calculator();

        // Scanner object to take input from user
        Scanner scan = new Scanner(System.in);

        // Variablw to store user's menu chocie
        int ch;

        do {
            // Calculator menu
            System.out.println("Enter the operation you want to perform:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("0. Exit");

            // Read user choice
            System.out.print("Enter your choice: ");
            ch = scan.nextInt();

            // If user inputs 0 as choice ie exiting the program
            if (ch == 0) {
                System.out.println("Exiting Calculator!");
                break;
            }

            // Checking condition for invalid choice
            if (ch < 1 || ch > 5) {
                System.out.println("Invalid choice!");
                continue;
            }

            // Input numbers
            System.out.print("Enter first number: ");
            int num1 = scan.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scan.nextInt();

            // Switch Case
            switch (ch) {
                case 1:
                    System.out.println("Addition = " + c.addNum(num1, num2));
                    break;
                case 2:
                    System.out.println("Subtraction = " + c.subtractNum(num1, num2));
                    break;
                case 3:
                    System.out.println("Multiplication = " + c.mulNum(num1, num2));
                    break;
                case 4:
                    System.out.println("Division = " + c.divNum(num1, num2));
                    break;
                case 5:
                    System.out.println("Modulus (Remainder) = " + c.modNum(num1, num2));
                    break;
            }

        } while (ch != 0); // Continue until user chooses exit (0)

        // Closing scanner object
        scan.close();
    }
}


