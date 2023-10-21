drop database QuanLyThuVien
GO

create database QuanLyThuVien
GO

use QuanLyThuVien
GO

CREATE TABLE NhaXuatBan (
    MaNhaXuatBan VARCHAR(10) PRIMARY KEY,
    TenNhaXuatBan NVARCHAR(255) NOT NULL
);
GO

CREATE TABLE TheLoaiSach (
    MaTheLoai VARCHAR(10) PRIMARY KEY,
    TenTheLoai NVARCHAR(255) NOT NULL,
    ViTri INT NOT NULL
);
GO

CREATE TABLE TacGia (
    MaTacGia VARCHAR(10) PRIMARY KEY,
    TenTacGia NVARCHAR(255) NOT NULL,
    GioiTinh BIT DEFAULT 0, --0(FALSE) NAM, 1(TRUE) NỮ
    NgaySinh DATE NOT NULL
);
GO

CREATE TABLE Sach (
    MaSach VARCHAR(10) PRIMARY KEY,
    MaTheLoai VARCHAR(10) NULL,
    MaTacGia VARCHAR(10) NULL,
    MaNhaXuatBan VARCHAR(10) NULL,
    TenSach NVARCHAR(255) NOT NULL,
    SoLuong INT NOT NULL,
    NgayNhap DATE NOT NULL,
    Hinh VARCHAR(255) NOT NULL,
    Link VARCHAR(255) NULL,
    FOREIGN KEY (MaTheLoai) REFERENCES TheLoaiSach(MaTheLoai) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (MaTacGia) REFERENCES TacGia(MaTacGia) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (MaNhaXuatBan) REFERENCES NhaXuatBan(MaNhaXuatBan) ON UPDATE CASCADE ON DELETE SET NULL
);
GO

CREATE TABLE SinhVien (
    MaSinhVien VARCHAR(10) PRIMARY KEY,
    MatKhau VARCHAR(255) NOT NULL,
    TenSinhVien NVARCHAR(255) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh BIT DEFAULT 0, --0(FALSE) NAM, 1(TRUE) NỮ
    DiaChi NVARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    SoDienThoai VARCHAR(20) NOT NULL,
    Hinh VARCHAR(255) NOT NULL
);
GO

CREATE TABLE NhanVien (
    MaNhanVien VARCHAR(10) PRIMARY KEY,
    TenNhanVien NVARCHAR(255) NOT NULL,
    MatKhau VARCHAR(255) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh BIT DEFAULT 0, --0(FALSE) NAM, 1(TRUE) NỮ
    DiaChi NVARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    SoDienThoai VARCHAR(20) NOT NULL,
    Hinh VARCHAR(255) NOT NULL
);
GO

CREATE TABLE PhieuMuon (
    MaPhieuMuon VARCHAR(10) PRIMARY KEY,
    MaSinhVien VARCHAR(10) NULL,
    MaNhanVien VARCHAR(10) NULL,
    NgayMuon DATE DEFAULT GETDATE(),
    NgayTra DATE NOT NULL,
    GhiChu NVARCHAR(255) NOT NULL,
    TrangThai BIT DEFAULT 0, --0(FALSE) CHƯA TRẢ, 1(TRUE) ĐÃ TRẢ
    FOREIGN KEY (MaSinhVien) REFERENCES SinhVien(MaSinhVien) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien) ON UPDATE CASCADE ON DELETE SET NULL
);
GO

CREATE TABLE ChiTietPhieuMuon (
    MaPhieuMuon VARCHAR(10),
    MaSach VARCHAR(10),
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaPhieuMuon, MaSach),
    FOREIGN KEY (MaPhieuMuon) REFERENCES PhieuMuon(MaPhieuMuon) ON UPDATE CASCADE,
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach) ON UPDATE CASCADE
);
GO

INSERT INTO NhaXuatBan (MaNhaXuatBan, TenNhaXuatBan) VALUES
('NXB001', N'Nhà xuất bản Tri Thức'),
('NXB002', N'Nhà xuất bản Tổng hợp TP.HCM'),
('NXB003', N'Nhà xuất bản Phụ nữ'),
('NXB004', N'Nhà xuất bản NXB Trẻ'),
('NXB005', N'Nhà xuất bản Đại học Quốc gia Hà Nội'),
('NXB006', N'Nhà xuất bản Giáo dục'),
('NXB007', N'Nhà xuất bản Thế giới'),
('NXB008', N'Nhà xuất bản Văn học'),
('NXB009', N'Nhà xuất bản Kim Đồng');
GO

INSERT INTO TheLoaiSach (MaTheLoai, TenTheLoai, ViTri) VALUES
('TL001', N'Văn học', 1),
('TL002', N'Khoa học - Kỹ thuật', 2),
('TL003', N'Tâm lý - Tôn giáo', 3),
('TL004', N'Kinh tế - Kinh doanh', 4),
('TL005', N'Lịch sử - Địa lý', 5),
('TL006', N'Sách giáo khoa', 6),
('TL007', N'Tự truyện - Hồi ký', 7);
GO

-- Tác giả tiểu thuyết
INSERT INTO TacGia(MaTacGia, TenTacGia, GioiTinh, NgaySinh) VALUES
('TG001', N'Nguyễn Nhật Ánh', 0, '1971-05-07'),
('TG002', N'Nguyễn Thị Minh Ngọc', 1, '1983-03-08'),
('TG003', N'Nguyễn Nhật Ánh', 0, '1971-05-07');
GO

-- Tác giả sách khoa học
INSERT INTO TacGia(MaTacGia, TenTacGia, NgaySinh) VALUES
('TG004', 'Trần Đức Lương', '1960-01-01'),
('TG005', 'Phạm Hoàng Hà', '1975-06-12'),
('TG006', 'Đinh Quang Anh Thái', '1982-09-25');
GO

-- Tác giả sách kinh doanh
INSERT INTO TacGia(MaTacGia, TenTacGia, GioiTinh, NgaySinh) VALUES
('TG007', N'Jack Ma', 0, '1964-09-10'),
('TG008', N'Robert Kiyosaki', 0, '1947-04-08'),
('TG009', N'Sheryl Sandberg', 1, '1969-08-28');
GO

-- Tác giả tiểu sử
INSERT INTO TacGia(MaTacGia, TenTacGia, GioiTinh, NgaySinh) VALUES
('TG010', N'Phan Huyền Thư', 1, '1984-03-10'),
('TG011', N'Nguyễn Đức Sơn', 0, '1981-02-12'),
('TG012', N'Lê Viết Chương', 0, '1979-11-03');
GO

INSERT INTO Sach(MaSach, MaTheLoai, MaTacGia, MaNhaXuatBan, TenSach, SoLuong, NgayNhap, Hinh, Link) VALUES
('S001', 'TL001', 'TG001', 'NXB008', N'Cho tôi xin một vé đi tuổi thơ', 50, '2022-01-01', 'sach1.jpg', 'sach1.pdf'),
('S002', 'TL002', 'TG004', 'NXB001', N'Thuyết về tất cả', 20, '2022-01-02', 'sach2.jpg', 'sach2.pdf'),
('S003', 'TL004', 'TG008', 'NXB002', N'Babylon giàu có', 30, '2022-01-03', 'sach3.jpg', 'sach3.pdf'),
('S004', 'TL006', 'TG011', 'NXB005', N'Lịch sử Việt Nam 6', 40, '2022-01-04', 'sach4.jpg', 'sach4.pdf'),
('S005', 'TL007', 'TG012', 'NXB004', N'Câu chuyện về trường học', 25, '2022-01-05', 'sach5.jpg', 'sach5.pdf'),
('S006', 'TL001', 'TG002', 'NXB009', N'Gửi em', 15, '2022-01-06', 'sach6.jpg', 'sach6.pdf'),
('S007', 'TL005', 'TG003', 'NXB008', N'Xứ mộng', 35, '2022-01-07', 'sach7.jpg', 'sach7.pdf'),
('S008', 'TL003', 'TG010', 'NXB003', N'Làm thế nào để yêu một người', 45, '2022-01-08', 'sach8.jpg', 'sach8.pdf'),
('S009', 'TL002', 'TG005', 'NXB006', N'Cơ học lượng tử', 20, '2022-01-09', 'sach9.jpg', 'sach9.pdf'),
('S010', 'TL007', 'TG012', 'NXB004', N'Khi tôi trở thành mặt trời', 25, '2022-01-10', 'sach10.jpg', 'sach10.pdf'),
('S011', 'TL006', 'TG002', 'NXB009', N'Giáo dục mầm non', 30, '2022-01-11', 'sach11.jpg', 'sach11.pdf'),
('S012', 'TL004', 'TG007', 'NXB002', N'Alibaba - Tinh thần chủ động, sự kiên trì và khả năng thay đổi', 35, '2022-01-12', 'sach12.jpg', 'sach12.pdf'),
('S013', 'TL003', 'TG011', 'NXB003', N'Tâm lý học đám đông', 20, '2022-01-13', 'sach13.jpg', 'sach13.pdf'),
('S014', 'TL002', 'TG004', 'NXB002', N'100 bài toán vật lý kỳ thú', 30, '2022-01-01', 'sach14.jpg', 'sach14.pdf'),
('S015', 'TL004', 'TG007', 'NXB003', N'Alibaba: Câu chuyện của chú chó nhỏ', 20, '2022-01-02', 'sach15.jpg', 'sach15.pdf'),
('S016', 'TL005', 'TG011', 'NXB005', N'Bí mật đông y - Dược liệu quý trong trị liệu bệnh lý', 15, '2022-01-03', 'sach16.jpg', 'sach16.pdf'),
('S017', 'TL001', 'TG001', 'NXB004', N'Bồ câu không cánh', 30, '2022-01-04', 'sach17.jpg', 'sach17.pdf'),
('S018', 'TL003', 'TG010', 'NXB001', N'Bố tôi là thần chết', 25, '2022-01-05', 'sach18.jpg', 'sach18.pdf'),
('S019', 'TL004', 'TG008', 'NXB003', N'Bố già giàu, bố trẻ khôn', 40, '2022-01-06', 'sach19.jpg', 'sach19.pdf'),
('S020', 'TL006', 'TG012', 'NXB006', N'Bộ sách tiếng Việt lớp 1', 100, '2022-01-07', 'sach20.jpg', 'sach20.pdf'),
('S021', 'TL002', 'TG006', 'NXB002', N'Cơ học kinh tế', 30, '2022-01-08', 'sach21.jpg', 'sach21.pdf'),
('S022', 'TL007', 'TG010', 'NXB001', N'Cơn gió nghìn xuân', 20, '2022-01-09', 'sach22.jpg', 'sach22.pdf');
GO

INSERT INTO SinhVien (MaSinhVien, MatKhau, TenSinhVien, NgaySinh, GioiTinh, DiaChi, Email, SoDienThoai, Hinh)
VALUES
('SV001', '12345', N'Nguyễn Hoàng Minh', '1999-01-01', 0, N'Đường Trần Hưng Đạo, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'nguyenhoangminh@gmail.com', '0987654321', 'SV001.jpg'),
('SV002', '12345', N'Phạm Thị Tuyết Nhung', '2000-02-02', 1, N'Đường Tôn Thất Thuyết, Phường Mỹ Đình 2, Quận Nam Từ Liêm, Hà Nội', 'phamtuyetnhung@gmail.com', '0123456789', 'SV002.jpg'),
('SV003', '12345', N'Trần Quốc Thái', '2001-03-03', 0, N'Đường Bùi Thị Xuân, Phường Phạm Ngũ Lão, Quận 1, Thành phố Hồ Chí Minh', 'tranquocthai@gmail.com', '0369852147', 'SV003.jpg'),
('SV004', '12345', N'Lê Thị Minh Châu', '2002-04-04', 1, N'Đường Nguyễn Chí Thanh, Phường Thanh Xuân Bắc, Quận Thanh Xuân, Hà Nội', 'leminhchau@gmail.com', '0791234567', 'SV004.jpg'),
('SV005', '12345', N'Đỗ Thị Tâm', '2003-05-05', 1, N'Đường Cầu Diễn, Phường Minh Khai, Quận Bắc Từ Liêm, Hà Nội', 'dothitam@gmail.com', '0987654321', 'SV005.jpg'),
('SV006', '12345', N'Võ Thị Ngọc Ánh', '2004-06-06', 1, N'Đường Bà Triệu, Phường Nguyễn Du, Quận Hai Bà Trưng, Hà Nội', 'vothi.ngocanh@gmail.com', '0123456789', 'SV006.jpg'),
('SV007', '12345', N'Nguyễn Thành Trung', '2005-07-07', 0, N'Đường Nguyễn Thị Minh Khai, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'nguyenthanhtrung@gmail.com', '0369852147', 'SV007.jpg'),
('SV008', '12345', N'Lê Thị Hoài An', '2006-08-08', 1, N'Đường Láng, Phường Thịnh Quang, Quận Đống Đa, Hà Nội', 'lethihoaian@gmail.com', '0791233150', 'SV008.jpg'),
('SV009', '12345', N'Nguyễn Thị Hồng Hạnh', '2000-09-09', 1, N'Đường Tôn Thất Thuyết, Phường Mỹ Đình 1, Quận Nam Từ Liêm, Hà Nội', 'nguyenthihonghanh@gmail.com', '0987654321', 'SV009.jpg'),
('SV010', '12345', N'Phạm Thị Thu Trang', '2001-10-10', 1, N'Đường Hồ Tùng Mậu, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'phamthithutrang@gmail.com', '0123456789', 'SV010.jpg'),
('SV011', '12345', N'Lê Thị Tuyết Mai', '2002-11-11', 1, N'Đường Hoàng Quốc Việt, Phường Nghĩa Đô, Quận Cầu Giấy, Hà Nội', 'lethituyetmai@gmail.com', '0369852147', 'SV011.jpg'),
('SV012', '12345', N'Nguyễn Văn A', '2003-12-12', 0, N'Đường Nguyễn Hữu Cảnh, Phường 22, Quận Bình Thạnh, Thành phố Hồ Chí Minh', 'nguyenvana@gmail.com', '0791234567', 'SV012.jpg'),
('SV013', '12345', N'Đỗ Thị Anh Thư', '2004-01-13', 1, N'Đường Cầu Giấy, Phường Nghĩa Tân, Quận Cầu Giấy, Hà Nội', 'dothianhthu@gmail.com', '0987654321', 'SV013.jpg'),
('SV014', '12345', N'Vũ Thị Huyền Trang', '2005-02-14', 1, N'Đường Cát Linh, Phường Văn Miếu, Quận Đống Đa, Hà Nội', 'vuthihuyentrang@gmail.com', '0123456789', 'SV014.jpg'),
('SV015', '12345', N'Nguyễn Văn B', '2006-03-15', 0, N'Đường Hồng Bàng, Phường 10, Quận 5, Thành phố Hồ Chí Minh', 'nguyenvanb@gmail.com', '0369852147', 'SV015.jpg');
GO

INSERT INTO NhanVien (MaNhanVien, TenNhanVien, MatKhau, NgaySinh, GioiTinh, DiaChi, Email, SoDienThoai, Hinh)
VALUES 
('NV001', N'Nguyễn Thị Minh', '12345', '1998-03-15', 1, N'123 Lê Lợi', 'hma2001.ah@gmail.com', '0987654321', 'NV001.jpg'),
('NV002', N'Trần Văn Tuấn', '12345', '1997-02-10', 0, N'456 Hoàng Diệu', 'tuan.tran@example.com', '0987654322', 'NV002.jpg'),
('NV003', N'Phạm Thị Kim', '12345', '1998-05-22', 1, N'789 Lê Hồng Phong', 'kim.pham@example.com', '0987654323', 'NV003.jpg'),
('NV004', N'Lê Hồng Sơn', '12345', '1996-11-18', 0, N'1011 Nguyễn Du', 'son.le@example.com', '0987654324', 'NV004.jpg'),
('NV005', N'Nguyễn Thị Hương', '12345', '1999-07-12', 1, N'1213 Trần Hưng Đạo', 'huong.nguyen@example.com', '0987654325', 'NV005.jpg'),
('NV006', N'Trần Đình Thiện', '12345', '1998-08-05', 0, N'1415 Nguyễn Trãi', 'thien.tran@example.com', '0987654326', 'NV006.jpg'),
('NV007', N'Vũ Thị Ngọc', '12345', '1997-04-03', 1, N'1617 Tôn Đức Thắng', 'ngoc.vu@example.com', '0987654327', 'NV007.jpg'),
('NV008', N'Nguyễn Văn Hoàng', '12345', '1996-01-01', 0, N'1819 Phan Bội Châu', 'hoang.nguyen@example.com', '0987654328', 'NV008.jpg'),
('NV009', N'Phạm Đức Anh', '12345', '1998-09-08', 0, N'2021 Lý Tự Trọng', 'anh.pham@example.com', '0987654329', 'NV009.jpg'),
('NV010', N'Trần Thị Mỹ', '12345', '1995-12-31', 1, N'2223 Nguyễn Văn Cừ', 'my.tran@example.com', '0987654330', 'NV010.jpg'),
('NV011', N'Nguyễn Văn Tuấn', '12345', '1997-11-23', 0, N'2425 Tôn Thất Tùng', 'tuan.nguyen@example.com', '0987654331', 'NV011.jpg');
GO

INSERT INTO PhieuMuon (MaPhieuMuon, MaSinhVien, MaNhanVien,NgayMuon, NgayTra, GhiChu, TrangThai) VALUES
('PM001', 'SV001', 'NV001','2023-03-20', '2023-03-25', N'Chưa trả', 0),
('PM002', 'SV002', 'NV002','2023-03-20', '2023-03-26', N'Đã trả', 1),
('PM003', 'SV003', 'NV003','2023-03-20', '2023-03-25', N'Chưa trả', 0),
('PM004', 'SV004', 'NV004','2023-03-20', '2023-03-25', N'Chưa trả', 0),
('PM005', 'SV005', 'NV005','2023-03-20', '2023-03-28', N'Đã trả', 1),
('PM006', 'SV001', 'NV001','2023-04-01', '2023-04-08', N'Chưa trả', 0),
('PM007', 'SV002', 'NV002','2023-04-01', '2023-04-08', N'Đã trả', 1),
('PM008', 'SV003', 'NV003','2023-04-01', '2023-04-10', N'Chưa trả', 0),
('PM009', 'SV004', 'NV004','2023-04-01', '2023-04-07', N'Chưa trả', 0),
('PM010', 'SV005', 'NV005','2023-04-01', '2023-04-07', N'Đã trả', 1),
('PM011', 'SV001', 'NV001', '2023-03-01', '2023-03-08', N'Phiếu mượn sách', 1),
('PM012', 'SV002', 'NV001', '2023-03-03', '2023-03-10', N'Phiếu mượn sách', 1),
('PM013', 'SV003', 'NV002', '2023-03-05', '2023-03-12', N'Phiếu mượn sách', 0),
('PM014', 'SV001', 'NV003', '2023-03-07', '2023-03-14', N'Phiếu mượn sách', 0),
('PM015', 'SV004', 'NV004', '2023-03-10', '2023-03-17', N'Phiếu mượn sách', 0),
('PM016', 'SV005', 'NV005', '2023-03-13', '2023-03-20', N'Phiếu mượn sách', 0),
('PM017', 'SV001', 'NV003', '2023-03-15', '2023-03-22', N'Phiếu mượn sách', 1),
('PM018', 'SV002', 'NV005', '2023-03-18', '2023-03-25', N'Phiếu mượn sách', 0),
('PM019', 'SV003', 'NV002', '2023-03-21', '2023-03-28', N'Phiếu mượn sách', 0),
('PM020', 'SV004', 'NV001', '2023-03-24', '2023-03-31', N'Phiếu mượn sách', 0),
('PM021', 'SV005', 'NV002', '2023-03-27', '2023-04-03', N'Phiếu mượn sách', 0),
('PM022', 'SV001', 'NV004', '2023-03-29', '2023-04-05', N'Phiếu mượn sách', 0);
GO

INSERT INTO ChiTietPhieuMuon (MaPhieuMuon, MaSach, SoLuong) VALUES
('PM001', 'S001', 2),
('PM001', 'S002', 1),
('PM002', 'S003', 3),
('PM002', 'S004', 1),
('PM003', 'S005', 2),
('PM003', 'S001', 1),
('PM004', 'S003', 2),
('PM004', 'S005', 1),
('PM005', 'S002', 1),
('PM005', 'S004', 2),
('PM005', 'S001', 2),
('PM006', 'S002', 1),
('PM007', 'S003', 3),
('PM008', 'S004', 1),
('PM008', 'S005', 2),
('PM009', 'S001', 1),
('PM009', 'S003', 2),
('PM010', 'S005', 1),
('PM010', 'S002', 1),
('PM010', 'S004', 2);
GO

CREATE PROCEDURE sp_LayThongTinMuonTrongNgay
AS
BEGIN
	DECLARE @SoSinhVien INT, @SoSach INT, @SoPhieuMuon INT
	SELECT @SoSinhVien = COUNT(DISTINCT MaSinhVien),
		   @SoSach = SUM(SoLuong),
		   @SoPhieuMuon = COUNT(*) 
	FROM PhieuMuon pm
	JOIN ChiTietPhieuMuon ctpm ON pm.MaPhieuMuon = ctpm.MaPhieuMuon
	WHERE pm.NgayMuon = CONVERT(date, GETDATE())

	SELECT @SoSinhVien AS 'SoSinhVienMuonSach',
		   @SoSach AS 'SoSachDuocMuon',
		   @SoPhieuMuon AS 'SoPhieuMuonDaLap'
	END
GO
--exec sp_LayThongTinMuonTrongNgay

CREATE PROCEDURE sp_TrangThaiMuonSachSV
    @MaSinhVien VARCHAR(10)
AS
BEGIN
    SELECT TOP 1 
           CASE WHEN TrangThai = 0 THEN N'Có thể mượn' ELSE N'Không thể mượn' END AS TinhTrangMuonSach
    FROM PhieuMuon
    WHERE MaSinhVien = @MaSinhVien
    ORDER BY NgayMuon DESC
END
GO
--exec sp_TrangThaiMuonSachSV 'SV002'

CREATE PROCEDURE sp_CheckMaPhieuMuon
    @MaPhieuMuon VARCHAR(10)
AS
BEGIN
    SET NOCOUNT ON;
    
    IF EXISTS (SELECT * FROM PhieuMuon WHERE MaPhieuMuon = @MaPhieuMuon)
        SELECT 1 AS Result
    ELSE
        SELECT 0 AS Result
END
GO
--exec sp_CheckMaPhieuMuon 'PM011'

CREATE PROCEDURE sp_DanhSachSVMuonSachMoiNhat
AS
BEGIN
    SELECT 
		P.MaPhieuMuon,
        SV.MaSinhVien, 
        SV.TenSinhVien, 
        P.NgayMuon, 
        P.NgayTra, 
		P.TrangThai,
        DATEDIFF(DAY, P.NgayMuon, P.NgayTra) AS NgayConLai
    FROM 
        SinhVien SV 
        INNER JOIN PhieuMuon P ON SV.MaSinhVien = P.MaSinhVien
    WHERE 
        P.TrangThai = 0
        AND NOT EXISTS (
            SELECT 1
            FROM PhieuMuon
            WHERE MaSinhVien = SV.MaSinhVien AND TrangThai = 0 AND NgayMuon > P.NgayMuon
        )
    ORDER BY NgayConLai ASC
END
GO

CREATE PROCEDURE sp_CheckMaSach
    @MaSach VARCHAR(10)
AS
BEGIN
    SET NOCOUNT ON;
    
    IF EXISTS (SELECT * FROM Sach WHERE MaSach = @MaSach)
        SELECT 1 AS Result
    ELSE
        SELECT 0 AS Result
END
GO
--exec sp_CheckMaSach 'S0110'

CREATE PROCEDURE sp_CheckMaTheLoai
    @MaTheLoai VARCHAR(10)
AS
BEGIN
    SET NOCOUNT ON;
    
    IF EXISTS (SELECT * FROM TheLoaiSach WHERE MaTheLoai = @MaTheLoai)
        SELECT 1 AS Result
    ELSE
        SELECT 0 AS Result
END
GO
--exec sp_CheckMaTheLoai'TL001'

CREATE PROCEDURE sp_GetAvailableBooks
    @MaSach VARCHAR(10)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @SoLuong INT, @SoLuongMuon INT

    -- Lấy số lượng sách có sẵn trong bảng Sách
    SELECT @SoLuong = SoLuong
    FROM Sach
    WHERE MaSach = @MaSach

    -- Lấy số lượng sách đã được mượn từ bảng ChiTietPhieuMuon
    SELECT @SoLuongMuon = SUM(SoLuong)
    FROM ChiTietPhieuMuon
    WHERE MaSach = @MaSach

    -- Tính số lượng sách còn lại có thể mượn
    DECLARE @SoLuongConLai INT
    SET @SoLuongConLai = @SoLuong - @SoLuongMuon

    -- Trả về kết quả
    SELECT @SoLuongConLai AS 'SoLuongConLai'
END
GO

--EXEC sp_GetAvailableBooks 'MS001'

insert into Sach(MaSach, MaTheLoai, MaTacGia, MaNhaXuatBan, TenSach, SoLuong, NgayNhap, Hinh, Link) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
update Sach set MaTheLoai=?, MaTacGia=?, MaNhaXuatBan=?, TenSach=?, SoLuong=?, NgayNhap=?, Hinh=?, Link=? where MaSach = ?
delete from Sach where MaSach = ?
select * from Sach
select * from Sach where MaSach = ?

insert into TheLoaiSach(MaTheLoai, TenTheLoai, ViTri) values (?, ?, ?)
update TheLoaiSach set TenTheLoai=?, ViTri=? where MaTheLoai = ?
delete from TheLoaiSach where MaTheLoai = ?
select * from TheLoaiSach
select * from TheLoaiSach where MaTheLoai = ?


select * from Sach where MaSach = 'S200'

select * from PhieuMuon where MaPhieuMuon = 'PM001'

select * from TheLoaiSach where TenTheLoai like '%Kinh%'

select * from ChiTietPhieuMuon where MaPhieuMuon = 'PM001'

--Top 10 mượn nhiều nhất
SELECT TOP 5 s.*, SUM(ct.SoLuong) AS TongSoLuongMuon
FROM Sach s
INNER JOIN ChiTietPhieuMuon ct ON s.MaSach = ct.MaSach
GROUP BY s.MaSach, s.MaTheLoai, s.MaTacGia, s.MaNhaXuatBan, s.TenSach, s.SoLuong, s.NgayNhap, s.Hinh, s.Link
ORDER BY TongSoLuongMuon DESC;

--Top 10 mượn ít nhất
SELECT TOP 5 s.*, SUM(ct.SoLuong) AS TongSoLuongMuon
FROM Sach s
INNER JOIN ChiTietPhieuMuon ct ON s.MaSach = ct.MaSach
GROUP BY s.MaSach, s.MaTheLoai, s.MaTacGia, s.MaNhaXuatBan, s.TenSach, s.SoLuong, s.NgayNhap, s.Hinh, s.Link
ORDER BY TongSoLuongMuon ASC;

delete from Sach

select * from Sach where MaSach like '%Cho%' or TenSach like '%Cho%'
select * from NhanVien where Email  = 'hma2001.ah@gmail.com'