package model.bo;

import model.bean.Product;
import model.dao.ProductDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBO {
    private ProductDAO productDAO = new ProductDAO();

   /* // Lấy danh sách các sản phẩm theo UserID
    public ArrayList<Product> getProductsByUserID(String userID) throws SQLException {
        try {
            return productDAO.getProductsByUserID(userID); // Gọi phương thức từ ProductDAO
        } catch (SQLException e) {
            // Xử lý lỗi nếu cần thiết
            System.err.println("Error while fetching products for UserID " + userID + ": " + e.getMessage());
            // Ném lại ngoại lệ để có thể xử lý tại nơi gọi
            throw e;
        }
    } */
   // Lấy danh sách các sản phẩm theo UserID
   public ArrayList<Product> getProductsByUserID(String userID) {
       try {
           return productDAO.getProductsByUserID(userID);
       } catch (Exception e) {
           System.err.println("Lỗi trong BO khi lấy danh sách sản phẩm theo UserID: " + e.getMessage());
           e.printStackTrace();
           return new ArrayList<>(); // Trả về danh sách rỗng nếu xảy ra lỗi
       }
   }

   // Lấy danh sách tất cả chi tiết đơn hàng
    public ArrayList<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm chi tiết đơn hàng mới
    public boolean addProduct(Product product) {
        try {
            productDAO.addProduct(product);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

