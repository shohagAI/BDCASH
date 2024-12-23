package bd.edu.seu.bdcash.Primary;

import bd.edu.seu.bdcash.Controller.CashInController;
import bd.edu.seu.bdcash.Controller.CashOutController;
import bd.edu.seu.bdcash.Controller.UserController;
import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Services.SendMoney;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import bd.edu.seu.bdcash.Utilities.CashoutBalance;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class UserCashHistory implements Initializable {

    @FXML
    TableView<CashOut> cashOutTableView;
    @FXML
    TableColumn<CashOut,String> cNumberField;
    @FXML
    TableColumn<CashOut,Number> cAmountField;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cNumberField.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomernumber()));
        cAmountField.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getAmount()));
        ObservableList<CashOut> cashOutObservableList = FXCollections.observableArrayList();
        cashOutTableView.setItems(cashOutObservableList);

        List<CashOut> List = read(UserController.user);
        cashOutObservableList.addAll(List);

    }

    public List<CashOut> read(String number) {
        List<CashOut> cashOutList = new ArrayList<>();;
        try {

            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String querry = "select * from cashout2 where userNumber="+number+";";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()) {
                String userNumber = resultSet.getString("userNumber");
                String customerNumber = resultSet.getString("customerNumber");
                double amount = resultSet.getDouble("amount");
                CashOut cashOut = new CashOut(userNumber, customerNumber, amount);
                cashOutList.add(cashOut);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Filled to connect");
        }
        return cashOutList;

    }
    @FXML
    public void goToSendMoneyHistory()throws IOException {
        HelloApplication.changedcene("sendMoneyHistory");
        System.out.println("Go to sendmoney history");
    }
    public void reachargeHistory()throws IOException{
        HelloApplication.changedcene("rechargeHistory");
        System.out.println("go to reacharge history page");
    }
    public void GiftHistory()throws IOException{
        HelloApplication.changedcene("giftHistory");
        System.out.println("go to gift history page");
    }
}
