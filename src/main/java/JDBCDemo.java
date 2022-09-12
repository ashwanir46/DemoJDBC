import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/carsales";
            String user = "root";
            String pass = "admin";
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                System.out.println("connection success");
                //statement
                Statement st = connection.createStatement();
                String sql = "Insert into salepersondetails values (1010, 'Ashwani', 'India', 9);";
                int rows = st.executeUpdate(sql);
                if (rows == 1) {
                    System.out.println("data inserted");
                } else {
                    System.out.println("data not inserted");
                }
            } else {
                System.out.println("connection not connected");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
