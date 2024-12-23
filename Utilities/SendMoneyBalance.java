package bd.edu.seu.bdcash.Utilities;

import bd.edu.seu.bdcash.Services.SendMoney;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SendMoneyBalance {

    public static void insert(SendMoney sendMoney){

        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="insert into sendmoney values('"+sendMoney.getUserNumber()+"',"+sendMoney.getCustomerNumber()+",'"+sendMoney.getAmount()+"');";
            statement.execute(querry);
        }catch (
                SQLException ex){
            ex.printStackTrace();
            System.err.println("can not connect database.");
        }

    }




    //........read.........


    public List<SendMoney> getUserList(String mobailNumber){
        List<SendMoney>  sendMoneyList=new ArrayList<>();
        try{
            Connection connection=ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from sendmoney where  usermobaile='"+mobailNumber+"';";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String userNumber=resultSet.getString("usermobaile");
                String CustomerNumber=resultSet.getString("customermobaile");
                double amount=resultSet.getDouble("amount");

                SendMoney sendMoney=new SendMoney(userNumber,CustomerNumber,amount);
                sendMoneyList.add(sendMoney);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return sendMoneyList;
    }

    public double getSendMoneyBalance(String number){
        List<SendMoney> sendMoneyList=getUserList(number);
        double sum=0;
        for (SendMoney sendMoney : sendMoneyList) {
            sum=sum+sendMoney.getAmount();
        }
        return sum;
    }

}
