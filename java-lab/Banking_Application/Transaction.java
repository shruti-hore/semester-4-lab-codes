public class Transaction {
        private String txnID;
        private String date;
        private double amount;
        private String type; // debit or credit

        public Transaction(String txnID, String date, double amount, String type) {
            this.txnID = txnID;
            this.date = date;
            this.amount = amount;
            this.type = type;
        }

        public String toString() {
            return txnID + " | " + date + " | " + amount + " | " + type;
        }
}