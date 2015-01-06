package crypto;

import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * events : map of all events the key is the name of the event key :
 * SecretKeySpec generated for the password of the user. used to test if the
 * password is correct
 * 
 * @author joris
 *
 */
public class Diary {

	private Map<String, EventCrypter> events;
	private SecretKeySpec key;

	/**
	 * 
	 * @param name
	 *            : name of the event
	 * @param event
	 *            : the object event
	 */
	public void addEvent(String name, EventCrypter event) {
		this.events.put(name, event);
	}

}
