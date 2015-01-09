package gui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import crypto.AbsEvent;
/**
 * Abstract class used to save and load events to/from a file
 * @author gael
 *
 */
public abstract class  Memory {
	
	static File reader = new File("agenda.txt");
	
	/**
	 * Save the ArrayList passed in @param to the file
	 * @param the ArrayList containing the events will be saved to disk
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeToFile(ArrayList<AbsEvent> list) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(reader)));
		Iterator<AbsEvent> it = list.iterator();
		oos.writeInt(list.size());		//writing number of event to read used for reading
		while (it.hasNext()) {
			oos.writeObject(it.next());
		}
		oos.close();
	}
	
	/**
	 * Return the ArrayList saved in the file
	 * @return	the ArrayList containing the events
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<AbsEvent> readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<AbsEvent> list = new ArrayList<AbsEvent>();
		File reader = new File("agenda.txt");
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(reader)));
		int lineToRead = (int)ois.readInt();
		AbsEvent eventLoaded;
		for(int i=0;i<lineToRead;i++) {
			eventLoaded = (AbsEvent)ois.readObject();	//reading event
			list.add(eventLoaded);				//adding event to the new arrayList
		}
		ois.close();
		return list;
	}
	
	

}
