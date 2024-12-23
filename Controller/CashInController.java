package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashIn;
import bd.edu.seu.bdcash.Utilities.CashoutBalance;
import bd.edu.seu.bdcash.Utilities.EachOfAccountBalance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CashInController implements Initializable {

    @FXML
    ImageView cashinImageField;
    @FXML
    TextField cashAmount;
    @FXML
    TextField wonAgentField;
    @FXML
    TextField agentMobailNumber;
    @FXML
    Label cashSuccesShow;
    public static String agentNumber;
    @FXML
    Label totalCashiInThisNumber;

    @FXML
    public void successCashin(){
       String wonNumber=wonAgentField.getText();

        String customerNumber=agentMobailNumber.getText();
        agentNumber=customerNumber;

        double amount=Double.parseDouble(cashAmount.getText());

        cashSuccesShow.setText("Succesfully cashin="+amount);
        CashIn cashIn=new CashIn(wonNumber,customerNumber,amount);
       EachOfAccountBalance.insertFx(cashIn);

    }


  public static double  agentCashInAmount;


  EachOfAccountBalance eachOfAccountBalance=new EachOfAccountBalance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wonAgentField.setText(AgentController.agentUser);

       // agentCashInAmount= eachOfAccountBalance.cashInGetBalance(agentNumber);//getBalance(agentNumber);
       // System.out.println(agentNumber+ " " + agentCashInAmount);

       // EachOfAccountBalance eachOfAccountBalance1 =  new EachOfAccountBalance();
       // double totalCashIn = eachOfAccountBalance1.cashInGetBalance(agentNumber);

       // CashoutBalance balance = new CashoutBalance();
      //  double totalCashOut = balance.getCashOutBalance(agentNumber);

      //  double agentBalance = totalCashIn- totalCashOut;
       // totalCashiInThisNumber.setText(agentBalance + "");


    }
    @FXML
    public void agentToHomeButton()throws IOException {
        HelloApplication.changedcene("agentWorkFeatureInformation");
        System.out.println("go to agent home page");
    }
}
