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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Customer;
import vn.edu.vttu.data.RestaurantInfo;
import vn.edu.vttu.sqlite.TbServer;

/**
 *
 * @author nhphuoc
 */
public class PanelCustomer extends javax.swing.JPanel {

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
            if (hex.endsWith("")) {
                return true;
            } else {
                matcher = pattern.matcher(hex);
                return matcher.matches();
            }
        }
    }

    /**
     * Creates new form PanelCustomer
     */
    private Connection conn;
    private boolean add = false;
    private RestaurantInfo rs=RestaurantInfo.getinfo(ConnectDB.conn());

    public PanelCustomer() {
        initComponents();
        enableButton(true);
        loadTbCustomer();
    }

    private void enableButton(boolean b) {
        btnAdd.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDel.setEnabled(b);
        btnSave.setEnabled(!b);
        txtName.setEnabled(!b);
        txtPhone.setEnabled(!b);
        txtAdress.setEnabled(!b);
        txtEmail.setEnabled(!b);
        dtBirtday.setEnabled(!b);
        cobSex.setEnabled(!b);
        tbCustomer.setEnabled(b);
        dtBirtday.setEnabled(b);
    }

    private void loadTbCustomer() {
        conn = ConnectDB.conn();
        tbCustomer.setModel(Customer.getAll(conn));
        try {
            tbCustomer.setRowSelectionInterval(0, 0);
            tbCustomer.getColumnModel().getColumn(0).setMinWidth(30);
            tbCustomer.getColumnModel().getColumn(0).setMaxWidth(30);
            tbCustomer.getColumnModel().getColumn(2).setMinWidth(50);
            tbCustomer.getColumnModel().getColumn(2).setMaxWidth(50);
            tbCustomer.getColumnModel().getColumn(4).setMinWidth(50);
            tbCustomer.getColumnModel().getColumn(4).setMaxWidth(50);

        } catch (Exception e) {
        }
        tbCustomer.getTableHeader().setReorderingAllowed(false);
        conn = null;
    }

    private void bindingText(int index) {
        if (String.valueOf(tbCustomer.getValueAt(index, 3)) != null || !String.valueOf(tbCustomer.getValueAt(index, 3)).equals("")) {
            String dt = String.valueOf(tbCustomer.getValueAt(index, 3));
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //String datetime = formatter.format(dt);
            try {
                java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
                dtBirtday.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(PanelCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Date ts = new Date(datetime);

        }
        txtID.setText(String.valueOf(tbCustomer.getValueAt(index, 0)));
        txtName.setText(String.valueOf(tbCustomer.getValueAt(index, 1)));
        cobSex.setSelectedItem(String.valueOf(tbCustomer.getValueAt(index, 2)));

        txtPhone.setText(String.valueOf(tbCustomer.getValueAt(index, 5)));
        txtAdress.setText(String.valueOf(tbCustomer.getValueAt(index, 6)));
        txtEmail.setText(String.valueOf(tbCustomer.getValueAt(index, 7)));
    }

    private boolean add(String name, boolean sex, Date birthday, String phone, String address, String email) {
        boolean succ = false;
        if (Customer.insert(name, sex, (java.sql.Date) birthday, phone, address, email, conn)) {
            succ = true;
        } else {
            succ = false;
        }
        return succ;
    }

    private boolean update(int id, String name, boolean sex, Date birthday, String phone, String address, String email) {
        boolean succ = false;
        if (Customer.updateAll(id, name, sex, (java.sql.Date) birthday, phone, address, email, conn)) {
            succ = true;
        } else {
            succ = false;
        }
        return succ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cobSex = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        dtBirtday = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnDel = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnSave = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnReload = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("ID:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Họ Tên:");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Giới Tính:");

        cobSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Ngày Sinh:");

        dtBirtday.setDate(new Date());
        dtBirtday.setDateFormatString("d/M/yyyy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Điện Thoại:");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("Địa Chỉ:");

        txtAdress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(153, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jToolBar1.setRollover(true);

        btnAdd.setBackground(new java.awt.Color(153, 204, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/add-icon_24x24.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setMaximumSize(new java.awt.Dimension(80, 31));
        btnAdd.setMinimumSize(new java.awt.Dimension(80, 31));
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
        btnEdit.setMaximumSize(new java.awt.Dimension(80, 31));
        btnEdit.setMinimumSize(new java.awt.Dimension(80, 31));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator2);

        btnDel.setBackground(new java.awt.Color(153, 204, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/delete-icon-24x24.png"))); // NOI18N
        btnDel.setText("Xóa");
        btnDel.setMaximumSize(new java.awt.Dimension(80, 31));
        btnDel.setMinimumSize(new java.awt.Dimension(80, 31));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDel);
        jToolBar1.add(jSeparator3);

        btnSave.setBackground(new java.awt.Color(153, 204, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Save-icon-24x24.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setMaximumSize(new java.awt.Dimension(80, 31));
        btnSave.setMinimumSize(new java.awt.Dimension(80, 31));
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
        btnReload.setMaximumSize(new java.awt.Dimension(80, 31));
        btnReload.setMinimumSize(new java.awt.Dimension(80, 31));
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReload);
        jToolBar1.add(jSeparator5);

        btnPrint.setBackground(new java.awt.Color(153, 204, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/print-icon-24x24.png"))); // NOI18N
        btnPrint.setText("In");
        btnPrint.setMaximumSize(new java.awt.Dimension(80, 31));
        btnPrint.setMinimumSize(new java.awt.Dimension(80, 31));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cobSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtBirtday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(txtAdress)))
                .addGap(163, 163, 163))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtBirtday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cobSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbCustomer = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbCustomer.setFocusTraversalPolicyProvider(true);
        tbCustomer.setGridColor(new java.awt.Color(204, 204, 204));
        tbCustomer.setRowHeight(25);
        tbCustomer.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tbCustomer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCustomerMousePressed(evt);
            }
        });
        tbCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbCustomerKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCustomer);

        txtSearch.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("Tìm Kiếm Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void tbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerMouseClicked
        int index = tbCustomer.getSelectedRow();
        bindingText(index);
    }//GEN-LAST:event_tbCustomerMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add = true;
        enableButton(false);
        txtID.setText("");
        txtName.setText("");
        txtAdress.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtName.requestFocus();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        enableButton(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        EmailValidator validator = new EmailValidator();
        Date dt = dtBirtday.getDate();
        Date ds = new java.sql.Date(dt.getTime());
        if (txtName.getText().trim().equals("") || txtName.getText().trim().length() > 50) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa nhập tên khách hàng hoặc nhập sai", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
        } else if (txtPhone.getText().trim().length() > 13) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập sai số điện thoại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtPhone.requestFocus();
        } else if (!validator.validate(txtEmail.getText().trim())) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập sai Email", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
        } else if (((dt.getYear() + 1900) - (new Date().getYear() + 1900)) > 18) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn nhập sai năm sinh", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            dtBirtday.requestFocus();
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
            conn = ConnectDB.conn();
            if (add) {
                if (Customer.insert(name, sex, (java.sql.Date) ds, phone, address, email, conn)) {
                    loadTbCustomer();
                    JOptionPane.showMessageDialog(getRootPane(), "Thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    enableButton(true);
                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "Không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int id = Integer.parseInt(txtID.getText());
                if (Customer.updateAll(id, name, sex, (java.sql.Date) ds, phone, address, email, conn)) {
                    loadTbCustomer();
                    JOptionPane.showMessageDialog(getRootPane(), "Thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    enableButton(true);
                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "Không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                }
            }
            conn = null;
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            HashMap<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("tennhahang", rs.getName());
            parameter.put("diachi", "Địa Chỉ: " + rs.getAddress());
            parameter.put("sdt", "Điện Thoại: " + rs.getPhone());
            parameter.put("logo","http://" + TbServer.getValues().getIp() + "/Restaurant/"+rs.getLogo());
            JasperReport jr = JasperCompileManager.compileReport(getClass().getResourceAsStream("/vn/edu/vttu/report/customer.jrxml"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parameter, ConnectDB.conn());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        enableButton(true);
        loadTbCustomer();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        conn = ConnectDB.conn();
        tbCustomer.setModel(Customer.searchGetAll(txtSearch.getText().trim(), conn));
        try {
            tbCustomer.setRowSelectionInterval(0, 0);
            tbCustomer.getColumnModel().getColumn(0).setMinWidth(30);
            tbCustomer.getColumnModel().getColumn(0).setMaxWidth(30);
            tbCustomer.getColumnModel().getColumn(2).setMinWidth(50);
            tbCustomer.getColumnModel().getColumn(2).setMaxWidth(50);
            tbCustomer.getColumnModel().getColumn(4).setMinWidth(50);
            tbCustomer.getColumnModel().getColumn(4).setMaxWidth(50);

        } catch (Exception e) {
        }
        conn = null;
    }//GEN-LAST:event_txtSearchKeyReleased

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

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (txtID.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa chọn khách hàng");
        } else {
            conn = ConnectDB.conn();
            if (Customer.countCustomerUsing(Integer.parseInt(txtID.getText().trim()), conn)) {
                if (JOptionPane.showConfirmDialog(getRootPane(), "Bạn có thật sự muốn xóa khách hàng này không?", "Hỏi?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        if (Customer.delete(Integer.parseInt(txtID.getText().trim()), conn)) {
                            JOptionPane.showMessageDialog(getRootPane(), "Thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                            loadTbCustomer();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(getRootPane(), "Không thể xóa khách hàng này", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "Khách hàng đang sử dụng dịch vụ hoặc có hóa đơn đang đặt, không thể xóa", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void tbCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerMousePressed
        int index = tbCustomer.getSelectedRow();
        bindingText(index);
    }//GEN-LAST:event_tbCustomerMousePressed

    private void tbCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCustomerKeyPressed
        int index = tbCustomer.getSelectedRow();
        bindingText(index);
    }//GEN-LAST:event_tbCustomerKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cobSex;
    private com.toedter.calendar.JDateChooser dtBirtday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
