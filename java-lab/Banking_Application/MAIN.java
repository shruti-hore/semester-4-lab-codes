import java.util.*;

public class MAIN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        Customer currentCustomer = null;
        Account currentAccount = null;

        while (true) {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("PAN: ");
                    String pan = sc.nextLine();

                    System.out.print("Aadhar: ");
                    String aadhar = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("DOB: ");
                    String dob = sc.nextLine();

                    currentCustomer = new Customer(id, name, pan, aadhar, address, dob);

                    System.out.print("Account Number: ");
                    int accNum = sc.nextInt();

                    System.out.print("Initial Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    currentAccount = new Account(accNum, balance, "Savings");

                    currentCustomer.addAccount(currentAccount);
                    bank.addCustomer(currentCustomer);

                    System.out.println("Customer added successfully");
                    break;

                case 2:
                    if (currentAccount == null) {
                        System.out.println("No account found");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();

                    currentAccount.deposit(dep);
                    break;

                case 3:
                    if (currentAccount == null) {
                        System.out.println("No account found");
                        break;
                    }

                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();

                    currentAccount.withdraw(wit);
                    break;

                case 4:
                    if (currentCustomer != null) {
                        currentCustomer.viewAccounts();
                    } else {
                        System.out.println("No customers available");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}