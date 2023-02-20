
package com.nhom13.ql_ts;

import com.nhom13.DAO.EmployeeDAO;
import com.nhom13.Entity.Employee;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class LoginForm extends javax.swing.JFrame {
    
    private Employee emp;
    private Home home ;

 
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void getInfoLogin(){
        
    }
    // Kiểm tra trạng thái đăng nhập
    public boolean checkLogin(){
        emp = null;
        try{
            EmployeeDAO dao = new EmployeeDAO();
            emp = dao.findEmployeeByAccount(txtUsername.getText().trim(), new String(txtPassword.getPassword()).trim());
            if(emp!=null){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    // Kiểm tra kí tự đặc biệt
    public static boolean isContainSpecialWord(String s){
        Pattern VALID_INPUT_REGEX = Pattern.compile("[$&+,:;=\\\\\\\\?@#|/'<>.^*()%!-]",Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_INPUT_REGEX.matcher(s);
        return matcher.find();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblForgot = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnLogin = new com.nhom13.swingCustom.ButtonCustom();
        lblNoAccount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đăng Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        lblForgot.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblForgot.setForeground(new java.awt.Color(51, 51, 255));
        lblForgot.setText("Quên mật khẩu?");
        lblForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotMouseClicked(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setText("  ");

        btnLogin.setBackground(new java.awt.Color(51, 204, 0));
        btnLogin.setBorder(null);
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLogin.setColor(new java.awt.Color(51, 204, 0));
        btnLogin.setColorOver(new java.awt.Color(0, 204, 102));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setRadius(15);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblNoAccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNoAccount.setForeground(new java.awt.Color(51, 102, 255));
        lblNoAccount.setText("Chưa có tài khoản?");
        lblNoAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNoAccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblForgot)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNoAccount)
                        .addGap(213, 213, 213))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNoAccount)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        boolean check = true;

        if(txtUsername.getText().isEmpty()){
            lblError.setText("Vui lòng nhập username.");
            check = false;
        }else if(isContainSpecialWord(txtUsername.getText())){
            lblError.setText("Username không được chứa kí tự đặc biệt.");
            check = false;
        }else if(txtUsername.getText().contains(" ")){
            lblError.setText("Username không được chứa khoảng trắng.");
            check = false;
        }

        if(new String(txtPassword.getPassword()).isEmpty()){
            lblError.setText("Vui lòng nhập password.");
            check = false;
        }else if(new String(txtPassword.getPassword()).contains(" ")){
            lblError.setText("Password không được chứa khoảng trắng.");
            check = false;
        }
        
            if(checkLogin()){
                if(!emp.isStatus()){
                JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị viên để biết thêm chi tiết.","Thông báo", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công.","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    home = new Home(emp);
                    this.dispose();
                    home.setTitle("Quản lí quán trà sữa");
                    home.setVisible(true);
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu.","Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotMouseClicked
        JOptionPane.showMessageDialog(this, "Tính năng này chưa được hỗ trợ.","Thông báo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_lblForgotMouseClicked

    private void lblNoAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNoAccountMouseClicked
         JOptionPane.showMessageDialog(this, "Vui lòng liên hệ với quản lí để đăng kí tài khoản.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblNoAccountMouseClicked

  
//    public static void main(String args[]) {
// 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblForgot;
    private javax.swing.JLabel lblNoAccount;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
