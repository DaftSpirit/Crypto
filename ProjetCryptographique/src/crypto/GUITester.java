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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class GUITester {
	public static void main(String[] args) {
		// Interface_P i1 = new Interface_P();
		Crypter cr;
		try {
			Map<String, AbsEvent> diary = new HashMap<String, AbsEvent>();
			cr = new Crypter("password");
			
			Date d1 = new Date();
			Event e1 = new Event("Event 1", "une description", d1);
			
			diary.put(e1.getName(), e1);
			System.out.println(e1);
			
			EventCrypted ce;
			ce = cr.encryptEvent(e1);
			System.out.println(ce);
			diary.put(ce.getName().toString(), ce);
			
			// System.out.println(ce);
			Event e2 = cr.decryptEvent(ce);
			System.out.println(e2);
			// System.out.println(e2);

			System.out.println(diary.toString());
			
			/* Writing in a file the diary */
			ObjectInputStream ois;
			ObjectOutputStream oos;
			oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("agenda.txt"))));
			
			Iterator<Entry<String, AbsEvent>> it = diary.entrySet().iterator();
			while(it.hasNext())
			{
				oos.writeObject(it.next());
			}
			//oos.writeObject(diary);
			oos.close();
			
			

		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			
			e.printStackTrace();
		} catch (BadPaddingException e) {
			
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		



	}

}
