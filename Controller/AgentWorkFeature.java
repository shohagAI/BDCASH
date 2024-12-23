package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashIn;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class AgentWorkFeature {
    @FXML
    ImageView agentProfileImageView;

    @FXML
    public void cashIn()throws IOException{
     HelloApplication.changedcene("cashInInformation");
        System.out.println("go to cashIn page");
    }

    @FXML
    public void backAgentLoginProfile()throws IOException {
        HelloApplication.changedcene("agentInformation");
        System.out.println("go to agent login page");
    }
    @FXML
    public void agentHistory()throws IOException{
        HelloApplication.changedcene("agentHistory");
        System.out.println("go to agent history page");

    }

}
