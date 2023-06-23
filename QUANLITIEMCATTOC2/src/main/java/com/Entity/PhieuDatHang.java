package com.Entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUDATHANG")
public class PhieuDatHang {
	@Id
	@GeneratedValue
	@Column(name = "idPHIEUDATHANG")
	private int idPhieuDatHang;
	@Column(name = "HOTENNGUOINHAN")
	private String hoTenNguoiNhan;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYDAT")
	private Date ngayDat;
	@Column(name = "DIACHI")
	private String diaChi;
	@Column(name = "SDT_NGUOINHAN")
	private String soDienThoaiNguoiNhan;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYDUKIENGIAOHANG")
	private Date ngayDuKienGiaoHang;
	@ManyToOne
	@JoinColumn(name = "MAKHACHHANG")
	private KhachHang khachHangDat;
	@ManyToOne
	@JoinColumn(name = "MATINHTRANG")
	private TinhTrangDonHang tinhTrangDonHang;
	@ManyToOne
	@JoinColumn(name = "MANHANVIENDUYET")
	private NhanVien nhanVienDuyet;
	@ManyToOne
	@JoinColumn(name = "MANHANVIENGIAO")
	private NhanVien nhanVienGiao;
	@OneToMany(mappedBy = "phieuDatHang", fetch = FetchType.EAGER)
	private List<ChiTietPhieuDatHang> chiTietPhieuDatHangs;
	
	
	public PhieuDatHang() {
	
	}


	public PhieuDatHang(int idPhieuDatHang, String hoTenNguoiNhan, Date ngayDat, String diaChi,
			String soDienThoaiNguoiNhan, Date ngayDuKienGiaoHang, KhachHang khachHangDat,
			TinhTrangDonHang tinhTrangDonHang, NhanVien nhanVienDuyet, NhanVien nhanVienGiao) {
		this.idPhieuDatHang = idPhieuDatHang;
		this.hoTenNguoiNhan = hoTenNguoiNhan;
		this.ngayDat = ngayDat;
		this.diaChi = diaChi;
		this.soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
		this.ngayDuKienGiaoHang = ngayDuKienGiaoHang;
		this.khachHangDat = khachHangDat;
		this.tinhTrangDonHang = tinhTrangDonHang;
		this.nhanVienDuyet = nhanVienDuyet;
		this.nhanVienGiao = nhanVienGiao;
	}

	public int getIdPhieuDatHang() {
		return idPhieuDatHang;
	}

	public void setIdPhieuDatHang(int idPhieuDatHang) {
		this.idPhieuDatHang = idPhieuDatHang;
	}

	public String getHoTenNguoiNhan() {
		return hoTenNguoiNhan;
	}

	public void setHoTenNguoiNhan(String hoTenNguoiNhan) {
		this.hoTenNguoiNhan = hoTenNguoiNhan;
	}



	public Date getNgayDat() {
		return ngayDat;
	}



	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}



	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getSoDienThoaiNguoiNhan() {
		return soDienThoaiNguoiNhan;
	}



	public void setSoDienThoaiNguoiNhan(String soDienThoaiNguoiNhan) {
		this.soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
	}



	public Date getNgayDuKienGiaoHang() {
		return ngayDuKienGiaoHang;
	}



	public void setNgayDuKienGiaoHang(Date ngayDuKienGiaoHang) {
		this.ngayDuKienGiaoHang = ngayDuKienGiaoHang;
	}



	
	public KhachHang getKhachHangDat() {
		return khachHangDat;
	}


	public void setKhachHangDat(KhachHang khachHangDat) {
		this.khachHangDat = khachHangDat;
	}
	public TinhTrangDonHang getTinhTrangDonHang() {
		return tinhTrangDonHang;
	}
	public void setTinhTrangDonHang(TinhTrangDonHang tinhTrangDonHang) {
		this.tinhTrangDonHang = tinhTrangDonHang;
	}
	public NhanVien getNhanVienDuyet() {
		return nhanVienDuyet;
	}
	public void setNhanVienDuyet(NhanVien nhanVienDuyet) {
		this.nhanVienDuyet = nhanVienDuyet;
	}
	public NhanVien getNhanVienGiao() {
		return nhanVienGiao;
	}
	public void setNhanVienGiao(NhanVien nhanVienGiao) {
		this.nhanVienGiao = nhanVienGiao;
	}


	public List<ChiTietPhieuDatHang> getChiTietPhieuDatHangs() {
		return chiTietPhieuDatHangs;
	}


	public void setChiTietPhieuDatHangs(List<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
		this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
	}


	@Override
	public String toString() {
		return "PhieuDatHang [idPhieuDatHang=" + idPhieuDatHang + ", hoTenNguoiNhan=" + hoTenNguoiNhan + ", ngayDat="
				+ ngayDat + ", diaChi=" + diaChi + ", soDienThoaiNguoiNhan=" + soDienThoaiNguoiNhan
				+ ", ngayDuKienGiaoHang=" + ngayDuKienGiaoHang + ", khachHangDat=" + khachHangDat
				+ ", tinhTrangDonHang=" + tinhTrangDonHang + ", nhanVienDuyet=" + nhanVienDuyet + ", nhanVienGiao="
				+ nhanVienGiao + ", chiTietPhieuDatHangs=" + chiTietPhieuDatHangs + "]";
	}
	
	
	
}
