import java.util.Scanner;

// Class representing a Bank Account
class BankAccount {
    private double balance;
    private int pin;

    // Constructor to initialize balance and PIN
    public BankAccount(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Method to verify the entered PIN
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
        } else {
            System.out.println("Invalid amount! Deposit must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid amount! Withdrawal must be positive.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn Rs." + amount);
        }
    }
}

// Main class for ATM operations
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a sample account with ₹10,000 balance and PIN = 1234
        BankAccount userAccount = new BankAccount(10000.0, 1234);

        System.out.println("********** Welcome to the ATM **********");

        // Step 1: Ask for PIN
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();

        // Step 2: Verify PIN
        if (!userAccount.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN! Access denied.");
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n========= ATM Menu =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is Rs." + userAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs.");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.\nHave a great day!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
