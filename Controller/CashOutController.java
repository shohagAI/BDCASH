package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import bd.edu.seu.bdcash.Utilities.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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

public class CashOutController implements Initializable {
    @FXML
    TextField userNumberFoeld;
@FXML
TextField customerNumberField;

@FXML
TextField cashOutAmountField;
@FXML
    Label accountBalaced;
@FXML
Label succesFullyCashOut;
public static String userNumber;
Alert alert;

    double userBalance;
 @FXML
    public void cashOut(){
      userNumber=userNumberFoeld.getText();
     String CustomerNumber=customerNumberField.getText();
     double amount=Double.parseDouble(cashOutAmountField.getText());
     succesFullyCashOut.setText("Succesfully CashOut: "+amount);
     CashOut cashOut=new CashOut(userNumber,CustomerNumber,amount);
     if(UserWorkFeature.userBalance<amount){
         alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("some thing wrong");
         alert.setHeaderText(null);
         alert.setContentText("You have no safficiant balance");
         alert.showAndWait();
     } else if(amount>20000) {
         alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("some thing wrong");
         alert.setHeaderText(null);
         alert.setContentText("Cann't cashout gater than 20000tk one times");
         alert.showAndWait();

     }else if(amount<50){
         alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("some thing wrong");
         alert.setHeaderText(null);
         alert.setContentText("Less than 50 taka.\n Amount limit increase and cashout");
         alert.showAndWait();

     }else{
         CashoutBalance.insert(cashOut);
     }


 }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println(UserController.user);

        userNumberFoeld.setText(UserController.user);


    }




  @FXML
    public void cashOutToHome()throws IOException {
        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("go to home page");
    }

}
