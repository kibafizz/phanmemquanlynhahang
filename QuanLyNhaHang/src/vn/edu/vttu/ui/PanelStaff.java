/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Staff;

/**
 *
 * @author nhphuoc
 */
public class PanelStaff extends javax.swing.JPanel {

    public class EmailValidator {

        private Pattern pattern;
        private Matcher matcher;
        private static final String EMAIL_PATTERN
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public EmailValidator() {
            pattern = Pattern.compile(EMAIL_PATTERN);
        }

        public boolean validate(final String hex) {
            if (!hex.equals("")) {
                matcher = pattern.matcher(hex);
                return matcher.matches();
            }
            return true;
        }
    }

    /**
     * Creates new form PanelStaff
     */
    private Connection conn;
    private boolean add = false;

    public PanelStaff() {
        initComponents();
        loadData();
        bindingText(0);        
        enableButton(true);
    }

    private void enableButton(boolean b) {
        btnAdd.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDelete.setEnabled(b);
        btnSave.setEnabled(!b);
        txtName.setEnabled(!b);
        txtPhone.setEnabled(!b);
        txtAdress.setEnabled(!b);
        txtEmail.setEnabled(!b);
        dtBirthDay.setEnabled(!b);
        cobSex.setEnabled(!b);
        tbStaff.setEnabled(b);        
    }

    private void loadData() {
        conn = ConnectDB.conn();
        tbStaff.setModel(Staff.getAll(conn));
        try {
            tbStaff.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
         tbStaff.getTableHeader().setReorderingAllowed(false);
    }

    private void bindingText(int index) {
        txtID.setText(String.valueOf(tbStaff.getValueAt(index, 0)));
        txtName.setText(String.valueOf(tbStaff.getValueAt(index, 1)));
        cobSex.setSelectedItem(String.valueOf(tbStaff.getValueAt(index, 2)));
        txtID.setText(String.valueOf(tbStaff.getValueAt(index, 0)));
        if (String.valueOf(tbStaff.getValueAt(index, 3)) != null || !String.valueOf(tbStaff.getValueAt(index, 3)).equals("")) {
            String dt = String.valueOf(tbStaff.getValueAt(index, 3));
            java.util.Date date;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
                dtBirthDay.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        txtPhone.setText(String.valueOf(tbStaff.getValueAt(index, 4)));
        txtEmail.setText(String.valueOf(tbStaff.getValueAt(index, 5)));
        txtAdress.setText(String.valueOf(tbStaff.getValueAt(index, 6)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelStaffInfo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cobSex = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        dtBirthDay = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnSave = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnReload = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnPrint = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStaff = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("ID");

        txtID.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Họ Tên:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Giới Tính:");

        cobSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Ngày Sinh:");

        dtBirthDay.setDate(new Date());
        dtBirthDay.setDateFormatString("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Điện Thoại");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("Địa Chỉ:");

        jToolBar1.setBackground(new java.awt.Color(153, 204, 255));
        jToolBar1.setRollover(true);

        btnAdd.setBackground(new java.awt.Color(153, 204, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/add-icon_24x24.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);
        jToolBar1.add(jSeparator1);

        btnEdit.setBackground(new java.awt.Color(153, 204, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/edit-icon-24x24.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator2);

        btnDelete.setBackground(new java.awt.Color(153, 204, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/delete-icon-24x24.png"))); // NOI18N
        btnDelete.setText("Xóa");
        jToolBar1.add(btnDelete);
        jToolBar1.add(jSeparator3);

        btnSave.setBackground(new java.awt.Color(153, 204, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Save-icon_24x24.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);
        jToolBar1.add(jSeparator4);

        btnReload.setBackground(new java.awt.Color(153, 204, 255));
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Refresh-icon-24x24.png"))); // NOI18N
        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReload);
        jToolBar1.add(jSeparator5);

        btnPrint.setBackground(new java.awt.Color(153, 204, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/print-icon-24x24.png"))); // NOI18N
        btnPrint.setText("Print");
        jToolBar1.add(btnPrint);
        jToolBar1.add(jSeparator6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(txtID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cobSex, 0, 111, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(txtAdress))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cobSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tbStaff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbStaff = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbStaff.setGridColor(new java.awt.Color(204, 204, 204));
        tbStaff.setRowHeight(25);
        tbStaff.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tbStaff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStaffMouseClicked(evt);
            }
        });
        tbStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbStaffKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbStaff);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("Tìm Kiếm Nhân Viên:");

        javax.swing.GroupLayout panelStaffInfoLayout = new javax.swing.GroupLayout(panelStaffInfo);
        panelStaffInfo.setLayout(panelStaffInfoLayout);
        panelStaffInfoLayout.setHorizontalGroup(
            panelStaffInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(panelStaffInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelStaffInfoLayout.setVerticalGroup(
            panelStaffInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStaffInfoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStaffInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Nhân Viên", panelStaffInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sắp Lịch Trực", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Xem Lịch Trực", jPanel3);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add = true;
        enableButton(false);
        txtName.setText("");
        txtPhone.setText("");
        txtAdress.setText("");
        txtEmail.setText("");
        txtName.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        enableButton(false);
        txtName.requestFocus();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        EmailValidator validator = new EmailValidator();
        if (txtName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa nhập tên nhân viên");
        } else if (txtName.getText().trim().length() > 50) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập tên quá dài");
        } else if ((dtBirthDay.getDate().getYear() + 1900) - (new Date().getYear() + 1900) > 18) {
            JOptionPane.showMessageDialog(getRootPane(), "Tuổi nhân viên phải lớn hơn 18 tuổi");
        } else if (txtPhone.getText().trim().length() > 13) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập số điện thoại sai");
        } else if (!validator.validate(txtEmail.getText().trim())) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập sai địa chỉ Email");
        } else {
            String name = txtName.getText().trim();
            boolean sex = true;
            if (cobSex.getSelectedItem().equals("Nam")) {
                sex = true;
            } else {
                sex = false;
            }
            String phone = txtPhone.getText().trim();
            String address = txtAdress.getText().trim();
            String email = txtEmail.getText().trim();
            Date dt = dtBirthDay.getDate();;
            Date ds = new java.sql.Date(dt.getTime());
            String pin = "";
            conn = ConnectDB.conn();
            if (add == true) {
                if (Staff.insertStaffInfo(name, sex, (java.sql.Date) ds, phone, address, email, pin, conn)) {
                    loadData();
                    bindingText(1);
                    enableButton(true);
                }
            } else {
                if (!txtID.getText().trim().equals("")) {
                    int id=Integer.parseInt(txtID.getText().trim());
                    if (Staff.updateStaffInfo(name, sex, (java.sql.Date) ds, phone, address, email, pin, id, conn)) {
                        JOptionPane.showMessageDialog(getRootPane(), "Cập nhật thành công");
                        loadData();
                        bindingText(1);
                        enableButton(true);
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa chọn nhân viê nào");
                }
            }
            conn = null;

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbStaffKeyReleased
        int index = tbStaff.getSelectedRow();
        bindingText(index);
    }//GEN-LAST:event_tbStaffKeyReleased

    private void tbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaffMouseClicked
        int index = tbStaff.getSelectedRow();
        bindingText(index);
    }//GEN-LAST:event_tbStaffMouseClicked

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        int key = evt.getKeyChar();
        String st = txtPhone.getText();
        String stTest = "0123456789";
        if (key != evt.VK_BACK_SPACE
                && key != evt.VK_DELETE
                && key != evt.VK_ENTER) {
            int flag = 0;
            if (stTest.indexOf(evt.getKeyChar()) == -1) {
                flag++;
            }
            if (flag > 0) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        loadData();
        enableButton(true);
    }//GEN-LAST:event_btnReloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cobSex;
    private com.toedter.calendar.JDateChooser dtBirthDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelStaffInfo;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
