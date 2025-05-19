import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double balance = 0;
        boolean isRunning = true;
        int choice;

        // Display Menu
        while (isRunning) {
            System.out.println("\n***************");
            System.out.println("Banking Program");
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");
            System.out.print("Enter your choice (1-4): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> showBalance(balance);
                    case 2 -> balance += deposit();
                    case 3 -> balance -= withdraw(balance);
                    case 4 -> isRunning = false;
                    default -> System.out.println("INVALID CHOICE");
                }
            } else {
                System.out.println("Please enter a valid number (1-4).");
                scanner.next(); // clear invalid input
            }
        }

        System.out.println("***************************");
        System.out.println("Thank you! Have a nice day!");
        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.println("***************");
        System.out.printf("Current Balance: $%.2f\n", balance);
        System.out.println("***************");
    }

    static double deposit() {
        double amount;

        while (true) {
            System.out.print("Enter the amount to be deposited: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    return amount;
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
    }

    static double withdraw(double balance) {
        double amount;

        while (true) {
            System.out.print("Enter the amount to be withdrawn: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount can't be negative.");
                    return 0;
                } else if (amount > balance) {
                    System.out.println("INSUFFICIENT FUNDS.");
                    return 0;
                } else {
                    return amount;
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
    }
}
