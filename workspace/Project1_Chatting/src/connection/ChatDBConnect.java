package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC : Java Database Connectivity
// 자바에서 DB에 접속할 수 있게 하는 자바 API이며
// DB에서 자료를 쿼리(특정 정보를 요청)하거나 업데이트하는 방법 제공
// 이 파일에서는 커넥션(이클립스 - DB 연결) 목적으로 사용
// 싱글톤(Singleton) 패턴 적용
// -> 클래스에 static 속성을 부여해 클래스 생성 시에만 메모리 영역을 할당하고
//		그 안에 객체를 만들어 사용하는 방식
public class ChatDBConnect {
	private static ChatDBConnect instance;
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "chatdb";
	private String pw = "chatdb";
	
	static {
		try {
			Class.forName(driver);
			System.out.println("드라이버 클래스 확인됨.");
			System.out.println("DB에 접속했습니다.");
		} catch(ClassNotFoundException e) {
			System.out.println("DB Connection Error");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private ChatDBConnect() {}
	
	public static ChatDBConnect getInstance() {
		synchronized(ChatDBConnect.class) {
			if(instance == null) {
				instance = new ChatDBConnect();
			}	
		}
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
								url, user, pw);
	}
	
	public void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ChatDBConnect.getInstance();
		
	}
}




