package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THAYDOIGIASANPHAM")
public class ThayDoiGiaSanPham {
	@Id
	@GeneratedValue
	@Column(name = "idGIASANPHAM")
	private int idGiaSanPham;
	@ManyToOne
	@JoinColumn(name = "MASANPHAM")
	private SanPham sanPham;
	@Column(name = "NGAYAPDUNG")
	private String ngayApDung;
	@Column(name = "GIA")
	private String gia;
	@ManyToOne
	@JoinColumn(name = "MAQUANLI")
	private NhanVien quanLiThayDoiGiaSanPham;
	public ThayDoiGiaSanPham(SanPham sanPham, String ngayApDung, String gia, NhanVien quanLiThayDoiGiaSanPham) {
	
		this.sanPham = sanPham;
		this.ngayApDung = ngayApDung;
		this.gia = gia;
		this.quanLiThayDoiGiaSanPham = quanLiThayDoiGiaSanPham;
	}
	public ThayDoiGiaSanPham() {
	
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public String getNgayApDung() {
		return ngayApDung;
	}
	public void setNgayApDung(String ngayApDung) {
		this.ngayApDung = ngayApDung;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public NhanVien getquanLiThayDoiGiaSanPham() {
		return quanLiThayDoiGiaSanPham;
	}
	public void setquanLiThayDoiGiaSanPham(NhanVien quanLiThayDoiGiaSanPham) {
		this.quanLiThayDoiGiaSanPham = quanLiThayDoiGiaSanPham;
	}
	
}
