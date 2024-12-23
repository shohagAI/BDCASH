package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.AgentLogin;
import bd.edu.seu.bdcash.Services.UserLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
  @FXML

  TextField userNumberField;
  @FXML
  PasswordField userPasswordField;
  Connection connect;
  PreparedStatement prepare;
  ResultSet result;
  Alert alert;
  public static String user="";
  @FXML
  public void userLogin()throws IOException{

    String mobail=userNumberField.getText();
    user=mobail;

    String password=userPasswordField.getText();

    String sql="Select * from userLogin where number= ? and password= ?";
    connect= UserLogin.connectuser();
    try{
      prepare = connect.prepareStatement(sql);
      prepare.setString(1,mobail);
      prepare.setString(2,password);

      result=prepare.executeQuery();

      if(mobail.isEmpty() || password.isEmpty()){
        alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error massage");
        alert.setHeaderText(null);
        alert.setContentText("Empty enter");
        alert.showAndWait();
      }else{
        if(result.next()){
          alert=new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Information massage");
          alert.setHeaderText(null);
          alert.setContentText("Succesfully Login");
          HelloApplication.changedcene("userWorkFeatureInformation");
          // alert.showAndWait();
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
    public void goToHomeFromUser()throws IOException {
      HelloApplication.changedcene("homeInformation");
      System.out.println("go to hhome page");
  }
  @FXML
  public void forSignUp()throws IOException{
    HelloApplication.changedcene("signUpInformation");
    System.out.println("Go to SignUp page");
  }

}
