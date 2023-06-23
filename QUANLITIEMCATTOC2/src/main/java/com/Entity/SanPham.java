package com.Entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SANPHAM")
public class SanPham {
	@Id
	@Column(name = "MASANPHAM")
	private String maSanPham;
	@Column(name = "TENSANPHAM")
	private String tenSanPham;
	@Column(name = "MOTA")
	private String moTa;
	@Column(name = "HINHANH")
	private String hinhAnh;
	@Column(name = "GIA")
	private BigDecimal gia;
	@ManyToOne
	@JoinColumn(name = "MALOAISANPHAM")
	private LoaiSanPham loaiSanPham;
	@OneToMany(mappedBy = "sanPhamDuocDat", fetch = FetchType.EAGER)
	private List<ChiTietPhieuDatHang> chiTietPhieuDatHangs;
	public SanPham() {
	}
	
	
	
	public SanPham(String maSanPham, String tenSanPham, String moTa, String hinhAnh, BigDecimal gia,
			LoaiSanPham loaiSanPham, List<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.gia = gia;
		this.loaiSanPham = loaiSanPham;
		this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
	}



	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
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
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}



	public BigDecimal getGia() {
		return gia;
	}



	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}



	public List<ChiTietPhieuDatHang> getChiTietPhieuDatHangs() {
		return chiTietPhieuDatHangs;
	}



	public void setChiTietPhieuDatHangs(List<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
		this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
	}



	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", hinhAnh="
				+ hinhAnh + ", gia=" + gia + ", loaiSanPham=" + loaiSanPham + ", chiTietPhieuDatHangs="
				+ chiTietPhieuDatHangs + "]";
	}
	
	
	
	
}
