/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.ExportExcel;
import vn.edu.vttu.data.Invoice;
import vn.edu.vttu.data.NumberCellRenderer;
import vn.edu.vttu.data.TableService;

/**
 *
 * @author nhphuoc
 */
public class PanelStatiticsService extends javax.swing.JPanel {

    /**
     * Creates new form PanelStatiticsRevenue
     */
    private int totalNumber=0;
    public PanelStatiticsService() {
        initComponents();
    }

    private void statiticsYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFormDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbResult.setModel(Invoice.getStatiticsByYear(tsStart, tsToDate, ConnectDB.conn()));
    }

    private void showChart() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DefaultPieDataset dataset = new DefaultPieDataset();
        int row = tbResult.getRowCount();
        for(int i=0;i<row;i++){
            totalNumber=totalNumber+Integer.parseInt(String.valueOf(tbResult.getValueAt(i, 3)));
        }
        for (int i = 0; i < row; i++) {
            double value = 0;
            try {
                try {
                    value = Double.parseDouble(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll("\\.", ""));
                } catch (Exception e) {
                    value = Double.parseDouble(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll(",", ""));
                }
            } catch (Exception e) {
                value = 0;
            }
            String name = String.valueOf(tbResult.getValueAt(i, 1)).trim();
            DecimalFormat df = new DecimalFormat("###,##");
            value=(value/totalNumber)*100;
            System.out.println(totalNumber);
            dataset.setValue(name, value);
        }                
        
        JFreeChart chart = ChartFactory.createPieChart3D("THỐNG KÊ TỶ LỆ SỬ DỤNG DỊCH VỤ",dataset,true,true,true);
        PiePlot3D p = (PiePlot3D)chart.getPlot(); 
        p.setNoDataMessage("Không có dữ liệu thống kê");
        ChartPanel CP = new ChartPanel(chart);
        pnChart.removeAll();
        pnChart.add(CP);
        pnChart.updateUI();
        pnChart.repaint();
        //ChartFrame frame = new ChartFrame("Thống kê doanh thu", chart);
        //frame.setSize(450, 350);
        //frame.setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        dtFormDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dtToDate = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        btnStatitics = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnExport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbTotalPay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResult = new javax.swing.JTable();
        pnChart = new javax.swing.JPanel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Từ Ngày:");

        dtFormDate.setDateFormatString("dd/MM/yyyy");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Đến Ngày:");

        dtToDate.setDateFormatString("dd/MM/yyyy");

        jToolBar1.setBackground(new java.awt.Color(102, 153, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnStatitics.setBackground(new java.awt.Color(102, 153, 255));
        btnStatitics.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnStatitics.setForeground(new java.awt.Color(255, 255, 255));
        btnStatitics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/statistics.png"))); // NOI18N
        btnStatitics.setText("Thống Kê");
        btnStatitics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatiticsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStatitics);

        jToolBar2.setBackground(new java.awt.Color(31, 114, 70));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

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
        jToolBar2.add(btnExport);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 153, 0));
        jLabel5.setText("Tổng Doanh Thu:");

        lbTotalPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTotalPay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalPay.setText("0 VNĐ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtFormDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 33, Short.MAX_VALUE)
                            .addComponent(dtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(dtFormDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        tbResult = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tbResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại Dịch Vụ", "Tên Dịch Vụ", "ĐVT", "Số Lượng Bán", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResult.setGridColor(new java.awt.Color(204, 204, 204));
        tbResult.setRowHeight(25);
        tbResult.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tbResult.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbResult);

        pnChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnChart.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(pnChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnChart, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatiticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatiticsActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFormDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbResult.setModel(TableService.getStatiticsService(tsStart, tsToDate, ConnectDB.conn()));
        tbResult.getColumnModel().getColumn(4).setCellRenderer(new NumberCellRenderer());
        tbResult.getTableHeader().setReorderingAllowed(false);
        showChart();
        int total=0;
        for(int i=0;i<tbResult.getRowCount();i++){
            int x=0;
            try {
                x=Integer.parseInt(tbResult.getValueAt(i, 4).toString().replaceAll("\\.", ""));
            } catch (Exception e) {
                x=Integer.parseInt(tbResult.getValueAt(i, 4).toString().replaceAll(",", ""));
            }           
            total=total+x;                    
        }
        DecimalFormat df = new DecimalFormat("#,###,###");
        lbTotalPay.setText(df.format(total)+" VNĐ");
    }//GEN-LAST:event_btnStatiticsActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
       ExportExcel ex = new ExportExcel();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String from = formatter.format(dtFormDate.getDate());
        String to = formatter.format(dtToDate.getDate());
        String fileName = "THONG_DICH_VU_TU_NGAY_" + from + "_DEN_" + to;
        String sheetName = "THỐNG SỬ DỤNG DỊCH VỤ";
        String header = "THỐNG KÊ SỬ DỤNG DỊCH VỤ TỪ NGÀY " + from + " ĐẾN " + to;
        int col = tbResult.getColumnCount();
        int row = tbResult.getRowCount();        
        ex.exportExcel(fileName, header, sheetName, col, row, tbResult.getModel());
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnStatitics;
    private com.toedter.calendar.JDateChooser dtFormDate;
    private com.toedter.calendar.JDateChooser dtToDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbTotalPay;
    private javax.swing.JPanel pnChart;
    private javax.swing.JTable tbResult;
    // End of variables declaration//GEN-END:variables
}
