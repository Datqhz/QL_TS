package com.nhom13.Component;

import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.MonAnDAO;
import com.nhom13.Dialog.FoodPopup;
import com.nhom13.Dialog.Feature;
import com.nhom13.Dialog.FoodPopup;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Entity.MonAn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class FoodList extends ManagerView {

    private List<MonAn> Foodlist = new ArrayList<>();
    private List<LoaiMon> listCategory = new ArrayList<>();
    FoodPopup form;
    

    public FoodList(FoodPopup form) {
        super();
        setHeaderTable("ID Món", "Tên món", "Đơn vị tính", "Giá", "Mô tả", "Loại");
        loadData();
        this.form = form;

        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    private void getData() {
        try {
            MonAnDAO monAnDAO = new MonAnDAO();
            LoaiMonDao loaiMonDao = new LoaiMonDao();
            Foodlist = monAnDAO.findAll();
            listCategory = loaiMonDao.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNameCategory(int id) {
        return listCategory.stream().filter(l -> l.getId() == id).map(l -> l.getTen()).findFirst().orElse(null);
    }

    private void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (MonAn monAn : Foodlist) {
            Object[] row = new Object[]{monAn.getId(), monAn.getTenMon(), monAn.getDonVi(), monAn.getGia(), monAn.getMoTa(), getNameCategory(monAn.getIdLoaiMon())};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    public MonAn getSaleIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return Foodlist.get(row);
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
                form.setFeature(Feature.EDIT, getSaleIsSelected());
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
                    MonAnDAO dao = new MonAnDAO();
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa món thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dao.deleteMonAn(getSaleIsSelected());
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
                String keyword = txtSearch.getText().trim();
                if (keyword != null && keyword.length() > 0) {

                    try {
                        MonAnDAO monAnDAO = new MonAnDAO();
                        LoaiMonDao loaiMonDao = new LoaiMonDao();
                        Foodlist = monAnDAO.findAll();
                        listCategory = loaiMonDao.findAll();
                        for (MonAn monAn : Foodlist) {
                            Object[] row = new Object[]{monAn.getId(), monAn.getTenMon(), monAn.getDonVi(), monAn.getGia(), monAn.getMoTa(), getNameCategory(monAn.getIdLoaiMon())};
                            tblModel.addRow(row);
                        }
                        tblModel.fireTableDataChanged();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(btnSearch, "Vui lòng nhập tên món ăn muốn tìm kiếm");
                }
            }

        });
    }
}
