import java.sql.*;

import javax.swing.JOptionPane;
public class DbConnection {
    public static Connection connee(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conne = DriverManager.getConnection("jdbc:sqlite:Database//school.sqlite");
			JOptionPane.showMessageDialog(null, "DB connected");
			return conne;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "DB not connected");
			return null;
		}
	}
}
