package bd.edu.seu.bdcash.Primary;

import bd.edu.seu.bdcash.Controller.AgentController;
import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashIn;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import bd.edu.seu.bdcash.Utilities.EachOfAccountBalance;
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

public class AgentHistory implements Initializable {
    @FXML
    TableView<CashIn> agentTableView;

    @FXML
    TableColumn<CashIn,Number> amountColoum;
    @FXML
    TableColumn<CashIn,String> userNumberColoum;

 ObservableList<CashIn> observableList;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

   // AgentNumberColoum.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getWonNumber()));
    amountColoum.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getAmount()));
    userNumberColoum.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getCustomerNumber()));


        observableList= FXCollections.observableArrayList();
        agentTableView.setItems(observableList);

        List<CashIn> cashInList= readList();
        observableList.addAll(cashInList);

    }


    public List<CashIn> readList(){
        List<CashIn> cashInList=new ArrayList<>();
        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from cashin;";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String agentNumber=resultSet.getString("agentNumber");
                String usernumber=resultSet.getString("userNumber");
                double amount=resultSet.getDouble("amount");

                CashIn cashIn=new CashIn(agentNumber,usernumber,amount);
                cashInList.add(cashIn);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return cashInList;
    }

@FXML
    public void BackAgentPage()throws IOException {
        HelloApplication.changedcene("agentWorkFeatureInformation");
        System.out.println("Back");
    }
}
