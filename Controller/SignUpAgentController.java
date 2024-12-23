package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.SignUp;
import bd.edu.seu.bdcash.Services.SignUpAgent;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpAgentController {

  @FXML
    TextField SignUpAgentBumberField;
  @FXML
    PasswordField signupPaswwordField;
  @FXML
  PasswordField confirmSignupPassField;
  Alert alert;
  @FXML
    public void signUpAgentButton()throws IOException{
       String number=SignUpAgentBumberField.getText();
       String firstPAssword= signupPaswwordField.getText();
       String confirmPassword=confirmSignupPassField.getText();
      SignUpAgent signUpAgent=new SignUpAgent(number,firstPAssword);

      if(signUpAgent.getPassword().equals(confirmPassword)){
          alert=new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Information massage");
          alert.setHeaderText(null);
          alert.setContentText("Succesfully SignUp");
          insertFXAgentReg(signUpAgent);
          HelloApplication.changedcene("homeInformation");
          alert.showAndWait();
      }else{

          alert=new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Information massage");
          alert.setHeaderText(null);
          alert.setContentText("Not match password");
          HelloApplication.changedcene("homeInformation");
          alert.showAndWait();

      }


    }


    public void insertFXAgentReg(SignUpAgent signUpAgent) {
        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="Insert into agentlogin values('"+signUpAgent.getNumber()+"','"+signUpAgent.getPassword()+"')";
            statement.execute(querry);
        }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("Failed to connect databases.");        }
    }

    @FXML
    public void signUpAgentToHome()throws IOException {
        HelloApplication.changedcene("homeInformation");
        System.out.println("Go to HomePage");
    }

}
