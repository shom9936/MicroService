package moonweight;

public class Test {
	public static void main(String[] args) {
		String id = "#������#�̺���#������#Ű����";
		String[] list = id.split("#");
		for(String str : list) {
			System.out.println(str);
		}
	}
}
