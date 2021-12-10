package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.TelInfoDBConn;
import vo.TelInfoVO;

public class TelInfoDAO {
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException {
		con = new TelInfoDBConn().getConnection();
	}
	
	public ArrayList<TelInfoVO> getAllInfo() throws SQLException{
		ArrayList<TelInfoVO> list = new ArrayList<>();
		String sql = "select * from teltable5 order by id";
		
		pstmt = con.prepareStatement(sql);
		res = pstmt.executeQuery();
		
		while(res.next()) {
			int id = res.getInt("id");
			String name = res.getString("name");
			String tel = res.getString("tel");
			String date = res.getString("d").substring(0,10);
			
			TelInfoVO vo = new TelInfoVO(id, name, tel, date);
			list.add(vo);
		}
		
		return list;
	}
	
	public int insert(int id, String name, String tel, String date) throws SQLException {
		String sql = "insert into teltable5 values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, tel);
		pstmt.setString(4, date);
		int result = pstmt.executeUpdate();
		if(result > 0) System.out.println("성공");
		else System.out.println("실패");
		return result;
	}

	public TelInfoVO getOneInfo(String name) {
		String sql = "select * from teltable5 where name = ?";
		TelInfoVO vo = new TelInfoVO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeQuery();
			while(res.next()) {
				vo.setName(res.getString("name"));
				vo.setId(res.getInt("id"));
				vo.setTel(res.getString("tel"));
				
				vo.setDate(res.getString("d").substring(0,10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public int delete(String name) {
		String sql = "delete from teltable5 where name = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(String name, String tel, String date) {
		String sql = "update teltable5 set tel = ? , d = ? where name = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, date);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}















