package fee.management.system;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.Level;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class signup extends javax.swing.JFrame {
    
    String uname,name,password,con_password,contact_nu;
    Date dob;
    int id=1;
    public signup() {
        super("Fees Management System");
        initComponents();
    }
    boolean validation(){

    uname = usr_name.getText();
    name = txt_name.getText();
    password = txt_pass.getText();
    con_password = txt_con_pass.getText();
    dob = txt_dob.getDate();
    contact_nu = contact_num.getText();
    
     if(uname.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter username ");
        return false;
    }
     if(name.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter name ");
        return false;
    }
     if(password.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter password ");
        return false;
    }
     if(con_password.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter confirm password ");
        return false;
    }
     if(dob.equals(null)){
        JOptionPane.showMessageDialog(this,"Please enter date of birth ");
        return false;
    }
     if(contact_nu.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter contact number ");
        return false;
    }
    if(password.length()<8){
        lb_pass.setText("Password length should greater than 8");
        return false;
    }
    if(!password.equals(con_password)){
        JOptionPane.showMessageDialog(this,"password and confirm password is not matching ");
        return false;
    }
   
    return true;
    }
    public void checkPassword(){
    if(password.length()<8){
        lb_pass.setText("Password length should greater than 8");
    }
    else{
        lb_pass.setText("");
    }
    }
    public void checkContact(){
        password = txt_pass.getText();
        contact_nu = contact_num.getText();
        if(contact_nu.length()==10){
            lb_contact.setText("");
        }
        else{
            lb_contact.setText("contact number should be 10 digit");
        }
    }
    public int getId(){
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            String sql = "select max(id) from signup";
            Statement st = con.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
            id=rs.getInt(1);
            id++;
        }
        }
        catch(ClassNotFoundException ex){
            
        }catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
        
    }
    void insertDetails(){
        SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
        String mydob = format.format(dob);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            String sql = "insert into signup values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,getId());            
            stmt.setString(2,uname);
            stmt.setString(3,name);
            stmt.setString(4,password);
            stmt.setString(5,mydob);
            stmt.setString(6,contact_nu);
            int i = stmt.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(this, "record inserted successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "record not inserted");
            }
        }
        catch (SQLException e){
        e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        usr_name = new javax.swing.JTextField();
        contact_num = new javax.swing.JTextField();
        btn_signup = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        txt_con_pass = new javax.swing.JPasswordField();
        lb_pass = new javax.swing.JLabel();
        lb_contact = new javax.swing.JLabel();
        txt_dob = new com.toedter.calendar.JDateChooser();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SignUp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 80));

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Password                :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 142, 161, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Username               :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 34, 161, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Name                      :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 84, 161, 29));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Confirm Password  :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Contact Number    :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 290, 161, 29));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Date of Birth           :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 237, 161, 29));

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 182, 29));

        usr_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usr_nameActionPerformed(evt);
            }
        });
        jPanel3.add(usr_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 182, 29));

        contact_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_numActionPerformed(evt);
            }
        });
        contact_num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contact_numKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contact_numKeyReleased(evt);
            }
        });
        jPanel3.add(contact_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 182, 29));

        btn_signup.setBackground(new java.awt.Color(0, 204, 204));
        btn_signup.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_signup.setText("Sign Up");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel3.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 349, 110, 35));

        btn_login.setBackground(new java.awt.Color(0, 204, 204));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel3.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 349, 98, 35));

        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });
        jPanel3.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 182, 30));
        jPanel3.add(txt_con_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 180, 30));

        lb_pass.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 128, 237, -1));

        lb_contact.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lb_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 272, 182, 12));
        jPanel3.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 180, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 420));

        setSize(new java.awt.Dimension(504, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void usr_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usr_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usr_nameActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void contact_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_numActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
          if(validation()){
              insertDetails();
          }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Login lg= new Login();
        lg.show();
        dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        checkPassword();
    }//GEN-LAST:event_txt_passKeyPressed

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
        checkPassword();
    }//GEN-LAST:event_txt_passKeyReleased

    private void contact_numKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact_numKeyReleased
        checkContact();
    }//GEN-LAST:event_contact_numKeyReleased

    private void contact_numKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact_numKeyPressed
        checkContact();
    }//GEN-LAST:event_contact_numKeyPressed
    public static void main(String args[]) {

        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JTextField contact_num;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lb_contact;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JPasswordField txt_con_pass;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField usr_name;
    // End of variables declaration//GEN-END:variables
}