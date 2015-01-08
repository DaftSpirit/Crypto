package crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
		Map<String, AbsEvent> diary = new HashMap<String, AbsEvent>();
		
		Event e1 = new Event("Event 1", "une description", new Date());
		diary.put(e1.getName(), e1);
		System.out.println(e1);
		EventCrypted ce = cr.encryptEvent(e1);
		diary.put(ce.getName().toString(), ce);
//		System.out.println(ce);
		Event e2 = cr.decryptEvent(ce);
//		System.out.println(e2);
		
		
		
		
		System.out.println(diary.toString());
		
		
//		ObjectInputStream ois;
//		ObjectOutputStream oos;
//		
//		try {
//			oos=new ObjectOutputStream(
//					new BufferedOutputStream(
//							new FileOutputStream(
//									new File("agenda.txt"))));
//			oos.writeObject(diary);
//			oos.close();
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
}
