package vo;

/*
create table member(
    id      varchar2(10) primary key ,
    pwd     varchar2(50) not null,
    name    varchar2(30) not null,
    email   varchar2(30),
    tel     varchar2(10)
);
 */

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String tel;
	
	public MemberVO() {}
	
	
	public MemberVO(String id, String pwd, String name, String email, String tel) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
