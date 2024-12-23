package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Services.SendMoney;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import bd.edu.seu.bdcash.Utilities.CashoutBalance;
import bd.edu.seu.bdcash.Utilities.EachOfAccountBalance;
import bd.edu.seu.bdcash.Utilities.ReachargeBalance;
import bd.edu.seu.bdcash.Utilities.SendMoneyBalance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SendMoneyController implements Initializable {
    @FXML
    TextField SendUserNumberField;
    @FXML
    TextField sendcustomerNumberField;
    @FXML
    TextField sendMoneyAmountField;
    @FXML
    Label SuccesfullySendShowButton;
    @FXML
    Label afterSentMoney;
    double  userBalance;
    Alert alert;


    @FXML
    public void sendMoneyButton(){
        String sendUserNumber=SendUserNumberField.getText();
        String customerNumber=sendcustomerNumberField.getText();
        double sendAmount=Double.parseDouble(sendMoneyAmountField.getText());
        SuccesfullySendShowButton.setText("Succesfully send : "+sendAmount);
        SendMoney sendMoney=new SendMoney(sendUserNumber,customerNumber,sendAmount);
        if(UserWorkFeature.userBalance<sendAmount){
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText(null);
            alert.setContentText("You have no safficiant balance");
            alert.showAndWait();
        }else {
            SendMoneyBalance.insert(sendMoney);
        }


    }

    @FXML
    public void sendPAgeToHome()throws IOException {
        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("go to home page");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(UserController.user);
        SendUserNumberField.setText(UserController.user);



    }


}
