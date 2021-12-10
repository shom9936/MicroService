package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConn;
import vo.MemberVO;
import vo.ShopReviewVO;
import vo.SurfAreaVO;
import vo.SurfShopVO;
import vo.SurfSpotVO;

public class SurfDAO {
	private Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public SurfDAO() throws ClassNotFoundException, SQLException {
		con = new DBConn().getConnection();
	}

	// area -> location
	public ArrayList<SurfAreaVO> locationSearch(String area) throws SQLException {
		ArrayList<SurfAreaVO> list = new ArrayList<SurfAreaVO>();
		String sql = "select * from surf_area where spot_area = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, area);
		rs = ps.executeQuery();
		while (rs.next()) {
			String location = rs.getString("spot_location");
			SurfAreaVO vo = new SurfAreaVO(location);
			list.add(vo);
		} 
		return list;
	}
	
	// location -> spot
	public ArrayList<SurfSpotVO> spotSearch(String location) throws SQLException{
		ArrayList<SurfSpotVO> list = new ArrayList<SurfSpotVO>();
		String sql = "select * from surf_spot where spot_location = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, location);
		rs = ps.executeQuery();
		while(rs.next()) {
			String spot = rs.getString("spot_name");
			SurfSpotVO vo = new SurfSpotVO(spot);
			list.add(vo);
		}
		return list;
	}
	
	// spot -> shop 
	public ArrayList<SurfShopVO> shopSearch(String spot) throws SQLException {
		ArrayList<SurfShopVO> list = new ArrayList<SurfShopVO>();
		String sql = "select shop_name from surf_shop where spot_name = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, spot);
		rs = ps.executeQuery();
		while(rs.next()) {
			String shop = rs.getString("shop_name");
			SurfShopVO vo = new SurfShopVO(shop);
			list.add(vo);
		}
		return list;
	}
	
	// shop information
	public SurfShopVO shopInfo(String shop) throws SQLException{
		SurfShopVO vo = null;
		String sql = "select * from surf_shop where shop_name = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, shop);
		rs = ps.executeQuery();
		while(rs.next()) {
			String shop_name = rs.getString("shop_name");
			String spot_name = rs.getString("spot_name");
			String spot_address = rs.getString("spot_address");
			vo = new SurfShopVO(shop_name, spot_name, spot_address);
			
		}
		return vo;
	}
	
	// get shop review
	public ArrayList<ShopReviewVO> getReview(String shop_name) throws SQLException{
		ArrayList<ShopReviewVO> list = new ArrayList<>();
		ShopReviewVO vo;
		String sql = "select * from shop_review where shop_name = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, shop_name);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			vo = new ShopReviewVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setId(rs.getString("id"));
			vo.setContent(rs.getString("content"));
			vo.setShop_name(shop_name);
			vo.setStar_rating(rs.getInt("star_rating"));
			list.add(vo);
		}
		
		return list;
	}
	
	// write review
	public int writeReview(ShopReviewVO vo) throws SQLException {
		String sql = "insert into shop_review values(seq_review.nextval, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setInt(2, vo.getStar_rating());
		ps.setString(3, vo.getShop_name());
		ps.setString(4, vo.getContent());
		
		int num = ps.executeUpdate();
		
		return num;
	}
	
	// delete review
	public int deleteReview(int seq) throws SQLException{
		String sql = "delete from shop_review where seq = ?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, seq);
		
		int num = ps.executeUpdate();
		
		return num;
		
	}
	
}
