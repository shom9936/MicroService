package vo;

public class SurfShopVO {

	private String shop_name;
	private String spot_name;
	private String spot_address;

	public SurfShopVO() {
	}

	public SurfShopVO(String shop_name) {
		super();
		this.shop_name = shop_name;
	}

	public SurfShopVO(String shop_name, String spot_name, String spot_address) {
		super();
		this.shop_name = shop_name;
		this.spot_name = spot_name;
		this.spot_address = spot_address;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getSpot_name() {
		return spot_name;
	}

	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}

	public String getSpot_address() {
		return spot_address;
	}

	public void setSpot_address(String spot_address) {
		this.spot_address = spot_address;
	}
}
