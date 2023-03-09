package com.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DICHVU")
public class DichVu {
	@Id
	@Column(name = "MADICHVU")
	private String maDichVu;
	@Column(name = "TENDICHVU")
	private String tenDichVu;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "THOIGIANTHUCHIEN")
	private Date thoiGianThucHien;
	@Column(name = "MOTA")
	private String moTa;
	@Column(name = "HINHANH")
	private String hinhAnh;
	@ManyToOne
	@JoinColumn(name = "MALOAIDICHVU")
	private LoaiDichVu loaiDichVu;
	@ManyToOne
	@JoinColumn(name = "MAQUANLI")
	private NhanVien quanLiTaoDichVu;
	
	
	
	public DichVu() {
		super();
	}
	public DichVu(String maDichVu, String tenDichVu, Date thoiGianThucHien, String moTa, String hinhAnh,
			LoaiDichVu loaiDichVu, NhanVien quanLiTaoDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.thoiGianThucHien = thoiGianThucHien;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.loaiDichVu = loaiDichVu;
		this.quanLiTaoDichVu = quanLiTaoDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public Date getThoiGianThucHien() {
		return thoiGianThucHien;
	}
	public void setThoiGianThucHien(Date thoiGianThucHien) {
		this.thoiGianThucHien = thoiGianThucHien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public LoaiDichVu getLoaiDichVu() {
		return loaiDichVu;
	}
	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}
	public NhanVien getQuanLiTaoDichVu() {
		return quanLiTaoDichVu;
	}
	public void setQuanLiTaoDichVu(NhanVien quanLiTaoDichVu) {
		this.quanLiTaoDichVu = quanLiTaoDichVu;
	}
	
}
