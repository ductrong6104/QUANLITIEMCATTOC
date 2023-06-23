package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TINHTRANGDONHANG")
public class TinhTrangDonHang {
	@Id
	@Column(name = "MATINHTRANG")
	private String maTinhTrang;
	@Column(name = "MOTA")
	private String moTa;
	@OneToMany(mappedBy = "tinhTrangDonHang",fetch = FetchType.EAGER)
	private List<PhieuDatHang> phieuDatHangs;
	
	public TinhTrangDonHang() {
	}
	public TinhTrangDonHang(String maTinhTrang, String moTa) {
		this.maTinhTrang = maTinhTrang;
		this.moTa = moTa;
	}
	public String getMaTinhTrang() {
		return maTinhTrang;
	}
	public void setMaTinhTrang(String maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public List<PhieuDatHang> getPhieuDatHangs() {
		return phieuDatHangs;
	}
	public void setPhieuDatHangs(List<PhieuDatHang> phieuDatHangs) {
		this.phieuDatHangs = phieuDatHangs;
	}
	
}
