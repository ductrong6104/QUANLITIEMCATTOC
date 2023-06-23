package com.Entity;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "GIA")
	private BigDecimal gia;
	@ManyToOne
	@JoinColumn(name = "MALOAIDICHVU")
	private LoaiDichVu loaiDichVu;
	
	
	public DichVu() {
		super();
	}
	
	public DichVu(String maDichVu, String tenDichVu, Date thoiGianThucHien, String moTa, String hinhAnh, BigDecimal gia,
			LoaiDichVu loaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.thoiGianThucHien = thoiGianThucHien;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.gia = gia;
		this.loaiDichVu = loaiDichVu;
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
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", thoiGianThucHien=" + thoiGianThucHien
				+ ", moTa=" + moTa + ", hinhAnh=" + hinhAnh + ", gia=" + gia + ", loaiDichVu=" + loaiDichVu + "]";
	}
	
	
}
