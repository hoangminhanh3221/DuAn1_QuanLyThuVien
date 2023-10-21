/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hma20
 */
public class TrangChuSinhVienFrame extends javax.swing.JFrame {

    /**
     * Creates new form TrangChuFrame
     */
    public TrangChuSinhVienFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setClock();
        openMain(ttpanel, "Thong tin sinh vien");
        setColorMenu(pnlThongTin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlThongTin = new javax.swing.JPanel();
        btnThongTin = new javax.swing.JButton();
        pnlSach = new javax.swing.JPanel();
        btnSach = new javax.swing.JButton();
        pnlPhieuMuon = new javax.swing.JPanel();
        btnPhieuMuon = new javax.swing.JButton();
        lblDateTime = new javax.swing.JLabel();
        TittleBar = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblDoiMatKhau = new javax.swing.JLabel();
        lblTroGiup = new javax.swing.JLabel();
        lblGioiThieu = new javax.swing.JLabel();
        lblDoiMatKhau1 = new javax.swing.JLabel();
        tbpHome = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(0, 119, 182));
        pnlMenu.setMaximumSize(new java.awt.Dimension(200, 600));
        pnlMenu.setMinimumSize(new java.awt.Dimension(200, 600));
        pnlMenu.setPreferredSize(new java.awt.Dimension(200, 700));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlMenu.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/icons8_user_32px.png"))); // NOI18N
        pnlMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        pnlThongTin.setBackground(new java.awt.Color(0, 119, 182));
        pnlThongTin.setMaximumSize(new java.awt.Dimension(200, 50));
        pnlThongTin.setMinimumSize(new java.awt.Dimension(200, 50));

        btnThongTin.setBackground(new java.awt.Color(28, 40, 89));
        btnThongTin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/trangchu_24px.png"))); // NOI18N
        btnThongTin.setText("Thong tin");
        btnThongTin.setBorder(null);
        btnThongTin.setBorderPainted(false);
        btnThongTin.setContentAreaFilled(false);
        btnThongTin.setDefaultCapable(false);
        btnThongTin.setFocusPainted(false);
        btnThongTin.setFocusable(false);
        btnThongTin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongTinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongTinMouseExited(evt);
            }
        });
        btnThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, -1));

        pnlSach.setBackground(new java.awt.Color(0, 119, 182));
        pnlSach.setMaximumSize(new java.awt.Dimension(200, 50));
        pnlSach.setMinimumSize(new java.awt.Dimension(200, 50));

        btnSach.setBackground(new java.awt.Color(28, 40, 89));
        btnSach.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSach.setForeground(new java.awt.Color(255, 255, 255));
        btnSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/sach_24px.png"))); // NOI18N
        btnSach.setText("Sach");
        btnSach.setBorder(null);
        btnSach.setBorderPainted(false);
        btnSach.setContentAreaFilled(false);
        btnSach.setDefaultCapable(false);
        btnSach.setFocusPainted(false);
        btnSach.setFocusable(false);
        btnSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSachMouseExited(evt);
            }
        });
        btnSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSachLayout = new javax.swing.GroupLayout(pnlSach);
        pnlSach.setLayout(pnlSachLayout);
        pnlSachLayout.setHorizontalGroup(
            pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSachLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnSach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSachLayout.setVerticalGroup(
            pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSach, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, -1));

        pnlPhieuMuon.setBackground(new java.awt.Color(0, 119, 182));
        pnlPhieuMuon.setMaximumSize(new java.awt.Dimension(200, 50));
        pnlPhieuMuon.setMinimumSize(new java.awt.Dimension(200, 50));

        btnPhieuMuon.setBackground(new java.awt.Color(28, 40, 89));
        btnPhieuMuon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/phieumuon_24px.png"))); // NOI18N
        btnPhieuMuon.setText("Phieu muon");
        btnPhieuMuon.setBorder(null);
        btnPhieuMuon.setBorderPainted(false);
        btnPhieuMuon.setContentAreaFilled(false);
        btnPhieuMuon.setDefaultCapable(false);
        btnPhieuMuon.setFocusPainted(false);
        btnPhieuMuon.setFocusable(false);
        btnPhieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPhieuMuonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPhieuMuonMouseExited(evt);
            }
        });
        btnPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuMuonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPhieuMuonLayout = new javax.swing.GroupLayout(pnlPhieuMuon);
        pnlPhieuMuon.setLayout(pnlPhieuMuonLayout);
        pnlPhieuMuonLayout.setHorizontalGroup(
            pnlPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhieuMuonLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlPhieuMuonLayout.setVerticalGroup(
            pnlPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, -1));

        lblDateTime.setForeground(new java.awt.Color(255, 255, 255));
        lblDateTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateTime.setText("DayTime");
        pnlMenu.add(lblDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 150, 30));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        TittleBar.setBackground(new java.awt.Color(0, 119, 182));
        TittleBar.setMaximumSize(new java.awt.Dimension(1000, 36));
        TittleBar.setMinimumSize(new java.awt.Dimension(1000, 36));
        TittleBar.setPreferredSize(new java.awt.Dimension(1000, 50));
        TittleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Thong tin");
        TittleBar.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 240, 40));

        lblDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/doimatkhau_24px.png"))); // NOI18N
        lblDoiMatKhau.setText("Dang Xuat");
        TittleBar.add(lblDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 120, 50));

        lblTroGiup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTroGiup.setForeground(new java.awt.Color(255, 255, 255));
        lblTroGiup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/trogiup_24px.png"))); // NOI18N
        lblTroGiup.setText("Tro Giup");
        TittleBar.add(lblTroGiup, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 120, 50));

        lblGioiThieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGioiThieu.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiThieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/gioithieu_24px.png"))); // NOI18N
        lblGioiThieu.setText("Gioi Thieu");
        TittleBar.add(lblGioiThieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 120, 50));

        lblDoiMatKhau1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDoiMatKhau1.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoiMatKhau1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/doimatkhau_24px.png"))); // NOI18N
        lblDoiMatKhau1.setText("Doi mat khau");
        TittleBar.add(lblDoiMatKhau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 120, 50));

        getContentPane().add(TittleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 50));

        tbpHome.setBackground(new java.awt.Color(255, 255, 255));
        tbpHome.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tbpHome.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        tbpHome.addTab("tab1", jPanel1);

        getContentPane().add(tbpHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 1050, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSachMouseEntered
        hover(true, pnlSach);
    }//GEN-LAST:event_btnSachMouseEntered

    private void btnSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSachMouseExited
        hover(false, pnlSach);
    }//GEN-LAST:event_btnSachMouseExited

    private void btnSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSachActionPerformed
        openMain(spanel, "Sach");
    }//GEN-LAST:event_btnSachActionPerformed

    private void btnPhieuMuonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhieuMuonMouseEntered
        hover(true, pnlPhieuMuon);
    }//GEN-LAST:event_btnPhieuMuonMouseEntered

    private void btnPhieuMuonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhieuMuonMouseExited
        hover(false, pnlPhieuMuon);
    }//GEN-LAST:event_btnPhieuMuonMouseExited

    private void btnPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuMuonActionPerformed
        openMain(pmpanel, "Phieu muon");
    }//GEN-LAST:event_btnPhieuMuonActionPerformed

    private void btnThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongTinMouseEntered
        // TODO add your handling code here:
        hover(true, pnlThongTin);
    }//GEN-LAST:event_btnThongTinMouseEntered

    private void btnThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongTinMouseExited
        // TODO add your handling code here:
        hover(false, pnlThongTin);
    }//GEN-LAST:event_btnThongTinMouseExited

    private void btnThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinActionPerformed
        // TODO add your handling code here:
        openMain(ttpanel, "Thong tin sinh vien");
    }//GEN-LAST:event_btnThongTinActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuSinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuSinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuSinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuSinhVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuSinhVienFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TittleBar;
    private javax.swing.JButton btnPhieuMuon;
    private javax.swing.JButton btnSach;
    private javax.swing.JButton btnThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblDoiMatKhau1;
    private javax.swing.JLabel lblGioiThieu;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTroGiup;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPhieuMuon;
    private javax.swing.JPanel pnlSach;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JTabbedPane tbpHome;
    // End of variables declaration//GEN-END:variables

    Timer clock;
    Color no = new Color(0,119,182);
    Color yes = new Color(96,177,255);
    SinhVien_ThongTinPanel ttpanel = new SinhVien_ThongTinPanel();
    SinhVien_SachPanel spanel=new SinhVien_SachPanel();
    SinhVien_PhieuMuonPanel pmpanel = new SinhVien_PhieuMuonPanel();
    
    private void setClock() {
        clock = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss aa");
                Date day = new Date();
                String time = sdf.format(day);
                lblDateTime.setText(time);
            }
        });
        clock.start();
    }
    
    private void setColorMenu(JPanel panel){
        JPanel[] panels = new JPanel[]{
            pnlThongTin,
            pnlSach,
            pnlPhieuMuon
        };
        for (int i = 0; i < panels.length; i++) {
            if(panel == panels[i]){
                panels[i].setBackground(yes);
            } else {
                panels[i].setBackground(no);
            }
        }
    }
    
    private void openMain(JPanel panel, String title) {
        tbpHome.removeAll();
        tbpHome.addTab("tab 1",panel);
        lblTitle.setText(title);
        tbpHome.setSelectedComponent(panel);
    }
    
    private void hover(boolean isHover, JPanel panel){
        if(isHover){
            panel.setBackground(yes);
        } else {
            panel.setBackground(no);
        }
    }
    
}