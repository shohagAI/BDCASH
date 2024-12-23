package bd.edu.seu.bdcash.Services;

public class CashIn {
    private String wonNumber;
    private String customerNumber;
    private double amount;


    CashIn() {

    }

    public CashIn(String wonNumber, String customerNumber, double amount) {
        this.wonNumber = wonNumber;
        this.customerNumber = customerNumber;
        this.amount = amount;

    }

    public String getWonNumber() {
        return wonNumber;
    }

    public void setWonNumber(String wonNumber) {
        this.wonNumber = wonNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


