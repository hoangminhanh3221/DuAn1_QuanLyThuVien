/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ui;

import com.poly.dao.TKPhieuMuonDAO;
import com.poly.model.PhieuMuon;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MINH HIEU
 */
public class TKPhieuMuonPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanVien_TKSach
     */
    public TKPhieuMuonPanel() {
        initComponents();
        setTable();
        fillToTable();
        setComboBox();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        cboNgay = new javax.swing.JComboBox<>();
        cboThang = new javax.swing.JComboBox<>();
        cboLuaChon = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuMuon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblTong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Lựa chọn");

        jLabel2.setText("Ngày");

        jLabel3.setText("Tháng");

        jLabel5.setText("Năm");

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        cboNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNgayActionPerformed(evt);
            }
        });

        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        cboLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Số phiếu mượn đã trả", "Số phiếu mượn chưa trả", "Số phiếu mượn quá hạn", "Số phiếu mượn sắp hết hạn", "Sắp xếp phiếu mượn theo mã sinh viên", "Sắp xếp phiếu mượn theo mã nhân viên", "Sắp xếp phiếu mượn theo ngày mượn", "Sắp xếp phiếu mượn theo ngày trả" }));
        cboLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLuaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Mã thể loại", "Mã NXB", "Mã tác giả", "Tên sách", "Ngày nhập", "Số lượng", "Còn lại"
            }
        ));
        jScrollPane1.setViewportView(tblPhieuMuon);

        jButton1.setText("Xuất Excel");

        lblTong.setText("Tong phieu muon:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(lblTong)
                .addGap(759, 759, 759)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLuaChonActionPerformed
        // TODO add your handling code here:
        if (cboLuaChon.getSelectedIndex() == 0 || cboLuaChon.getSelectedIndex() == -1) {
            fillToTable();
            cboNgay.setSelectedIndex(0);
            cboThang.setSelectedIndex(0);
            cboNam.setSelectedIndex(0);
        } else if (cboLuaChon.getSelectedIndex() == 1) {
            String sql = "SELECT * FROM PhieuMuon WHERE TrangThai = 1";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 2) {
            String sql = "SELECT * FROM PhieuMuon WHERE TrangThai = 0";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 3) {
            String sql = "SELECT * FROM PhieuMuon WHERE TrangThai = 0 AND NgayTra < GETDATE()";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 4) {
            String sql = "SELECT * FROM PhieuMuon WHERE TrangThai = 0 AND NgayTra BETWEEN GETDATE() AND DATEADD(day, 3, GETDATE())";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 5) {
            String sql = "SELECT * FROM PhieuMuon ORDER BY MaSinhVien;";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 6) {
            String sql = "SELECT * FROM PhieuMuon ORDER BY MaNhanVien;";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 7) {
            String sql = "SELECT * FROM PhieuMuon ORDER BY NgayMuon ASC";
            getCBOLuaChon(sql);
        } else if (cboLuaChon.getSelectedIndex() == 8) {
            String sql = "SELECT * FROM PhieuMuon ORDER BY NgayTra ASC";
            getCBOLuaChon(sql);
        }
    }//GEN-LAST:event_cboLuaChonActionPerformed

    private void cboNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayActionPerformed
        // TODO add your handling code here:
        if (cboNgay.getSelectedIndex() == 0 || cboNgay.getSelectedIndex() == -1) {
            fillToTable();
        } else {
            String sql = "SELECT * FROM PhieuMuon WHERE DAY(NgayMuon) = ?";
            getCBONgayThangNam(sql, cboNgay.getSelectedIndex());
        }
    }//GEN-LAST:event_cboNgayActionPerformed

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        // TODO add your handling code here:
        if (cboThang.getSelectedIndex() == 0 || cboThang.getSelectedIndex() == -1) {
            fillToTable();
        } else {
            String sql = "SELECT * FROM PhieuMuon WHERE MONTH(NgayMuon) = ?";
            getCBONgayThangNam(sql, cboThang.getSelectedIndex());
        }
    }//GEN-LAST:event_cboThangActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        if (cboNam.getSelectedIndex() == 0 || cboNam.getSelectedIndex() == -1) {
            fillToTable();
        } else {
            String sql = "SELECT * FROM PhieuMuon WHERE YEAR(NgayMuon) = ?";
            getCBONgayThangNam(sql, cboNam.getSelectedIndex());
        }
    }//GEN-LAST:event_cboNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLuaChon;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboNgay;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tblPhieuMuon;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel model;
    TKPhieuMuonDAO pmDAO = new TKPhieuMuonDAO();
    List<PhieuMuon> listPM;
    LocalDate localDate = LocalDate.now();
    int day = localDate.getDayOfMonth();
    int month = localDate.getMonthValue();
    int year = localDate.getYear();

    private void setTable() {
        model = new DefaultTableModel();
        String[] colums = new String[]{
            "STT", "Ma phieu muon", "Ma sinh vien", "Ma nhan vien", "Ngay muon", "Ngay tra", "Trang thai", "Ghi chu"
        };
        model.setColumnIdentifiers(colums);
        tblPhieuMuon.setModel(model);
    }

    private void setComboBox() {
        cboNgay.removeAll();
        cboNgay.addItem("Chon ngay");
        for (int i = 1; i <= day; i++) {
            cboNgay.addItem(i + "");
        }

        cboThang.removeAll();
        cboThang.addItem("Chon thang");
        for (int i = 1; i <= month; i++) {
            cboThang.addItem(i + "");
        }

        cboNam.removeAll();
        cboNam.addItem("Chon nam");
        for (int i = 3; i >= 0; i--) {
            int index = year - i;
            cboNam.addItem(index + "");
        }
    }

    private void fillToTable() {
        listPM = pmDAO.selectAll();
        model.setRowCount(0);
        int stt = 1;
        for (PhieuMuon pm : listPM) {
            model.addRow(new Object[]{
                stt,
                pm.getMaPhieuMuon(),
                pm.getMaSinhVien(),
                pm.getMaNhanVien(),
                pm.getNgayMuon(),
                pm.getNgayTra(),
                pm.isTrangThai(),
                pm.getGhiChu()
            });
            stt++;
        }
        lblTong.setText("Tong phieu muon: " + (stt - 1));
    }

    private void fillToTable(List<PhieuMuon> list) {
        listPM = pmDAO.selectAll();
        model.setRowCount(0);
        int stt = 1;
        for (PhieuMuon pm : list) {
            model.addRow(new Object[]{
                stt,
                pm.getMaPhieuMuon(),
                pm.getMaSinhVien(),
                pm.getMaNhanVien(),
                pm.getNgayMuon(),
                pm.getNgayTra(),
                pm.isTrangThai(),
                pm.getGhiChu()
            });
            stt++;
        }
        lblTong.setText("Tong phieu muon: " + (stt - 1));
    }

    private void getCBOLuaChon(String sql) {
        List<PhieuMuon> list = pmDAO.selectCBOLuaChon(sql);
        fillToTable(list);
    }

    private void getCBONgayThangNam(String sql, int index) {
        List<PhieuMuon> list = pmDAO.selectBySQL(sql, index);
        fillToTable(list);
    }
}