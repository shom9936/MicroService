package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC : Java Database Connectivity
// �ڹٿ��� DB�� ������ �� �ְ� �ϴ� �ڹ� API�̸�
// DB���� �ڷḦ ����(Ư�� ������ ��û)�ϰų� ������Ʈ�ϴ� ��� ����
// �� ���Ͽ����� Ŀ�ؼ�(��Ŭ���� - DB ����) �������� ���
// �̱���(Singleton) ���� ����
// -> Ŭ������ static �Ӽ��� �ο��� Ŭ���� ���� �ÿ��� �޸� ������ �Ҵ��ϰ�
//		�� �ȿ� ��ü�� ����� ����ϴ� ���
public class ChatDBConnect {
	private static ChatDBConnect instance;
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "chatdb";
	private String pw = "chatdb";
	
	static {
		try {
			Class.forName(driver);
			System.out.println("����̹� Ŭ���� Ȯ�ε�.");
			System.out.println("DB�� �����߽��ϴ�.");
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




