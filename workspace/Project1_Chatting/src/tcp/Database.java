package tcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "chatdb";
	private String pwd = "chatdb";
	private String userid;
	private String usermessage;
	private int portnumber;
	
	
	private String inetAddress;
	private int serverPortno;
	private int userPortno;
	private String sql = "insert into chat_room(user_id,user_message,user_portno, user_logtime) values(?,?,?, sysdate)";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public Database(String user_message, String user_id, int port_number) {
		this.usermessage = user_message;
		this.userid = user_id;
		this.portnumber = port_number;
	}
	
	public Database(String inetAddress,int userPortno ,int serverPortno) {
		this.inetAddress = inetAddress;
		this.userPortno = userPortno;
		this.serverPortno = serverPortno;
	}

	public void insert() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pst = conn.prepareStatement(sql);
	    

		pst.setString(1, userid);
		pst.setString(2, usermessage);
		pst.setInt(3, portnumber);

		pst.executeUpdate();
		pst.close();
		conn.close();
	}
	
	public void insert2() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pst = conn.prepareStatement("insert into chat_user(user_ip, user_portno, server_portno) values(?,?,?)");
	    

		pst.setString(1, inetAddress);
		pst.setInt(2, userPortno);
		pst.setInt(3, serverPortno);

		pst.executeUpdate();
		pst.close();
		conn.close();
	}

}
