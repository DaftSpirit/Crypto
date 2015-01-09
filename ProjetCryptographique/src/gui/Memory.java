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

public abstract class  Memory {
	
	static File reader = new File("agenda.txt");
	
	public static void writeToFile(ArrayList<AbsEvent> list) throws FileNotFoundException, IOException {
		System.out.println("*********** WRITING EVENTS TO FILE ***********"); //debug purpose
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(reader)));
		Iterator<AbsEvent> it = list.iterator();
		oos.writeInt(list.size());		//writing number of event to read used for reading
		while (it.hasNext()) {
			oos.writeObject(it.next());
		}
		oos.close();
	}
	
	public static ArrayList<AbsEvent> readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("*********** READING EVENTS FROM FILE ***********");	//debug purpose
		
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
