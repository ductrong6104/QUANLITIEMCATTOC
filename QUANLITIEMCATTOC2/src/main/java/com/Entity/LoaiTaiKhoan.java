package com.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAITAIKHOAN")
public class LoaiTaiKhoan {
	@Id
	@Column(name = "MALOAI")
	private String maLoai;
	@Column(name = "TENLOAI")
	private String tenLoai;
	@OneToMany(mappedBy = "loaiTaiKhoan", fetch = FetchType.EAGER)
	private Collection<TaiKhoanKhachHang> taiKhoanKhachHangs;
	public LoaiTaiKhoan() {}
	public LoaiTaiKhoan(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public Collection<TaiKhoanKhachHang> getTaiKhoanKhachHangs() {
		return taiKhoanKhachHangs;
	}
	public void setTaiKhoanKhachHangs(Collection<TaiKhoanKhachHang> taiKhoanKhachHangs) {
		this.taiKhoanKhachHangs = taiKhoanKhachHangs;
	}
	
}
