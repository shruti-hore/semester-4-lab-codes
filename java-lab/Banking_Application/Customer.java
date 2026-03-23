import java.util.*;

public class Customer {
    private String cusID;
    private String name;
    private String PAN;
    private String aadhar;
    private String addressProof;
    private String DOB;
    private List<Account> accounts;

    // constructor
    public Customer (String cusID, String name, String PAN, String aadhar, 
                    String addressProof, String DOB) {
        this.cusID = cusID;
        this.name = name;
        this.PAN = PAN;
        this.aadhar = aadhar;
        this.addressProof = addressProof;
        this.DOB = DOB;
        this.accounts = new ArrayList<>();
    }

    // add account
    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    // view account
    public void viewAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
