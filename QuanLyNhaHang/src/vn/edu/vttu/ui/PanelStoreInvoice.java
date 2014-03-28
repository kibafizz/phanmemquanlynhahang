/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.vttu.ui;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.ExportExcel;
import vn.edu.vttu.data.NumberCellRenderer;
import vn.edu.vttu.data.RawMaterialInvoice;
import vn.edu.vttu.data.RawMaterialInvoiceDetail;

/**
 *
 * @author nhphuoc
 */
public class PanelStoreInvoice extends javax.swing.JPanel {

    /**
     * Creates new form PanelStoreInvoice
     */
    public PanelStoreInvoice() {
        initComponents();
        dtfromdate.setDate(new Date());
        dttodate.setDate(new Date());
        //loadTableStoreInvoice();
    }
    private void loadTableStoreInvoice(Timestamp from, Timestamp to){
        tbStoreInvoice.setModel(RawMaterialInvoice.getByDate(from,to,ConnectDB.conn()));
         tbStoreInvoice.getTableHeader().setReorderingAllowed(false);
    }
    private void loadTableStoreInvoiceDetail(int id){
        tbRawmaterialDetail.setModel(RawMaterialInvoiceDetail.getByIdRawmaterial(id, ConnectDB.conn()));
        tbRawmaterialDetail.getTableHeader().setReorderingAllowed(false);
        tbRawmaterialDetail.getColumnModel().getColumn(2).setCellRenderer(new NumberCellRenderer());
        tbRawmaterialDetail.getColumnModel().getColumn(3).setCellRenderer(new NumberCellRenderer());
        tbRawmaterialDetail.getColumnModel().getColumn(4).setCellRenderer(new NumberCellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dtfromdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dttodate = new com.toedter.calendar.JDateChooser();
        jToolBar3 = new javax.swing.JToolBar();
        btnSearch = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        btnExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStoreInvoice = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRawmaterialDetail = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        jLabel8.setBackground(new java.awt.Color(102, 153, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 153, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HÓA ĐƠN NHẬP HÀNG");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Từ Ngày:");

        dtfromdate.setDate(new Date());
        dtfromdate.setDateFormatString("dd/MM/yyyy");
        dtfromdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtfromdatePropertyChange(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Đến Ngày:");

        dttodate.setDate(new Date());
        dttodate.setDateFormatString("dd/MM/yyyy");
        dttodate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dttodatePropertyChange(evt);
            }
        });

        jToolBar3.setBackground(new java.awt.Color(51, 153, 255));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnSearch.setBackground(new java.awt.Color(51, 153, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Search-icon.png"))); // NOI18N
        btnSearch.setText("Tìm Kiếm Hóa Đơn");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar3.add(btnSearch);

        jToolBar4.setBackground(new java.awt.Color(31, 114, 70));
        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        btnExport.setBackground(new java.awt.Color(31, 114, 70));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Excel-icon.png"))); // NOI18N
        btnExport.setText("Xuất Ra Excel");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jToolBar4.add(btnExport);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Tổng Cộng");

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 51, 0));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(dtfromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dttodate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(dtfromdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dttodate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbStoreInvoice = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbStoreInvoice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbStoreInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ngày Lập", "Nhân Viên", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbStoreInvoice.setGridColor(new java.awt.Color(204, 204, 204));
        tbStoreInvoice.setRowHeight(25);
        tbStoreInvoice.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tbStoreInvoice.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbStoreInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbStoreInvoiceMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbStoreInvoice);

        tbRawmaterialDetail = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbRawmaterialDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mặt Hàng", "ĐVT", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRawmaterialDetail.setGridColor(new java.awt.Color(204, 204, 204));
        tbRawmaterialDetail.setRowHeight(23);
        tbRawmaterialDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tbRawmaterialDetail);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setText("Chi Tiết Hóa Đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dtfromdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtfromdatePropertyChange
        if (dtfromdate.getDate().compareTo(dttodate.getDate()) > 0) {
            dttodate.setDate(dtfromdate.getDate());
        }
    }//GEN-LAST:event_dtfromdatePropertyChange

    private void dttodatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dttodatePropertyChange
        if (dtfromdate.getDate().compareTo(dttodate.getDate()) > 0) {
            dtfromdate.setDate(dttodate.getDate());
        }
    }//GEN-LAST:event_dttodatePropertyChange

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime1 = formatter.format(dtfromdate.getDate());
        Timestamp from = Timestamp.valueOf(datetime1);
        
        String datetime2 = formatter.format(dttodate.getDate());
        Timestamp to = Timestamp.valueOf(datetime2);
        loadTableStoreInvoice(from, to);
        tbStoreInvoice.getColumnModel().getColumn(3).setCellRenderer(new NumberCellRenderer());
        tbStoreInvoice.getTableHeader().setReorderingAllowed(false);
        int total = 0;
        for(int i=0;i<tbStoreInvoice.getRowCount();i++){
            float n=0;
            try {
                n=Float.parseFloat(tbStoreInvoice.getValueAt(i, 3).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
           total=(int) (total+n);
        }
        DecimalFormat df = new DecimalFormat("#,###,###");
        lbTotal.setText(df.format(total));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbStoreInvoiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStoreInvoiceMouseReleased
        int index = tbStoreInvoice.getSelectedRow();
        int id= Integer.parseInt(String.valueOf(tbStoreInvoice.getValueAt(index, 0)));
        loadTableStoreInvoiceDetail(id);
    }//GEN-LAST:event_tbStoreInvoiceMouseReleased

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        ExportExcel ex = new ExportExcel();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String from = formatter.format(dtfromdate.getDate());
        String to = formatter.format(dttodate.getDate());
        String fileName = "THONG_KE_HOA_NHAP_KHO_TU_NGAY_" + from + "_DEN_" + to;
        String sheetName = "THỐNG KÊ NHẬP KHO";
        String header = "THỐNG KÊ HÓA ĐƠN NHẬP KHO TỪ NGÀY " + from + " ĐẾN " + to;
        int col = tbStoreInvoice.getColumnCount();
        int row = tbStoreInvoice.getRowCount();        
        ex.exportExcel(fileName, header, sheetName, col, row, tbStoreInvoice.getModel());
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dtfromdate;
    private com.toedter.calendar.JDateChooser dttodate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbRawmaterialDetail;
    private javax.swing.JTable tbStoreInvoice;
    // End of variables declaration//GEN-END:variables
}
