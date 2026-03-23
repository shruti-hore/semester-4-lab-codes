import java.util.*;

public class MAIN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        Customer currentCustomer = null;
        Account currentAccount = null;
        LoanAccount loanAccount = null;

        while (true) {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Accounts");
            System.out.println("5. View EMI");
            System.out.println("6. Pay EMI");
            System.out.println("7. View Loan Balance");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

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

                    currentAccount = new Account(accNum, balance, "Savings");

                    currentCustomer.addAccount(currentAccount);
                    bank.addCustomer(currentCustomer);

                    // Loan details
                    System.out.print("Enter Loan Amount: ");
                    double principal = sc.nextDouble();

                    System.out.print("Interest Rate (%): ");
                    double rate = sc.nextDouble();

                    System.out.print("Loan Tenure (months): ");
                    int tenure = sc.nextInt();
                    sc.nextLine();

                    loanAccount = new LoanAccount(
                        accNum, balance, "Loan",
                        principal, rate, 0,
                        "Home Loan", 0, "Property", tenure
                    );

                    System.out.println("Customer & Loan added successfully");
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
                    if (loanAccount == null) {
                        System.out.println("No loan found");
                        break;
                    }

                    double emi = loanAccount.calculateEMI();
                    System.out.printf("EMI: %.2f\n", emi);
                    break;

                case 6:
                    if (loanAccount == null || currentAccount == null) {
                        System.out.println("Loan or Account missing");
                        break;
                    }

                    if (loanAccount.getPrincipalAmt() <= 0) {
                        System.out.println("Loan already fully paid!");
                        break;
                    }

                    double emiPay = loanAccount.calculateEMI();

                    if (currentAccount.withdraw(emiPay)) {

                        double r = (loanAccount.getInterestRate() / 100) / 12;
                        double interest = loanAccount.getPrincipalAmt() * r;
                        double principalPaid = emiPay - interest;

                        double newPrincipal = loanAccount.getPrincipalAmt() - principalPaid;

                        if (newPrincipal < 0) newPrincipal = 0;

                        loanAccount.setPrincipalAmt(newPrincipal);

                        System.out.printf("EMI Paid: %.2f\n", emiPay);
                        System.out.printf("Remaining Loan: %.2f\n", newPrincipal);
                    }
                    break;

                case 7:
                    if (loanAccount != null) {
                        System.out.printf("Outstanding Loan: %.2f\n",
                                loanAccount.getPrincipalAmt());
                    } else {
                        System.out.println("No loan found");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}