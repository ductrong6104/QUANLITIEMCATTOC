package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN_NHANVIEN")
public class TaiKhoanNhanVien {
	@Id
	@Column(name = "MATAIKHOANNHANVIEN")
	private String maTaiKhoanNhanVien;
	@Column(name = "USERNAME_NHANVIEN")
	private String userNameNhanVien;
	@Column(name = "PASS_WORD")
	private String passWord;
	@ManyToOne
	@JoinColumn(name = "MATRANGTHAI")
	private TrangThaiTaiKhoan trangThaiTaiKhoanNhanVien;
	@ManyToOne
	@JoinColumn(name = "MAQUYEN")
	private Quyen quyen;
	
	

	public TaiKhoanNhanVien() {
	}
	
	
	
	public TaiKhoanNhanVien(String maTaiKhoanNhanVien, String userNameNhanVien, String passWord,
			TrangThaiTaiKhoan trangThaiTaiKhoanNhanVien, Quyen quyen) {
		this.maTaiKhoanNhanVien = maTaiKhoanNhanVien;
		this.userNameNhanVien = userNameNhanVien;
		this.passWord = passWord;
		this.trangThaiTaiKhoanNhanVien = trangThaiTaiKhoanNhanVien;
		this.quyen = quyen;
	}



	public String getUserNameNhanVien() {
		return userNameNhanVien;
	}
	public void setUserNameNhanVien(String userNameNhanVien) {
		this.userNameNhanVien = userNameNhanVien;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public TrangThaiTaiKhoan getTrangThaiTaiKhoanNhanVien() {
		return trangThaiTaiKhoanNhanVien;
	}
	public void setTrangThaiTaiKhoanNhanVien(TrangThaiTaiKhoan trangThaiTaiKhoanNhanVien) {
		this.trangThaiTaiKhoanNhanVien = trangThaiTaiKhoanNhanVien;
	}
	
	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}



	public String getMaTaiKhoanNhanVien() {
		return maTaiKhoanNhanVien;
	}



	public void setMaTaiKhoanNhanVien(String maTaiKhoanNhanVien) {
		this.maTaiKhoanNhanVien = maTaiKhoanNhanVien;
	}
	
	
}
