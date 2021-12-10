package vo;

public class SurfAreaVO {

	private String spot_area;
	private String spot_location;

	public SurfAreaVO() {
	}

	public SurfAreaVO(String spot_area, String spot_location) {
		super();
		this.spot_area = spot_area;
		this.spot_location = spot_location;
	}

	public SurfAreaVO(String spot_location) {
		super();
		this.spot_location = spot_location;
	}

	public String getSpot_area() {
		return spot_area;
	}

	public void setSpot_area(String spot_area) {
		this.spot_area = spot_area;
	}

	public String getSpot_location() {
		return spot_location;
	}

	public void setSpot_location(String spot_location) {
		this.spot_location = spot_location;
	}
}
