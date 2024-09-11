package fee.management.system;

import java.sql.*; 

public class dbconnection {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
