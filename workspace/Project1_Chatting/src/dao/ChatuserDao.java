package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ChatDBConnect;
import vo.ChatuserVo;

public class ChatuserDao {
	
	private ChatDBConnect dbcn;
	private static ChatuserDao instance;
	
	private ChatuserDao() {
		System.out.println("ChatuserDao 생성");
		dbcn = ChatDBConnect.getInstance();
	}
	public static ChatuserDao getInstance() {
		synchronized(ChatuserDao.class) {
			if(instance == null) {
				instance = new ChatuserDao();
			}return instance;
		}
	}
	// Insert
	public void insert(ChatuserVo vo) throws SQLException{
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into \"CHATUSER\"");
			sql.append("(\"USER_NUM\", \"USER_PORTNO\", \"USER_ID\", \"USER_LOGTIME\", \"USER_MESSAGE\")");
			sql.append("values ");
			sql.append("(?, ?, ?, sysdate, \"SEQ_USER_MESSAGE\")");
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			
			pst.setInt(1, vo.getUser_num());
			pst.setInt(2, vo.getUser_portno());
			pst.setString(3, vo.getUser_id());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		}
	}
	
	// Select(전체 조회)
	public List<ChatuserVo> selectAll() throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<ChatuserVo> result = new ArrayList<>();
		try {
			conn = dbcn.getConnection();
			System.out.println("DB 접속됨");
			
			String sql = "select * from \"CHATUSER\""
							+ " order by \"USER_NUM\"";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ChatuserVo temp = new ChatuserVo(
								rs.getInt("USER_NUM"),
								rs.getInt(2),
								rs.getString(3),
								rs.getDate("REGDATE"),
								rs.getString(5));
				result.add(temp);
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbcn.close(rs);
				dbcn.close(pst);
				dbcn.close(conn);
			} return result;
		}
	// Select(개별 조회)	
	public ChatuserVo selectUser(int searchNum) throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ChatuserVo result = null;
		
		try {
			String sql = "select * from \"CHATUSER\" where \"USER_NUM\"";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, searchNum);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				result = new ChatuserVo(
						rs.getInt("USER_NUM"),
						rs.getInt(2),
						rs.getString(3),
						rs.getDate("REGDATE"),
						rs.getString(5));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
			
		} finally {
			dbcn.close(rs);
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
	
	// Update
	public int update(ChatuserVo vo) throws SQLException {
		return update(vo.getUser_num(), vo.getUser_portno(),
						vo.getUser_id(), vo.getRegdate(),
						vo.getUser_message());
	}
	private int update(int user_num, int user_portno, 
						String user_id, Date regdate, 
						String user_message) 
									throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update \"CHATUSER\"");
			sql.append("set \"USER_ID\"= ?");
			sql.append("values ");
			sql.append("where \"USER_PORTNO\"= ?");
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, user_id);
			pst.setInt(2, user_portno);
			
			result = pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
	
	// Delete(전체 삭제)
	public int deleteAll() throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("delete from \"CHATUSER\"");
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			
			result = pst.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "내용이 삭제되었습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
	
	// Delete(선택 삭제)
	public int deleteUser(int user_num) throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("delete from \"CHATUSER\"");
			sql.append("where \"USER_NUM\"= ?");
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			
			if(result > 0) {
				System.out.println(result + "번 유저가 퇴장했습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
}
