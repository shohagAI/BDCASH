package bd.edu.seu.bdcash.Services;

import javafx.fxml.FXML;

public class SendMoney {
  @FXML
    private String userNumber;
  @FXML
  private  String customerNumber;
  @FXML
    private double amount;

  public void sendMoney(){

  }

  public SendMoney(String userNumber, String customerNumber, double amount) {
    this.userNumber = userNumber;
    this.customerNumber = customerNumber;
    this.amount = amount;
  }

  public String getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
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
