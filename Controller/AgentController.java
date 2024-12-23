package bd.edu.seu.bdcash.Controller;


import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.AgentLogin;
import bd.edu.seu.bdcash.Services.CashIn;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentController {

    @FXML
    TextField agentMobailNumberField;
    @FXML
    PasswordField agentPasswordField;
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;
    Alert alert;
    public static String agentUser="";
    public void agentLoginField()throws IOException{

        String mobail=agentMobailNumberField.getText();
        agentUser=mobail;
        String password=agentPasswordField.getText();

        String sql="Select * from agentLogin where mobail= ? and password= ?";
       connect=AgentLogin.connectbd();
       try{
           prepare = connect.prepareStatement(sql);
           prepare.setString(1,mobail);
           prepare.setString(2,password);

          result=prepare.executeQuery();

          if(mobail.isEmpty() || password.isEmpty()){
              alert=new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error massage");
              alert.setHeaderText(null);
              alert.setContentText("Fill All the fields");
              alert.showAndWait();
          }else{
              if(result.next()){
                  alert=new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information massage");
                  alert.setHeaderText(null);
                  alert.setContentText("Succesfully Login");
                  HelloApplication.changedcene("agentWorkFeatureInformation");
              }else {
                  alert=new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Error massage");
                  alert.setHeaderText(null);
                  alert.setContentText("wrong password \n try again");
                  alert.showAndWait();

              }
          }
       }catch (SQLException ex){
           ex.printStackTrace();
       }



    }




@FXML
    public void goToHomePageFromAgentpage()throws IOException {
    HelloApplication.changedcene("homeInformation");
    System.out.println("go to home page");
}
@FXML
    public void goToSignUpAgentPage()throws IOException{
    HelloApplication.changedcene("signUpAgentInformation");
    System.out.println("go to SignUp agent page");

}


}
