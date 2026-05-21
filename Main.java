import java.util.Scanner;
class Wallet {

    private double balance;  //encapsulated variable

    static double cashbackRate = 0.02; // Static variable (shared by all wallets)

    Wallet() {  // Constructor to initialize balance
        balance = 0;
    }

    // Getter method
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;

            System.out.println("Money Deposited Successfully");
        }else {
            System.out.println("Invalid Amount");
        }
    }
    public void transfer(Wallet receiver, double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            receiver.balance = receiver.balance + amount;
            double cashback = amount * cashbackRate;
            balance = balance + cashback;

            System.out.println("Transfer Successful");
            System.out.println("Cashback Received: " + cashback);
        }else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Wallet user1 = new Wallet();
        Wallet user2 = new Wallet();
        int choice;
        do {
            System.out.println("\nDigital Wallet System");

            System.out.println("1. Deposit Money");
            System.out.println("2. Transfer Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    user1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter Transfer Amount: ");
                    double transferAmount = sc.nextDouble();
                    user1.transfer(user2, transferAmount);
                    break;
                case 3:
                    System.out.println("User1 Balance: "
                    + user1.getBalance());
                    System.out.println("User2 Balance: "
                    + user2.getBalance());
                    break;
                case 4:
                    System.out.println("Project Closing...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice !=4);
    }
}
