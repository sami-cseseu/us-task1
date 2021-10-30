import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo {
	
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) throws SQLException, IOException {
		Demo task = new Demo();
		task.saveEmailtNewsLetter(null, null);
	}
	
	public void saveEmailtNewsLetter(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException{
		String email = req.getParameter("email");
		String option = req.getParameter("option");
		NewsLetter newsLetter = new NewsLetter();
		newsLetter.checkAndSave(email, option);
	}
	
}
