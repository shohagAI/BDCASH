package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.Gift;
import bd.edu.seu.bdcash.Utilities.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GiftController implements Initializable {

    @FXML
    TextField FromNumber;
    @FXML
    TextField toNumber;
    @FXML
    TextField numberField;
    @FXML
    TextArea PurposeOgGiftComment;
    @FXML
    Label GiftShowLabel;
    double  userBalance;
   Alert alert;
    @FXML
    public void GiftSendButton(){
        String Fromnumber=FromNumber.getText();
        String ToNumber=toNumber.getText();
        double amount=Double.parseDouble(numberField.getText());
        String purposes=PurposeOgGiftComment.getText();
        Gift gift=new Gift(Fromnumber,ToNumber,amount,purposes);
        if(UserWorkFeature.userBalance<amount){

            alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText(null);
            alert.setContentText("You have no safficiant balance");
            alert.showAndWait();

        }else{
            GiftBalance.insert(gift);


        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FromNumber.setText(UserController.user);


    }
    @FXML
    public void GoftTogoHome()throws IOException {
        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("Go to home");
    }
}
