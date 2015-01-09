package crypto;



public class EventCrypted extends AbsEvent {
	private byte[] name;
	private byte[] description;
	private byte[] date;
	private byte[] fin;
	
	public EventCrypted(byte[] name, byte[] description, byte[] date, byte[] fin) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.fin = fin;
		super.crypted = true;
	}

	@Override
	public String toString() {

		return "This event crypted [name=" + name.toString() + ", description=" + description.toString()
				+ ", date=" + date.toString() + "]\n";
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

	public byte[] getFin() {
		return fin;
	}

	public void setFin(byte[] fin) {
		this.fin = fin;
	}
	
	

}
