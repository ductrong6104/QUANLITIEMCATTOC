package com.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "CHITIETPHIEUDATHANG")
public class ChiTietPhieuDatHang {
	@Id
	@GeneratedValue
	@Column(name = "idCHITIETPHIEUDATHANG")
	private int idChiTietPhieuDatHang;
	@ManyToOne
	@JoinColumn(name = "MASANPHAM")
	private SanPham sanPhamDuocDat;
	@ManyToOne
	@JoinColumn(name = "idPHIEUDATHANG")
	private PhieuDatHang phieuDatHang;
	@Column(name = "SOLUONG")
	private int soLuong;
	@Column(name = "DONGIA")
	private BigDecimal donGia;
	
	public ChiTietPhieuDatHang() {
		
	}
	
	
	public ChiTietPhieuDatHang(int idChiTietPhieuDatHang, SanPham sanPhamDuocDat, PhieuDatHang phieuDatHang,
			int soLuong, BigDecimal donGia) {
		super();
		this.idChiTietPhieuDatHang = idChiTietPhieuDatHang;
		this.sanPhamDuocDat = sanPhamDuocDat;
		this.phieuDatHang = phieuDatHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}


	public int getIdChiTietPhieuDatHang() {
		return idChiTietPhieuDatHang;
	}
	public void setIdChiTietPhieuDatHang(int idChiTietPhieuDatHang) {
		this.idChiTietPhieuDatHang = idChiTietPhieuDatHang;
	}
	
	public SanPham getSanPhamDuocDat() {
		return sanPhamDuocDat;
	}
	public void setSanPhamDuocDat(SanPham sanPhamDuocDat) {
		this.sanPhamDuocDat = sanPhamDuocDat;
	}
	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}
	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Override
	public String toString() {
		return "ChiTietPhieuDatHang [idChiTietPhieuDatHang=" + idChiTietPhieuDatHang + ", sanPhamDuocDat="
				+ sanPhamDuocDat + ", phieuDatHang=" + phieuDatHang + ", soLuong=" + soLuong + "]";
	}


	public BigDecimal getDonGia() {
		return donGia;
	}


	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}
	
	
	
}
