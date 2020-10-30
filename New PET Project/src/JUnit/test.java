package JUnit;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class test {
	
	

	@Test
	public void testGetListItemName() {
		
		assertEquals("value", setconnection("step", "value","Des"));
		
	}

	String setconnection(String table_name, String theItemName, String theItemDescription)  {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
					
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet", "root","sajib1432");
		
		java.sql.Statement stat;
		
		stat = con.createStatement(); // Creating statement 
		
		String statement = "Insert into "+ table_name +"(name, des) values('"+theItemName + "','" + theItemDescription+"')" ;
	    stat.executeUpdate(statement); // Executing Query			
		
		PreparedStatement ps = con.prepareStatement("select * from "+table_name);
		ResultSet rs = ps.executeQuery();
		
		String value1 = "";
		
		while(rs.next()) 
			value1 =  rs.getString(1);
		
		stat = con.createStatement();
		statement = "truncate "+table_name;
		stat.execute(statement);
		
		return value1;
		
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return table_name;
		}
	

}
