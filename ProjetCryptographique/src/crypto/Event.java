package crypto;

import java.util.Date;
import java.security.*;
import javax.crypto.*;

public class Event {
	
	private String name;
	private Date date;
	private boolean crypted;
	
	/**
	 * 	public Event()
	 * 	default constructor for non crypted events
	 * 	@param null
	 */
	public Event()
	{
		this.name = "default event";
		this.crypted = false;
		this.date = new Date();	//unix time, initialized at the time of creation
	}
	
	/**
	 * public Event(boolean)
	 * debug constructor for tests and debug
	 * @param crypted defines if the event is crypted or not
	 */
	public Event(boolean crypted)
	{
		this.name = "debug event";
		this.date = new Date();
		this.crypted = crypted;
	}
	
	/**
	 * constructor used by gui for the typical use
	 * @param name : the name of the event
	 * @param date : date of event
	 * @param crypted : if the event is crypted or not
	 */
	public Event(String name, Date date, boolean crypted)
	{
		this.crypted = crypted;
		this.name = name;
		this.date = date;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isCrypted()
	{
		return this.crypted;
	}
	
	public void encrypt()
	{
		encryptName();
		encryptDate();
	}

	private void encryptDate() {
		// TODO Auto-generated method stub
		
	}

	private void encryptName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", date=" + date.toString() + ", crypted="
				+ crypted + "]";
	}
	
	
	
	

}
