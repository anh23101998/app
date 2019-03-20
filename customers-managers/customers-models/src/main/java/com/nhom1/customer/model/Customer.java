package com.nhom1.customer.model;

public class Customer {
	private String MaXe;
	private String sAnh1;
	private String sAnh2;
	private String sGio;
	private String sNgay;

	public Customer() {

	}

	public Customer(String MaXe) {
		this.MaXe = MaXe;
	}

	public Customer(String MaXe, String sAnh1, String sAnh2, String sGio, String sNgay) {

		this.MaXe = MaXe;
		this.sAnh1 = sAnh1;
		this.sAnh2 = sAnh2;
		this.sGio = sGio;
		this.sNgay = sNgay;
	}

	public String getMaXe() {
		return MaXe;
	}

	public void setMaXe(String maXe) {
		MaXe = maXe;
	}

	public String getsAnh1() {
		return sAnh1;
	}

	public void setsAnh1(String sAnh1) {
		this.sAnh1 = sAnh1;
	}

	public String getsAnh2() {
		return sAnh2;
	}

	public void setsAnh2(String sAnh2) {
		this.sAnh2 = sAnh2;
	}

	public String getsGio() {
		return sGio;
	}

	public void setsGio(String sGio) {
		this.sGio = sGio;
	}

	public String getsNgay() {
		return sNgay;
	}

	public void setsNgay(String sNgay) {
		this.sNgay = sNgay;
	}

	@Override
	public String toString() {
		return "Customer [MaXe=" + MaXe + ", sAnh1=" + sAnh1 + ", sAnh2=" + sAnh2 + ", sGio=" + sGio + ", sNgay="
				+ sNgay + "]";
	}

}
