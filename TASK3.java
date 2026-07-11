# -------------------------------
# ATM INTERFACE
# -------------------------------


import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "admin";
        String pin = "1234";

        double balance = 10000;
        String history = "";

        System.out.println("===== ATM MACHINE =====");

        System.out.print("Enter User ID: ");
        String uid = sc.nextLine();

        System.out.print("Enter PIN: ");
        String upin = sc.nextLine();

        if (!uid.equals(userId) || !upin.equals(pin)) {
            System.out.println("Invalid User ID or PIN.");
            return;
        }

        System.out.println("\nLogin Successful!");

        while (true) {

            System.out.println("\n------ ATM MENU ------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Balance");
            System.out.println("6. Quit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (history.equals("")) {
                        System.out.println("No Transactions Yet.");
                    } else {
                        System.out.println(history);
                    }
                    break;

                case 2:
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= balance) {
                        balance -= withdraw;
                        history += "Withdraw: ₹" + withdraw + "\n";
                        System.out.println("Withdrawal Successful.");
                    } else {
                        System.out.println("Insufficient Balance.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Amount to Deposit: ");
                    double deposit = sc.nextDouble();

                    balance += deposit;
                    history += "Deposit: ₹" + deposit + "\n";
                    System.out.println("Deposit Successful.");
                    break;

                case 4:
                    System.out.print("Enter Receiver Account Number: ");
                    sc.next(); // Dummy input

                    System.out.print("Enter Amount to Transfer: ");
                    double transfer = sc.nextDouble();

                    if (transfer <= balance) {
                        balance -= transfer;
                        history += "Transfer: ₹" + transfer + "\n";
                        System.out.println("Transfer Successful.");
                    } else {
                        System.out.println("Insufficient Balance.");
                    }
                    break;

                case 5:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 6:
                    System.out.println("Thank You for Using ATM.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
