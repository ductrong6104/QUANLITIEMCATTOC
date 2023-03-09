package com.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAITHONGBAO")
public class LoaiThongBao {
	@Id
	@Column(name = "MALOAITHONGBAO")
	private String maLoaiThongBao;
	@Column(name = "TENLOAITHONGBAO")
	private String tenLoaiThongBao;
	@OneToMany(mappedBy = "loaiThongBao", fetch = FetchType.EAGER)
	private List<ThongBao> thongBaos;
	
	public LoaiThongBao() {
	}
	
	public LoaiThongBao(String maLoaiThongBao, String tenLoaiThongBao) {
		this.maLoaiThongBao = maLoaiThongBao;
		this.tenLoaiThongBao = tenLoaiThongBao;
	}

	public String getMaLoaiThongBao() {
		return maLoaiThongBao;
	}
	public void setMaLoaiThongBao(String maLoaiThongBao) {
		this.maLoaiThongBao = maLoaiThongBao;
	}
	public String getTenLoaiThongBao() {
		return tenLoaiThongBao;
	}
	public void setTenLoaiThongBao(String tenLoaiThongBao) {
		this.tenLoaiThongBao = tenLoaiThongBao;
	}

	public List<ThongBao> getThongBaos() {
		return thongBaos;
	}

	public void setThongBaos(List<ThongBao> thongBaos) {
		this.thongBaos = thongBaos;
	}
	
}
