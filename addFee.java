package fee.management.system;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

public class addFee extends javax.swing.JFrame {

    public addFee() {
        super("Fees Management System");
        initComponents();
        displayCash();
        fill();
        int reciept = getRecieptNo();
        txt_receipt.setText(Integer.toString(reciept));
    }
    public void displayCash(){
        lbl_dd.setVisible(false);
        txt_dd.setVisible(false);
        txt_bank.setVisible(false);
        lbl_bank.setVisible(false);
    }
    public boolean validation1(){
        if(txt_reg.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Registration number");
            return false;
        }
        if(date_tran.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please enter date");
            return false;
        }
        if(txt_amount.getText().equals("")||txt_amount.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this, "Please enter amount(only in digits)");
            return false;
        }
        if(txt_contact.getText().equals("")||txt_contact.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"Please enter 10 mobile number only");
            return false;
        }
        if(txt_mode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            if(txt_dd.getText().equals("")){
                 JOptionPane.showMessageDialog(this, "Please enter DD / Check numeber");
                return false;
            }
            if(txt_bank.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        if(txt_mode.getSelectedItem().toString().equalsIgnoreCase("dd")){
            if(txt_dd.getText().equals("")){
                 JOptionPane.showMessageDialog(this, "Please enter DD / Check numeber");
                return false;
            }
            if(txt_bank.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        if(txt_mode.getSelectedItem().toString().equalsIgnoreCase("card")){
            if(txt_bank.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter bank name");
                return false;
            }
        }
        
    
        return true;
    }
    public void fill(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            PreparedStatement pst = con.prepareStatement("select course_name from course");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
        	txt_coursemode.addItem(rs.getString("course_name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public int getRecieptNo(){
        int res = 0;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            String st = "select max(reciept_no) from fees";
            Statement pst = con.createStatement();
            rs = pst.executeQuery(st);
            while(rs.next()){
                res = rs.getInt(1);
                res++;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
    public String innerData(){
        String str ="";
        SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-mm-dd");
        
        int recieptNo = Integer.parseInt(txt_receipt.getText());
        String date = dateformat.format(date_tran.getDate());
        String mode = txt_mode.getSelectedItem().toString();
        String bank = txt_bank.getText();
        String dd = txt_dd.getText();
        String reg = txt_reg.getText();
        String cont = txt_contact.getText();
        String course = txt_coursemode.getSelectedItem().toString();
        float amt = Float.parseFloat(txt_amount.getText());
        float sgst = Float.parseFloat(txt_sgst.getText());
        float tot_amt = Float.parseFloat(txt_total.getText());
        String word = txt_amt_word.getText();
        String remark =txt_remark.getText();
        
        
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ganesh123@");
            PreparedStatement pst = con.prepareStatement("insert into fees values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,recieptNo);
            //pst.setString(2, date);
            pst.setString(2,mode);
            pst.setString(3, dd);
            pst.setString(4, bank);
            pst.setString(5,reg);
            pst.setString(6,cont);
            pst.setString(7,course);
            pst.setFloat(8,amt);
            pst.setFloat(9,sgst);
            pst.setString(10,remark);
            pst.setFloat(11,tot_amt);
            pst.setString(12, word);
            int res = pst.executeUpdate();
            if(res==1){
                str = "success";
            }
            else{
                str = "failed";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        btnhome = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        panelParent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_receipt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_dd = new javax.swing.JLabel();
        txt_mode = new javax.swing.JComboBox<>();
        txt_dd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date_tran = new com.toedter.calendar.JDateChooser();
        lbl_bank = new javax.swing.JLabel();
        txt_bank = new javax.swing.JTextField();
        panel_child = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_reg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_coursemode = new javax.swing.JComboBox<>();
        txt_contact = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_course = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_sgst = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_amt_word = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        btn_proceed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(0, 204, 255));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setBackground(new java.awt.Color(0, 0, 0));
        btnhome.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setText("       Home");
        btnhome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        panelsidebar.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 48, 242, 87));

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText(" Edit Courses");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        panelsidebar.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 194, 242, 93));

        btnLogout.setBackground(new java.awt.Color(0, 0, 0));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("         Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        panelsidebar.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 485, 242, 89));

        btnView.setBackground(new java.awt.Color(0, 0, 0));
        btnView.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("Search Record");
        btnView.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        panelsidebar.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 342, 242, 90));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 680));

        panelParent.setBackground(new java.awt.Color(255, 255, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fees Payment Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        panelParent.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 855, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Receipt No.            :");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 66, -1, 28));

        txt_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptActionPerformed(evt);
            }
        });
        panelParent.add(txt_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 71, 173, 26));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Mode of Payment :");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 110, 150, 28));

        lbl_dd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_dd.setText("DD / Check No.      :");
        panelParent.add(lbl_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 146, -1, 30));

        txt_mode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD  ", "Cheque", "Cash", "Card" }));
        txt_mode.setSelectedIndex(2);
        txt_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeActionPerformed(evt);
            }
        });
        panelParent.add(txt_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 111, 173, 28));
        panelParent.add(txt_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 146, 173, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Date of Transcation :");
        panelParent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 68, 171, 28));
        panelParent.add(date_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 68, 154, 30));

        lbl_bank.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_bank.setText("Bank Name               :");
        panelParent.add(lbl_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 112, 171, -1));
        panelParent.add(txt_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 110, 243, 30));

        panel_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Registration No.     :");
        panel_child.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 22, -1, 30));
        panel_child.add(txt_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 24, 171, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Contact No.            :");
        panel_child.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 22, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Courses                   :");
        panel_child.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 73, -1, 30));

        txt_coursemode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_coursemode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursemodeActionPerformed(evt);
            }
        });
        panel_child.add(txt_coursemode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 75, 290, 28));
        panel_child.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 24, 210, 31));
        panel_child.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 173, 849, -1));
        panel_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 109, 849, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Sr. No.");
        panel_child.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 139, 94, 22));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Selected Course   :");
        panel_child.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 133, 158, 28));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Amount (Rs)        :");
        panel_child.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 187, -1, 22));

        txt_course.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseActionPerformed(evt);
            }
        });
        panel_child.add(txt_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 124, 162, 33));

        txt_amount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panel_child.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 182, 162, 33));

        txt_sgst.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panel_child.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 227, 162, 33));

        txt_total.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panel_child.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 272, 162, 33));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("SGST  9%            :");
        panel_child.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 229, 149, 29));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Total Amount  :");
        panel_child.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 272, 136, 33));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Total Amount in Words :");
        panel_child.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 352, -1, 33));

        txt_amt_word.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amt_wordActionPerformed(evt);
            }
        });
        panel_child.add(txt_amt_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 352, 352, 33));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Remarks     :");
        panel_child.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 415, -1, 33));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panel_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 397, 354, 61));

        btn_proceed.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_proceed.setText("Proceed");
        btn_proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proceedActionPerformed(evt);
            }
        });
        panel_child.add(btn_proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 409, 185, 49));

        panelParent.add(panel_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 182, -1, -1));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 850, 680));

        setSize(new java.awt.Dimension(1145, 686));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        home h1 = new home();
        h1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     editCourse e1 = new editCourse();
     e1.setVisible(true);
     dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
      JOptionPane.showMessageDialog(this, "Logged out successfully");
      Login ln = new Login();
      ln.show();
      dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txt_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptActionPerformed

    private void txt_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeActionPerformed
        if(txt_mode.getSelectedIndex()==0){
            lbl_dd.setVisible(true);
            txt_dd.setVisible(true);
            txt_bank.setVisible(true);
            lbl_bank.setVisible(true);
        }
        else if(txt_mode.getSelectedIndex()==1){
             lbl_dd.setVisible(true);
            txt_dd.setVisible(true);
            txt_bank.setVisible(true);
            lbl_bank.setVisible(true);
        }
        else if(txt_mode.getSelectedIndex()==3){
             lbl_dd.setVisible(false);
            txt_dd.setVisible(false);
            txt_bank.setVisible(true);
            lbl_bank.setVisible(true); 
        }
        else{
            lbl_dd.setVisible(false);
            txt_dd.setVisible(false);
            txt_bank.setVisible(false);
            lbl_bank.setVisible(false);
        }
        
    }//GEN-LAST:event_txt_modeActionPerformed

    private void txt_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        Float x = Float.parseFloat(txt_amount.getText());
        Float sgst = (x*0.09f);
        txt_sgst.setText(sgst.toString());
        float total = x + sgst;
        txt_total.setText(Float.toString(total));
        int z =(int)total;
        txt_amt_word.setText(NumberToWordsConverter.convert(z));
        
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
       
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_amt_wordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amt_wordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amt_wordActionPerformed

    private void btn_proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proceedActionPerformed
        if(validation1()==true){
            String result = innerData();
            if(result.equals("success")){
                JOptionPane.showMessageDialog(this,"Payment is done, fees has been updated successfully");
            }
            else{
                JOptionPane.showMessageDialog(this,"Data updation failed");
            }
            
        }
    }//GEN-LAST:event_btn_proceedActionPerformed

    private void txt_coursemodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursemodeActionPerformed
            txt_course.setText(txt_coursemode.getSelectedItem().toString());     
    }//GEN-LAST:event_txt_coursemodeActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        searchRecord s1 = new searchRecord();
        s1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnViewActionPerformed
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addFee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addFee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btn_proceed;
    private javax.swing.JButton btnhome;
    private com.toedter.calendar.JDateChooser date_tran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_bank;
    private javax.swing.JLabel lbl_dd;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panel_child;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_amt_word;
    private javax.swing.JTextField txt_bank;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_course;
    private javax.swing.JComboBox<String> txt_coursemode;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JComboBox<String> txt_mode;
    private javax.swing.JTextField txt_receipt;
    private javax.swing.JTextField txt_reg;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
