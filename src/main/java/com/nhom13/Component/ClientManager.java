package com.nhom13.Component;

import com.nhom13.DAO.KhachHangDAO;
import com.nhom13.Dialog.ClientPopup;
import com.nhom13.Dialog.Feature;
import com.nhom13.Entity.KhachHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientManager extends ManagerView {

    ClientPopup dialog;
    List<KhachHang> listClient;
    

    public ClientManager(ClientPopup dialog) {
        super();
        setHeaderTable("ID khách hàng", "Tên khách hàng", "Số điện thoại", "Ngày sinh");
        this.dialog = dialog;
        loadData();
        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);

    }

    public void getData() {
        try {
            KhachHangDAO dao = new KhachHangDAO();
            listClient = dao.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (KhachHang client : listClient) {
            Object[] row = new Object[]{client.getId(), client.getHo() + " " + client.getTen(), client.getSdt(), client.getNgaySinh()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    public KhachHang getRowIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return listClient.get(row);
        }
        return null;
    }

    public void AddEventListener() {

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
                dialog.setFeature(Feature.ADD, null);
                dialog.setStatus(false);
                dialog.setVisible(true);
                if (dialog.isStatus()) {
                    loadData();
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setFeature(Feature.EDIT, getRowIsSelected());
                dialog.setStatus(false);
                dialog.setVisible(true);
                if (dialog.isStatus()) {
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
                    KhachHangDAO dao = new KhachHangDAO();
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa khách hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dao.deleteKhachHang(getRowIsSelected());
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
                    KhachHangDAO dao = new KhachHangDAO();
                    listClient = dao.searchByName(keyword);
                    tblModel.setRowCount(0);
                    for (KhachHang client : listClient) {
                        Object[] row = new Object[]{client.getId(), client.getHo() + " " + client.getTen(), client.getSdt(), client.getNgaySinh()};
                        tblModel.addRow(row);
                    }
                    tblModel.fireTableDataChanged();

                }
            }
        });
    }
}
