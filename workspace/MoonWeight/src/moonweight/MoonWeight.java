package moonweight;

import java.util.ArrayList;

public class MoonWeight {

	public static void main(String[] args) {
		
		String q = "127.0.0.1";
		String[] list = q.split("\\.");
		
		for(String str : list) {
			System.out.println(str + " : " + str.length());
		}
		
		System.out.println(list.length);
		System.out.println("*");

	}

}
