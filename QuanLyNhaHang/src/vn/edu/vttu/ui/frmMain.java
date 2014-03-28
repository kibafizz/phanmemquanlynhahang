/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.UIManager;
import vn.edu.vttu.data.ConnectDB;
import vn.edu.vttu.data.LoginInformation;
import vn.edu.vttu.data.Staff;

/**
 *
 * @author nhphuoc
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    int x=0;int y=100;
    public frmMain() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        String u = Staff.getById(LoginInformation.getId_staff(), ConnectDB.conn()).getName();
        lbLoginUser.setText("Nhân Viên: " + u);
        main.removeAll();
        PanelTable pn_table = new PanelTable();
        main.add(pn_table);
        main.revalidate();
        main.repaint();                
    }  
    public void paint() {        
        Graphics2D g2 = null;
        g2.drawString("abc", x, y);
        try{Thread.sleep(100);}catch(Exception ex){};
        x+=10;
        if(x>lbInfo.getWidth()){
            x=0;
        }
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSystem = new javax.swing.JButton();
        btnWaiter = new javax.swing.JButton();
        btnService = new javax.swing.JButton();
        btnStore = new javax.swing.JButton();
        btnPromotion = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnDifferentMoney = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnDistributor = new javax.swing.JButton();
        btnDanhMuc = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbLoginUser = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ NHÀ HÀNG - RSM");

        main.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(620, 80));
        jToolBar1.setMinimumSize(new java.awt.Dimension(620, 80));

        btnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/config-icon.png"))); // NOI18N
        btnSystem.setText("Hệ Thống");
        btnSystem.setFocusable(false);
        btnSystem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSystem.setMaximumSize(new java.awt.Dimension(77, 75));
        btnSystem.setMinimumSize(new java.awt.Dimension(77, 75));
        btnSystem.setPreferredSize(new java.awt.Dimension(77, 75));
        btnSystem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSystemActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSystem);

        btnWaiter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/waiter-icon.png"))); // NOI18N
        btnWaiter.setText("Phục Vụ");
        btnWaiter.setFocusable(false);
        btnWaiter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWaiter.setMaximumSize(new java.awt.Dimension(77, 75));
        btnWaiter.setMinimumSize(new java.awt.Dimension(77, 75));
        btnWaiter.setPreferredSize(new java.awt.Dimension(77, 75));
        btnWaiter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnWaiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaiterActionPerformed(evt);
            }
        });
        jToolBar1.add(btnWaiter);

        btnService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/menu.png"))); // NOI18N
        btnService.setText("Dịch Vụ");
        btnService.setFocusable(false);
        btnService.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnService.setMaximumSize(new java.awt.Dimension(77, 75));
        btnService.setMinimumSize(new java.awt.Dimension(77, 75));
        btnService.setPreferredSize(new java.awt.Dimension(77, 75));
        btnService.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiceActionPerformed(evt);
            }
        });
        jToolBar1.add(btnService);

        btnStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Factory-icon.png"))); // NOI18N
        btnStore.setText("Kho Hàng");
        btnStore.setFocusable(false);
        btnStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStore.setMaximumSize(new java.awt.Dimension(77, 75));
        btnStore.setMinimumSize(new java.awt.Dimension(77, 75));
        btnStore.setPreferredSize(new java.awt.Dimension(77, 75));
        btnStore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStore);

        btnPromotion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/promotion.png"))); // NOI18N
        btnPromotion.setText("Khuyến Mãi");
        btnPromotion.setFocusable(false);
        btnPromotion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPromotion.setMaximumSize(new java.awt.Dimension(77, 75));
        btnPromotion.setMinimumSize(new java.awt.Dimension(77, 75));
        btnPromotion.setPreferredSize(new java.awt.Dimension(77, 75));
        btnPromotion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPromotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromotionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPromotion);

        btnInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/invoice-icon.png"))); // NOI18N
        btnInvoice.setText("Hóa Đơn");
        btnInvoice.setFocusable(false);
        btnInvoice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInvoice.setMaximumSize(new java.awt.Dimension(77, 75));
        btnInvoice.setMinimumSize(new java.awt.Dimension(77, 75));
        btnInvoice.setPreferredSize(new java.awt.Dimension(77, 75));
        btnInvoice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInvoice);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/customer.png"))); // NOI18N
        jButton4.setText("Khách Hàng");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(77, 75));
        jButton4.setMinimumSize(new java.awt.Dimension(77, 75));
        jButton4.setPreferredSize(new java.awt.Dimension(77, 75));
        jButton4.setVerifyInputWhenFocusTarget(false);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btnStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/staff.png"))); // NOI18N
        btnStaff.setText("Nhân Viên");
        btnStaff.setFocusable(false);
        btnStaff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStaff.setMaximumSize(new java.awt.Dimension(77, 75));
        btnStaff.setMinimumSize(new java.awt.Dimension(77, 75));
        btnStaff.setPreferredSize(new java.awt.Dimension(77, 75));
        btnStaff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStaff);

        btnDifferentMoney.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Money-icon.png"))); // NOI18N
        btnDifferentMoney.setText("Chi Khác");
        btnDifferentMoney.setFocusable(false);
        btnDifferentMoney.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDifferentMoney.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDifferentMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDifferentMoneyActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDifferentMoney);

        btnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/statistics.png"))); // NOI18N
        btnStatistics.setText("Thống Kê");
        btnStatistics.setFocusable(false);
        btnStatistics.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStatistics.setMaximumSize(new java.awt.Dimension(77, 75));
        btnStatistics.setMinimumSize(new java.awt.Dimension(77, 75));
        btnStatistics.setPreferredSize(new java.awt.Dimension(77, 75));
        btnStatistics.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStatistics);

        btnDistributor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/companies-icon.png"))); // NOI18N
        btnDistributor.setText("Nhà Cung Cấp");
        btnDistributor.setFocusable(false);
        btnDistributor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDistributor.setMaximumSize(new java.awt.Dimension(77, 75));
        btnDistributor.setMinimumSize(new java.awt.Dimension(77, 75));
        btnDistributor.setPreferredSize(new java.awt.Dimension(77, 75));
        btnDistributor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDistributor);

        btnDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/catalog-icon.png"))); // NOI18N
        btnDanhMuc.setText("Danh Mục");
        btnDanhMuc.setFocusable(false);
        btnDanhMuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDanhMuc.setMaximumSize(new java.awt.Dimension(77, 75));
        btnDanhMuc.setMinimumSize(new java.awt.Dimension(77, 75));
        btnDanhMuc.setPreferredSize(new java.awt.Dimension(77, 75));
        btnDanhMuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDanhMuc);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/edu/vttu/image/Help-icon.png"))); // NOI18N
        jButton7.setText("Trợ Giúp");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(77, 75));
        jButton7.setMinimumSize(new java.awt.Dimension(77, 75));
        jButton7.setPreferredSize(new java.awt.Dimension(77, 75));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        lbLoginUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLoginUser.setForeground(new java.awt.Color(255, 0, 51));
        lbLoginUser.setText("Đăng Nhập:nhphuo ");

        lbInfo.setText("info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbLoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoginUser)
                    .addComponent(lbInfo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSystemActionPerformed
        main.removeAll();
        PanelConfigSystem configSystem = new PanelConfigSystem();
        main.add(configSystem);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnSystemActionPerformed

    private void btnWaiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaiterActionPerformed
        main.removeAll();
        PanelTable pn_table = new PanelTable();
        main.add(pn_table);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnWaiterActionPerformed

    private void btnServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceActionPerformed
        main.removeAll();
        PanelService panelservice = new PanelService();
        main.add(panelservice);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnServiceActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        main.removeAll();
        PanelCustomer panelcustomer = new PanelCustomer();
        main.add(panelcustomer);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        main.removeAll();
        PanelStaff panelstaff = new PanelStaff();
        main.add(panelstaff);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        main.removeAll();
        PanelInvoce panelinvoice = new PanelInvoce();
        main.add(panelinvoice);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void btnPromotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromotionActionPerformed
        main.removeAll();
        PanelPromotion panelpromotion = new PanelPromotion();
        main.add(panelpromotion);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnPromotionActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreActionPerformed
        main.removeAll();
        PanelStore panelstore = new PanelStore();
        main.add(panelstore);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        main.removeAll();
        PanelMenuStatistics panelmenustatitics = new PanelMenuStatistics();
        main.add(panelmenustatitics);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnStatisticsActionPerformed

    private void btnDifferentMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDifferentMoneyActionPerformed
        main.removeAll();
        PanelPaymentInvoice panelpaymentInvoive = new PanelPaymentInvoice();
        main.add(panelpaymentInvoive);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnDifferentMoneyActionPerformed

    private void btnDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributorActionPerformed
        main.removeAll();
        PanelDistributor panelDistributor = new PanelDistributor();
        main.add(panelDistributor);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnDistributorActionPerformed

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
       main.removeAll();
        PanelCatolog panelcatolog = new PanelCatolog();
        main.add(panelcatolog);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_btnDanhMucActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmMain frm = new frmMain();
                frm.setVisible(true);
                GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle bounds = env.getMaximumWindowBounds();
                frm.setMaximizedBounds(bounds);
                frm.setExtendedState(frm.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhMuc;
    private javax.swing.JButton btnDifferentMoney;
    private javax.swing.JButton btnDistributor;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnPromotion;
    private javax.swing.JButton btnService;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton btnStore;
    private javax.swing.JButton btnSystem;
    private javax.swing.JButton btnWaiter;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbLoginUser;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
