/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.time.DateUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.Invoice;

/**
 *
 * @author nhphuoc
 */
public class PanelStatiticsRevenue extends javax.swing.JPanel {

    /**
     * Creates new form PanelStatiticsRevenue
     */
    public PanelStatiticsRevenue() {
        initComponents();
    }

    private void statiticsDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFormDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbResult.setModel(Invoice.getStatiticsByDate(tsStart, tsToDate, ConnectDB.conn()));
    }

    private void statiticsMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFormDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbResult.setModel(Invoice.getStatiticsByMonth(tsStart, tsToDate, ConnectDB.conn()));
    }

    private void statiticsYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetimeStart = formatter.format(dtFormDate.getDate());
        Timestamp tsStart = Timestamp.valueOf(datetimeStart);
        String datetimeEnd = formatter.format(dtToDate.getDate());
        Timestamp tsToDate = Timestamp.valueOf(datetimeEnd);
        tbResult.setModel(Invoice.getStatiticsByYear(tsStart, tsToDate, ConnectDB.conn()));
    }

    private void showChart(String title, String begin, String end) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int row = tbResult.getRowCount();        
        for (int i = 0; i < row; i++) {
            float value = 0;
            try {
                try {
                    value = Float.parseFloat(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll("\\.", "")) / 1000;
                } catch (Exception e) {
                    value = Float.parseFloat(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll(",", "")) / 1000;
                }
            } catch (Exception e) {
                value=0;
            }
            String date = String.valueOf(tbResult.getValueAt(i, 0)).trim();

            dataset.addValue(value, "Doanh Thu", date);
        }

        JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ DOANH THU\nTỪ " + title + " " + begin + " ĐẾN " + title + " " + end, title, "Số Tiền(Đơn vị: nghìn đồng)", dataset);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
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
        jLabel1 = new javax.swing.JLabel();
        cobStatiticsCondition = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        dtFormDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dtToDate = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        btnStatitics = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbTotalInvoice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbTotalPay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResult = new javax.swing.JTable();
        pnChart = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Thống Kê Theo: ");

        cobStatiticsCondition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngày", "Tháng", "Năm" }));

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

        jButton1.setBackground(new java.awt.Color(31, 114, 70));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Excel-icon.png"))); // NOI18N
        jButton1.setText("Xuất Ra Excel");
        jToolBar2.add(jButton1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 153, 0));
        jLabel4.setText("Tổng Số Hóa Đơn");

        lbTotalInvoice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTotalInvoice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalInvoice.setText("0 Hóa Đơn");

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
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cobStatiticsCondition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cobStatiticsCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(dtFormDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotalInvoice)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        tbResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời Gian", "Số Hóa Đơn ", "Tổng Tiền Giảm Giá", "Tổng Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        pnChart.setLayout(new java.awt.GridLayout());

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatiticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatiticsActionPerformed
        int index = cobStatiticsCondition.getSelectedIndex();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy");
        switch (index) {
            case 0:
                statiticsDay();
                showChart("Ngày", format.format(dtFormDate.getDate()), format.format(dtToDate.getDate()));// thống kê theo ngày
                break;
            case 1:
                statiticsMonth();
                showChart("Tháng", format1.format(dtFormDate.getDate()), format1.format(dtToDate.getDate()));
                break;
            case 2:
                statiticsYear();
                showChart("Năm", format2.format(dtFormDate.getDate()), format2.format(dtToDate.getDate()));
                break;
            default:
                statiticsDay();
                showChart("Ngày", format.format(dtFormDate.getDate()), format.format(dtToDate.getDate()));// thống kê theo ngày
                break;
        }
        int row = tbResult.getRowCount();
        int totalInvoice = 0;
        for (int i = 0; i < row; i++) {
            totalInvoice = totalInvoice + Integer.parseInt(String.valueOf(tbResult.getValueAt(i, 1)));
        }
        int totalPay = 0;
        for (int i = 0; i < row; i++) {
            int value = 0;
            try {
                totalPay = Integer.parseInt(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll("\\.", ""));
            } catch (Exception e) {
                totalPay = Integer.parseInt(String.valueOf(tbResult.getValueAt(i, 3)).trim().replaceAll(",", ""));
            }
            totalPay = totalPay + value;
        }
        DecimalFormat df = new DecimalFormat("#,###,###");
        lbTotalInvoice.setText(df.format(totalInvoice) + " Hóa Đơn");
        lbTotalPay.setText(df.format(totalPay) + " VNĐ");
        //lbStatus.setText("Tổng số hóa đơn: "+);
    }//GEN-LAST:event_btnStatiticsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatitics;
    private javax.swing.JComboBox cobStatiticsCondition;
    private com.toedter.calendar.JDateChooser dtFormDate;
    private com.toedter.calendar.JDateChooser dtToDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbTotalInvoice;
    private javax.swing.JLabel lbTotalPay;
    private javax.swing.JPanel pnChart;
    private javax.swing.JTable tbResult;
    // End of variables declaration//GEN-END:variables
}
