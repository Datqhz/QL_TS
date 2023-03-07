package com.nhom13.Component;

import com.nhom13.DAO.KhuyenMaiDAO;
import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.Dialog.Feature;
import com.nhom13.Dialog.FoodCategoryPopup;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.KhuyenMai;
import com.nhom13.Entity.LoaiMon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FoodCategory extends ManagerView {

    private Employee emp;
    private List<LoaiMon> loaiMons;
    FoodCategoryPopup form;

    public FoodCategory(FoodCategoryPopup form, Employee emp) {
        super();
        setHeaderTable("ID loại", "Tên loại");
        loadData();
        this.form = form;
        this.emp = emp;
        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    private void getData() {
        try {
            LoaiMonDao dao = new LoaiMonDao();
            loaiMons = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (LoaiMon lm : loaiMons) {
            Object[] row = new Object[]{lm.getId(), lm.getTen()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();

    }

    public LoaiMon getCategoryIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return loaiMons.get(row);
        }
        return null;
    }

    private void AddEventListener() {
        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblData.getSelectedRow();
                if (row >= 0) {
                    btnEdit.setEnabled(true);
                    btnRemove.setEnabled(true);
                }
            }

        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setStatus(false);
                form.setFeature(Feature.ADD, null);
                form.setVisible(true);
                if (form.isStatus()) {
                    loadData();
                }
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setStatus(false);
                form.setFeature(Feature.EDIT, getCategoryIsSelected());
                form.setVisible(true);
                if (form.isStatus()) {
                    loadData();
                    btnEdit.setEnabled(false);
                    btnRemove.setEnabled(false);
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    LoaiMonDao dao = new LoaiMonDao();
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa loại món thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dao.deleteLoaiMon(getCategoryIsSelected());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                loadData();
                btnEdit.setEnabled(false);
                btnRemove.setEnabled(false);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                btnEdit.setEnabled(false);
                btnRemove.setEnabled(false);
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtSearch.getText();
                if (keyword != null || keyword.length() > 0) {
                    LoaiMonDao dao = new LoaiMonDao();
                    try {
                        loaiMons = dao.SearchLoaiMon(keyword);
                        tblModel.setRowCount(0);
                        for (LoaiMon lm : loaiMons) {
                            Object[] row = new Object[]{lm.getId(), lm.getTen()};
                            tblModel.addRow(row);
                        }
                        tblModel.fireTableDataChanged();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(btnSearch, "Vui lòng nhập tên món ăn muốn tìm kiếm");
                }

            }

        });
    }
}
