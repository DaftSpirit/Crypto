package crypto;

import java.util.Date;

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
	
	

}
