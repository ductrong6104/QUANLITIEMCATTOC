package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRANGTHAITK")
public class TrangThaiTaiKhoan {
	@Id
	@Column(name = "MATRANGTHAI")
	private String maTrangThai;
	@Column(name = "TENTT")
	private String tenTrangThai;
	
	@OneToMany(mappedBy = "trangThaiTaiKhoanNhanVien", fetch = FetchType.EAGER)
	private List<TaiKhoanNhanVien> taiKhoanNhanViens;
	@OneToMany(mappedBy = "trangThaiTaiKhoanKhachHang", fetch = FetchType.EAGER)
	private List<TaiKhoanKhachHang> taiKhoanKhachHangs;
	
	
	public TrangThaiTaiKhoan() {}
	public TrangThaiTaiKhoan(String maTrangThai, String tenTrangThai) {
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}
	public String getMaTrangThai() {
		return maTrangThai;
	}
	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public List<TaiKhoanNhanVien> getTaiKhoanNhanViens() {
		return taiKhoanNhanViens;
	}
	public void setTaiKhoanNhanViens(List<TaiKhoanNhanVien> taiKhoanNhanViens) {
		this.taiKhoanNhanViens = taiKhoanNhanViens;
	}
	public List<TaiKhoanKhachHang> getTaiKhoanKhachHangs() {
		return taiKhoanKhachHangs;
	}
	public void setTaiKhoanKhachHangs(List<TaiKhoanKhachHang> taiKhoanKhachHangs) {
		this.taiKhoanKhachHangs = taiKhoanKhachHangs;
	}
	
}
