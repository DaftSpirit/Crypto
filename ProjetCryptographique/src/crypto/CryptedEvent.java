package crypto;

import java.util.Date;

public class CryptedEvent extends Event {

	private String crypted;

	public CryptedEvent(String name, String description, Date date,
			boolean crypted) {
		super(name, description, date);
		crypted = true;
	}

	@Override
	public String toString() {

		return "Event [name=" + name + ", description=" + description
				+ ", date=" + date.toString() + ", crypted=" + crypted + "]";
	}

}
