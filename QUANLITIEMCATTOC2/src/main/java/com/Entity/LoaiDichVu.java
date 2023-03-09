package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAIDICHVU")
public class LoaiDichVu {
	@Id
	@Column(name = "MALOAIDICHVU")
	private String maLoaiDichVu;
	@Column(name = "TENLOAIDICHVU")
	private String tenLoaiDichVu;
	@OneToMany(mappedBy = "loaiDichVu",fetch = FetchType.EAGER)
	private List<DichVu> dichVus; 
	public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu) {
		super();
		this.maLoaiDichVu = maLoaiDichVu;
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	public LoaiDichVu() {
		super();
	}
	public String getMaLoaiDichVu() {
		return maLoaiDichVu;
	}
	public void setMaLoaiDichVu(String maLoaiDichVu) {
		this.maLoaiDichVu = maLoaiDichVu;
	}
	public String getTenLoaiDichVu() {
		return tenLoaiDichVu;
	}
	public void setTenLoaiDichVu(String tenLoaiDichVu) {
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	public List<DichVu> getDichVus() {
		return dichVus;
	}
	public void setDichVus(List<DichVu> dichVus) {
		this.dichVus = dichVus;
	}
	
	
}
