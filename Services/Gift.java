package bd.edu.seu.bdcash.Services;

public class Gift {
    private String fromNumber;

    private String toNUmber;
    private  double amount;
    private String purposes;

    public Gift(String fromNumber, String toNUmber,double amount ,String purposes) {
        this.fromNumber = fromNumber;
        this.toNUmber = toNUmber;
        this.amount=amount;
        this.purposes = purposes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    public String getToNUmber() {
        return toNUmber;
    }

    public void setToNUmber(String toNUmber) {
        this.toNUmber = toNUmber;
    }

    public String getPurposes() {
        return purposes;
    }

    public void setPurposes(String purposes) {
        this.purposes = purposes;
    }
}
