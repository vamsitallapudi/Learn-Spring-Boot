package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class TestJdbcConn {
	
	private static Logger logger = Logger.getLogger(TestJdbcConn.class);
	static {
//		create layout obj
		SimpleLayout layout = new SimpleLayout();
//		create appender object having layout obj
		ConsoleAppender appender = new ConsoleAppender(layout);
//		add appender to logger obj
		logger.addAppender(appender);
//		logger level to retrieve log message
		logger.setLevel(Level.DEBUG);
	}
	
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			if(con != null) {
				st = con.createStatement();
			}
			if(st!= null)
				 rs = st.executeQuery("SELECT * FROM STUDENT");
			rs.first();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}
	}
}
