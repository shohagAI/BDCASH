package bd.edu.seu.bdcash.Utilities;

import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;
import bd.edu.seu.bdcash.Services.CashIn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EachOfAccountBalance{

    public static void insertFx(CashIn cashIn){
        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="insert into cashin values('"+cashIn.getWonNumber()+"','"+cashIn.getCustomerNumber()+"',"+cashIn.getAmount()+");";
            statement.execute(querry);
        }catch (
                SQLException ex){
            ex.printStackTrace();
            System.err.println("can not connect database.");
        }
    }

    public List<CashIn> getList(String mobailNumber){
        List<CashIn> cashInList=new ArrayList<>();
        try{
            Connection connection=ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from cashin where userNumber='"+mobailNumber+"';";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String wonNumber=resultSet.getString("agentNumber");
                String customerNumber=resultSet.getString("userNumber");
                double amount=resultSet.getDouble("amount");

                CashIn cashIn=new CashIn(wonNumber,customerNumber,amount);
                cashInList.add(cashIn);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return cashInList;
    }


    public double cashInGetBalance(String number){
        List<CashIn> cashInList=getList(number);
        double sum=0;
        for (CashIn cashIn : cashInList) {
            sum+=cashIn.getAmount();

        }
        return sum;
    }



}
