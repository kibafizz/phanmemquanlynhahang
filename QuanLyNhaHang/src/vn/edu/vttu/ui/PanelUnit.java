/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.TableModel;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Unit;
import static vn.edu.vttu.ui.PanelService.setSelectedValueUnit;

/**
 *
 * @author nhphuoc
 */
public class PanelUnit extends javax.swing.JPanel {

    class ItemRenderer extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            if (value != null) {
                vn.edu.vttu.model.Unit item = (vn.edu.vttu.model.Unit) value;
                setText(item.getName().toUpperCase());
            }
            if (index == -1) {
                vn.edu.vttu.model.Unit item = (vn.edu.vttu.model.Unit) value;
                setText("" + item.getName());
            }
            return this;
        }
    }

    /**
     * Creates new form PanelUnit
     */
    private Connection conn;
    private boolean add = false;
    private String x;
    JTable table;

    public PanelUnit() {
        initComponents();

        loadUnit();
        enableControl(true);
        fillcobUnit();
    }

    private void loadData() {
        conn = ConnectDB.conn();
        //tbUnit.setModel(Unit.getAll(conn));
        conn = null;
    }

    private void loadUnit() {
        tbUnit.setModel(Unit.getAll(ConnectDB.conn()));
        tbUnit.getColumnModel().getColumn(4).setMinWidth(0);
        tbUnit.getColumnModel().getColumn(4).setMaxWidth(0);
        tbUnit.getTableHeader().setReorderingAllowed(false);
    }

    public void setSelectedValue(JComboBox comboBox, int value) {
        vn.edu.vttu.model.Unit item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (vn.edu.vttu.model.Unit) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private void fillcobUnit() {

        conn = ConnectDB.conn();
        Vector<vn.edu.vttu.model.Unit> model = new Vector<vn.edu.vttu.model.Unit>();
        try {
            model = Unit.selectUnitPanelUnit(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel defaultComboBoxModel = new javax.swing.DefaultComboBoxModel(model);
        cobDVT.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        cobDVT.setModel(defaultComboBoxModel);
        cobDVT.setRenderer(new PanelUnit.ItemRenderer());
        conn = null;

    }

    private void setSelectedUnit(JComboBox comboBox, int value) {
        vn.edu.vttu.model.Unit item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (vn.edu.vttu.model.Unit) comboBox.getItemAt(i);
            if (item.getId() == value) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private void enableControl(boolean b) {
        btnadd.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDel.setEnabled(b);
        btnSave.setEnabled(!b);
        tbUnit.setEnabled(b);
        txtName.setEnabled(!b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnadd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnReload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cobDVT = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtCast = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUnit = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Tên:");

        jToolBar1.setBackground(new java.awt.Color(102, 153, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnadd.setBackground(new java.awt.Color(102, 153, 255));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/add-icon_24x24.png"))); // NOI18N
        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnadd);
        jToolBar1.add(jSeparator1);

        btnEdit.setBackground(new java.awt.Color(102, 153, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/edit-icon-24x24.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator2);

        btnDel.setBackground(new java.awt.Color(102, 153, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Button-Close-icon_24x24.png"))); // NOI18N
        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDel);

        btnSave.setBackground(new java.awt.Color(102, 153, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Save-icon-24x24.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);
        jToolBar1.add(jSeparator3);

        btnReload.setBackground(new java.awt.Color(102, 153, 255));
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Refresh-icon-24x24.png"))); // NOI18N
        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReload);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("ĐVT Cha");

        cobDVT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Chuyển Đổi");

        tbUnit = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbUnit.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUnit.setGridColor(new java.awt.Color(204, 204, 204));
        tbUnit.setRowHeight(25);
        tbUnit.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tbUnit.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbUnitMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbUnit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(cobDVT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCast)
                    .addComponent(txtName))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cobDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        add = true;
        enableControl(false);
        txtName.setText("");
        txtName.requestFocus();

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        enableControl(false);
        txtName.requestFocus();
        x = txtName.getText().trim();
    }//GEN-LAST:event_btnEditActionPerformed

    private void tbUnitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnitMouseReleased
        int index = tbUnit.getSelectedRow();
        txtID.setText(tbUnit.getValueAt(index, 0).toString());
        txtName.setText(tbUnit.getValueAt(index, 1).toString());
        try {
            txtCast.setText(tbUnit.getValueAt(index, 3).toString());
        } catch (Exception e) {
            txtCast.setText("");
        }
        try {
            setSelectedUnit(cobDVT, Integer.parseInt(tbUnit.getValueAt(index, 4).toString()));
        } catch (Exception e) {
            setSelectedUnit(cobDVT, 0);
        }

    }//GEN-LAST:event_tbUnitMouseReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa nhập tên đơn vị tính", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
        } else {
            String name = txtName.getText();
            vn.edu.vttu.model.Unit unit = (vn.edu.vttu.model.Unit) cobDVT.getSelectedItem();
            String id_unit_parent = null;
            if (unit.getId() == 0) {
            } else {
                id_unit_parent = unit.getId() + "";
            }
            String cast = txtCast.getText();
            Connection conn = ConnectDB.conn();
            try {
                if (add == true) {
                    if (id_unit_parent == null) {
                        if (Unit.insert(name, id_unit_parent, cast, true, conn)) {
                            JOptionPane.showMessageDialog(getRootPane(), "Thêm đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                            loadUnit();
                            fillcobUnit();
                            enableControl(true);
                        } else {
                            JOptionPane.showMessageDialog(getRootPane(), "Thêm đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                            loadUnit();
                            fillcobUnit();
                        }
                    } else {
                        if (Unit.insert(name, id_unit_parent, cast, false, conn)) {
                            if (Unit.updateParent(true, Integer.parseInt(id_unit_parent), conn)) {
                                JOptionPane.showMessageDialog(getRootPane(), "Thêm đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                loadUnit();
                                fillcobUnit();
                                enableControl(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(getRootPane(), "Thêm đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                            loadUnit();
                            fillcobUnit();
                        }
                    }
                } else {
                    if (!x.equals(txtName.getText())) {
                        if (Unit.testName(txtName.getText().trim(), conn) == false) {
                            JOptionPane.showMessageDialog(getRootPane(), "Tên đơn vị tính đã có", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                            txtName.setText("");
                            txtName.requestFocus();
                        } else {
                            if (id_unit_parent == null) {
                                if (Unit.update(name, id_unit_parent, cast, true, Integer.parseInt(txtID.getText()), conn)) {
                                    JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                    loadUnit();
                                    fillcobUnit();
                                    enableControl(true);
                                } else {
                                    JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                if (Unit.update(name, id_unit_parent, cast, false, Integer.parseInt(txtID.getText()), conn)) {
                                    if (Unit.updateParent(true, Integer.parseInt(id_unit_parent), conn)) {
                                        JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                        loadUnit();
                                        fillcobUnit();
                                        enableControl(true);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } else {
                        if (id_unit_parent == null) {
                            if (Unit.update(name, id_unit_parent, cast, true, Integer.parseInt(txtID.getText()), conn)) {
                                JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                loadUnit();
                                fillcobUnit();
                                enableControl(true);
                            } else {
                                JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            if (Unit.update(name, id_unit_parent, cast, false, Integer.parseInt(txtID.getText()), conn)) {
                                if (Unit.updateParent(true, Integer.parseInt(id_unit_parent), conn)) {
                                    JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                    loadUnit();
                                    fillcobUnit();
                                    enableControl(true);
                                }
                            } else {
                                JOptionPane.showMessageDialog(getRootPane(), "Cập nhật đơn vị tính không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (Exception e) {
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        loadUnit();
        enableControl(true);
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        Connection conn = ConnectDB.conn();
        try {
            if (txtID.getText().equals("")) {
                JOptionPane.showMessageDialog(getRootPane(), "Bạn chưa chọn đơn vị tính", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if (JOptionPane.showConfirmDialog(getRootPane(), "Bạn thật sự muốn xóa", "Thông Báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (Unit.delete(Integer.parseInt(txtID.getText()), conn)) {
                        JOptionPane.showMessageDialog(getRootPane(), "Xóa thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                        loadUnit();
                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Xóa không thành công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnadd;
    private javax.swing.JComboBox cobDVT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbUnit;
    private javax.swing.JTextField txtCast;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
