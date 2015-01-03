package crypto;

import java.util.Date;

public class Tester {

	public static void main(String[] args) {
		Date d1 = new Date();
		Event e1 = new Event("Event 1", d1, false);
		
		System.out.println(e1.toString());

	}

}
