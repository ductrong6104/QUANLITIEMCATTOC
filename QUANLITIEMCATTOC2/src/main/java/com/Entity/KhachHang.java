package com.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
	@Id
	@Column(name = "MAKHACHHANG")
	private String maKhachHang;
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
	@OneToMany(mappedBy = "khachHangDat", fetch = FetchType.EAGER)
	private List<PhieuDatHang> hangDuocDats;
	
	public KhachHang() {}
	
	
	public KhachHang(String maKhachHang, String ho, String ten, Date ngaySinh, String diaChi, String email,
			List<PhieuDatHang> hangDuocDats) {
		this.maKhachHang = maKhachHang;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.hangDuocDats = hangDuocDats;
	}


	
	public String getMaKhachHang() {
		return maKhachHang;
	}


	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
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
	
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", ho=" + ho + ", ten=" + ten + ", ngaySinh=" + ngaySinh
				+ ", diaChi=" + diaChi + ", email=" + email + ", hangDuocDats=" + hangDuocDats + "]";
	}

	public List<PhieuDatHang> getHangDuocDats() {
		return hangDuocDats;
	}

	public void setHangDuocDats(List<PhieuDatHang> hangDuocDats) {
		this.hangDuocDats = hangDuocDats;
	}
	
	
}
