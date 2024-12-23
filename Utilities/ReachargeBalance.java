package bd.edu.seu.bdcash.Utilities;

import bd.edu.seu.bdcash.Services.CashOut;
import bd.edu.seu.bdcash.Services.Reacharge;
import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReachargeBalance {

    public static void insert(Reacharge reacharge){

        try{
            Connection connection= ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="insert into reacharge values('"+reacharge.getUserNumber()+"',"+reacharge.getToNumber()+",'"+reacharge.getAmount()+"');";

            statement.execute(querry);
        }catch (
                SQLException ex){
            ex.printStackTrace();
            System.err.println("can not connect database.");
        }

    }



    public List<Reacharge> getUserList(String mobailNumber){
        List<Reacharge> reachargeList=new ArrayList<>();
        try{
            Connection connection=ConnectionSingleton.getConnection();
            Statement statement=connection.createStatement();
            String querry="select * from reacharge where  userMobilenumber='"+mobailNumber+"';";
            ResultSet resultSet=statement.executeQuery(querry);
            while(resultSet.next()){
                String userNumber=resultSet.getString("userMobilenumber");
                String toNumber=resultSet.getString("Tonumbernumber");
                double amount=resultSet.getDouble("amount");

                Reacharge reacharge=new Reacharge(userNumber,toNumber,amount);
                reachargeList.add(reacharge);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Faield to connect database.");
        }
        return reachargeList;
    }

    public  double getReachargeBalance(String number){
        List<Reacharge> reachargeList=getUserList(number);
        double sum=0;
        for (Reacharge reacharge : reachargeList) {
            sum=sum+reacharge.getAmount();
        }
        return sum;
    }
}
