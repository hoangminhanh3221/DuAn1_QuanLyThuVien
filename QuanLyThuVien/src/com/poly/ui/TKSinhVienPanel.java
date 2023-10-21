/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Da Da
 */
public class TKSinhVienPanel extends javax.swing.JPanel {
    DefaultTableModel tblModel= new DefaultTableModel();
    LocalDate localDate = LocalDate.now();
    int day = localDate.getDayOfMonth();
    int month = localDate.getMonthValue();
    int year = localDate.getYear();
    String url = "jdbc:sqlserver://localhost:54970;databaseName=QuanLyThuVien";
    String user = "sa";
    String pass = "123";
    /**
     * Creates new form ThongKeSinhVien
     */
    public TKSinhVienPanel() {
        initComponents();
        setTable();
        setComboBox();
    }
    private void setTable() {
        tblModel = new DefaultTableModel();
        String[] colums = new String[]{
            "STT","Mã phiếu mượn","Mã Sinh Viên","Tên Sinh Viên","SDT","Ngày mượn","Ngày trả","Trạng thái"
        };
        tblModel.setColumnIdentifiers(colums);
        tblTKSV.setModel(tblModel);
        thongKe();
    }
    private void setComboBox() {
        cboNgay.removeAll();
        cboNgay.addItem("Chon ngay");
        for (int i = 1; i <= 31; i++) {
            cboNgay.addItem(i + "");
        }

        cboThang.removeAll();
        cboThang.addItem("Chon thang");
        for (int i = 1; i <= 12; i++) {
            cboThang.addItem(i + "");
        }

        cboNam.removeAll();
        cboNam.addItem("Chon nam");
        for (int i = 3; i >= 0; i--) {
            int index = year - i;
            cboNam.addItem(index + "");
        }
    }
    public void thongKe() {
        if (cboNgay.getSelectedIndex()==0 || cboThang.getSelectedIndex()==0 || cboNam.getSelectedIndex()==0){
            String sql0="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien,phieumuon where sinhvien.masinhvien=phieumuon.masinhvien";
            String sql1="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien inner join phieumuon on sinhvien.masinhvien=phieumuon.masinhvien where trangthai =0";
            String sql2="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien inner join phieumuon on sinhvien.masinhvien=phieumuon.masinhvien where trangthai =1";
            String sql3="select maphieumuon ,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien left join phieumuon on sinhvien.masinhvien=phieumuon.masinhvien where maphieumuon is null order by sinhvien.masinhvien";
            if (cboLuaChon.getSelectedIndex()==0){
                execProc(sql0);    
            }else if (cboLuaChon.getSelectedIndex()==1){
                execProc(sql1);
            }else if (cboLuaChon.getSelectedIndex()==2){
                execProc(sql2);
            }else if (cboLuaChon.getSelectedIndex()==3){
               execProc(sql3);
            }
       }else if (cboNgay.getSelectedIndex()!=0 || cboThang.getSelectedIndex()!=0 || cboNam.getSelectedIndex()!=0){
            String ngay=(String) cboNgay.getSelectedItem();
            String thang = (String) cboThang.getSelectedItem();
            String nam = (String) cboNam.getSelectedItem();
            String fulldate = nam+"-"+thang+"-"+ngay;
            String sql4="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien,phieumuon where sinhvien.masinhvien=phieumuon.masinhvien and ngaymuon > '"+fulldate+"'";
            String sql5="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien inner join phieumuon on sinhvien.masinhvien=phieumuon.masinhvien where trangthai =0 and ngaymuon > '"+fulldate+"'" ;
            String sql6="select maphieumuon,sinhvien.masinhvien,tensinhvien,sodienthoai,ngaymuon, ngaytra , trangthai from sinhvien inner join phieumuon on sinhvien.masinhvien=phieumuon.masinhvien where trangthai =1 and ngaymuon > '"+fulldate+"'" ;
            if (cboLuaChon.getSelectedIndex()==0){
               execProc(sql4);
            }else if (cboLuaChon.getSelectedIndex()==1){
                execProc(sql5);
            }else if (cboLuaChon.getSelectedIndex()==2){
                execProc(sql6);
            }else if (cboLuaChon.getSelectedIndex()==3){
                tblModel.setRowCount(0);
            }
        }
            
    }
    public void execProc (String sql){
        int i=0;
        tblModel.setRowCount(0);
        try {
            Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){ 
                i++;
                String tt = null;
                if (rs.getBoolean(7)==true){
                    tt="Đã trả sách";
                }else if (rs.getBoolean(7)==false) {
                    tt="Chưa trả sách";
                }         
                Object[] obj = {i,rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getDate(5),rs.getDate(6),tt};
                System.out.println(Arrays.toString(obj));
                tblModel.addRow(obj);
                }
                lblTong.setText("Tổng sinh viên: "+i);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        cboNgay = new javax.swing.JComboBox<>();
        cboThang = new javax.swing.JComboBox<>();
        cboLuaChon = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTKSV = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblTong = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        cboLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số sinh viên mượn sách", "Số sinh viên chưa trả sách", "Số sinh viên đã trả sách", "Số sinh viên chưa bao giờ mượn sách" }));
        cboLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLuaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblTKSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Phiếu Mượn", "Mã Sinh Viên", "Tên SinhVien", "SDT", "Ngày mượn", "Ngày trả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTKSV);

        jButton1.setText("Xuất Excel");

        lblTong.setText("Tổng sinh viên:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(lblTong)
                .addGap(759, 759, 759)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        thongKe();
    }//GEN-LAST:event_cboNamActionPerformed

    private void cboNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayActionPerformed
        thongKe();
    }//GEN-LAST:event_cboNgayActionPerformed

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        thongKe();
    }//GEN-LAST:event_cboThangActionPerformed

    private void cboLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLuaChonActionPerformed
        thongKe();
    }//GEN-LAST:event_cboLuaChonActionPerformed


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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tblTKSV;
    // End of variables declaration//GEN-END:variables
}
