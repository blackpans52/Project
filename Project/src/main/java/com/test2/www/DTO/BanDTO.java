package com.test2.www.DTO;

public class BanDTO {
	private int no;
	private String id;
	private String nickname;
	private String reason;
	private String ban_time;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBan_time() {
		return ban_time;
	}
	public void setBan_time(String ban_time) {
		this.ban_time = ban_time;
	}
}
