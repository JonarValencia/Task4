import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String DB_URL = "jdbc:sqlite:hardware.db";

    public List<Hardware> fetchHardwareMasterlist() {
    List<Hardware> list = new ArrayList<>();
    
    try {
        Class.forName("org.sqlite.JDBC");
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT id, brand, spec, type FROM hardware_tables";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                String type = rs.getString("type");

                if (type.equalsIgnoreCase("Laptop")) {
                    list.add(new Laptop(id, brand, spec));
                } else if (type.equalsIgnoreCase("Phone")) {
                    list.add(new Phone(id, brand, spec));
                }
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("Driver not found! Add the JAR to Referenced Libraries.");
    } catch (SQLException e) {
        System.out.println("Error connecting to hardware_tables: " + e.getMessage());
    }
    return list;
}
}