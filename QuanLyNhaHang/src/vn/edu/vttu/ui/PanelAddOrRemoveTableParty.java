/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Customer;
import vn.edu.vttu.data.RestaurantInfo;
import vn.edu.vttu.data.Table;
import vn.edu.vttu.data.TableLocation;
import vn.edu.vttu.data.TableReservation;
import vn.edu.vttu.data.TableReservationDetail;
import vn.edu.vttu.data.VariableStatic;

/**
 *
 * @author nhphuoc
 */
public class PanelAddOrRemoveTableParty extends javax.swing.JPanel {

    class ItemRendererLocation extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            if (value != null) {
                vn.edu.vttu.model.TableLocation item = (vn.edu.vttu.model.TableLocation) value;
                setText(item.getName());
            }

            if (index == -1) {
                vn.edu.vttu.model.TableLocation item = (vn.edu.vttu.model.TableLocation) value;
                setText("" + item.getName());
            }

            return this;
        }
    }

    /**
     * Creates new form PanelAddOrRemoveTableParty
     */
    private RestaurantInfo rs=RestaurantInfo.getinfo(ConnectDB.conn());
    public PanelAddOrRemoveTableParty() {
        initComponents();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        lbMaHoaDon.setText(VariableStatic.getIdReservation() + "");
        lbKhachHang.setText(Customer.getByID(VariableStatic.getIdCustomer(), ConnectDB.conn()).getNAME());
        lbNgayNhanBan.setText(formatter.format(VariableStatic.getDateTimeReservation()));
        fillkhCombo(ConnectDB.conn());
        tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), ConnectDB.conn()));

    }

    private void loadTable(Timestamp ts, int location, Connection conn) {
        tbDanhSachBan.setModel(Table.getByDateNotReservation(ts, rs.getHourReservationParty(), location, conn));
        try {
            tbDanhSachBan.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tbDanhSachBan.getTableHeader().setReorderingAllowed(false);
    }

    private void fillkhCombo(Connection conn) {
        Vector<vn.edu.vttu.model.TableLocation> model = new Vector<vn.edu.vttu.model.TableLocation>();
        try {
            model = TableLocation.selectTableLocation(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel defaultComboBoxModel = new javax.swing.DefaultComboBoxModel(model);
        cobLocation.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        cobLocation.setModel(defaultComboBoxModel);
        cobLocation.setRenderer(new PanelAddOrRemoveTableParty.ItemRendererLocation());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSachBan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDanhSachBanDuocDat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbMaHoaDon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbNgayNhanBan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cobLocation = new javax.swing.JComboBox();

        tbDanhSachBan = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbDanhSachBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Bàn", "Tên Bàn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhSachBan.setGridColor(new java.awt.Color(204, 204, 204));
        tbDanhSachBan.setRowHeight(23);
        tbDanhSachBan.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tbDanhSachBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDanhSachBan);

        tbDanhSachBanDuocDat = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbDanhSachBanDuocDat.getTableHeader().setReorderingAllowed(false);
        tbDanhSachBanDuocDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Bàn", "Tên Bàn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhSachBanDuocDat.setGridColor(new java.awt.Color(204, 204, 204));
        tbDanhSachBanDuocDat.setRowHeight(23);
        tbDanhSachBanDuocDat.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tbDanhSachBanDuocDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachBanDuocDatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDanhSachBanDuocDat);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Mã Hóa Đơn");

        lbMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMaHoaDon.setText(" ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Khách Hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Ngày Nhận Bàn:");

        jLabel5.setText("Danh Sách Bàn");

        jLabel6.setText("Bàn Được Đặt");

        lbKhachHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbKhachHang.setText(" ");

        lbNgayNhanBan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNgayNhanBan.setText(" ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Vị Trí:");

        cobLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cobLocation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cobLocationPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNgayNhanBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(lbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(lbMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cobLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbMaHoaDon))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbNgayNhanBan))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cobLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cobLocationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cobLocationPropertyChange
        try {
            Connection conn = ConnectDB.conn();

            vn.edu.vttu.model.TableLocation tb = (vn.edu.vttu.model.TableLocation) cobLocation.getSelectedItem();
            int idlocation = tb.getId();
            loadTable(VariableStatic.getDateTimeReservation(), idlocation, conn);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_cobLocationPropertyChange

    private void tbDanhSachBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachBanMouseClicked
        if (evt.getClickCount() == 2) {
            Connection conn = ConnectDB.conn();
            int index = tbDanhSachBan.getSelectedRow();
            int id = Integer.parseInt(String.valueOf(tbDanhSachBan.getValueAt(index, 0)));
            try {
                conn.setAutoCommit(false);
                if (TableReservationDetail.insert(id,
                        VariableStatic.getIdReservation(), conn)) {
                    if (Table.updateStatus(id, 3, conn)) {
                        tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), conn));
                        conn.commit();
                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Không thể thêm","Thông Báo",JOptionPane.ERROR_MESSAGE);
                        throw new Exception();
                    }
                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "Không thể thêm","Thông Báo",JOptionPane.ERROR_MESSAGE);
                    throw new Exception();
                }
            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelAddOrRemoveTableParty.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_tbDanhSachBanMouseClicked

    private void tbDanhSachBanDuocDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachBanDuocDatMouseClicked
        if (evt.getClickCount() == 2) {
            int index = tbDanhSachBanDuocDat.getSelectedRow();
            int id = Integer.parseInt(String.valueOf(tbDanhSachBanDuocDat.getValueAt(index, 0)));
            Connection conn = ConnectDB.conn();
            try {
                conn.setAutoCommit(false);
                if (TableReservationDetail.delete(VariableStatic.getIdReservation(),
                        id, ConnectDB.conn())) {
                    if (TableReservation.countidTableReservation(id, conn) > 0) {
                        if (TableReservation.countidTableUsing(id, conn) > 0) {
                            if (Table.updateStatus(id, 2, conn)) {
                                conn.commit();
                                tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), ConnectDB.conn()));
                            } else {
                                throw new Exception();
                            }
                        } else {
                            if (Table.updateStatus(id, 3, conn)) {
                                conn.commit();
                                tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), ConnectDB.conn()));
                            }
                        }
                    } else {
                        if (TableReservation.countidTableUsing(id, conn) > 0) {
                            if (Table.updateStatus(id, 2, conn)) {
                                conn.commit();
                                tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), ConnectDB.conn()));
                            }
                        } else {
                            if (Table.updateStatus(id, 1, conn)) {
                                conn.commit();
                                tbDanhSachBanDuocDat.setModel(TableReservation.getListTable(VariableStatic.getIdReservation(), ConnectDB.conn()));
                            }
                        }
                    }
                }

            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_tbDanhSachBanDuocDatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cobLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbNgayNhanBan;
    private javax.swing.JTable tbDanhSachBan;
    private javax.swing.JTable tbDanhSachBanDuocDat;
    // End of variables declaration//GEN-END:variables
}
