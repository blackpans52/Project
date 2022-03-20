package com.test2.www.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class BoardDAO {
	private static BoardDAO bDao = new BoardDAO();
	private DataSource dataSource;
	private String table_name = "board1";
	
	private BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static BoardDAO getBoardDAO() {
		return bDao;
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
	
	public ArrayList<BoardInfoDTO> boardListDAO() {
		ArrayList<BoardInfoDTO> list = new ArrayList<BoardInfoDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoDTO dto = new BoardInfoDTO();
				dto.setBoard_code(rs.getString("board_code"));
				dto.setBoard_name(rs.getString("board_name"));
				dto.setAdmin_id(rs.getString("admin_id"));
				dto.setBoard_category1(rs.getString("board_category1"));
				dto.setBoard_category2(rs.getString("board_category2"));
				dto.setBoard_importance(rs.getBoolean("board_importance"));
				dto.setAdmin_write(rs.getBoolean("admin_write"));
				dto.setArticle_Cnt(rs.getInt("article_Cnt"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}
	
	public ArrayList<BoardInfoDTO> categoryBoardListDAO(String board_category1) {
		ArrayList<BoardInfoDTO> list = new ArrayList<BoardInfoDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info where board_category1 REGEXP ? AND board_importance is false";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_category1);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoDTO dto = new BoardInfoDTO();
				dto.setBoard_code(rs.getString("board_code"));
				dto.setBoard_name(rs.getString("board_name"));
				dto.setAdmin_id(rs.getString("admin_id"));
				dto.setBoard_category1(rs.getString("board_category1"));
				dto.setBoard_category2(rs.getString("board_category2"));
				dto.setBoard_importance(rs.getBoolean("board_importance"));
				dto.setAdmin_write(rs.getBoolean("admin_write"));				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}
	
	public ArrayList<BoardInfoDTO> boardRankingListDAO(int count, int articleCnt, String board_category1) {
		ArrayList<BoardInfoDTO> list = new ArrayList<BoardInfoDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info WHERE board_category1 REGEXP ? AND article_Cnt > 0 AND board_importance is false ORDER BY article_Cnt DESC"
				+ " LIMIT " + count*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_category1);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoDTO dto = new BoardInfoDTO();
				dto.setBoard_code(rs.getString("board_code"));
				dto.setBoard_name(rs.getString("board_name"));
				dto.setAdmin_id(rs.getString("admin_id"));
				dto.setBoard_category1(rs.getString("board_category1"));
				dto.setBoard_category2(rs.getString("board_category2"));
				dto.setBoard_importance(rs.getBoolean("board_importance"));
				dto.setAdmin_write(rs.getBoolean("admin_write"));
				dto.setArticle_Cnt(rs.getInt("article_Cnt"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}
	
	public ArrayList<BoardInfoDTO> allRankingListDAO(int count, int articleCnt) {
		ArrayList<BoardInfoDTO> list = new ArrayList<BoardInfoDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info WHERE article_Cnt > 0 AND board_importance is false ORDER BY article_Cnt DESC"
				+ " LIMIT " + count*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoDTO dto = new BoardInfoDTO();
				dto.setBoard_code(rs.getString("board_code"));
				String board_name = rs.getString("board_name");
				dto.setBoard_name(board_name.substring(0, board_name.length()-3).trim());
				dto.setAdmin_id(rs.getString("admin_id"));
				dto.setBoard_category1(rs.getString("board_category1"));
				dto.setBoard_category2(rs.getString("board_category2"));
				dto.setBoard_importance(rs.getBoolean("board_importance"));
				dto.setAdmin_write(rs.getBoolean("admin_write"));
				dto.setArticle_Cnt(rs.getInt("article_Cnt"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}
	
	public void createBoardDAO(BoardInfoDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board_info(board_code, board_name, board_category1, board_category2, board_importance, admin_write) VALUES(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_code());
			pstmt.setString(2, dto.getBoard_name());
			pstmt.setString(3, dto.getBoard_category1());
			pstmt.setString(4, dto.getBoard_category2());
			pstmt.setBoolean(5, false);
			pstmt.setBoolean(6, dto.isAdmin_write());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void DeleteBoardDAO(String bCode) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM board_info WHERE board_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bCode);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public BoardInfoDTO getBoardInfoDAO(String bCode) {
		BoardInfoDTO dto = new BoardInfoDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info WHERE board_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bCode);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_code(rs.getString("board_code"));
				dto.setBoard_name(rs.getString("board_name"));
				dto.setAdmin_id(rs.getString("admin_id"));
				dto.setBoard_category1(rs.getString("board_category1"));
				dto.setBoard_category2(rs.getString("board_category2"));
				dto.setBoard_importance(rs.getBoolean("board_importance"));
				dto.setAdmin_write(rs.getBoolean("admin_write"));
				dto.setArticle_Cnt(rs.getInt("article_Cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return dto;
	}
	
	public void boardAuthorityDAO(BoardInfoDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board_info SET admin_id = ? WHERE board_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAdmin_id());
			pstmt.setString(2, dto.getBoard_code());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}	
	
	public void articleCnt(int one, String board_code) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board_info SET article_Cnt = article_Cnt+? WHERE board_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, one);			
			pstmt.setString(2, board_code);			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public ArrayList<BoardDTO> titleListDAO(int count, int articleCnt, String board_code) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" WHERE board_Code = ?"
			+ " ORDER BY no DESC LIMIT " + count*articleCnt +", " + articleCnt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));				
				dto.setTitle(rs.getString("title"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setArticle_category(rs.getString("article_category"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> MainNewsListDAO(int count, int articleCnt, String board_code) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+ table_name
			+ " WHERE board_code = ? AND main_news = true ORDER BY no DESC LIMIT " + count*articleCnt +", " + articleCnt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));				
				dto.setTitle(rs.getString("title"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setArticle_category(rs.getString("article_category"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> newsTitleListDAO(int count, int articleCnt, String board_code) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+ table_name
			+ " WHERE board_code = ? AND main_news = false ORDER BY no DESC LIMIT " + count*articleCnt +", " + articleCnt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));				
				dto.setTitle(rs.getString("title"));
				dto.setArticle_category(rs.getString("article_category"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> newsListDAO(int count, int articleCnt, String board_code, String article_category) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+ table_name+" WHERE board_code IN (SELECT board_code FROM board_info WHERE board_code = ?) AND (article_category = ? or article_category = 'multi')"
				+ " ORDER BY no DESC LIMIT " + count*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			pstmt.setString(2, article_category);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));				
				dto.setTitle(rs.getString("title"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContents(rs.getString("contents"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setArticle_category(rs.getString("article_category"));
				dto.setThumbnail(rs.getString("thumbnail"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> searchNewsListDAO(String where, int count, int articleCnt, String board_code, String article_category) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+ table_name+" WHERE "+ where +" AND board_code IN (SELECT board_code FROM board_info WHERE board_code = ?) AND (article_category = ? or article_category = 'multi')"
				+ " ORDER BY no DESC LIMIT " + count*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			pstmt.setString(2, article_category);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));				
				dto.setTitle(rs.getString("title"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContents(rs.getString("contents"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setArticle_category(rs.getString("article_category"));
				dto.setThumbnail(rs.getString("thumbnail"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> listDAO(int page, int articleCnt, String board_code) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (select @ROWNUM:= @ROWNUM + 1 as rownum, "+table_name+".* from "+table_name+", (select @ROWNUM:= 0) TMP WHERE board_code = "+board_code+") SUB ORDER BY rownum DESC"
			+ " LIMIT " + page*articleCnt +", " + articleCnt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setRownum(rs.getInt("rownum"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setArticle_category(rs.getString("article_category"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> searchListDAO(String where, int page, int articleCnt, String board_code) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (select @ROWNUM:= @ROWNUM + 1 as rownum, "+table_name+".* from "+table_name+", (select @ROWNUM:= 0) TMP WHERE board_code = "+board_code+") SUB"
				+ " WHERE "+ where +" ORDER BY rownum DESC LIMIT " + page*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setRownum(rs.getInt("rownum"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setArticle_category(rs.getString("article_category"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> bestListDAO(int page, int articleCnt) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name+" WHERE best is true ORDER BY no DESC"
			+ " LIMIT " + page*articleCnt +", " + articleCnt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setBoard_code(getBoardInfoDAO(rs.getString("board_code")).getBoard_name());
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BoardDTO> bestSearchListDAO(String where, int page, int articleCnt) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name
				+ " WHERE "+ where +" AND best is true ORDER BY no DESC LIMIT " + page*articleCnt +", " + articleCnt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				if(rs.getString("wtime").substring(0, 10).equals(today)) {
					dto.setWtime(rs.getString("wtime").substring(11,16));  
		        } else {
		        	dto.setWtime(rs.getString("wtime").substring(0,10));     	
		        }
				dto.setHit(rs.getInt("hit"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setBoard_code(getBoardInfoDAO(rs.getString("board_code")).getBoard_name());
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
	
	public int listSize(String board_code) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT count(rownum) FROM (select @ROWNUM:= @ROWNUM + 1 as rownum, "+table_name+".* from "+table_name+", (select @ROWNUM:= 0) TMP WHERE board_code = "+board_code+") SUB";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(rownum)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int searchListSize(String where, String board_code) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(rownum) FROM (select @ROWNUM:= @ROWNUM + 1 as rownum, "+table_name+".* from "+table_name+", (select @ROWNUM:= 0) TMP WHERE board_code = "+board_code+") SUB"
			+ " WHERE "+ where +" ORDER BY no";	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(rownum)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int bestListSize() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT count(*) FROM "+table_name+" WHERE best is true";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int bestSearchListSize(String where) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM "+table_name
			+ " WHERE "+ where +" AND best is true ORDER BY no";	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int newsListSize(String board_code, String article_category) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT count(*) FROM "+ table_name+" WHERE board_code IN (SELECT board_code FROM board_info WHERE board_code = ?) AND (article_category = ? or article_category = 'multi')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			pstmt.setString(2, article_category);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int searchNewsListSize(String where, String board_code, String article_category) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT count(*) FROM "+ table_name+" WHERE "+ where +" AND board_code IN (SELECT board_code FROM board_info WHERE board_code = ?) AND (article_category = ? or article_category = 'multi')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_code);
			pstmt.setString(2, article_category);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public BoardDTO getBoardDTO(String no) {
		BoardDTO dto = new BoardDTO();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
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
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setWtime(rs.getString("wtime"));
				dto.setHit(rs.getInt("hit"));
				dto.setBoard_code(rs.getString("board_code"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setBest(rs.getBoolean("best"));
				dto.setArticle_category(rs.getString("article_category"));
				dto.setMain_news(rs.getBoolean("main_news"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void writeDAO(BoardDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO "+table_name+"(id, nickname, title, contents, board_code, thumbnail, article_category) VALUES(?,?,?,?,?,?,?)";
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getBoard_code());
			pstmt.setString(6, dto.getThumbnail());
			pstmt.setString(7, dto.getArticle_category());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public BoardDTO viewDAO(String no) {
		BoardDTO dto = getBoardDTO(no);
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE "+table_name+" SET hit = hit + 1 WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void modifyDAO(BoardDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" SET title = ?, contents = ?, article_category = ?, wTime = now() WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setString(3, dto.getArticle_category());
			pstmt.setInt(4, dto.getNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void deleteDAO(String no) {
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
	
	public void bestSwitchDAO(String no,boolean flag) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" SET best = ? WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, flag);
			pstmt.setString(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void mainNewsSwitchDAO(String no,boolean flag) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE "+table_name+" SET main_news = ? WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setBoolean(1, flag);
			pstmt.setString(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
	
	public ArrayList<BoardDTO> realTimeBestListDAO() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();        
        c1.add(Calendar.HOUR, -3);        
        String time = sdf.format(c1.getTime());
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "+table_name
			+ " WHERE board_code IN (SELECT board_code FROM board_info WHERE board_category1 = 'community') AND hit > 100 AND wtime > ? ORDER BY no DESC"
			+ " LIMIT 0,7";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, time);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setReplyCnt(rDao.replyCntDAO(dto.getNo()));
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return list;
	}
}
