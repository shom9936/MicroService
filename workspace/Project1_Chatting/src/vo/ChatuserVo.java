package vo;

import java.util.Date;

public class ChatuserVo {
	private int user_num;
	private int user_portno;
	private String user_id;
	private Date regdate;
	private String user_message;
	
	public ChatuserVo() {}
	
	public ChatuserVo(int user_num, int user_portno, 
						String user_id, Date regdate, 
						String user_message) {
		this.user_num = user_num;
		this.user_portno = user_portno;
		this.user_id = user_id;
		this.regdate = new Date();
		this.user_message = user_message;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getUser_portno() {
		return user_portno;
	}

	public void setUser_portno(int user_portno) {
		this.user_portno = user_portno;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getUser_message() {
		return user_message;
	}

	public void setUser_message(String user_message) {
		this.user_message = user_message;
	}

	@Override
	public String toString() {
		return "ChatuserVo [user_num=" + user_num 
					+ ", user_portno=" + user_portno 
					+ ", user_id=" + user_id
					+ ", regdate=" + regdate 
					+ ", user_message=" + user_message + "]";
	}
	
	

}
