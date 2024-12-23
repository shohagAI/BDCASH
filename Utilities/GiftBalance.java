package bd.edu.seu.bdcash.Utilities;

import bd.edu.seu.bdcash.Services.Gift;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GiftBalance {

    public static void insert(Gift gift){

        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="insert into gift values('"+gift.getFromNumber()+"','"+gift.getToNUmber()+"',"+gift.getAmount()+",'"+gift.getPurposes()+"');";

            statement.execute(querry);
        }catch (
                SQLException ex){
            ex.printStackTrace();
            System.err.println("can not connect database.");
        }


    }




    public List<Gift> getList(String mobailNumber){
        List<Gift> giftList=new ArrayList<>();
        try{
            Connection connection=ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from gift where FromNumber='"+mobailNumber+"';";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String fromNumber=resultSet.getString("FromNumber");
                String toNumber=resultSet.getString("ToNumber");
                double amount=resultSet.getDouble("amount");
                String purpose=resultSet.getString("purposes");

                Gift gift=new Gift(fromNumber,toNumber,amount,purpose);
                giftList.add(gift);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return giftList;
    }


    public double totalgiftgetBalance(String number){
        List<Gift> giftList=getList(number);
        double sum=0;
        for (Gift gift : giftList) {
            sum=sum+gift.getAmount();

        }
        return sum;
    }



}
