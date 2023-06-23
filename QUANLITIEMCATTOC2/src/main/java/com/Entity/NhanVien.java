package com.Entity;

import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
	@Id
	@Column(name = "MANHANVIEN")
	private String maNhanVien;
	@Column(name = "HO")
	private String ho;	
	@Column(name = "TEN")
	private String ten;	
	@Column(name = "PHAI")
	private String phai;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "NGAYSINH")
	private Date ngaySinh;
	@Column(name = "DIACHI")
	private String diaChi;
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "HINH")
	private String hinh;
	@OneToMany(mappedBy = "quanLiTB", fetch = FetchType.EAGER)
	private List<ThongBao> thongBaos;
	@OneToMany(mappedBy = "nhanVienDuyet", fetch = FetchType.EAGER)
	private List<PhieuDatHang> hangDuocDuyets;
	@OneToMany(mappedBy = "nhanVienGiao", fetch = FetchType.EAGER)
	private List<PhieuDatHang> hangDuocGiaos;
	public NhanVien() {
	}
	public NhanVien(String maNhanVien, String ho, String ten, String phai, Date ngaySinh, String diaChi,
			String soDienThoai, String email, String hinh) {
		this.maNhanVien = maNhanVien;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.hinh = hinh;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public List<ThongBao> getThongBaos() {
		return thongBaos;
	}
	public void setThongBaos(List<ThongBao> thongBaos) {
		this.thongBaos = thongBaos;
	}
	
	public List<PhieuDatHang> getHangDuocDuyets() {
		return hangDuocDuyets;
	}
	public void setHangDuocDuyets(List<PhieuDatHang> hangDuocDuyets) {
		this.hangDuocDuyets = hangDuocDuyets;
	}
	public List<PhieuDatHang> getHangDuocGiaos() {
		return hangDuocGiaos;
	}
	public void setHangDuocGiaos(List<PhieuDatHang> hangDuocGiaos) {
		this.hangDuocGiaos = hangDuocGiaos;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", ngaySinh="
				+ ngaySinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email=" + email + ", hinh="
				+ hinh + ", thongBaos=" + thongBaos + ", hangDuocDuyets=" + hangDuocDuyets + ", hangDuocGiaos="
				+ hangDuocGiaos + "]";
	}
	
	
	
}
