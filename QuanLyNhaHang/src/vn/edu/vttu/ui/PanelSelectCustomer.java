/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vttu.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import vn.edu.vttu.data.Customer;
import vn.edu.vttu.data.TableReservation;
import vn.edu.vttu.data.TableService;
import vn.edu.vttu.data.ConnectDB;

/**
 *
 * @author nhphuoc
 */
public class PanelSelectCustomer extends javax.swing.JPanel {

    /**
     * Creates new form pn
     */
    private JPopupMenu popupMenuTableInvoice;
    private Connection conn = ConnectDB.conn();

    public PanelSelectCustomer() {
        initComponents();
        loadTable();
        txtSearchCustomer.requestFocus();
        //popupTableCustomer();
    }

    private void loadTable() {
        tbCustomer.setModel(Customer.getLimit(conn));
        try {
            tbCustomer.setRowSelectionInterval(0, 0);
            Customer.setID(Integer.parseInt(String.valueOf(tbCustomer.getValueAt(0, 0))));
        } catch (Exception e) {
        }
        
        tbCustomer.getTableHeader().setReorderingAllowed(false);
    }

    private void popupTableCustomer() {
        try {
            popupMenuTableInvoice = new JPopupMenu();
            BufferedImage bImgCalService = ImageIO.read(getClass().getResourceAsStream("/vn/edu/vttu/image/add-icon.png"));
            Image imageCalService = bImgCalService.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
            popupMenuTableInvoice.add(new JMenuItem(new AbstractAction("Thêm Khách Hàng", new ImageIcon(imageCalService)) {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }));
            tbCustomer.setComponentPopupMenu(popupMenuTableInvoice);
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearchCustomer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        txtSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCustomerKeyReleased(evt);
            }
        });

        tbCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbCustomer = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
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
        tbCustomer.setRowHeight(23);
        tbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomerMouseClicked(evt);
            }
        });
        tbCustomer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbCustomerFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tbCustomer);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Tìm  Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchCustomer)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerMouseClicked
        int index = tbCustomer.getSelectedRow();
        Customer.setID(Integer.parseInt(String.valueOf(tbCustomer.getValueAt(index, 0))));
    }//GEN-LAST:event_tbCustomerMouseClicked

    private void txtSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCustomerKeyReleased
        tbCustomer.setModel(Customer.searchNamePhone(txtSearchCustomer.getText(), conn));
        tbCustomer.setRowSelectionInterval(0, 0);
        Customer.setID(Integer.parseInt(String.valueOf(tbCustomer.getValueAt(0, 0))));

    }//GEN-LAST:event_txtSearchCustomerKeyReleased

    private void tbCustomerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbCustomerFocusGained

    }//GEN-LAST:event_tbCustomerFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
