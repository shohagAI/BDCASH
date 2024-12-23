package bd.edu.seu.bdcash.Primary;

import bd.edu.seu.bdcash.Controller.UserController;
import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.Gift;
import bd.edu.seu.bdcash.Services.Reacharge;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GiftHistory implements Initializable {


    @FXML
    TableView<Gift> giftTableView;
    @FXML
    TableColumn<Gift, String> gnumberColoum;

    @FXML
    TableColumn<Gift, Number> gAmountColoum;

    @FXML
    TableColumn<Gift, String> gPurposeColoum;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gnumberColoum.setCellValueFactory(s->new SimpleStringProperty(s.getValue().getToNUmber()));
        gAmountColoum.setCellValueFactory(s->new SimpleDoubleProperty(s.getValue().getAmount()));
        gPurposeColoum.setCellValueFactory(s->new SimpleStringProperty(s.getValue().getPurposes()));

        ObservableList<Gift> giftObservableList= FXCollections.observableArrayList();
        giftTableView.setItems(giftObservableList);
        List<Gift> list=read(UserController.user);
        giftObservableList.addAll(list);

    }

    public List<Gift> read(String number){
        List<Gift> giftList=new ArrayList<>();
     try{

         Connection connection= ConnectionSingleton.getConnection();
         Statement statement=connection.createStatement();
         String querry="Select * from gift where FromNumber="+number+";";
         ResultSet resultSet=statement.executeQuery(querry);
         while (resultSet.next()){
             String fromNumber=resultSet.getString("FromNumber");
             String toNumber=resultSet.getString("ToNumber");
             double amount=resultSet.getDouble("amount");
             String purpose=resultSet.getString("purposes");
             Gift gift=new Gift(fromNumber,toNumber,amount,purpose);
             giftList.add(gift);
         }
     }catch (SQLException ex){
         ex.printStackTrace();
         System.err.println("Failled to connect database");
     }
     return  giftList;

    }
    public void goHomeFromGiftHistory()throws IOException {

        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("back home");
    }


}
