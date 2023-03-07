package com.nhom13.Dialog;

import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.MonAnDAO;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Entity.MonAn;
import com.nhom13.Support.CharFilterAlphabet;
import com.nhom13.Support.CharFilterNumber;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class FoodPopup extends javax.swing.JDialog {

    private String maNV;
    private boolean status;
    Feature feature;
    private MonAn monAn;
    List<LoaiMon> listCategory;
    DefaultComboBoxModel modelcbx = new DefaultComboBoxModel();

    public FoodPopup(java.awt.Frame parent, String maNv) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.maNV = maNv;
        setTitle("Thêm món.");
        cbxCategory.setModel(modelcbx);
        AbstractDocument document1 = (AbstractDocument) txtUnit.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
        AbstractDocument document3 = (AbstractDocument) txtPrice.getDocument();
        document3.setDocumentFilter(new CharFilterNumber());
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void resetForm() {
        txtFoodName.setText("");
        txtUnit.setText("");
        txtPrice.setText("");
        txtImgPath.setText("");
        txtNote.setText("");
        cbxCategory.setSelectedItem(null);
        lblReviewImg.setIcon(null);
    }

    public void loadCombobox() {
        try {
            LoaiMonDao dao = new LoaiMonDao();
            listCategory = dao.findAll();
        } catch (Exception e) {
            System.out.println("load category fail");
        }
    }

    public void setItemCombobox() {
        loadCombobox();
        modelcbx.removeAllElements();
        for (LoaiMon category : listCategory) {

            modelcbx.addElement(category.getTen());
        }

    }

    public void setFeature(Feature f, MonAn ma) {
        setItemCombobox();
        status = false;
        feature = f;
        if (feature == Feature.ADD) {
            btnFeature.setText("ADD");

            this.monAn = null;
        } else {
            btnFeature.setText("EDIT");
            this.monAn = ma;
            txtFoodName.setText(ma.getTenMon());
            txtUnit.setText(ma.getDonVi());
            txtPrice.setText(String.valueOf(ma.getGia()));
            txtNote.setText(ma.getMoTa());
            LoaiMon loaiMon = listCategory.stream().filter(l -> l.getId() == ma.getIdLoaiMon()).findFirst().orElse(null);
            cbxCategory.setSelectedItem(loaiMon.getTen());
        }
    }

    public boolean check(String m) {
        return m.length() == 0 || m == null;
    }

    public Icon Resize(String path, int k, int m) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(k, m, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtFoodName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImgPath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        cbxCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnChooseImg = new com.nhom13.swingCustom.ButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        btnFeature = new com.nhom13.swingCustom.ButtonCustom();
        btnReset = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        lblReviewImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tên món");

        txtUnit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Đơn vị tính");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Giá");

        txtImgPath.setEditable(false);
        txtImgPath.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Ảnh");

        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        cbxCategory.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Mô tả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Loại món");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        btnChooseImg.setBorder(null);
        btnChooseImg.setForeground(new java.awt.Color(0, 0, 102));
        btnChooseImg.setText("Chọn ảnh");
        btnChooseImg.setBorderColor(new java.awt.Color(0, 0, 204));
        btnChooseImg.setColorClick(new java.awt.Color(0, 0, 153));
        btnChooseImg.setColorOver(new java.awt.Color(0, 255, 255));
        btnChooseImg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChooseImg.setRadius(10);
        btnChooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImgActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        btnFeature.setBorder(null);
        btnFeature.setForeground(new java.awt.Color(255, 255, 255));
        btnFeature.setText("Thêm");
        btnFeature.setBorderColor(new java.awt.Color(255, 255, 255));
        btnFeature.setColor(new java.awt.Color(0, 0, 204));
        btnFeature.setColorClick(new java.awt.Color(0, 0, 153));
        btnFeature.setColorOver(new java.awt.Color(0, 255, 255));
        btnFeature.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFeature.setRadius(10);
        btnFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeatureActionPerformed(evt);
            }
        });

        btnReset.setBorder(null);
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Làm mới");
        btnReset.setBorderColor(new java.awt.Color(255, 255, 255));
        btnReset.setColor(new java.awt.Color(0, 0, 204));
        btnReset.setColorClick(new java.awt.Color(0, 0, 153));
        btnReset.setColorOver(new java.awt.Color(0, 255, 255));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setRadius(10);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Đóng");
        btnClose.setBorderColor(new java.awt.Color(255, 255, 255));
        btnClose.setColor(new java.awt.Color(0, 0, 204));
        btnClose.setColorClick(new java.awt.Color(0, 0, 153));
        btnClose.setColorOver(new java.awt.Color(0, 255, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setRadius(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblReviewImg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblReviewImg.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnChooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblReviewImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrice)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(lblReviewImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImgActionPerformed
        JFileChooser c = new JFileChooser();
        int rs = c.showOpenDialog(this);
        if (rs == JFileChooser.APPROVE_OPTION) {
            txtImgPath.setText(c.getSelectedFile().getAbsolutePath());
            lblReviewImg.setIcon(Resize(c.getSelectedFile().getAbsolutePath(), 180, 180));
        }
    }//GEN-LAST:event_btnChooseImgActionPerformed

    private void btnFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureActionPerformed
        String name = txtFoodName.getText().trim();
        String donVi = txtUnit.getText().trim();
        String gia = txtPrice.getText().trim();
        String moTa = txtNote.getText().trim();
        String imgPath;
        if (check(txtImgPath.getText().trim())) {
            imgPath = "C:\\Users\\baam0\\OneDrive\\Documents\\GitHub\\QL_TS\\src\\main\\resources\\new.png";
        } else {
            imgPath = txtImgPath.getText();
        }
        String tenLoai = cbxCategory.getSelectedItem().toString();
        if (check(name) || check(gia) || check(tenLoai)) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
        } else {
            MonAn monAn1 = new MonAn();
            monAn1.setTenMon(name);
            monAn1.setDonVi(donVi);
            monAn1.setGia(Integer.parseInt(gia));
            monAn1.setMoTa(moTa);
            monAn1.setAnh(imgPath);
            monAn1.setMaNv(maNV);
            int idLoaiMon = listCategory.stream().filter(l -> l.getTen().equals(tenLoai)).map(l -> l.getId()).findFirst().orElse(null);
            monAn1.setIdLoaiMon(idLoaiMon);
            System.out.println(monAn1);
            try {
                MonAnDAO dao = new MonAnDAO();
                if (feature == Feature.ADD) {
                    dao.save(monAn1);
                    JOptionPane.showMessageDialog(rootPane, "Add successful");
                } else {
                    monAn1.setId(monAn.getId());
                    dao.update(monAn1);
                    JOptionPane.showMessageDialog(rootPane, "Edit sucessful");
                }
            } catch (Exception e) {
            }
            status = true;
            resetForm();
            setVisible(false);
        }
    }//GEN-LAST:event_btnFeatureActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        resetForm();
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FoodPopup dialog = new FoodPopup(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnChooseImg;
    private com.nhom13.swingCustom.ButtonCustom btnClose;
    private com.nhom13.swingCustom.ButtonCustom btnFeature;
    private com.nhom13.swingCustom.ButtonCustom btnReset;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblReviewImg;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtImgPath;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
