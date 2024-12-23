package bd.edu.seu.bdcash.Primary;

import bd.edu.seu.bdcash.Controller.UserController;
import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Services.Reacharge;
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

public class ReachargeHistory implements Initializable {
  @FXML
    TableView<Reacharge>  reachargeTableViewField;
          @FXML
    TableColumn<Reacharge,String> rNumberColoum;
    @FXML
    TableColumn<Reacharge,Number> rAmountColoum;
    @FXML
    TableColumn<Reacharge,Number> rpurposesField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rNumberColoum.setCellValueFactory(x->new SimpleStringProperty(x.getValue().getToNumber()));
        rAmountColoum.setCellValueFactory(x->new SimpleDoubleProperty(x.getValue().getAmount()));

        ObservableList<Reacharge> reachargeObservableList= FXCollections.observableArrayList();

        List<Reacharge> list=read(UserController.user);
        reachargeObservableList.addAll(list);
        reachargeTableViewField.setItems(reachargeObservableList);


    }



    public List<Reacharge> read(String number) {
        List<Reacharge> reachargeList= new ArrayList<>();;
        try {

            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String querry = "select * from reacharge where  userMobilenumber='"+number+"';";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()) {
                String userNumber = resultSet.getString("userMobilenumber");
                String toNumber = resultSet.getString("Tonumbernumber");
                double amount = resultSet.getDouble("amount");
                Reacharge reacharge= new Reacharge(userNumber, toNumber, amount);
                reachargeList.add(reacharge);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Filled to connect");
        }
        return reachargeList;

    }
    public void GotoHomePageFromreachare()throws IOException {
        HelloApplication.changedcene("userWorkFeatureInformation");
        System.out.println("Go to home page");
    }
}
