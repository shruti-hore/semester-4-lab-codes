class LoanAccount extends Account {

    private double principalAmt;
    private double interestRate;
    private double interestAmt;
    private String loanType;
    private double penalty;
    private String collaterals;
    private int tenure;

    public LoanAccount(int accNum, double balance, String accType,
                       double principalAmt, double interestRate,
                       double interestAmt, String loanType,
                       double penalty, String collaterals, int tenure) {

        super(accNum, balance, accType);

        this.principalAmt = principalAmt;
        this.interestRate = interestRate;
        this.interestAmt = interestAmt;
        this.loanType = loanType;
        this.penalty = penalty;
        this.collaterals = collaterals;
        this.tenure = tenure;
    }

    public double calculateEMI() {
        double r = (this.interestRate / 100) / 12;
        int n = this.tenure;

        double emi = (this.principalAmt * r * Math.pow(1 + r, n)) 
                   / (Math.pow(1 + r, n) - 1);

        return emi;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPrincipalAmt() {
        return principalAmt;
    }

    public void setPrincipalAmt(double principalAmt) {
        this.principalAmt = principalAmt;
    }

    public void setTenure(int tenure) {   // ✅ FIXED
        this.tenure = tenure;
    }

    public int getTenure() {
        return tenure;
    }

    public void repayLoan() {

        double r = (this.interestRate / 100) / 12;
        double emi = calculateEMI();

        double remainingBalance = this.principalAmt;

        System.out.printf("EMI: %.2f\n\n", emi);

        for (int i = 1; i <= tenure; i++) {

            double interest = remainingBalance * r;
            double principalPaid = emi - interest;

            remainingBalance -= principalPaid;

            if (remainingBalance < 0) remainingBalance = 0;

            System.out.println("Month " + i);
            System.out.printf("Interest: %.2f\n", interest);
            System.out.printf("Principal Paid: %.2f\n", principalPaid);
            System.out.printf("Remaining Balance: %.2f\n\n", remainingBalance);
        }

        // final update
        this.principalAmt = 0;
    }
}