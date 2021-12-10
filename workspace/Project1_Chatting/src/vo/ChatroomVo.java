package vo;


// VO = Value Object
/*
CREATE TABLE chatroom (
    user_ip                         varchar2(40),
    user_portno                     number,
    user_num                        number,
    server_portno                   number
);
 */

public class ChatroomVo {
	private String user_ip;
	private int user_portno;
	private int user_num;
	private int server_portno;
	
	public ChatroomVo()	{}
	
	public ChatroomVo(String user_ip, int user_portno, 
						int user_num, int server_portno) {
		this.user_ip = user_ip;
		this.user_portno = user_portno;
		this.user_num = user_num;
		this.server_portno = server_portno;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public int getUser_portno() {
		return user_portno;
	}

	public void setUser_portno(int user_portno) {
		this.user_portno = user_portno;
	}

	public int getUser_num() {
		return user_num;
	}

	public int getServer_portno() {
		return server_portno;
	}

	public void setServer_portno(int server_portno) {
		this.server_portno = server_portno;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	@Override
	public String toString() {
		return "ChatroomVo [user_ip=" + user_ip 
						+ ", user_portno=" + user_portno 
						+ ", user_num=" + user_num
						+ ", user_total=" + server_portno + "]";
	}
	
}
