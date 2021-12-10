package vo;

public class TelInfoVO {
	private int id;
	private String name;
	private String tel;
	private String date;
	
	public TelInfoVO() {}

	public TelInfoVO(int id, String name, String tel, String date) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
