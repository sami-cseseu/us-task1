import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection connection;

	public ResultSet saveEmailWithOptions(String email, String options) throws SQLException {
		if(email == null) {
			return null;
		}
		
		ResultSet newsLetter = checkUniEmailAndSave(email);
		if(newsLetter == null) {
			return null;
		}
		
		validateAndSaveNewsLetterOption(newsLetter, options);
		return newsLetter;
	}
	
	public ResultSet checkUniEmailAndSave(String email) throws SQLException {
		if(email.contains("upb.de")) {
			ResultSet newsLetter = saveNewsLetterEmail(email);
			return newsLetter;
		}
		
		return null;
	}
	
	private ResultSet saveNewsLetterEmail(String email) throws SQLException{
		String insert = "INSERT INTO customer(email) VALUES "+email;
		connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = connection.createStatement();
		    rs = stmt.executeQuery(insert); // sink
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	private ResultSet validateAndSaveNewsLetterOption(ResultSet newsLetter, String options) throws SQLException {
		
		if(options == null) {
			return null;
		}
		
		String insert = "INSERT INTO customer(newsletter_id, email) VALUES(?,?);";
		PreparedStatement ps = null;
		connection = null;
		try {
			ps = connection.prepareStatement(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ps.setString(1, options);
		ps.setString(1, options);
		ps.executeQuery();
		return ps.getResultSet();
	}
	
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
}
