package vo;
/*
create table board_comment( 
	board_no number ,
	id varchar2(30) not null , 
	seq number not null ,
	content varchar2(1000) ,
	logtime date ,
	foreign key (board_no) REFERENCES board(seq)
);
 */
public class CommentVO {
	private int board_no;
	private String id;
	private int seq;
	private String content;
	private String logtime;
	
	public CommentVO() {}

	public CommentVO(int board_no, String id, int seq, String content, String logtime) {
		this.board_no = board_no;
		this.id = id;
		this.seq = seq;
		this.content = content;
		this.logtime = logtime;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	
	
}
