package com.springbook.biz.user;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	
	private String postcode;
	private String roadAddress;
	private String jubunAddress;
	private String detailAddress;
	private String extraAddress;
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJubunAddress() {
		return jubunAddress;
	}
	public void setJubunAddress(String jubunAddress) {
		this.jubunAddress = jubunAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
