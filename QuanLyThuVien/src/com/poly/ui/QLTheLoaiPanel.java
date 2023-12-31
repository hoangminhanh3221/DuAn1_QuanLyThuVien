/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ui;

import com.poly.dao.TheLoaiSachDAO;
import com.poly.helper.MsgBox;
import com.poly.model.TheLoaiSach;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hma20
 */
public class QLTheLoaiPanel extends javax.swing.JPanel {

    /**
     * Creates new form QLTheLoaiPanel
     */
    public QLTheLoaiPanel() {
        initComponents();
        setTable();
        fillToTable();
        btnFirst.setEnabled(false);
        loadForm(0);
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
        jLabel2 = new javax.swing.JLabel();
        txtMaTheLoai = new javax.swing.JTextField();
        txtTenTheLoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtViTri = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboSapXep = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnNhapDS = new javax.swing.JButton();
        btnInDS = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông Tin Thể Loại");

        jLabel2.setText("Ma the loai :");

        jLabel3.setText("Ten the loai :");

        jLabel4.setText("Vi tri :");

        btnXoa.setText("Xoa");
        btnXoa.setPreferredSize(new java.awt.Dimension(90, 27));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.setPreferredSize(new java.awt.Dimension(90, 27));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setText("Moi");
        btnMoi.setPreferredSize(new java.awt.Dimension(90, 27));
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThem.setText("Them");
        btnThem.setPreferredSize(new java.awt.Dimension(90, 27));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(610, 650));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Danh Sách Thể Loại");
        jLabel8.setPreferredSize(new java.awt.Dimension(600, 30));
        jPanel2.add(jLabel8);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setPreferredSize(new java.awt.Dimension(380, 72));

        txtTimKiem.setPreferredSize(new java.awt.Dimension(300, 27));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/timkiem_black_24px.png"))); // NOI18N
        btnTimKiem.setPreferredSize(new java.awt.Dimension(40, 27));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sắp xếp"));
        jPanel4.setPreferredSize(new java.awt.Dimension(190, 72));

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Tên thể loại tăng dần", "Tên thể loại giảm dần" }));
        cboSapXep.setPreferredSize(new java.awt.Dimension(160, 27));
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(575, 493));

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTheLoai);

        jPanel2.add(jScrollPane1);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(585, 30));

        btnNhapDS.setText("Nhap DS");
        btnNhapDS.setPreferredSize(new java.awt.Dimension(90, 27));
        btnNhapDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapDSbtnNhapDSActionPerformed(evt);
            }
        });

        btnInDS.setText("In DS");
        btnInDS.setPreferredSize(new java.awt.Dimension(90, 27));
        btnInDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInDSbtnInDSActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLast.setText(">>");
        btnLast.setPreferredSize(new java.awt.Dimension(90, 27));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastbtnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNext.setText(">");
        btnNext.setPreferredSize(new java.awt.Dimension(90, 27));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextbtnNextActionPerformed(evt);
            }
        });

        btnPre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPre.setText("<");
        btnPre.setPreferredSize(new java.awt.Dimension(90, 27));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrebtnPreActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFirst.setText("<<");
        btnFirst.setPreferredSize(new java.awt.Dimension(90, 27));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstbtnPreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhapDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhapDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 610, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        // TODO add your handling code here:
        int index = tblTheLoai.getSelectedRow();
        loadForm(index);
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (isCheckForm()) {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (isCheckFormUpdate()) {
            update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (MsgBox.confirm(this, "Ban co chac chan muon xoa?")) {
            delete();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNhapDSbtnNhapDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapDSbtnNhapDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapDSbtnNhapDSActionPerformed

    private void btnInDSbtnInDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInDSbtnInDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInDSbtnInDSActionPerformed

    private void btnLastbtnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastbtnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastbtnLastActionPerformed

    private void btnNextbtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextbtnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextbtnNextActionPerformed

    private void btnPrebtnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrebtnPreActionPerformed
        // TODO add your handling code here:
        previous();
    }//GEN-LAST:event_btnPrebtnPreActionPerformed

    private void btnFirstbtnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstbtnPreActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstbtnPreActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
        if(cboSapXep.getSelectedIndex() == 0 || cboSapXep.getSelectedIndex() == -1){
            fillToTable();
        } else if(cboSapXep.getSelectedIndex() == 1) {
            sapXep1();
        } else if(cboSapXep.getSelectedIndex() == 2){
            sapXep2();
        }
    }//GEN-LAST:event_cboSapXepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInDS;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhapDS;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtMaTheLoai;
    private javax.swing.JTextField txtTenTheLoai;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtViTri;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel model;
    TheLoaiSachDAO tlsDAO = new TheLoaiSachDAO();
    List<TheLoaiSach> listTLS = new ArrayList<>();

    private void setTable() {
        model = new DefaultTableModel();
        String[] colums = new String[]{
            "STT", "Ma the loai", "Ten the loai", "Vi tri"
        };
        model.setColumnIdentifiers(colums);
        tblTheLoai.setModel(model);
    }

    private void fillToTable() {
        listTLS = tlsDAO.selectAll();
        model.setRowCount(0);
        int stt = 1;
        for (TheLoaiSach tls : listTLS) {
            model.addRow(new Object[]{
                stt, tls.getMaTheLoai(), tls.getTenTheLoai(), tls.getViTri()
            });
            stt++;
        }
        tblTheLoai.setRowSelectionInterval(0, 0);
        btnFirst.setEnabled(false);
    }

    private void loadForm(int index) {
        TheLoaiSach tls = listTLS.get(index);
        txtMaTheLoai.setText(tls.getMaTheLoai());
        txtTenTheLoai.setText(tls.getTenTheLoai());
        txtViTri.setText(tls.getViTri() + "");
    }

    private boolean isCheckForm() {
        if (txtMaTheLoai.getText().equals("")) {
            txtMaTheLoai.requestFocus();
            MsgBox.alert(this, "Chưa nhập mã the loai");
            return false;
        } else if (txtTenTheLoai.getText().equals("")) {
            txtTenTheLoai.requestFocus();
            MsgBox.alert(this, "Chưa nhập ten the loai");
            return false;
        } else if (txtViTri.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập vi tri");
            return false;
        } else if (tlsDAO.checkMaTheLoai(txtMaTheLoai.getText())) {
            MsgBox.alert(this, "Ma sach da ton tai!");
            return false;
        } else {
            return true;
        }
    }

    private boolean isCheckFormUpdate() {
        if (txtMaTheLoai.getText().equals("")) {
            txtMaTheLoai.requestFocus();
            MsgBox.alert(this, "Chưa nhập mã the loai");
            return false;
        } else if (txtTenTheLoai.getText().equals("")) {
            txtTenTheLoai.requestFocus();
            MsgBox.alert(this, "Chưa nhập ten the loai");
            return false;
        } else if (txtViTri.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập vi tri");
            return false;
        } else if (!tlsDAO.checkMaTheLoai(txtMaTheLoai.getText())) {
            MsgBox.alert(this, "Ma sach khong ton tai!");
            return false;
        } else {
            return true;
        }
    }

    private void insert() {
        TheLoaiSach tls = new TheLoaiSach(
                txtMaTheLoai.getText(),
                txtTenTheLoai.getText(),
                Integer.parseInt(txtViTri.getText())
        );
        try {
            tlsDAO.insert(tls);
            MsgBox.alert(this, "Them thanh cong!");
            fillToTable();
            clearForm();
        } catch (Exception e) {
            MsgBox.alert(this, "Them that bai!");
        }
    }

    private void update() {
        TheLoaiSach tls = new TheLoaiSach(
                txtMaTheLoai.getText(),
                txtTenTheLoai.getText(),
                Integer.parseInt(txtViTri.getText())
        );
        try {
            tlsDAO.update(tls);
            MsgBox.alert(this, "Sua thanh cong!");
            fillToTable();
        } catch (Exception e) {
            MsgBox.alert(this, "Sua that bai!");
        }
    }

    private void delete() {
        try {
            tlsDAO.delete(txtMaTheLoai.getText());
            MsgBox.alert(this, "Xoa thanh cong!");
            fillToTable();
        } catch (Exception e) {
            MsgBox.alert(this, "Xoa that bai!");
        }
    }

    private void clearForm() {
        txtMaTheLoai.setText("");
        txtTenTheLoai.setText("");
        txtViTri.setText("");
    }

    private void first() {
        tblTheLoai.setRowSelectionInterval(0, 0);
        onAndOff(false, true, true, true);
    }

    private void previous() {
        onAndOff(true, true, true, true);
        int max = model.getRowCount();
        int index = tblTheLoai.getSelectedRow() - 1;
        if (index < 0) {
            tblTheLoai.setRowSelectionInterval(max - 1, max - 1);
            btnLast.setEnabled(false);
        } else {
            tblTheLoai.setRowSelectionInterval(index, index);
            if (index == 0) {
                btnFirst.setEnabled(false);
            }
        }
    }

    private void next() {
        onAndOff(true, true, true, true);
        int max = model.getRowCount();
        int index = tblTheLoai.getSelectedRow() + 1;
        if (index == max) {
            tblTheLoai.setRowSelectionInterval(0, 0);
            btnFirst.setEnabled(false);
        } else {
            tblTheLoai.setRowSelectionInterval(index, index);
            if (index == max - 1) {
                btnLast.setEnabled(false);
            }
        }
    }

    private void last() {
        int max = model.getRowCount();
        tblTheLoai.setRowSelectionInterval(max - 1, max - 1);
        onAndOff(true, true, true, false);
    }

    private void onAndOff(boolean... b) {
        btnFirst.setEnabled(b[0]);
        btnPre.setEnabled(b[1]);
        btnNext.setEnabled(b[2]);
        btnLast.setEnabled(b[3]);
    }

    private void timKiem() {
        String sql = "select * from TheLoaiSach where TenTheLoai like '%"+txtTimKiem.getText()+"%'";
        listTLS = tlsDAO.selectBySql(sql);
        if (!listTLS.isEmpty()) {
            model.setRowCount(0);
            int stt = 1;
            for (TheLoaiSach tls : listTLS) {
                model.addRow(new Object[]{
                    stt, tls.getMaTheLoai(), tls.getTenTheLoai(), tls.getViTri()
                });
                stt++;
            }
            tblTheLoai.setRowSelectionInterval(0, 0);
            btnFirst.setEnabled(false);
        }
    }
    
    private void sapXep1(){
        String sql = "SELECT * FROM TheLoaiSach ORDER BY TenTheLoai ASC";
        listTLS = tlsDAO.selectBySql(sql);
        if (!listTLS.isEmpty()) {
            model.setRowCount(0);
            int stt = 1;
            for (TheLoaiSach tls : listTLS) {
                model.addRow(new Object[]{
                    stt, tls.getMaTheLoai(), tls.getTenTheLoai(), tls.getViTri()
                });
                stt++;
            }
            tblTheLoai.setRowSelectionInterval(0, 0);
            btnFirst.setEnabled(false);
        }
    }
    private void sapXep2(){
        String sql = "SELECT * FROM TheLoaiSach ORDER BY TenTheLoai DESC";
        listTLS = tlsDAO.selectBySql(sql);
        if (!listTLS.isEmpty()) {
            model.setRowCount(0);
            int stt = 1;
            for (TheLoaiSach tls : listTLS) {
                model.addRow(new Object[]{
                    stt, tls.getMaTheLoai(), tls.getTenTheLoai(), tls.getViTri()
                });
                stt++;
            }
            tblTheLoai.setRowSelectionInterval(0, 0);
            btnFirst.setEnabled(false);
        }
    }
}
