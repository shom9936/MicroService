package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.BoardVO;
import vo.CommentVO;

public class BoardDAO {
	private static DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private static BoardDAO instance;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	private BoardDAO() {}

	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	public ArrayList<BoardVO> boardList (int start, int end){
		
		String sql = "select * from" 
					+ "(select rownum rn, tt.*"
					+ "from (select * from board order by seq desc) tt)"
					+ "where rn>=? and rn <= ?";
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO boardVO = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				boardVO = new BoardVO();
				boardVO.setSeq(res.getInt("seq"));
				boardVO.setId(res.getString("id"));
				boardVO.setTitle(res.getString("title"));
				boardVO.setContent(res.getString("content"));
				boardVO.setHit(res.getInt("hit"));
				boardVO.setLogtime(res.getString("logtime"));
				
				list.add(boardVO);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	} // boardlist() end
	
	public int getTotalArticle() {
		
		String sql = "select count(*) from board";
		int total = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			if(res.next()) {
				total = res.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return total;
	} // getTotalArticle() end
	
	public BoardVO getBoardInfo(int seq) {
		String sql  ="select * from board where seq = ?";
		BoardVO vo = new BoardVO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				vo.setComment_cnt(res.getInt("comment_cnt"));
				vo.setContent(res.getString("content"));
				vo.setFilename(res.getString("filename"));
				vo.setHit(res.getInt("hit"));
				vo.setId(res.getString("id"));
				vo.setLogtime(res.getString("logtime"));
				vo.setSeq(res.getInt("seq"));
				vo.setTitle(res.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int updateHit(int seq) {
		String sql = "update board set hit=hit+1 where seq = ?";
		int num = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			num = pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return num;
	}
	
	public ArrayList<CommentVO> getComment(int board_no){
		String sql = "select * from board_comment where board_no = ?";
		CommentVO commentVO;
		ArrayList<CommentVO> list = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				commentVO = new CommentVO();
				commentVO.setBoard_no(board_no);
				commentVO.setContent(res.getString("content"));
				commentVO.setId(res.getString("id"));
				commentVO.setLogtime(res.getString("logtime"));
				commentVO.setSeq(res.getInt("seq"));
				list.add(commentVO);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int write(BoardVO vo) {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, 0, sysdate, 0)";
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getFilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int update(BoardVO vo) {
		String sql = "update board set title = ? , content = ?, filename = ? where seq = ?";
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getFilename());
			pstmt.setInt(4, vo.getSeq());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int delete(int seq) {
		String sql = "delete from board where seq = ?";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int commentWrite(CommentVO vo) {
		String sql = "insert into board_comment values(?, ?, comment_seq.nextval, ?, sysdate)";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoard_no());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int commentDelete(int seq) {
		String sql = "delete from board_comment where seq = ?";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
