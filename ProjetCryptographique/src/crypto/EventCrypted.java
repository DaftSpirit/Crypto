package crypto;



public class EventCrypted extends Event {
	private byte[] name;
	private byte[] description;
	private byte[] date;
	
	
	public EventCrypted(byte[] name, byte[] description, byte[] date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}

	@Override
	public String toString() {

		return "Event [name=" + name.toString() + ", description=" + description.toString()
				+ ", date=" + date.toString() + ", CRYPTED]";
	}

	public byte[] getName() {
		return name;
	}

	public void setName(byte[] name) {
		this.name = name;
	}

	public byte[] getDescription() {
		return description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}

	public byte[] getDate() {
		return date;
	}

	public void setDate(byte[] date) {
		this.date = date;
	}
	
	

}
