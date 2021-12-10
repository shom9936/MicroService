package moonweight;

public class Test {
	public static void main(String[] args) {
		String id = "#개구리#이병헌#강새벽#키보드";
		String[] list = id.split("#");
		for(String str : list) {
			System.out.println(str);
		}
	}
}
