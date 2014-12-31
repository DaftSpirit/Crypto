package crypto;

import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * events : map of all events the key is the name of the event
 * key : SecretKeySpec generated for the password of the user. used to test if the password is correct
 * @author joris
 *
 */
public class Diary {
	
	private Map<String,Event> events;
	private SecretKeySpec key;

}
