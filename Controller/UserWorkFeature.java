package bd.edu.seu.bdcash.Controller;

import bd.edu.seu.bdcash.HelloApplication;
import bd.edu.seu.bdcash.Utilities.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class UserWorkFeature {
    @FXML
    ImageView userActivitiesPannelImage;
    @FXML
    Label currentBalance;
    public static double profit;
   public static double userBalance;
    @FXML
    public void yourTotalBalance(){

        EachOfAccountBalance eachOfAccountBalance1 =  new EachOfAccountBalance();
        double totalCashIn = eachOfAccountBalance1.cashInGetBalance(UserController.user);
      //  System.out.println("Cashin = "+totalCashIn);

        CashoutBalance cashoutBalance =  new CashoutBalance();
        double totalCasoutBalance=cashoutBalance.getCashOutBalance(UserController.user);
       // System.out.println(totalCasoutBalance);
        profit=(totalCasoutBalance*0.10);


        SendMoneyBalance sendMoneyBalance=new SendMoneyBalance();
        double  totalSendbalance= sendMoneyBalance.getSendMoneyBalance(UserController.user);
       // System.out.println(totalSendbalance);

        ReachargeBalance reachargeBalance=new ReachargeBalance();
        double totalReacharge=reachargeBalance.getReachargeBalance(UserController.user);
       // System.out.println(totalReacharge);

        GiftBalance giftBalance=new GiftBalance();
        double totalGiftBalance=giftBalance.totalgiftgetBalance(UserController.user);
       // System.out.println(totalGiftBalance);

        userBalance = (totalCashIn -totalCasoutBalance-totalSendbalance-totalReacharge-totalGiftBalance);
        System.out.println("user balance after all= "+userBalance);
        currentBalance.setText(userBalance+" Taka");
        System.out.println("Total Profit = "+profit);

    }

    @FXML
    public void CashOutButton()throws IOException {
        HelloApplication.changedcene("cashOutInformation");
        System.out.println("go to cashout Page page");

    }

    @FXML
    public void sendMoneyButton()throws IOException{
        HelloApplication.changedcene("SendMoneyInformation");
        System.out.println("Go to sendMoney page");
    }

    @FXML
    public void goToRechargePage()throws IOException{
        HelloApplication.changedcene("reachargeInformation");
        System.out.println("Go to Reacharge page");
    }

    @FXML
    public void exitFromUserPage()throws IOException{
        HelloApplication.changedcene("homeInformation");
        System.out.println("Go to Reacharge page");
    }
    public void UserHistoryButton()throws IOException{
        HelloApplication.changedcene("userHistoryInformation");
        System.out.println("Go to User History page");

    }

    @FXML
    public void gotoGiftPage()throws IOException{
        HelloApplication.changedcene("giftInformation");
        System.out.println("go to gift page");
    }


}
