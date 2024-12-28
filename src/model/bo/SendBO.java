package model.bo;

import model.bean.Send;
import model.dao.SendDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SendBO {
    private SendDAO sendDAO = new SendDAO();

    // Lấy tất cả các bản ghi giao hàng
    public ArrayList<Send> getAllSends() {
        try {
            return sendDAO.getAllSends();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm giao hàng mới
    public boolean addSend(Send send) {
        try {
            sendDAO.addSend(send);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật trạng thái giao hàng
    public boolean updateSend(Send send) {
        try {
            sendDAO.updateSend(send);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa giao hàng
    public boolean deleteSend(String employeeID, String orderID) {
        try {
            sendDAO.deleteSend(employeeID, orderID);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Lấy thông tin giao hàng theo OrderID
    public ArrayList<Send> getSendByOrderID(String orderID) {
        try {
            return sendDAO.getSendByOrderID(orderID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

