import java.util.Scanner;

class Wallet {
    private double balance;
    static double cashbackRate = 0.02;
    public Wallet() {
        this.balance = 0;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void transferTo(Wallet receiver, double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount entered!");
            }
            if (this.balance < amount) {
                throw new Exception("Insufficient balance!");
            }
            this.balance -= amount;
            receiver.balance += amount;
            double cashback = amount * cashbackRate;
            this.balance += cashback;
            System.out.println("Transaction successful!");
            System.out.println("Cashback received: " + cashback);
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();
        int choice;
        double amount;
        do {
            System.out.println("\nDIGITAL WALLET MENU:");
            System.out.println("1. Deposit to Wallet 1");
            System.out.println("2. Deposit to Wallet 2");
            System.out.println("3. Transfer from Wallet 1 to Wallet 2");
            System.out.println("4. Check Balances");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit in Wallet 1: ");
                    amount = sc.nextDouble();
                    w1.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit in Wallet 2: ");
                    amount = sc.nextDouble();
                    w2.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to transfer: ");
                    amount = sc.nextDouble();
                    w1.transferTo(w2, amount);
                    break;
                case 4:
                    System.out.println("Wallet 1 Balance: " + w1.getBalance());
                    System.out.println("Wallet 2 Balance: " + w2.getBalance());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again");
            }
        } while(choice != 5);
    }
}
