package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ChatDBConnect;
import vo.ChatroomVo;

// DAO(Database Access Object) : 데이터베이스에 쿼리 전송, 결과 출력 역할
public class ChatroomDao {
	private ChatDBConnect dbcn;
	private static ChatroomDao instance;
	
	private ChatroomDao() {
		System.out.println("ChatroomDao 생성");
		dbcn = ChatDBConnect.getInstance();
	}
	public static ChatroomDao getInstance() {
		synchronized(ChatroomDao.class) {
			if(instance == null) {
				instance = new ChatroomDao();
			} return instance;
		}
	}
	// Insert
	public void Insert(ChatroomVo vo) throws SQLException {
		
		// DML
		
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("insert into \"CHATROOM\"");
			sql.append("(\"user_ip\", \"user_portno\", \"user_num\", \"user_total\")");
			sql.append("values ");
			sql.append("(?, ?, \"SEQ_USER_NUM\".nextval, ?)");
			
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			
			pst.setString(1, vo.getUser_ip());
			pst.setInt(2, vo.getUser_portno());
			pst.setInt(3, vo.getServer_portno());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		}
	}
	
	// Select(전체 조회)
	public List<ChatroomVo> selectAll() throws SQLException{
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<ChatroomVo> result = new ArrayList<>();
		try {
			conn = dbcn.getConnection();
			System.out.println("DB 접속됨");
			
			String sql = "select * from \"CHATROOM\" "
							+ " order by \"USER_NUM\" asc";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ChatroomVo temp = new ChatroomVo(
								rs.getString(1),
								rs.getInt(2),
								rs.getInt("USER_NUM"),
								rs.getInt(4));
				result.add(temp);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				dbcn.close(rs);
				dbcn.close(pst);
				dbcn.close(conn);
			} return result;
		}
	
	// Select(개별 조회)
	public ChatroomVo selectUser(int searchNum) throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ChatroomVo result = null;
		
		try {
			String sql = "select * from \"CHATROOM\" where \"USER_NUM\"";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, searchNum);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				result = new ChatroomVo(
						rs.getString(1),
						rs.getInt(2),
						rs.getInt("USER_NUM"),
						rs.getInt(4));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbcn.close(rs);
			dbcn.close(pst);
			dbcn.close(conn);
		}return result;
	}
	
	// Update
	public int update(ChatroomVo vo) throws SQLException {
		return update(vo.getUser_ip(), 
								vo.getUser_portno(),
								vo.getUser_num(), 
								vo.getServer_portno());
	}
	
	public int update(String user_ip, 
								int user_portno,
								int user_num,
								int user_total) throws SQLException {
		Connection conn = dbcn.getConnection();
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update \"CHATROOM\"");
			sql.append("set \"USER_IP\"= ?, \"USER_TOTAL\"= ?");
			sql.append("values ");
			sql.append("where \"USER_PORTNO\"= ?");
			
			System.out.println("SQL: " + sql.toString());
			
			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, user_ip);
			pst.setInt(2, user_total);
			pst.setInt(3, user_portno);
			
			result = pst.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "행이 수정되었습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
	
	// Delete(전체 삭제)
	public int deleteAll() {
		Connection conn = null;
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			conn = dbcn.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete from \"CHATROOM\"");
			
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
	public int deleteUser(int user_ip) {
		Connection conn = null;
		PreparedStatement pst = null;
		int result = -1;
		
		try {
			conn = dbcn.getConnection();
				
			StringBuffer sql = new StringBuffer();
			sql.append("delete from \"CHATROOM\"");
			sql.append("where \"USER_IP\"= ?");
			
			System.out.println("SQL: " + sql.toString());
				
			pst = conn.prepareStatement(sql.toString());
				
			if(result > 0) {
				System.out.println(result + "행이 삭제되었습니다.");
				}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbcn.close(pst);
			dbcn.close(conn);
		} return result;
	}
}


