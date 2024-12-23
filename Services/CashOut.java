package bd.edu.seu.bdcash.Services;

public class CashOut {
    private String userNuumber;
    private  String customernumber;
    private double amount;
    public CashOut(){

    }

    public CashOut(String userNuumber, String customernumber, double amount) {
        this.userNuumber = userNuumber;
        this.customernumber = customernumber;
        this.amount = amount;
    }

    public String getUserNuumber() {
        return userNuumber;
    }

    public void setUserNuumber(String userNuumber) {
        this.userNuumber = userNuumber;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
