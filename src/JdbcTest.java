import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author CraftMojo
 */

//import library

public class JdbcTest {

	public static void main(String[] args) throws SQLException {

		// definisikan connection
		Connection myConn = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;

		try {
			//get connection
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("Database sukses terhubung");
			
			//create statement
			myStatement = myConn.createStatement();
			
			//SQL Query
			myResultSet = myStatement.executeQuery("select * from employees");
			
			//Process Result Set
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("last_name") + ", " + myResultSet.getString("first_name"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// close connection
			if (myResultSet != null) {
				myResultSet.close();
			}

			if (myStatement != null) {
				myStatement.close();
			}

			if (myConn != null) {
				myConn.close();
			}

		}
	}
}


