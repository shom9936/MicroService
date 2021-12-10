package vo;
/*
create table shop_review (
    seq         number ,
    id          varchar2(10) ,
    star_rating number check( star_rating in (1,2,3,4,5)) ,
    shop_name   varchar2(50) ,
    content     VARCHAR2(1000), 
    foreign key (shop_name) REFERENCES surf_shop(shop_name)
);
 */
public class ShopReviewVO {

	private int seq;
	private String id;
	private int star_rating;
	private String shop_name;
	private String content;
	
	public ShopReviewVO() {}
	public ShopReviewVO(int seq, String id, int star_rating, String shop_name, String content) {
		this.seq = seq;
		this.id = id;
		this.star_rating = star_rating;
		this.shop_name = shop_name;
		this.content = content;
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
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
