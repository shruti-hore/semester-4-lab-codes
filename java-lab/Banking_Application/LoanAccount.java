class LoanAccount extends Account {

    private double principalAmt;
    private double interestRate;
    private double interestAmt;
    private String loanType;
    private double penalty;
    private String collaterals;

    public LoanAccount(int accNum, double balance, String accType,
                       double principalAmt, double interestRate,
                       double interestAmt, String loanType,
                       double penalty, String collaterals) {

        super(accNum, balance, accType);

        this.principalAmt = principalAmt;
        this.interestRate = interestRate;
        this.interestAmt = interestAmt;
        this.loanType = loanType;
        this.penalty = penalty;
        this.collaterals = collaterals;
    }
}