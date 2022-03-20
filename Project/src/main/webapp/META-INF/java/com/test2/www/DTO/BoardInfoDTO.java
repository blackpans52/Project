package com.test2.www.DTO;

public class BoardInfoDTO {
	private String board_code;
	private String board_name;
	private String board_category1;
	private String board_category2;
	private String admin_id;
	private boolean board_importance;
	private boolean admin_write;
	private int article_Cnt;
	
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getBoard_category1() {
		return board_category1;
	}
	public void setBoard_category1(String board_category1) {
		this.board_category1 = board_category1;
	}
	public String getBoard_category2() {
		return board_category2;
	}
	public void setBoard_category2(String board_category2) {
		this.board_category2 = board_category2;
	}
	public boolean isBoard_importance() {
		return board_importance;
	}
	public void setBoard_importance(boolean board_importance) {
		this.board_importance = board_importance;
	}
	public boolean isAdmin_write() {
		return admin_write;
	}
	public void setAdmin_write(boolean admin_write) {
		this.admin_write = admin_write;
	}
	public int getArticle_Cnt() {
		return article_Cnt;
	}
	public void setArticle_Cnt(int article_Cnt) {
		this.article_Cnt = article_Cnt;
	}	
}
