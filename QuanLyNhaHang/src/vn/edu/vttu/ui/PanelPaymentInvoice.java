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
import javax.swing.JOptionPane;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.NumberCellRenderer;
import vn.edu.vttu.data.PaymentInvoice;

/**
 *
 * @author nhphuoc
 */
public class PanelPaymentInvoice extends javax.swing.JPanel {

    /**
     * Creates new form PanelPaymentInvoice
     */
    public PanelPaymentInvoice() {
        initComponents();
        dtFromDate.setDate(new Date());
        dtToDate.setDate(new Date());
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
        dtFromDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dtToDate = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        btnSearchPaymentInvoice = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnExportExcel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbNumberInvoice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        btnAddInvoice = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInvoicePayment = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Từ Ngày:");

        dtFromDate.setDateFormatString("dd/MM/yyyy");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Đến Ngày:");

        dtToDate.setDateFormatString("dd/MM/yyyy");

        jToolBar1.setBackground(new java.awt.Color(102, 153, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSearchPaymentInvoice.setBackground(new java.awt.Color(102, 153, 255));
        btnSearchPaymentInvoice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchPaymentInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchPaymentInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Search-icon.png"))); // NOI18N
        btnSearchPaymentInvoice.setText("Tìm Kiếm Phiếu Chi");
        btnSearchPaymentInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPaymentInvoiceActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearchPaymentInvoice);

        jToolBar2.setBackground(new java.awt.Color(31, 114, 70));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnExportExcel.setBackground(new java.awt.Color(31, 114, 70));
        btnExportExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Excel-icon.png"))); // NOI18N
        btnExportExcel.setText("Xuất Ra Excel");
        jToolBar2.add(btnExportExcel);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Tổng Phiếu: ");

        lbNumberInvoice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNumberInvoice.setForeground(new java.awt.Color(0, 0, 255));
        lbNumberInvoice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNumberInvoice.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Tổng Tiền:");

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(0, 0, 255));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("0");

        jToolBar3.setBackground(new java.awt.Color(0, 153, 255));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnAddInvoice.setBackground(new java.awt.Color(0, 153, 255));
        btnAddInvoice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnAddInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/add-icon_24x24.png"))); // NOI18N
        btnAddInvoice.setText("Viết Phiếu Chi");
        btnAddInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInvoiceActionPerformed(evt);
            }
        });
        jToolBar3.add(btnAddInvoice);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumberInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbNumberInvoice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbTotal))
                .addGap(31, 31, 31)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbInvoicePayment = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbInvoicePayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày Lập", "Người Lập", "Số Tiền", "Thông Tin", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInvoicePayment.setGridColor(new java.awt.Color(204, 204, 204));
        tbInvoicePayment.setRowHeight(25);
        tbInvoicePayment.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tbInvoicePayment.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbInvoicePayment);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchPaymentInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPaymentInvoiceActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFromDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbInvoicePayment.setModel(PaymentInvoice.getByDate(tsStart, tsToDate, ConnectDB.conn()));
        tbInvoicePayment.getColumnModel().getColumn(2).setCellRenderer(new NumberCellRenderer());
        int numberInvoice=tbInvoicePayment.getRowCount();
        int total=0;
        for(int i=0;i<tbInvoicePayment.getRowCount();i++){
            int cost=0;
            try {
                cost=Integer.parseInt(String.valueOf(tbInvoicePayment.getValueAt(i, 2)).trim().replaceAll("\\.", ""));
            } catch (Exception e) {
                cost=Integer.parseInt(String.valueOf(tbInvoicePayment.getValueAt(i, 2)).trim().replaceAll(",", ""));
            }
            total=total+cost;
        }
        DecimalFormat df = new DecimalFormat("#,###,###");
        lbNumberInvoice.setText(df.format(numberInvoice));
        lbTotal.setText(df.format(total));
    }//GEN-LAST:event_btnSearchPaymentInvoiceActionPerformed

    private void btnAddInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInvoiceActionPerformed
        int result = JOptionPane.showOptionDialog(null, new PanelWritePaymentInvoice(),
                "Viết Phiếu Chi", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    }//GEN-LAST:event_btnAddInvoiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInvoice;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnSearchPaymentInvoice;
    private com.toedter.calendar.JDateChooser dtFromDate;
    private com.toedter.calendar.JDateChooser dtToDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lbNumberInvoice;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbInvoicePayment;
    // End of variables declaration//GEN-END:variables
}
