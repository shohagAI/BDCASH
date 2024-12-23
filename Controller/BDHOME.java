package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class BDHOME {

@FXML
public void  goToUserLogingPage()throws IOException{
    HelloApplication.changedcene("userInformation");
    System.out.println("go to user page");
}


    @FXML
    public void goToAgentLoginPage()throws IOException{
        HelloApplication.changedcene("agentInformation");
        System.out.println("go to user page");
    }
 @FXML
    public void ExitFromBDCASH(){
        Alert alert=new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Massage");
        alert.setContentText("Succesfully exit");
        alert.showAndWait();

    }
}
