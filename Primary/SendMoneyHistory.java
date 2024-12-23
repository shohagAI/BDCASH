package bd.edu.seu.bdcash.Primary;

import bd.edu.seu.bdcash.Controller.UserController;
import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Services.SendMoney;
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

public class SendMoneyHistory implements Initializable {



    @FXML
    TableView<SendMoney> sendMoneyTableViewField;
    @FXML
    TableColumn<SendMoney, String> sNumberColoum;
    @FXML
    TableColumn<SendMoney,Number> sAmountColoum;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sNumberColoum.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCustomerNumber()));
        sAmountColoum.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getAmount()));

        ObservableList<SendMoney> sendMoneyObservableListList= FXCollections.observableArrayList();
        sendMoneyTableViewField.setItems(sendMoneyObservableListList);

        List<SendMoney> list = read(UserController.user);
        sendMoneyObservableListList.addAll(list);


    }

    public List<SendMoney> read(String number) {
        List<SendMoney> sendMoneyList= new ArrayList<>();;
        try {

            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String querry = "select * from sendMoney where usermobaile='"+number+"';";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()) {
                String userNumber = resultSet.getString("usermobaile");
                String customerNumber = resultSet.getString("customermobaile");
                double amount = resultSet.getDouble("amount");
                SendMoney sendmoney= new SendMoney(userNumber, customerNumber, amount);
                sendMoneyList.add(sendmoney);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Filled to connect");
        }
        return sendMoneyList;

    }

    public void GotoHomePage()throws IOException {
        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("Go to home page");
    }
}
