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
@Table(name = "THONGBAO")
public class ThongBao {
	@Id
	@Column(name = "MATHONGBAO")
	private String maThongBao;
	@Column(name = "TIEUDE")
	private String tieuDe;
	@Column(name = "NOIDUNGRUTGON")
	private String noiDungRutGon;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYGIODANG")
	private Date ngayGioDang;
	@Column(name = "XEMCHITIET")
	private String xemChiTiet;
	@ManyToOne
	@JoinColumn(name = "MALOAITHONGBAO")
	private LoaiThongBao loaiThongBao;
	@ManyToOne
	@JoinColumn(name = "MAQUANLI")
	private NhanVien quanLiTB;
	
	
	public ThongBao() {
	}
	
	public ThongBao(String maThongBao, String tieuDe, String noiDungRutGon, Date ngayGioDang, String xemChiTiet,
			LoaiThongBao loaiThongBao, NhanVien quanLiTB) {
		this.maThongBao = maThongBao;
		this.tieuDe = tieuDe;
		this.noiDungRutGon = noiDungRutGon;
		this.ngayGioDang = ngayGioDang;
		this.xemChiTiet = xemChiTiet;
		this.loaiThongBao = loaiThongBao;
		this.quanLiTB = quanLiTB;
	}

	public String getMaThongBao() {
		return maThongBao;
	}
	public void setMaThongBao(String maThongBao) {
		this.maThongBao = maThongBao;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDungRutGon() {
		return noiDungRutGon;
	}
	public void setNoiDungRutGon(String noiDungRutGon) {
		this.noiDungRutGon = noiDungRutGon;
	}
	public Date getNgayGioDang() {
		return ngayGioDang;
	}
	public void setNgayGioDang(Date ngayGioDang) {
		this.ngayGioDang = ngayGioDang;
	}
	public String getXemChiTiet() {
		return xemChiTiet;
	}
	public void setXemChiTiet(String xemChiTiet) {
		this.xemChiTiet = xemChiTiet;
	}
	public NhanVien getQuanLiTB() {
		return quanLiTB;
	}
	public void setQuanLiTB(NhanVien quanLiTB) {
		this.quanLiTB = quanLiTB;
	}

	public LoaiThongBao getLoaiThongBao() {
		return loaiThongBao;
	}

	public void setLoaiThongBao(LoaiThongBao loaiThongBao) {
		this.loaiThongBao = loaiThongBao;
	}
	
	
}
