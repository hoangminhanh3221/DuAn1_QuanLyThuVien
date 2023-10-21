/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.ui;

import com.poly.dao.SvSachDAO;
import com.poly.model.Sach;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hma20
 */
public class SinhVien_SachPanel extends javax.swing.JPanel {

    /**
     * Creates new form SinhVien_Sach
     */
    DefaultTableModel tblModelBook;
    SvSachDAO sachDao;
    int index = -1;
    String file = "";

    public SinhVien_SachPanel() {
        initComponents();

        tblModelBook = (DefaultTableModel) tblBook.getModel();
        sachDao = new SvSachDAO();

        loadTable(sachDao.selectAllSach("", ""));
    }

    public void loadTable(List<Object[]> lst) {
        tblModelBook.setRowCount(0);

        for (Object[] ob : lst) {
            tblModelBook.addRow(ob);
        }
    }

    public ImageIcon KichThuocIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public void clickTable() {
        index = tblBook.getSelectedRow();
        if (index == -1) {
            return;
        }

        String maS = tblModelBook.getValueAt(index, 0).toString();
        Sach sach = sachDao.getFindSach(maS);
        file = sach.getLink();
        txtLinkBook.setText(sach.getLink());
        lblHinhAnh.setIcon(KichThuocIcon(new ImageIcon("./src/com/poly/image/" + sach.getHinhAnh()), 130, 155));

    }

    public void openFile() {
        String filePath = "src/com/poly/pdf/" + file;

        // Tạo đối tượng File
        File file = new File(filePath);

        // Kiểm tra xem tệp có tồn tại hay không
        if (file.exists()) {

            // Mở tệp PDF bằng trình duyệt mặc định trên máy tính
            try {
                Desktop.getDesktop().browse(file.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Tệp không tồn tại!");
        }

    }

    public void findLoc() {
        int index = cboArrange.getSelectedIndex();
        if (index == 1) {
            loadTable(sachDao.selectAllSach(txtSearch.getText(), "DESC"));
        } else if (index == 2) {
            loadTable(sachDao.selectAllSach(txtSearch.getText(), "ASC"));
        }else{
            loadTable(sachDao.selectAllSach(txtSearch.getText(),""));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpSach_TheLoai = new javax.swing.JTabbedPane();
        pnlSach = new javax.swing.JPanel();
        lblBookSV = new javax.swing.JLabel();
        pnlSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlArrange = new javax.swing.JPanel();
        lblArrange = new javax.swing.JLabel();
        cboArrange = new javax.swing.JComboBox<>();
        pnlImage = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        lblLinkBook = new javax.swing.JLabel();
        btnOpenLink = new javax.swing.JButton();
        txtLinkBook = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tbpSach_TheLoai.setBackground(new java.awt.Color(255, 255, 255));
        tbpSach_TheLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnlSach.setBackground(new java.awt.Color(255, 255, 255));

        lblBookSV.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblBookSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBookSV.setText("Sách");

        pnlSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSearch.setText("Tìm Kiếm:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/icon/timkiem_black_24px.png"))); // NOI18N
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlArrange.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblArrange.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblArrange.setText("Sắp Xếp:");

        cboArrange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Top 10 Sách Có Số Lượng Nhiều Nhất", "Top 10 Sách Có Số Lượng Ít Nhất" }));
        cboArrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboArrangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlArrangeLayout = new javax.swing.GroupLayout(pnlArrange);
        pnlArrange.setLayout(pnlArrangeLayout);
        pnlArrangeLayout.setHorizontalGroup(
            pnlArrangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArrangeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlArrangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlArrangeLayout.createSequentialGroup()
                        .addComponent(lblArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cboArrange, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlArrangeLayout.setVerticalGroup(
            pnlArrangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArrangeLayout.createSequentialGroup()
                .addComponent(lblArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHinhAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblLinkBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLinkBook.setText("Đường Dẫn:");

        btnOpenLink.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOpenLink.setText("Mở");
        btnOpenLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenLinkActionPerformed(evt);
            }
        });

        tblBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản", "Ngày Nhập", "Số Lượng", "Có Thể Mượn "
            }
        ));
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        javax.swing.GroupLayout pnlSachLayout = new javax.swing.GroupLayout(pnlSach);
        pnlSach.setLayout(pnlSachLayout);
        pnlSachLayout.setHorizontalGroup(
            pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSachLayout.createSequentialGroup()
                .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBookSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlSachLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSachLayout.createSequentialGroup()
                                .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlSachLayout.createSequentialGroup()
                                        .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pnlArrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlSachLayout.createSequentialGroup()
                                        .addComponent(lblLinkBook, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLinkBook)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnOpenLink, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSachLayout.setVerticalGroup(
            pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBookSV)
                .addGap(18, 18, 18)
                .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSachLayout.createSequentialGroup()
                        .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlArrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLinkBook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpenLink, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLinkBook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tbpSach_TheLoai.addTab("Sách", pnlSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbpSach_TheLoai, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbpSach_TheLoai))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        findLoc();

    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        clickTable();
    }//GEN-LAST:event_tblBookMouseClicked

    private void btnOpenLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenLinkActionPerformed
        openFile();
    }//GEN-LAST:event_btnOpenLinkActionPerformed

    private void cboArrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboArrangeActionPerformed
        txtSearch.setText("");
        findLoc();
    }//GEN-LAST:event_cboArrangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpenLink;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboArrange;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArrange;
    private javax.swing.JLabel lblBookSV;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblLinkBook;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlArrange;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JPanel pnlSach;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTable tblBook;
    private javax.swing.JTabbedPane tbpSach_TheLoai;
    private javax.swing.JTextField txtLinkBook;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
