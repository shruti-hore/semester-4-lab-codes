class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accNum, double balance, String accType, double interestRate) {
        super(accNum, balance, accType);
        this.interestRate = interestRate;
    }
}