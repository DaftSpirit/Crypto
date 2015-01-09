package crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class GUITester {
	public static void main(String[] args) {

		Crypter cr;
		try {
			ArrayList<AbsEvent> diary = new ArrayList<AbsEvent>();
			cr = new Crypter("password");

			Date d1 = new Date();
			Event e1 = new Event("Event 1", "une description", d1);

			diary.add(e1);
			// System.out.println(e1);

			EventCrypted ce;
			ce = cr.encryptEvent(e1);
			// System.out.println(ce);
			diary.add(ce);

			// System.out.println(ce);
			Event e2 = cr.decryptEvent(ce);
			System.out.println(e2);

			/* Writing in a file the diary */
//			ObjectOutputStream oos = new ObjectOutputStream(
//					new BufferedOutputStream(new FileOutputStream(new File(
//							"agenda.txt"))));
//			Iterator<AbsEvent> it = diary.iterator();
//			oos.writeInt(diary.size());		//writing number of event to read used for reading
//			while (it.hasNext()) {
//				oos.writeObject(it.next());
//			}
//			oos.close();

			/* Reading the diary */
			File reader = new File("agenda.txt");
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(reader)));

			System.out.println("*********** From file ***********");
			int lineToRead = (int)ois.readInt();
			for(int i=0;i<lineToRead;i++) {
				System.out.println(((AbsEvent)ois.readObject()).toString());
			}
			
			ois.close();

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
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

	}

}
