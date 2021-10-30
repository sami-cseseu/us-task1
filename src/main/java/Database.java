import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection connection;

	
	public ResultSet saveEmail(String id, String email) throws SQLException{
		String values = "("+id+","+email+")";
		return EmailValuesSave(values);
	}
	
	public ResultSet EmailValuesSave(String values) {
		String insert = "INSERT INTO customer(id, email) VALUES " + values;
		connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = connection.createStatement();
		    rs = stmt.executeQuery(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet saveOption(String id, String option) throws SQLException{
		String values = "("+id+","+option+")";
		return OptionValuesSave(values);
	}
	
	public ResultSet OptionValuesSave(String values) {
		String insert = "INSERT INTO newsletter_options(id, option) VALUES "+ values;
		connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = connection.createStatement();
		    rs = stmt.executeQuery(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
}
