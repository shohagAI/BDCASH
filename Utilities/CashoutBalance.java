package bd.edu.seu.bdcash.Utilities;

import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CashoutBalance {


    public static void insert(CashOut cashOut){

        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="insert into cashout2 values('"+cashOut.getUserNuumber()+"',"+cashOut.getCustomernumber()+",'"+cashOut.getAmount()+"');";
            statement.execute(querry);
        }catch (
                SQLException ex){
            ex.printStackTrace();
            System.err.println("can not connect database.");
        }

    }



    public List<CashOut> getUserList(String mobailNumber){
        List<CashOut> cashOutList=new ArrayList<>();
        try{
            Connection connection=ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from cashout2 where  userNumber='"+mobailNumber+"';";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String userNumber=resultSet.getString("userNumber");
                String CustomerNumber=resultSet.getString("customerNumber");
                double amount=resultSet.getDouble("amount");

                CashOut cashOut=new CashOut(userNumber,CustomerNumber,amount);
                cashOutList.add(cashOut);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return cashOutList;
    }

    public  double getCashOutBalance(String number){
        List<CashOut> cashOutList=getUserList(number);
        double sum=0;
        for (CashOut cashOut : cashOutList) {
            sum=sum+cashOut.getAmount();
        }
        return sum;
    }
}
