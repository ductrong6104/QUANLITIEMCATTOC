package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN_KHACHHANG")
public class TaiKhoanKhachHang {
	@Id
	@Column(name = "MATAIKHOANKHACHHANG")
	private String maTaiKhoanKhachHang;
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	@Column(name = "PASS_WORD")
	private String passWord;
	@ManyToOne
	@JoinColumn(name = "MATRANGTHAI")
	private TrangThaiTaiKhoan trangThaiTaiKhoanKhachHang;
	@ManyToOne
	@JoinColumn(name = "MALOAI")
	private LoaiTaiKhoan loaiTaiKhoan;
	
	
	public TaiKhoanKhachHang() {
	}
	
	
	public TaiKhoanKhachHang(String maTaiKhoanKhachHang, String soDienThoai, String passWord,
			TrangThaiTaiKhoan trangThaiTaiKhoanKhachHang, LoaiTaiKhoan loaiTaiKhoan) {
		
		this.maTaiKhoanKhachHang = maTaiKhoanKhachHang;
		this.soDienThoai = soDienThoai;
		this.passWord = passWord;
		this.trangThaiTaiKhoanKhachHang = trangThaiTaiKhoanKhachHang;
		this.loaiTaiKhoan = loaiTaiKhoan;
	}


	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public TrangThaiTaiKhoan getTrangThaiTaiKhoanKhachHang() {
		return trangThaiTaiKhoanKhachHang;
	}
	public void setTrangThaiTaiKhoanKhachHang(TrangThaiTaiKhoan trangThaiTaiKhoanKhachHang) {
		this.trangThaiTaiKhoanKhachHang = trangThaiTaiKhoanKhachHang;
	}
	public LoaiTaiKhoan getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}


	public String getMaTaiKhoanKhachHang() {
		return maTaiKhoanKhachHang;
	}


	public void setMaTaiKhoanKhachHang(String maTaiKhoanKhachHang) {
		this.maTaiKhoanKhachHang = maTaiKhoanKhachHang;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	
}
