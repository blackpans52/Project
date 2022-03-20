package com.test2.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test2.www.DTO.ReplyDTO;

public class ReplyDAO {
	private static ReplyDAO rDao = new ReplyDAO();
	private DataSource dataSource;
	private String table_name = "reply";
	
	private ReplyDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ReplyDAO getReplyDAO() {
		return rDao;
	}
	
	public Connection getConnection() {
		Connection conn = null; 
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReplyDTO> replyListDAO(String no) {
		ArrayList<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" WHERE post_num = ? ORDER BY groupNum, stepNum";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setReply_nick(rs.getString("reply_nick"));
				dto.setReply_contents(rs.getString("reply_contents"));
				dto.setWtime(rs.getString("wtime"));
				dto.setLike_num(rs.getInt("like_num"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepNum(rs.getInt("stepNum"));
				replyList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return replyList;	
	}
	
	public ReplyDTO getReplyDTO(String no) {
		ReplyDTO dto = new ReplyDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" WHERE no = ?"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setReply_nick(rs.getString("reply_nick"));
				dto.setReply_contents(rs.getString("reply_contents"));
				dto.setPost_num(rs.getInt("post_num"));
				dto.setLike_num(rs.getInt("like_num"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepNum(rs.getInt("stepNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void writeReplyDAO(ReplyDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO "+table_name+"(id, nickname, reply_contents, post_num) VALUES(?,?,?,?);"
			+ "UPDATE "+table_name+" SET groupNum = (SELECT * FROM (SELECT MAX(no) FROM "+table_name+") AS a) WHERE no = (SELECT * FROM (SELECT MAX(no) FROM "+table_name+") AS b)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());			
			pstmt.setString(2, dto.getNickname());			
			pstmt.setString(3, dto.getReply_contents());
			pstmt.setInt(4, dto.getPost_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}		
	}
	
	public void deleteReplyDAO(String no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM "+table_name+" WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void nestedReplyDAO(ReplyDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO "+table_name+"(id, nickname, reply_nick, reply_contents, post_num, groupNum, stepNum) VALUES(?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getReply_nick());
			pstmt.setString(4, dto.getReply_contents());
			pstmt.setInt(5, dto.getPost_num());
			pstmt.setInt(6, dto.getGroupNum());
			pstmt.setInt(7, dto.getStepNum()+1);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void modifyReplyDAO(ReplyDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" SET reply_contents = ?, wTime = now() WHERE no =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getReply_contents());
			pstmt.setInt(2, dto.getNo());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public int replyCntDAO(int no) {
		int count = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM "+table_name+" WHERE post_num = ?;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return count;
	}
}
