package com.springbook.domain;

import java.util.Date;

public class DeliveryInfo {
	 private int mb_seq;
	 private int mb_delivseq;
	 private String mb_nickname;
	 private String mb_name;
	 private String mb_phone;
	 private String mb_gender;
	 private String mb_email;
	 private String mb_zipcode;
	 private String mb_addr;
	 private String mb_detailaddr;
	 private String mb_notes;
	 private Date mb_join;
	 
	public DeliveryInfo() {
		// TODO Auto-generated constructor stub
	}
	public DeliveryInfo(int mb_seq, int mb_delivseq, String mb_nickname, String mb_name, String mb_phone,
			String mb_gender, String mb_email, String mb_zipcode, String mb_addr, String mb_detailaddr, String mb_notes,
			Date mb_join) {
		this.mb_seq = mb_seq;
		this.mb_delivseq = mb_delivseq;
		this.mb_nickname = mb_nickname;
		this.mb_name = mb_name;
		this.mb_phone = mb_phone;
		this.mb_gender = mb_gender;
		this.mb_email = mb_email;
		this.mb_zipcode = mb_zipcode;
		this.mb_addr = mb_addr;
		this.mb_detailaddr = mb_detailaddr;
		this.mb_notes = mb_notes;
		this.mb_join = mb_join;
	}
	public int getMb_seq() {
		return mb_seq;
	}
	public void setMb_seq(int mb_seq) {
		this.mb_seq = mb_seq;
	}
	public int getMb_delivseq() {
		return mb_delivseq;
	}
	public void setMb_delivseq(int mb_delivseq) {
		this.mb_delivseq = mb_delivseq;
	}
	public String getMb_nickname() {
		return mb_nickname;
	}
	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_phone() {
		return mb_phone;
	}
	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}
	public String getMb_gender() {
		return mb_gender;
	}
	public void setMb_gender(String mb_gender) {
		this.mb_gender = mb_gender;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_zipcode() {
		return mb_zipcode;
	}
	public void setMb_zipcode(String mb_zipcode) {
		this.mb_zipcode = mb_zipcode;
	}
	public String getMb_addr() {
		return mb_addr;
	}
	public void setMb_addr(String mb_addr) {
		this.mb_addr = mb_addr;
	}
	public String getMb_detailaddr() {
		return mb_detailaddr;
	}
	public void setMb_detailaddr(String mb_detailaddr) {
		this.mb_detailaddr = mb_detailaddr;
	}
	public String getMb_notes() {
		return mb_notes;
	}
	public void setMb_notes(String mb_notes) {
		this.mb_notes = mb_notes;
	}
	public Date getMb_join() {
		return mb_join;
	}
	public void setMb_join(Date mb_join) {
		this.mb_join = mb_join;
	}
	@Override
	public String toString() {
		return "DeliveryInfo [mb_seq=" + mb_seq + ", mb_delivseq=" + mb_delivseq + ", mb_nickname=" + mb_nickname
				+ ", mb_name=" + mb_name + ", mb_phone=" + mb_phone + ", mb_gender=" + mb_gender + ", mb_email="
				+ mb_email + ", mb_zipcode=" + mb_zipcode + ", mb_addr=" + mb_addr + ", mb_detailaddr=" + mb_detailaddr
				+ ", mb_notes=" + mb_notes + ", mb_join=" + mb_join + "]";
	}
	
	

	 
	 
}
