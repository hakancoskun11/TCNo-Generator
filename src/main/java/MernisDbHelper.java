import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;


public class MernisDbHelper {
    private final String DB_URL = "**";
    private final String USER= "**";
    private final String PASSWORD = "**";
    String sql = "INSERT INTO prmadm.mernis values((?),'hakan','hakan','istanbul',to_date('01-DEC-78','DD-MON-RR'))";
    public void mernisInsert(String tcNo) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            PreparedStatement statement = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            System.out.println("Inserting mernis record...");
            statement.setString(1,tcNo);
            statement.executeUpdate();
            conn.commit();
            System.out.println("data committed");
            statement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
