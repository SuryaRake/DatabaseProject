package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Admin");
        
        Statement stm = con.createStatement();
      stm.executeUpdate("insert into eproduct(name,price,date_added)values('Tablet', 15000.79, now())");//insert query
      
        
        stm.executeUpdate("delete from eproduct where ID =10;"); // delete query
       // stm.executeUpdate("update eproduct set name = 'GamePlayer' where ID =7;");// update query
        
        ResultSet result = stm.executeQuery("select * from eproduct"); // to execute select query
        
        while(result.next()) {
            
            System.out.print(result.getInt("ID"));
           System.out.print(result.getString("name"));
           System.out.print(result.getFloat("price"));
           System.out.println(result.getTimestamp("date_added"));
            
        }


	}

}
