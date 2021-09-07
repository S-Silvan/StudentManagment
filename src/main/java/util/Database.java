package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	private static Connection conn=null;
	public static Connection getConnection() {
		if(conn==null) {
			FileReader fr;
			try {
				fr = new FileReader("src/main/resources/database.properties");
				Properties properties=new Properties();
				properties.load(fr);
				Class.forName(properties.getProperty("driver_class"));
				conn=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user_name"), properties.getProperty("password"));
			} catch (IOException |ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
