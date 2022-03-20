package com.test2.www.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test2.www.DTO.BanDTO;
import com.test2.www.DTO.MemberDTO;

public class MemberDAO {
	private static MemberDAO mDao = new MemberDAO();
	private DataSource dataSource;
	private String table_name = "member";
	
	private MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getMemberDAO() {
		return mDao;
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
	
	public ArrayList<MemberDTO> memberListDAO() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" ORDER BY no DESC";
				
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPostcode(rs.getString("postcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setDetailAddress(rs.getString("detailAddress"));
				dto.setExtraAddress(rs.getString("extraAddress"));
				dto.setTel(rs.getString("tel"));
				dto.setAuthority(rs.getString("authority"));
				banStatusDAO(dto.getId());
				dto.setBan_time(rs.getString("ban_time"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public MemberDTO getMember(String id) {
		MemberDTO dto = new MemberDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " +table_name+ " WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				dto.setPostcode(rs.getString("postcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setJibunAddress(rs.getString("jibunAddress"));
				dto.setDetailAddress(rs.getString("detailAddress"));
				dto.setExtraAddress(rs.getString("extraAddress"));
				dto.setTel(rs.getString("tel"));
				dto.setAuthority(rs.getString("authority"));
				dto.setBan_time(rs.getString("ban_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		} 
		return dto;
	}
	
	public void signUpDAO(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO "+ table_name +"(id, nickname, pw, email, postcode, roadAddress, jibunAddress, detailAddress, extraAddress, tel) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPostcode());
			pstmt.setString(6, dto.getRoadAddress());
			pstmt.setString(7, dto.getJibunAddress());
			pstmt.setString(8, dto.getDetailAddress());
			pstmt.setString(9, dto.getExtraAddress());
			pstmt.setString(10, dto.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public MemberDTO loginDAO(String id) {
		MemberDTO dto = new MemberDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAuthority(rs.getString("authority"));
				banStatusDAO(dto.getId());
				dto.setBan_time(rs.getString("ban_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return dto;
	}
	
	public void modifyDAO(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" set nickname=?, pw=?, email=?, postcode=?, roadAddress=?, jibunAddress=?, detailAddress=?, extraAddress=?, tel=? WHERE id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPostcode());
			pstmt.setString(5, dto.getRoadAddress());
			pstmt.setString(6, dto.getJibunAddress());
			pstmt.setString(7, dto.getDetailAddress());
			pstmt.setString(8, dto.getExtraAddress());
			pstmt.setString(9, dto.getTel());
			pstmt.setString(10, dto.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public boolean duplicateID(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT id FROM "+table_name+" WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public boolean duplicateNick(String nick) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT * FROM "+table_name+" WHERE nickname = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public void DeleteMemberDAO(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM "+table_name+" WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void memberAuthorityDAO(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" SET authority = ? WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAuthority());
			pstmt.setString(2, dto.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void banMemberDAO(BanDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ban_member(id, nickname, reason, ban_time) VALUES(?,?,?,?);"
				+ "UPDATE member SET ban_time = ? WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getReason());
			pstmt.setString(4, dto.getBan_time());
			pstmt.setString(5, dto.getBan_time());
			pstmt.setString(6, dto.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void banStatusDAO(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET ban_time = null WHERE id = ? and ban_time < CURRENT_TIMESTAMP";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
}
