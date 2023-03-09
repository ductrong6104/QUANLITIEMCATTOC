package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THAYDOIGIADICHVU")
public class ThayDoiGiaDichVu {
	@Id
	@GeneratedValue
	@Column(name = "idGIADICHVU")
	private int idGiaDichVu;
	@ManyToOne
	@JoinColumn(name = "MADICHVU")
	private DichVu dichVu;
	@Column(name = "NGAYAPDUNG")
	private String ngayApDung;
	@Column(name = "GIA")
	private String gia;
	@ManyToOne
	@JoinColumn(name = "MAQUANLI")
	private NhanVien quanLiThayDoiGiaDichVu;
	public ThayDoiGiaDichVu(DichVu dichVu, String ngayApDung, String gia, NhanVien quanLiThayDoiGiaSanPham) {
	
		this.dichVu = dichVu;
		this.ngayApDung = ngayApDung;
		this.gia = gia;
		this.quanLiThayDoiGiaDichVu = quanLiThayDoiGiaSanPham;
	}
	public ThayDoiGiaDichVu() {
	
	}
	public DichVu getSanPham() {
		return dichVu;
	}
	public void setSanPham(DichVu sanPham) {
		this.dichVu = sanPham;
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
		return quanLiThayDoiGiaDichVu;
	}
	public void setquanLiThayDoiGiaSanPham(NhanVien quanLiThayDoiGiaSanPham) {
		this.quanLiThayDoiGiaDichVu = quanLiThayDoiGiaSanPham;
	}
}
