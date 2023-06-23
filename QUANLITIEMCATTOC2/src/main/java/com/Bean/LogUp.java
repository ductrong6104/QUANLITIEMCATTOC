package com.Bean;

public class LogUp {
	private String hoTen;
	private String sdt;
	private String password;
	private String passwordRepeat;
	public LogUp() {
		super();
	}
	public LogUp(String hoTen, String sdt, String password, String passwordRepeat) {
		super();
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	@Override
	public String toString() {
		return "LogUp [hoTen=" + hoTen + ", sdt=" + sdt + ", password=" + password + ", passwordRepeat="
				+ passwordRepeat + "]";
	}
	
}
