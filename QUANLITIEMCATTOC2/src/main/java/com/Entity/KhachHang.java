package com.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
	@Id
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	@Column(name = "HO")
	private String ho;	
	@Column(name = "TEN")
	private String ten;	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "NGAYSINH")
	private Date ngaySinh;
	@Column(name = "DIACHI")
	private String diaChi;
	@Column(name = "EMAIL")
	private String email;
	
	
	public KhachHang() {}
	
	public KhachHang(String soDienThoai, String ho, String ten, Date ngaySinh, String diaChi, String email) {
		this.soDienThoai = soDienThoai;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return getClass().getName() + "[sdt:" + soDienThoai + "ho: " + ho + "ten: " + ten +"ngaysinh: " + ngaySinh + "dia chi:" + diaChi + "email: " + email;
	}
}
