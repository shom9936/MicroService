package vo;

public class SurfSpotVO {

	private String spot_name;
	private String spot_location;
	private String spot_area;

	public SurfSpotVO() {
	}

	public SurfSpotVO(String spot_name, String spot_location, String spot_area) {
		super();
		this.spot_name = spot_name;
		this.spot_location = spot_location;
		this.spot_area = spot_area;
	}

	public SurfSpotVO(String spot_name) {
		super();
		this.spot_name = spot_name;
	}

	public String getSpot_name() {
		return spot_name;
	}

	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}

	public String getSpot_location() {
		return spot_location;
	}

	public void setSpot_location(String spot_location) {
		this.spot_location = spot_location;
	}

	public String getSpot_area() {
		return spot_area;
	}

	public void setSpot_area(String spot_area) {
		this.spot_area = spot_area;
	}
}
