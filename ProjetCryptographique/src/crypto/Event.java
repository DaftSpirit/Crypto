package crypto;

import java.util.Date;

public class Event {

	protected String name;
	protected String description;
	protected Date date;

	public Event() {
		this.name = "default event";
		this.description = "default event description";
		this.date = new Date(); // unix time, initialized at the time of
								// creation
	}

	public Event(String name, String description, Date date) {
		this.name = "debug event";
		this.description = "default event description";
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", description=" + description
				+ ", date=" + date.toString() + "]";
	}
}
