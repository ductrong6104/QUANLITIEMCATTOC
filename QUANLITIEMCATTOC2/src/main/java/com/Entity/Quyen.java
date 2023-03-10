package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUYEN")
public class Quyen {
	@Id
	@Column(name = "MAQUYEN")
	private String maQuyen;
	@Column(name = "TENQUYEN")
	private String tenQuyen;
	@OneToMany(mappedBy = "quyen", fetch = FetchType.EAGER)
	private List<TaiKhoanNhanVien> taiKhoanNhanViens;
	
	
	public Quyen() {
	}
	
	public Quyen(String maQuyen, String tenQuyen) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
	}
	
	public String getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	public List<TaiKhoanNhanVien> getTaiKhoanNhanViens() {
		return taiKhoanNhanViens;
	}
	public void setTaiKhoanNhanViens(List<TaiKhoanNhanVien> taiKhoanNhanViens) {
		this.taiKhoanNhanViens = taiKhoanNhanViens;
	}
	
}
