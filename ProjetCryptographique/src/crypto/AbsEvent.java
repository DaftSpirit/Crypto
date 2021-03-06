package crypto;

import java.io.Serializable;


/**
 * An abstract class. Used for legacy purpose.
 * Super class of Event and EventCrypted. Allows to make an ArrayList of AbsEvent
 * @authors gael, joris
 */
public abstract class AbsEvent implements Serializable{

	protected boolean crypted;
	
	/**
	 * @author joris
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author joris
	 * @return the current state of an Event : if it's crypted or not
	 */
	public boolean isCrypted()
	{
		return this.crypted;
	}
	
}
