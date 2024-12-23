package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.SignUp;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpController {
    @FXML
    TextField regMobailField;
    @FXML
    PasswordField regPasswordField;
    @FXML
    PasswordField ConfirmPasswordField;
    Alert alert;
  @FXML
    public void  signUpButton()throws IOException{
        String mobaile=regMobailField.getText();
        String password=regPasswordField.getText();
        String rePassword=ConfirmPasswordField.getText();

        SignUp signUp=new SignUp(mobaile,password);

         if(password.equals(rePassword)){
             alert=new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Information massage");
             alert.setHeaderText(null);
             alert.setContentText("Succesfully SignUp");
             insertFXReg(signUp);
             HelloApplication.changedcene("homeInformation");
             alert.showAndWait();
         }else {
             alert=new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Somthing wrong");
             alert.setHeaderText(null);
             alert.setContentText("password not match");
            // HelloApplication.changedcene("homeInformation");
             alert.showAndWait();

         }
    }

    public void insertFXReg(SignUp signUp) {
        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="Insert into userLogin values('"+signUp.getMobail()+"','"+signUp.getPassword()+"')";
            statement.execute(querry);
        }catch (SQLException ex){
            ex.printStackTrace();
       System.err.println("Failed to connect databases.");
        }
    }

    @FXML
    public void signUpToHome()throws IOException {
        HelloApplication.changedcene("homeInformation");
        System.out.println("Go to HomePage");
    }



}
