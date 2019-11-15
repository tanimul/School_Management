import java.sql.*;
import javax.swing.JOptionPane;
     
public class PrintAllResult  {

  void print() {
      
    String url = "org.sqlite.JDBC";
    Connection con;
    String query = "select * from Sresult";
    Statement stmt;
  
    try {
      Class.forName("org.sqlite.JDBC");
  
    } catch(java.lang.ClassNotFoundException e) {
      System.err.print("ClassNotFoundException: "); 
      System.err.println(e.getMessage());
    }

    try {
      con = DriverManager.getConnection("jdbc:sqlite:Database//school.sqlite");
  
      stmt = con.createStatement();              
  
      ResultSet rs = stmt.executeQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();
 
      System.out.println("");
  
      int numberOfColumns = rsmd.getColumnCount();
  
      for (int i = 1; i <= numberOfColumns; i++) {
        if (i > 1) System.out.print(",  ");
        String columnName = rsmd.getColumnName(i);
        System.out.print(columnName);
      }
      System.out.println("");
  
      while (rs.next()) {
        for (int i = 1; i <= numberOfColumns; i++) {
          if (i > 1)  System.out.print(",  ");
          String columnValue = rs.getString(i);
           System.out.print(columnValue);
        }
         System.out.println("");  
      }
  
      stmt.close();
      con.close();
    } catch(SQLException ex) {
      System.err.print("Exception: ");
      System.err.println(ex.getMessage());
    }  
  }
}


