package bd.edu.seu.bdcash.Services;

public class Reacharge {
    private String userNumber;
    private String ToNumber;
    private double amount;

    public Reacharge(){

    }

    public Reacharge(String userNumber, String toNumber, double amount) {
        this.userNumber = userNumber;
        ToNumber = toNumber;
        this.amount = amount;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getToNumber() {
        return ToNumber;
    }

    public void setToNumber(String toNumber) {
        ToNumber = toNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
