package model.bo;

import model.bean.ImportExport;
import model.dao.ImportExportDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ImportExportBO {
    private ImportExportDAO importExportDAO = new ImportExportDAO();

    // Lấy danh sách tất cả các bản ghi nhập/xuất kho
    public ArrayList<ImportExport> getAllImportExports() {
        try {
            return importExportDAO.getAllImportExports();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm bản ghi nhập kho
    public boolean addImport(ImportExport importExport) {
        try {
            importExportDAO.addImport(importExport);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin xuất kho
    public boolean updateExport(ImportExport importExport) {
        try {
            importExportDAO.updateExport(importExport);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa bản ghi nhập xuất kho
    public boolean deleteImportExport(String orderID, String warehouseID) {
        try {
            importExportDAO.deleteImportExport(orderID, warehouseID);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

