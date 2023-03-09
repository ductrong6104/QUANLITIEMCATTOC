package com.Entity;

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
	@ManyToOne
	@JoinColumn(name = "MALOAISANPHAM")
	private LoaiSanPham loaiSanPham;
	@ManyToOne
	@JoinColumn(name = "MAQUANLI")
	private NhanVien quanLiTaoSanPham;
	@OneToMany(mappedBy = "sanPham", fetch = FetchType.EAGER)
	private List<ThayDoiGiaSanPham> giaSanPhams;
	public SanPham() {
	}
	
	public SanPham(String maSanPham, String tenSanPham, String moTa, String hinhAnh, LoaiSanPham loaiSanPham,
			NhanVien quanLiTaoSanPham) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.loaiSanPham = loaiSanPham;
		this.quanLiTaoSanPham = quanLiTaoSanPham;
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
	public NhanVien getQuanLiTaoSanPham() {
		return quanLiTaoSanPham;
	}
	public void setQuanLiTaoSanPham(NhanVien quanLiTaoSanPham) {
		this.quanLiTaoSanPham = quanLiTaoSanPham;
	}
	
	public String toString() {
		return getClass().getName() + "[masp: " + maSanPham + ", tensp: "+ tenSanPham + ", mota: " + moTa + ", hinhanh: " + hinhAnh + ", maloaisp: " + loaiSanPham.getMaLoaiSanPham() + ", maquanli: " + quanLiTaoSanPham.getTen();
	}

	public List<ThayDoiGiaSanPham> getGiaSanPhams() {
		return giaSanPhams;
	}

	public void setGiaSanPhams(List<ThayDoiGiaSanPham> giaSanPhams) {
		this.giaSanPhams = giaSanPhams;
	}
	
	
}
