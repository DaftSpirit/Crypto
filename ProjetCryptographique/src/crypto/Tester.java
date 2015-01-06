package crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Tester {

	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException {
	/*	Date d1 = new Date();
		Event e1 = new Event("Event 1", "une description", d1, false);
		System.out.println(e1.toString());
		e1.encrypt();
		System.out.println(e1);
		e1.decrypt();
		System.out.println(e1);
*/
		Crypter cr = new Crypter("popoyhyyyyyyyy");
		System.out.println(cr.decrypt(cr.encrypt("Taiii")));
	}

}
