import java.sql.*;

public class SQLInjectionDemo {
    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = conn.createStatement();

            // ⚠️ SQL injection
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Welcome: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
