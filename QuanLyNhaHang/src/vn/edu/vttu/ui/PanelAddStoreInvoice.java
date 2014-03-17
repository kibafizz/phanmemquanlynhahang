/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.DefaultTableModel;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Distributor;
import vn.edu.vttu.data.NumberCellRenderer;
import vn.edu.vttu.data.RawMaterial;
import vn.edu.vttu.data.RawMaterialInvoice;
import vn.edu.vttu.data.RawMaterialInvoiceDetail;
import vn.edu.vttu.data.TableLocation;
import vn.edu.vttu.data.Unit;

/**
 *
 * @author nhphuoc
 */
public class PanelAddStoreInvoice extends javax.swing.JPanel {

    class ItemRendererStore extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);

            if (value != null) {
                vn.edu.vttu.model.StoreList item = (vn.edu.vttu.model.StoreList) value;
                // đây là thông tin ta sẽ hiển thị , đối bảng khác sẽ khác cột chúng ta sẽ đổi lại tên tương ứng
                setText(item.getName().toUpperCase());
            }

            if (index == -1) {
                vn.edu.vttu.model.StoreList item = (vn.edu.vttu.model.StoreList) value;
                setText("" + item.getName());
            }

            return this;
        }

    }

    class ItemRendererUnit extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            try {
                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if (value != null) {
                    vn.edu.vttu.model.Unit item = (vn.edu.vttu.model.Unit) value;
                    // đây là thông tin ta sẽ hiển thị , đối bảng khác sẽ khác cột chúng ta sẽ đổi lại tên tương ứng
                    setText(item.getName().toUpperCase());
                }

                if (index == -1) {
                    vn.edu.vttu.model.Unit item = (vn.edu.vttu.model.Unit) value;
                    setText("" + item.getName());
                }

            } catch (Exception e) {
            }

            return this;
        }
    }

    class ItemRendererDistributor extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            try {
                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if (value != null) {
                    vn.edu.vttu.model.Distributor item = (vn.edu.vttu.model.Distributor) value;
                    // đây là thông tin ta sẽ hiển thị , đối bảng khác sẽ khác cột chúng ta sẽ đổi lại tên tương ứng
                    setText(item.getName().toUpperCase());
                }

                if (index == -1) {
                    vn.edu.vttu.model.Distributor item = (vn.edu.vttu.model.Distributor) value;
                    setText("" + item.getName());
                }

            } catch (Exception e) {
            }

            return this;
        }
    }

    /**
     * Creates new form PanelAddStoreInvoice
     */
    public PanelAddStoreInvoice() {
        initComponents();
        tbList.getColumnModel().getColumn(6).setMaxWidth(0);
        tbList.getColumnModel().getColumn(6).setMinWidth(0);
        fillcobStore();
        fillcobUnit();
        fillcobNhaCungCap();
    }

    private void fillcobStore() {

        Vector<vn.edu.vttu.model.StoreList> model = new Vector<vn.edu.vttu.model.StoreList>();
        try {
            model = RawMaterial.selectRawmaterial(ConnectDB.conn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel defaultComboBoxModel = new javax.swing.DefaultComboBoxModel(model);
        cobNguyenLieu.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        cobNguyenLieu.setModel(defaultComboBoxModel);
        cobNguyenLieu.setRenderer(new PanelAddStoreInvoice.ItemRendererStore());

    }

    private void fillcobUnit() {
        Vector<vn.edu.vttu.model.Unit> model = new Vector<vn.edu.vttu.model.Unit>();
        try {
            model = Unit.selectUnit(ConnectDB.conn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel defaultComboBoxModel = new javax.swing.DefaultComboBoxModel(model);
        cobUnit.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        cobUnit.setModel(defaultComboBoxModel);
        cobUnit.setRenderer(new PanelAddStoreInvoice.ItemRendererUnit());

    }

    private void fillcobNhaCungCap() {
        Vector<vn.edu.vttu.model.Distributor> model = new Vector<vn.edu.vttu.model.Distributor>();
        try {
            model = Distributor.selectDistributor(ConnectDB.conn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel defaultComboBoxModel = new javax.swing.DefaultComboBoxModel(model);
        cobNhaCungCap.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        cobNhaCungCap.setModel(defaultComboBoxModel);
        cobNhaCungCap.setRenderer(new PanelAddStoreInvoice.ItemRendererDistributor());

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
        cobNguyenLieu = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cobUnit = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnThemNguyenLieu = new javax.swing.JButton();
        btnThemDVT = new javax.swing.JButton();
        btnAddToList = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cobNhaCungCap = new javax.swing.JComboBox();
        btnThemNguyenLieu1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhập hàng"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Nguyên Liệu:");

        cobNguyenLieu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Đơn Vị Tính:");

        cobUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Số Lượng:");

        txtNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumberKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Đơn Giá:");

        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });
        txtDonGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyTyped(evt);
            }
        });

        btnThemNguyenLieu.setText("+");

        btnThemDVT.setText("+");
        btnThemDVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVTActionPerformed(evt);
            }
        });

        btnAddToList.setText("Thêm Vào Danh Sách");
        btnAddToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToListActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu Hóa Đơn");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDel.setText("Xóa Khỏi Danh Sách Đang Chọn");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Công Ty:");

        cobNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThemNguyenLieu1.setText("+");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("Ghi Chú:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cobNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cobNguyenLieu, 0, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemNguyenLieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cobUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemDVT)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemNguyenLieu1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnAddToList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cobNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNguyenLieu1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cobNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cobUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNguyenLieu)
                    .addComponent(btnThemDVT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddToList)
                    .addComponent(btnSave)
                    .addComponent(btnDel)))
        );

        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Nguyên Liệu", "Số Lượng", "ĐVT", "Đơn Giá", "Thành Tiền", "ID DVT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbList.setGridColor(new java.awt.Color(204, 204, 204));
        tbList.setRowHeight(25);
        tbList.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(tbList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed

    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void btnAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToListActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbList.getModel();
        vn.edu.vttu.model.StoreList store = (vn.edu.vttu.model.StoreList) cobNguyenLieu.getSelectedItem();
        int idNguyenLieu = store.getId();
        String tenNguyenLieu = store.getName();
        vn.edu.vttu.model.Unit unit = (vn.edu.vttu.model.Unit) cobUnit.getSelectedItem();
        int _unit = unit.getId();
        String tenDVT = unit.getName();
        boolean flag = false;
        int j = 0;
        if (txtNumber.getText().equals("") || txtDonGia.getText().equals("")) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa nhập số lượng hoặc đơn giá");
        } else {
            float soLuong = Float.parseFloat(txtNumber.getText().replaceAll(",", "\\."));
            int donGia = Integer.parseInt(txtDonGia.getText().trim().replaceAll("\\.", ""));
            if (tbList.getRowCount() > 0) {
                for (int i = 0; i < tbList.getRowCount(); i++) {
                    if (idNguyenLieu == Integer.parseInt(String.valueOf(tbList.getValueAt(i, 0)))) {
                        flag = false;
                        j = i;
                        break;
                    } else {
                        flag = true;
                    }
                }
                if (flag == false) {
                    float n = Float.parseFloat(String.valueOf(tbList.getValueAt(j, 2)));
                    float m;
                    m = n + soLuong;
                    tbList.setValueAt(m, j, 2);
                    tbList.setValueAt(m * Float.parseFloat(String.valueOf(tbList.getValueAt(j, 4))), j, 5);
                    tbList.setValueAt(donGia, j, 4);
                } else {
                    model.addRow(new Object[]{idNguyenLieu, tenNguyenLieu, soLuong, tenDVT, donGia, (soLuong * donGia), _unit});
                }
            } else {
                model.addRow(new Object[]{idNguyenLieu, tenNguyenLieu, soLuong, tenDVT, donGia, (soLuong * donGia), _unit});
            }
        }
        tbList.getColumnModel().getColumn(6).setMaxWidth(0);
        tbList.getColumnModel().getColumn(6).setMinWidth(0);
        tbList.getColumnModel().getColumn(5).setCellRenderer(new NumberCellRenderer());
        tbList.getColumnModel().getColumn(2).setCellRenderer(new NumberCellRenderer());
        tbList.getColumnModel().getColumn(4).setCellRenderer(new NumberCellRenderer());
    }//GEN-LAST:event_btnAddToListActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbList.getModel();
        model.removeRow(tbList.getSelectedRow());
        tbList.getColumnModel().getColumn(6).setMaxWidth(0);
        tbList.getColumnModel().getColumn(6).setMinWidth(0);
        tbList.getColumnModel().getColumn(5).setCellRenderer(new NumberCellRenderer());
        tbList.getColumnModel().getColumn(2).setCellRenderer(new NumberCellRenderer());
        tbList.getColumnModel().getColumn(4).setCellRenderer(new NumberCellRenderer());

    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (tbList.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Chưa có nguyên liệu nào trong danh sách hóa đơn");
        } else {
            vn.edu.vttu.model.Distributor store = (vn.edu.vttu.model.Distributor) cobNhaCungCap.getSelectedItem();
            int distributor = store.getId();
            Connection conn = ConnectDB.conn();
            try {
                conn.setAutoCommit(false);
                if (RawMaterialInvoice.insert(1, distributor, txtNote.getText(), conn)) {
                    int idRawInvoice = RawMaterialInvoice.getMaxID(conn).getId();
                    for (int i = 0; i < tbList.getRowCount(); i++) {
                        int idraw = Integer.parseInt(String.valueOf(tbList.getValueAt(i, 0)));
                        float number;
                        try {
                            number = Float.parseFloat(String.valueOf(tbList.getValueAt(i, 2)).trim());
                        } catch (Exception e) {
                            number = Float.parseFloat(String.valueOf(tbList.getValueAt(i, 2)).trim().replaceAll(",", ""));
                        }
                        int cost;
                        try {
                            cost = Integer.parseInt(String.valueOf(tbList.getValueAt(i, 4)).trim().replaceAll("\\.", ""));
                        } catch (Exception e) {
                            cost = Integer.parseInt(String.valueOf(tbList.getValueAt(i, 4)).trim().replaceAll(",", ""));
                        }
                        if (RawMaterialInvoiceDetail.insert(idraw, idRawInvoice, number, cost, conn)) {
                            if (RawMaterial.updateNumber(idraw, number, conn)) {
                            } else {
                                throw new Exception();
                            }
                        } else {
                            throw new Exception();
                        }
                    }
                    conn.commit();
                    JOptionPane.showMessageDialog(getRootPane(), "Thêm hóa đơn thành công");
                    DefaultTableModel model = (DefaultTableModel) tbList.getModel();
                    for (int i = 0; i < tbList.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
            } catch (Exception e) {
                try {
                    conn.rollback();
                    JOptionPane.showMessageDialog(getRootPane(), "Đã xảy ra lỗi" + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelAddStoreInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberKeyReleased

    }//GEN-LAST:event_txtNumberKeyReleased

    private void txtNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberKeyTyped
        int key = evt.getKeyChar();
        String st = txtNumber.getText();
        String stTest = "0123456789";
        if (key != evt.VK_BACK_SPACE
                && key != evt.VK_DELETE
                && key != evt.VK_ENTER
                && key != evt.VK_COMMA) {
            int flag = 0;
            if (stTest.indexOf(evt.getKeyChar()) == -1) {
                flag++;
            }
            if (flag > 0) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumberKeyTyped

    private void txtDonGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonGiaKeyReleased
        DecimalFormat df = new DecimalFormat("#,###.##;(#,###.##)");
        if (!txtDonGia.getText().trim().equals("")) {
            try {
                Long num = Long.parseLong(txtDonGia.getText().trim().replaceAll("\\.", ""));
                String str = txtDonGia.getText().trim().replaceAll("\\.", "");                
                txtDonGia.setText(String.valueOf(df.format(num)));
            } catch (Exception e) {
                Long num = Long.parseLong(txtDonGia.getText().trim().replaceAll(",", ""));
                txtDonGia.setText(String.valueOf(df.format(num)));
            }
        }
    }//GEN-LAST:event_txtDonGiaKeyReleased

    private void txtDonGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonGiaKeyTyped
        int key = evt.getKeyChar();
        String st = txtDonGia.getText();
        String stTest = "0123456789";
        if (key != evt.VK_BACK_SPACE
                && key != evt.VK_DELETE
                && key != evt.VK_ENTER
                && key != evt.VK_COMMA) {            
            int flag = 0;
            if (stTest.indexOf(evt.getKeyChar()) == -1) {
                flag++;
            }
            if (flag > 0) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtDonGiaKeyTyped

    private void btnThemDVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVTActionPerformed
        int result = JOptionPane.showConfirmDialog(null, new PanelUnit(),
                "Thêm Đơn Vị Tính", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);        
            fillcobUnit();        
    }//GEN-LAST:event_btnThemDVTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToList;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThemDVT;
    private javax.swing.JButton btnThemNguyenLieu;
    private javax.swing.JButton btnThemNguyenLieu1;
    private javax.swing.JComboBox cobNguyenLieu;
    private javax.swing.JComboBox cobNhaCungCap;
    private javax.swing.JComboBox cobUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbList;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
