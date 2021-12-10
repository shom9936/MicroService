package helloProcess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SawonDAO {
	
	private ArrayList<Object> alist;
	private JdbcTemplate jt;
	
	public JdbcTemplate getJdbcTemplate() {
		return jt;
	}
	
	public void setJdbcTemplate(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public ArrayList<Object> selectAll(){
		StringBuffer sb = new StringBuffer();
		sb.append("select name, tel from TelTable");
		
		alist = (ArrayList<Object>)getJdbcTemplate().query(sb.toString(), new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int num) throws SQLException {
				SawonVO sv = new SawonVO();
				System.out.println("줄번호 = " + num);
				// num : index ( 0, 1, ... )
				sv.setName(rs.getString("name"));
				sv.setTel(rs.getString("tel"));
				return sv;
			} // mapRow() end
		}); // new RowMapper() end // query() end
		System.out.println("자료 총 개수는 " + getCount());
		return alist;
	}
	
	
	public int getCount() {
		int cnt = jt.queryForObject("select count(name) from TelTable", Integer.class);
		return cnt;
	}
	
	public void update() {
		jt.update("update TelTable set tel=? where name=?", new Object[] {"010-7878-9595", "kongjoo"});
	}
	
}
