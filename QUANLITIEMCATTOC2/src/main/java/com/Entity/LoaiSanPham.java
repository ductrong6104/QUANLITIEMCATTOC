package com.Entity;

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
@Table(name = "LOAISANPHAM")
public class LoaiSanPham {
	@Id
	@Column(name = "MALOAISANPHAM")
	private String maLoaiSanPham;
	@Column(name = "TENLOAISANPHAM")
	private String tenLoaiSanPham;
	@OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.EAGER)
	private List<SanPham> sanPhams;
	
	public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
	}
	public LoaiSanPham() {
	}
	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}
	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}
	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}
	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSanPham=" + maLoaiSanPham + ", tenLoaiSanPham=" + tenLoaiSanPham + ", sanPhams="
				+ sanPhams + "]";
	}
	
}
