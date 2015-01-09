package crypto;

import java.io.Serializable;


/**
 * member crypted defines if the event is crypted or not
 * @author gael
 */
public abstract class AbsEvent implements Serializable{

	private boolean crypted;
	
	/**
	 * @author joris
	 */
	private static final long serialVersionUID = 1L;


}
