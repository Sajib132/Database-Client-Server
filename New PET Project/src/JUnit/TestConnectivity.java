package JUnit;


import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestConnectivity {

	@Test
	public void connectivity(){
		try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/pet", "root","sajib1432");
		} catch (SQLException e) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
}