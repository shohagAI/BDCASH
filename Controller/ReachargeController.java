package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.Reacharge;
import bd.edu.seu.bdcash.Utilities.CashoutBalance;
import bd.edu.seu.bdcash.Utilities.EachOfAccountBalance;
import bd.edu.seu.bdcash.Utilities.ReachargeBalance;
import bd.edu.seu.bdcash.Utilities.SendMoneyBalance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReachargeController implements Initializable {
    @FXML
    TextField ReachargeFromNumberField;
    @FXML
    TextField reachargeToNumberField;
    @FXML
    TextField ReachargeAmountField;
    @FXML
    Label curentBalanceafterReacharge;
    @FXML
            Label reacgargeShowLabel;
    double  userBalance;
    Alert alert;
    @FXML
    public void reachargeButton(){
        String FromNUmber=ReachargeFromNumberField.getText();
        String ToNumber=reachargeToNumberField.getText();
        double amount=Double.parseDouble(ReachargeAmountField.getText());
        reacgargeShowLabel.setText("succesfully Reacharge: "+amount);
        Reacharge reacharge=new Reacharge(FromNUmber,ToNumber, amount);

        if(UserWorkFeature.userBalance<amount){
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText(null);
            alert.setContentText("You have no safficiant balance");
            alert.showAndWait();
        }else {
            ReachargeBalance.insert(reacharge);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(UserController.user);
        ReachargeFromNumberField.setText(UserController.user);
        /*

        EachOfAccountBalance eachOfAccountBalance1 =  new EachOfAccountBalance();
        double totalCashIn = eachOfAccountBalance1.cashInGetBalance(UserController.user);
        System.out.println(totalCashIn);

        CashoutBalance cashoutBalance =  new CashoutBalance();
        double totalCasoutBalance=cashoutBalance.getCashOutBalance(UserController.user);
        System.out.println(totalCasoutBalance);

        SendMoneyBalance sendMoneyBalance=new SendMoneyBalance();
        double  totalSendbalance= sendMoneyBalance.getSendMoneyBalance(UserController.user);
        System.out.println(totalSendbalance);

        ReachargeBalance reachargeBalance=new ReachargeBalance();
        double totalReacharge=reachargeBalance.getReachargeBalance(UserController.user);
        System.out.println(totalReacharge);

        userBalance = totalCashIn - totalCasoutBalance-totalSendbalance-totalReacharge ;
        System.out.println("user balance after sendmoney= "+userBalance);

         */

    }

@FXML
    public void fromReachargepageToHome()throws IOException {
    HelloApplication.changedcene("userWorkFeatureInformation");
    System.out.println("go to home page");
    }
}
