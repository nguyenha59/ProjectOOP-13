package controller;
import java.sql.*;

public class PriceTotalQuery {
    public static void main(String[] args) {
        // Thông tin kết nối
        String jdbcURL = "jdbc:mysql://localhost:3306/gvproject"; // Cập nhật host và tên database
        String dbUser = "root"; // Tên người dùng MySQL
        String dbPassword = "chaeunwoo5904"; // Mật khẩu MySQL

        String query = "SELECT * FROM PriceTotal";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Tính toán chi phí cho từng đơn hàng:");

            int[] columnWidths = {10, 10, 15, 15, 15, 15, 15, 15}; // Độ rộng cho từng cột
            String[] columnFormats = new String[columnWidths.length];
            for (int i = 0; i < columnWidths.length; i++) {
                columnFormats[i] = "%-" + columnWidths[i] + "s"; // Định dạng từng cột
            }

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf(columnFormats[i - 1], metaData.getColumnName(i));
            }
            System.out.println();

            int totalWidth = 0;
            for (int width : columnWidths) {
                totalWidth += width;
            }
            System.out.println("-".repeat(totalWidth));

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf(columnFormats[i - 1], resultSet.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


