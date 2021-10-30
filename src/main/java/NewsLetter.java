import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

public class NewsLetter {
	private static boolean SAVE_EMAIL = true;
	private static String[] OPTIONS = new String[] {"All", "Major"};

	public void checkAndSave(String email, String option) throws SQLException, IOException{
		if(email != null && SAVE_EMAIL){
			checkEmailAndSave(email, option);
		}
	} 

	public void checkEmailAndSave(String email, String option) throws SQLException{
		if(email != null && ! email.contains("upb.de")) {
			takeOnlyExistingOptionAndSave(email, option);
		}
	}
	
	public void takeOnlyExistingOptionAndSave(String email, String option) throws SQLException {
		option =  Arrays.asList(OPTIONS).contains(option)? option : null; 
		saveEmailWithOption(email, option);
	}
	
	public void saveEmailWithOption(String email, String option) throws SQLException {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
		saveEmailInDB(uuid, email);
		saveOptionInDB(uuid, option);
	}
	
	private void saveOptionInDB(String uuid, String option) throws SQLException {
		if(option != null) {
			Database db = new Database();
			db.saveOption(uuid, option);
		}
	}

	public void saveEmailInDB(String uuid, String email) throws SQLException{
		if(email != null) {
			Database db = new Database();
			db.saveEmail(uuid, email);
		}
	}
}
