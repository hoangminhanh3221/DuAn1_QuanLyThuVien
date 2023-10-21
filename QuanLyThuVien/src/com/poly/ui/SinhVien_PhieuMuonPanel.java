/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ui;

import com.poly.dao.SvPhieuMuonDAO;
import com.poly.helper.Auth;
import com.poly.model.ChiTietPhieuMuon;
import com.poly.model.PhieuMuon;
import com.poly.model.SinhVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hma20
 */
public class SinhVien_PhieuMuonPanel extends javax.swing.JPanel {

    SinhVien _sv = null;
    SvPhieuMuonDAO pmDao;
    DefaultTableModel tblModelPm;
    DefaultTableModel tblModelPmct;
    int index = -1;

    public SinhVien_PhieuMuonPanel() {
        initComponents();
        _sv = Auth.sv;
        tblModelPm = (DefaultTableModel) tblPhieuMuon.getModel();
        tblModelPmct = (DefaultTableModel) tblChiTietPhieuMuon.getModel();
        pmDao = new SvPhieuMuonDAO();
        loadTablePM(pmDao.selectAllPm(_sv.getMaSinhVien(), -1));
    }

    public void loadTablePM(List<PhieuMuon> lst) {
        tblModelPm.setRowCount(0);
        for (PhieuMuon pm : lst) {
            tblModelPm.addRow(new Object[]{
                pm.getMaPhieuMuon(),
                pm.getMaSinhVien(),
                pm.getMaNhanVien(),
                pm.getNgayMuon(),
                pm.getNgayTra(),
                pm.isTrangThai()?"Ðã Trả":"Chưa Trả",
                pm.getGhiChu()
            });
        }
    }

    public void loadTablePMCT(List<ChiTietPhieuMuon> lst) {
        tblModelPmct.setRowCount(0);
        for (ChiTietPhieuMuon ctpm : lst) {
            tblModelPmct.addRow(new Object[]{
                ctpm.getMaPhieuMuon(),
                ctpm.getMaSach(),
                ctpm.getSoLuong()
            });
        }
    }

    public void clickPhieuMuon() {
        index = tblPhieuMuon.getSelectedRow();
        if (index == -1) {
            return;
        }

        String maPm = tblModelPm.getValueAt(index, 0).toString();
        loadTablePMCT(pmDao.selectAllPmCt(maPm));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPhieuMuon = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuMuon = new javax.swing.JTable();
        lblChiTietPM = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietPhieuMuon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        lblPhieuMuon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblPhieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhieuMuon.setText("Phiếu Mượn");

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatus.setText("Trạng Thái:");

        cboStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã Trả", "Chưa Trả" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        tblPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Sinh Viên", "Mã Nhân Viên", "Ngày Mượn", "Ngày Trả", "Trạng Thái", "Ghi Chú"
            }
        ));
        tblPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuMuon);

        lblChiTietPM.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblChiTietPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChiTietPM.setText("Chi Tiết Phiếu Mượn");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 402));

        tblChiTietPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Sách", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(tblChiTietPhieuMuon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblChiTietPM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblChiTietPM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonMouseClicked
        clickPhieuMuon();
    }//GEN-LAST:event_tblPhieuMuonMouseClicked

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        int index = cboStatus.getSelectedIndex();
        if (index == 1) {
            loadTablePM(pmDao.selectAllPm(_sv.getMaSinhVien(), 1));
        } else if (index == 2) {
            loadTablePM(pmDao.selectAllPm(_sv.getMaSinhVien(), 0));

        } else {
            loadTablePM(pmDao.selectAllPm(_sv.getMaSinhVien(), -1));

        }
    }//GEN-LAST:event_cboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChiTietPM;
    private javax.swing.JLabel lblPhieuMuon;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblChiTietPhieuMuon;
    private javax.swing.JTable tblPhieuMuon;
    // End of variables declaration//GEN-END:variables
}
