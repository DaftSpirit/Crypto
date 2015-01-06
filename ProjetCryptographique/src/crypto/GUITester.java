package crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import gui.GUIContainer;

/* Une classe main pour tester */

public class GUITester {

	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException {
		// Interface_P i1 = new Interface_P();
		Event e1 = new Event();
		System.out.println(e1);
		/*e1.encrypt();
		System.out.println(e1);
		e1.decrypt();
		System.out.println(e1);*/

	}

}
