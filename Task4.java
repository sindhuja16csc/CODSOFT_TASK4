import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void processTransaction() {
        try (Scanner scan = new Scanner(System.in)) {
            int choice;
            double amount;
            while (true) {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: Rs. " + String.format("%.2f",account.getBalance()));
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: Rs. ");
                        amount = scan.nextDouble();
                        if (amount > 0) {
                            account.deposit(amount);
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: Rs. ");
                        amount = scan.nextDouble();
                        if (amount > 0 && account.withdraw(amount)) {
                            System.out.println("Successfully Withdrawed Amount.");
                        } else {
                            System.out.println("Invalid withdrawal amount or Insufficient balance.\n Please Check the Amount Entered");
                        }
                        break;
                    case 4:
                        System.out.println("** Thank You **\n Visit Us Again \n Take Care!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance of Rs. 1000
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
