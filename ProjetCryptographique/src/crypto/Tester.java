package crypto;

import gui.Memory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Tester {
	public static void main(String[] args) {

		Crypter cr;
		Crypter cr2;
		try {
			ArrayList<AbsEvent> diary = new ArrayList<AbsEvent>();
			cr = new Crypter("password");
//			cr2 = new Crypter("password2");	//wrong password tester

			Date d1 = new Date(2015,01,16,19,00);
			Date d2 = new Date(2015,01,16,19,15);
			Event e1 = new Event("Event 1", "une description", d1, d2);	//Preuve que le getLength() est OK

			diary.add(e1);
			// System.out.println(e1);

			EventCrypted ce;
			ce = cr.encryptEvent(e1);
			// System.out.println(ce);
			diary.add(ce);

			// System.out.println(ce);
			Event e2 = cr.decryptEvent(ce);
			//System.out.println(e2);

			/* Writing events to file */
			Memory.writeToFile(diary);
			
			/* Reading events from file */
			ArrayList<AbsEvent> loadedList = Memory.readFromFile();
			System.out.println("Loaded from file");		//debug purpose
			System.out.println(loadedList.toString());	//debug purpose
			
//			EventCrypted eventC = (EventCrypted) loadedList.get(1);
//			Event eventNonC = cr2.decryptEvent(eventC);
//			System.out.println(eventNonC);


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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Wrong password. Ye hacker !");
		}

	}

}
