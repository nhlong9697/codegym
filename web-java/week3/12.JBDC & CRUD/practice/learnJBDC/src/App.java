import com.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
  public static void main(String[] args) {
    Connection connection = null;
    try {
      connection = ConnectionConfiguration.getConnection();
      if (connection != null) {
        System.out.println("connected");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException exception) {
          exception.printStackTrace();
        }
      }
    }
  }
}
