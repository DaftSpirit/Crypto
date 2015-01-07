package crypto;

import java.util.Date;

public class CryptedEvent extends Event {

	private boolean crypted;
	protected byte[] nameCrytped;
	
	public CryptedEvent(String name, String description, Date date, byte[] nameCrypted) {
		super(name, description, date);
		crypted = true;
		this.nameCrytped = nameCrypted;
	}

	@Override
	public String toString() {

		return "Event [name=" + name + ", description=" + description
				+ ", date=" + date.toString() + ", crypted=" + crypted + "]";
	}

}
