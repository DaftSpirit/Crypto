package crypto;

import java.util.Date;
import java.security.*;
import java.crypto.*;

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
		this.date = new Date(2015, 1, 1);
	}
	
	/**
	 * public Event(boolean)
	 * debug constructor for tests and debug
	 * @param crypted defines if the event is crypted or not
	 */
	public Event(boolean crypted)
	{
		this.name = "debug event";
		this.date = new Date(2015, 1, 1);
		this.crypted = crypted;
	}
	
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
	
	

}
