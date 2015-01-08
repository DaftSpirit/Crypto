package crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class GUITester {

	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException {
		// Interface_P i1 = new Interface_P();
		Crypter cr = new Crypter("password");
		Date d1 = new Date();
		Event e1 = new Event("Event 1", "une description", d1);
		System.out.println(e1);
		EventCrypted ce = cr.encryptEvent(e1);
		System.out.println(ce);
		Event e2 = cr.decryptEvent(ce);
		System.out.println(e2);
	}
}
