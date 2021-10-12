import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

public class NewsLetter {
	private static boolean SAVE_EMAIL = true;
	private static String[] NEWS_LETTER_EMILS;
	private static String NEWSLETTER_OPTIONS;

	public ResultSet checkAndSave(String email) throws SQLException, IOException{
		if(email != null && SAVE_EMAIL){
			return checkEmailAndSave(email);
		}
		return null;
	} 

	public ResultSet checkEmailAndSave(String email) throws SQLException{
		if(email != null && Arrays.asList(NEWS_LETTER_EMILS).contains(email)) {
			return setNewsLetterOptions(email);
		}
		
		return null;
	}

	public ResultSet setNewsLetterOptions(String email) throws SQLException{
		if(email != null) {
			String options = NEWSLETTER_OPTIONS;
			Database db = new Database();
			return db.saveEmailWithOptions(email, options);
		}
		return null;
	}
}
