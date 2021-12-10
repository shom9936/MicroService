package vo;
/*
 create table board (
	    SEQ NUMBER PRIMARY KEY,
	    ID VARCHAR2(30) NOT NULL,   
	    NAME VARCHAR2(30) NOT NULL,  
	    TITLE VARCHAR2(255) , 
	    CONTENT VARCHAR2(4000) NOT NULL,
	    FILENAME VARCHAR2(255),
	    HIT NUMBER DEFAULT 0,         
	    LOGTIME DATE, 
	    COMMENT_CNT NUMBER DEFAULT 0
);
 */
public class BoardVO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String filename;
	private int hit;
	private String logtime;
	private int comment_cnt;
	
	public BoardVO() {}

	public BoardVO(int seq, String id, String title, String content, String filename, int hit,
			String logtime, int comment_cnt) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.hit = hit;
		this.logtime = logtime;
		this.comment_cnt = comment_cnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public int getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	
}
